/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mycore.libmeta.pica.xml;

import java.io.Reader;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.EventReaderDelegate;

/**
 * FilterPicaXMLReaderDelegate can be used to extract PicaPlusXML Documents
 * from SRU responses.
 * 
 * The implementation is based on the Java StAX API and can be used as XMLEventReader.
 * 
 * @author Robert Stephan
 * 
 * @see javax.xml.stream.XMLEventReader
 */
public class FilterPicaXMLFromSRUReaderDelegate extends EventReaderDelegate {
    private static QName qnCollection = new QName("info:srw/schema/5/picaXML-v1.0", "collection");

    private static QName qnRecord = new QName("info:srw/schema/5/picaXML-v1.0", "record");

    @SuppressWarnings("unused")
    private static QName qnDatafield = new QName("info:srw/schema/5/picaXML-v1.0", "datafield");

    @SuppressWarnings("unused")
    private static QName qnSubfield = new QName("info:srw/schema/5/picaXML-v1.0", "subfield");

    private static QName qnZSRecords = new QName("http://www.loc.gov/zing/srw/", "records");
    
    private static QName qnZSearchRetrieveResponse = new QName("http://www.loc.gov/zing/srw/", "searchRetrieveResponse");

    private Queue<XMLEvent> queueOfNewEvents = new LinkedList<XMLEvent>();

    private XMLEventFactory eventFactory = XMLEventFactory.newInstance();

    private boolean showText = false;

    private boolean isFirstRecord = true;

    public enum RootElement {
        RECORD, COLLECTION;
    }

    private RootElement rootElement;

    /**
    * Constructor
    * 
    * @param parentXMLEventReader - the parent XML event reader
    */
    public FilterPicaXMLFromSRUReaderDelegate(XMLEventReader parentXMLEventReader, RootElement rootElement) {
        super(parentXMLEventReader);
        this.rootElement = rootElement;
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        while (true) {
            if (!queueOfNewEvents.isEmpty()) {
                return queueOfNewEvents.poll();
            }

            XMLEvent xmlEvent = super.nextEvent();
            if (xmlEvent == null) {
                return null;
            }
            if (xmlEvent.isStartElement()) {
                if (xmlEvent.asStartElement().getName().equals(qnZSRecords)) {
                    if (rootElement == RootElement.COLLECTION) {
                        queueOfNewEvents.add(eventFactory.createCharacters("\n"));
                        queueOfNewEvents.add(eventFactory.createStartElement(qnCollection, null, null));
                        queueOfNewEvents.add(eventFactory.createNamespace("info:srw/schema/5/picaXML-v1.0"));
                        queueOfNewEvents.add(eventFactory.createCharacters("\n"));
                    }
                    continue;
                }

                if (xmlEvent.asStartElement().getName().equals(qnRecord)) {
                    if (isFirstRecord || rootElement == RootElement.COLLECTION) {
                        showText = true;
                        return xmlEvent;
                    } else {
                        continue;
                    }
                }

                if (!xmlEvent.asStartElement().getName().getNamespaceURI().equals("info:srw/schema/5/picaXML-v1.0")) {
                    continue;
                }
            }

            if (xmlEvent.isEndElement()) {
                if (xmlEvent.asEndElement().getName().equals(qnZSRecords)) {
                    if (rootElement == RootElement.COLLECTION) {
                        queueOfNewEvents.add(eventFactory.createCharacters("\n"));
                        queueOfNewEvents.add(eventFactory.createEndElement(qnCollection, null));
                        continue;
                    }
                }
                if (xmlEvent.asEndElement().getName().equals(qnRecord)) {
                    showText = false;
                    if (isFirstRecord || rootElement == RootElement.COLLECTION) {
                        isFirstRecord = false;
                        return xmlEvent;
                    } else {
                        continue;
                    }
                }
                
                if (xmlEvent.asEndElement().getName().equals(qnZSearchRetrieveResponse)) {
                    //handle empty SRU responses ...
                    if (rootElement == RootElement.COLLECTION && isFirstRecord) {
                        queueOfNewEvents.add(eventFactory.createCharacters("\n"));
                        queueOfNewEvents.add(eventFactory.createStartElement(qnCollection, null, null));
                        queueOfNewEvents.add(eventFactory.createNamespace("info:srw/schema/5/picaXML-v1.0"));
                        queueOfNewEvents.add(eventFactory.createEndElement(qnCollection, null));
                        continue;
                    }
                    
                    if (rootElement == RootElement.RECORD && isFirstRecord) {
                        queueOfNewEvents.add(eventFactory.createCharacters("\n"));
                        queueOfNewEvents.add(eventFactory.createStartElement(qnRecord, null, null));
                        queueOfNewEvents.add(eventFactory.createNamespace("info:srw/schema/5/picaXML-v1.0"));
                        queueOfNewEvents.add(eventFactory.createEndElement(qnRecord, null));
                        continue;
                    }
                }
                
                if (!xmlEvent.asEndElement().getName().getNamespaceURI().equals("info:srw/schema/5/picaXML-v1.0")) {
                    continue;
                }
            }
            if (xmlEvent.isCharacters() && !showText) {
                continue;
            }

            if (isFirstRecord || rootElement == RootElement.COLLECTION
                || xmlEvent.isStartDocument() || xmlEvent.isEndDocument()) {
                return xmlEvent;
            } else {
                continue;
            }
        }
    }

    /**
     * utility function to retrieve (the first) pica record XML from SRU responses
     * 
     * @param in - the input XML
     * @param out - the output XML
     * @throws Exception - an error during processing occured
     */
    public static void filterPicaRecordXML(Reader in, Writer out) throws Exception {
        filterPicaXML(in, out, RootElement.RECORD);
    }

    /**
     * utility function to retrieve pica collection XML from SRU responses
     * 
     * @param in - the input XML
     * @param out - the output XML
     * @throws Exception - an error during processing occured
     */
    public static void filterPicaCollectionXML(Reader in, Writer out) throws Exception {
        filterPicaXML(in, out, RootElement.COLLECTION);
    }

    /**
     * utility function to retrieve picaXML from SRU responses
     * 
     * @param in - the input XML
     * @param out - the output XML
     * @param rootElement the expected Pica root Element (record or collection)
     * @throws Exception - an error during processing occured
     */
    private static void filterPicaXML(Reader in, Writer out, RootElement rootElement) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        XMLEventReader xmlEventReader
            = new FilterPicaXMLFromSRUReaderDelegate(inputFactory.createXMLEventReader(in), rootElement);
        XMLEventWriter xmlEventWriter = outputFactory.createXMLEventWriter(out);

        while (xmlEventReader.hasNext()) {
            xmlEventWriter.add(xmlEventReader.nextEvent());
        }
        xmlEventReader.close();
        xmlEventWriter.close();
    }

}
