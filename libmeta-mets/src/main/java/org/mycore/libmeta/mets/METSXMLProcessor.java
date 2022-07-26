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
package org.mycore.libmeta.mets;

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
import org.mycore.libmeta.mets.model.Mets;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * JAXB Marshaller allows only indentation up to 8th level and starts then on the first column again
 * bug report: https://java.net/jira/browse/JAXB-970
 * 
 * therefore we use xslt transformer for output
 * 
 * @author Robert Stephan
 */

public class METSXMLProcessor implements IXMLProcessor<Mets>{
    
    private static final METSXMLProcessor INSTANCE = new METSXMLProcessor();
    
    //private constructor to avoid client applications to use constructor
    private METSXMLProcessor() {}
    
    public static METSXMLProcessor getInstance() {
        return INSTANCE;
    }
    
    public Document marshalToDOM(Mets mets) throws Exception {
        return marshalToDOM(mets, null);
    }

    public Document marshalToDOM(Mets mets, String schemaLocations) throws Exception {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            JAXBContext jaxbContext = JAXBContext.newInstance(Mets.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            if (schemaLocations != null && schemaLocations.length() > 0) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
            }

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.marshal(mets, doc);

            return doc;
    }

    public void marshal(Mets mets, StreamResult streamResult, String schemaLocations) throws Exception{
        Document doc = marshalToDOM(mets, schemaLocations);
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
    
    public void marshal(Mets mets, Path p, String schemaLocations) throws Exception {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(mets, stream, schemaLocations);
    }

    public void marshal(Mets mets, Path p) throws Exception {
        marshal(mets, p, null);
    }

    public String marshalToString(Mets mets, String schemaLocations) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(mets, stream, schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public String marshalToString(Mets mets) throws Exception {
        return marshalToString(mets, null);
    }
    
    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Mets.class);
        return jaxbContext.createUnmarshaller();
    }

    public Mets unmarshal(Node xml) throws Exception {
        return (Mets) createUnmarshaller().unmarshal(xml);
    }

    public Mets unmarshal(String xml) throws Exception {
        return (Mets) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public Mets unmarshal(Path p) throws Exception {
        return (Mets) createUnmarshaller().unmarshal(p.toFile());
    }

    public Mets unmarshal(URL url) throws Exception {
        return (Mets) createUnmarshaller().unmarshal(url);
    }
}
