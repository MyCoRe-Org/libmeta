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
package org.mycore.libmeta.alto;

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

import org.mycore.libmeta.alto.model.Alto;
import org.mycore.libmeta.common.IXMLProcessor;
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

public class AltoXMLProcessor implements IXMLProcessor<Alto> {

    private static final AltoXMLProcessor INSTANCE = new AltoXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private AltoXMLProcessor() {
    };

    public static AltoXMLProcessor getInstance() {
        return INSTANCE;
    }

    public Document marshalToDOM(Alto alto) throws Exception {
        return marshalToDOM(alto, null);
    }

    public Document marshalToDOM(Alto alto, String schemaLocations) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        JAXBContext jaxbContext = JAXBContext.newInstance(Alto.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        if (schemaLocations != null && schemaLocations.length() > 0) {
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
        }

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.marshal(alto, doc);

        return doc;
    }

    public void marshal(Alto alto, StreamResult streamResult, String schemaLocations) throws Exception {
        Document doc = marshalToDOM(alto, schemaLocations);
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

    public void marshal(Alto alto, Path p, String schemaLocations) throws Exception {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(alto, stream, schemaLocations);
    }

    public void marshal(Alto alto, Path p) throws Exception {
        marshal(alto, p, null);
    }

    public String marshalToString(Alto alto, String schemaLocations) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(alto, stream, schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public String marshalToString(Alto alto) throws Exception {
        return marshalToString(alto, null);
    }

    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Alto.class);
        return jaxbContext.createUnmarshaller();
    }

    public Alto unmarshal(Node xml) throws Exception {
        return (Alto) createUnmarshaller().unmarshal(xml);
    }

    public Alto unmarshal(String xml) throws Exception {
        return (Alto) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public Alto unmarshal(Path p) throws Exception {
        return (Alto) createUnmarshaller().unmarshal(p.toFile());
    }

    public Alto unmarshal(URL url) throws Exception {
        return (Alto) createUnmarshaller().unmarshal(url);
    }
}
