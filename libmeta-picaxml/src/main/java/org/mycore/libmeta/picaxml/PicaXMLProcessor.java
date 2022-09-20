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
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.common.IXMLProcessor;
import org.mycore.libmeta.picaxml.model.PicaRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class PicaXMLProcessor implements IXMLProcessor<PicaRecord>{

    private static final PicaXMLProcessor INSTANCE = new PicaXMLProcessor();
    
    //private constructor to avoid client applications to use constructor
    private PicaXMLProcessor() {}
    
    public static PicaXMLProcessor getInstance() {
        return INSTANCE;
    }
    
    public Document marshalToDOM(PicaRecord pica) throws Exception {
        return marshalToDOM(pica, null);
    }

    public Document marshalToDOM(PicaRecord pica, String schemaLocations) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        JAXBContext jaxbContext = JAXBContext.newInstance(PicaRecord.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        if (schemaLocations != null && schemaLocations.length() > 0) {
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
        }

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.marshal(pica, doc);

        return doc;
    }

    public void marshal(PicaRecord pica, StreamResult streamResult, String schemaLocations) throws Exception {
        Document doc = marshalToDOM(pica, schemaLocations);
        doc.setXmlStandalone(true);
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        transformer.transform(new DOMSource(doc), streamResult);
    }

    public void marshal(PicaRecord pica, Path p, String schemaLocations) throws Exception {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(pica, stream, schemaLocations);
    }

    public void marshal(PicaRecord pica, Path p) throws Exception {
        marshal(pica, p, null);
    }

    public String marshalToString(PicaRecord pica, String schemaLocations) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(pica, stream, schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public String marshalToString(PicaRecord pica) throws Exception {
        return marshalToString(pica, null);
    }

    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(PicaRecord.class);
        return jaxbContext.createUnmarshaller();
    }

    public PicaRecord unmarshal(Node xml) throws Exception {
        return (PicaRecord) createUnmarshaller().unmarshal(xml);
    }

    public PicaRecord unmarshal(String xml) throws Exception {
        return (PicaRecord) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public PicaRecord unmarshal(Path p) throws Exception {
        return (PicaRecord) createUnmarshaller().unmarshal(p.toFile());
    }

    public  PicaRecord unmarshal(URL url) throws Exception {
        return (PicaRecord) createUnmarshaller().unmarshal(url);
    }

    public PicaRecord unmarshalFromSRU(URL url) throws Exception {
        URLConnection urlConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(
            inputFactory.createXMLEventReader(br));

        return (PicaRecord) createUnmarshaller().unmarshal(xmlEventReader);
    }
}
