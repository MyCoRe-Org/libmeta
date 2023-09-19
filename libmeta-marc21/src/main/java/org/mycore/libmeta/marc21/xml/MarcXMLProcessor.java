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
package org.mycore.libmeta.marc21.xml;


import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.common.IXMLProcessor;
import org.mycore.libmeta.marc21.model.MarcRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class MarcXMLProcessor implements IXMLProcessor<MarcRecord>{

private static final MarcXMLProcessor INSTANCE = new MarcXMLProcessor();
    
    //private constructor to avoid client applications to use constructor
    private MarcXMLProcessor() {}
    
    public static MarcXMLProcessor getInstance() {
        return INSTANCE;
    }
    
    public Document marshalToDOM(MarcRecord marc) throws Exception {
        return marshalToDOM(marc, null);
    }

    public Document marshalToDOM(MarcRecord marc, String schemaLocations) throws Exception {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            JAXBContext jaxbContext = JAXBContext.newInstance(MarcRecord.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            if (schemaLocations != null && schemaLocations.length() > 0) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
            }

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.marshal(marc, doc);

            return doc;
    }

    public void marshal(MarcRecord marc, StreamResult streamResult, String schemaLocations) throws Exception{
            Document doc = marshalToDOM(marc, schemaLocations);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(new DOMSource(doc), streamResult);
    }

    public void marshal(MarcRecord marc, Path p, String schemaLocations) throws Exception {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(marc, stream, schemaLocations);
    }

    public void marshal(MarcRecord marc, Path p) throws Exception {
        marshal(marc, p, null);
    }

    public String marshalToString(MarcRecord marc, String schemaLocations) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(marc, stream, schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public String marshalToString(MarcRecord marc) throws Exception {
        return marshalToString(marc, null);
    }

    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(MarcRecord.class);
        return jaxbContext.createUnmarshaller();
    }

    public MarcRecord unmarshal(Node xml) throws Exception {
        return (MarcRecord) createUnmarshaller().unmarshal(xml);
    }

    public MarcRecord unmarshal(String xml) throws Exception {
        return (MarcRecord) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public MarcRecord unmarshal(Path p) throws Exception {
        return (MarcRecord) createUnmarshaller().unmarshal(p.toFile());
    }

    public MarcRecord unmarshal(URL url) throws Exception {
        return (MarcRecord) createUnmarshaller().unmarshal(url);
    }
}
