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
package org.mycore.libmeta.common;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public abstract class DefaultXMLProcessor<T> {

    private Class<T> objectClass;

    public DefaultXMLProcessor(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    public Document marshalToDOM(T t) throws LibmetaProcessorException {
        return marshalToDOM(t, null);
    }

    public Document marshalToDOM(T t, String schemaLocations) throws LibmetaProcessorException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            JAXBContext jaxbContext = createJAXBContext();
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            if (schemaLocations != null && schemaLocations.length() > 0) {
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocations);
            }

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.marshal(t, doc);

            return doc;
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public String marshalToString(T t) throws LibmetaProcessorException {
        return marshalToString(t, null);
    }

    public String marshalToString(T t, String schemaLocations) throws LibmetaProcessorException {
        StringWriter sw = new StringWriter();
        marshal(t, new StreamResult(sw), schemaLocations);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    public void marshal(T t, Path p, String schemaLocations) throws LibmetaProcessorException {
        StreamResult stream = new StreamResult(p.toFile());
        marshal(t, stream, schemaLocations);
    }

    public void marshal(T t, Path p) throws LibmetaProcessorException {
        marshal(t, p, null);
    }

    /**
     * JAXB Marshaller allows only indentation up to 8th level 
     * and starts then on the first column again
     * bug report: https://java.net/jira/browse/JAXB-970
     * 
     * therefore we use the XSLT-Transformer for output
     */
    public void marshal(T t, StreamResult streamResult, String schemaLocations) throws LibmetaProcessorException {
        try {
            Document doc = marshalToDOM(t, schemaLocations);
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
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public JAXBContext createJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(objectClass);
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(Node xml) throws LibmetaProcessorException {
        try {
            return (T) createJAXBContext().createUnmarshaller().unmarshal(xml);
        } catch (JAXBException e) {
            throw new LibmetaProcessorException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(Source xml) throws LibmetaProcessorException {
        try {
            return (T) createJAXBContext().createUnmarshaller().unmarshal(xml);
        } catch (JAXBException e) {
            throw new LibmetaProcessorException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(String xml) throws LibmetaProcessorException {
        try {
            return (T) createJAXBContext().createUnmarshaller().unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new LibmetaProcessorException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(Path p) throws LibmetaProcessorException {
        try {
            return (T) createJAXBContext().createUnmarshaller().unmarshal(p.toFile());
        } catch (JAXBException e) {
            throw new LibmetaProcessorException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(URL url) throws LibmetaProcessorException {
        try {
            return (T) createJAXBContext().createUnmarshaller().unmarshal(url);
        } catch (JAXBException e) {
            throw new LibmetaProcessorException(e);
        }
    }
}
