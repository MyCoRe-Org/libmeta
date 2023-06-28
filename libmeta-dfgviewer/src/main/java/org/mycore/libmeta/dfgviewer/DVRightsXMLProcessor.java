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
package org.mycore.libmeta.dfgviewer;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.common.IXMLProcessor;
import org.mycore.libmeta.dfgviewer.model.Rights;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * JAXB Marshaller allows only indentation up to 8th level and starts then on the first column again
 * bug report: https://java.net/jira/browse/JAXB-970
 * 
 * therefore we use the XSLT-Transformer for output
 */
public class DVRightsXMLProcessor implements IXMLProcessor<Rights> {

    private static final DVRightsXMLProcessor INSTANCE = new DVRightsXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private DVRightsXMLProcessor() {
    }

    public static DVRightsXMLProcessor getInstance() {
        return INSTANCE;
    }

    public Document marshalToDOM(Rights rights) throws Exception {
        return marshalToDOM(rights, null);
    }

    public Document marshalToDOM(Rights rights, String schemaLocations) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        JAXBContext jaxbContext = JAXBContext.newInstance(Rights.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        if (schemaLocations != null && schemaLocations.length() > 0) {
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
        }

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.marshal(rights, doc);
        return doc;
    }

    public void marshal(Rights rights, StreamResult streamResult, String schemaLocations) throws Exception {
        Document doc = marshalToDOM(rights, schemaLocations);
        doc.setXmlStandalone(true);

        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        
        Transformer transformer = factory.newTransformer();
        //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(doc), streamResult);
    }

    public void marshal(Rights rights, Path p, String schemaLocations) throws Exception {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(rights, stream, schemaLocations);
    }

    public void marshal(Rights rights, Path p) throws Exception {
        marshal(rights, p, null);
    }

    public String marshalToString(Rights rights, String schemaLocations) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(rights, stream, schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public String marshalToString(Rights rights) throws Exception {
        return marshalToString(rights, null);
    }

    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Rights.class);
        return jaxbContext.createUnmarshaller();
    }

    public Rights unmarshal(Node xml) throws Exception {
        return (Rights) createUnmarshaller().unmarshal(xml);
    }

    public Rights unmarshal(String xml) throws Exception {
        return (Rights) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public Rights unmarshal(Path p) throws Exception {
        return (Rights) createUnmarshaller().unmarshal(p.toFile());
    }

    public Rights unmarshal(URL url) throws Exception {
        return (Rights) createUnmarshaller().unmarshal(url);
    }
}
