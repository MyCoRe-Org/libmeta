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
 * FilterPicaXMLReaderDelegate kann benutzt werden um PicaPlus XML Dokumente
 * aus SRU-Response Dokumenten zu extrahieren
 * 
 * Die Klasse basiert auf der Java StAX API und kann als XMLEventReader benutzt
 * werden.
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

    private Queue<XMLEvent> queueOfNewEvents = new LinkedList<XMLEvent>();

    private XMLEventFactory eventFactory = XMLEventFactory.newInstance();

    private boolean showText = false;

    /**
     * Constructor
     * 
     * @param parentXMLEventReader - the parent XML event reader
     */
    public FilterPicaXMLFromSRUReaderDelegate(XMLEventReader parentXMLEventReader) {
        super(parentXMLEventReader);
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        if (!queueOfNewEvents.isEmpty()) {
            return queueOfNewEvents.poll();
        }

        XMLEvent xmlEvent = super.nextEvent();
        if (xmlEvent == null) {
            return null;
        }
        if (xmlEvent.isStartElement()) {
            if (xmlEvent.asStartElement().getName().equals(qnZSRecords)) {
                queueOfNewEvents.add(eventFactory.createStartElement(qnCollection, null, null));
                queueOfNewEvents.add(eventFactory.createNamespace("info:srw/schema/5/picaXML-v1.0"));
                return nextEvent();
            }
            if (xmlEvent.asStartElement().getName().equals(qnRecord)) {
                showText = true;
            }

            if (!xmlEvent.asStartElement().getName().getNamespaceURI().equals("info:srw/schema/5/picaXML-v1.0")) {
                return nextEvent();
            }

        }

        if (xmlEvent.isEndElement()) {
            if (xmlEvent.asEndElement().getName().equals(qnZSRecords)) {
                return eventFactory.createEndElement(qnCollection, null);
            }
            if (xmlEvent.asEndElement().getName().equals(qnRecord)) {
                showText = false;
            }
            if (!xmlEvent.asEndElement().getName().getNamespaceURI().equals("info:srw/schema/5/picaXML-v1.0")) {
                return nextEvent();
            }
        }
        if (xmlEvent.isCharacters() && !showText) {
            return nextEvent();
        }

        return xmlEvent;

    }

    /**
     * utility function to retrieve picaXML from SRU responses
     * 
     * @param in - the input XML
     * @param out - the output XML
     * @throws Exception - an error during processing occured
     */
    public static void filterPicaXML(Reader in, Writer out) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(inputFactory.createXMLEventReader(in));
        XMLEventWriter xmlEventWriter = outputFactory.createXMLEventWriter(out);

        while (xmlEventReader.hasNext()) {
            xmlEventWriter.add(xmlEventReader.nextEvent());
        }
        xmlEventReader.close();
        xmlEventWriter.close();
    }

}
