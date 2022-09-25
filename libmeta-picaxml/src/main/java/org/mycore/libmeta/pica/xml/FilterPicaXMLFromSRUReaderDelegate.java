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
package org.mycore.libmeta.picaxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
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
 * Die main() Methode enthält Beispielcode für die Verwendung.
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

    /**
     * Main Funktion mit Beispiel-Code zur Demonstration.
     * 
     * @param args - the default input parameters (empty)
     * @throws Exception - if anything goes wrong
     */
    public static void main(String[] args) throws Exception {
        // 574683887
        // String SOURCE_URL =
        // "http://sru.gbv.de/vd17?version=1.1&operation=searchRetrieve&maximumRecords=1&recordSchema=picaxml&query=pica.ppn%3D006901972";
        // File OUTPUT_FILE = new File("C:\\temp\\ppn_006901972_local.xml");

        //String SOURCE_URL = "http://sru.gbv.de/gvk?version=1.1&operation=searchRetrieve&maximumRecords=1&recordSchema=picaxml&query=pica.ppn%3D340126604";
        String SOURCE_URL = "http://sru.gbv.de/gvk?version=1.1&operation=searchRetrieve&maximumRecords=1&recordSchema=picaxml&query=pica.url%3Dpurl.uni-rostock.de*";
        File OUTPUT_FILE = new File(
            "F:\\workspaces\\vaadin\\projects\\metadata\\target\\output\\picaxml\\ppn_340126604_local.xml");
        OUTPUT_FILE.getParentFile().mkdirs();

        URL url = new URL(SOURCE_URL);
        URLConnection urlConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), "UTF-8"));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));

        filterPicaXML(br, bw);
    }
}
