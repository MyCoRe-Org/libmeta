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
package org.mycore.libmeta.mycoreclass;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.common.IXMLProcessor;
import org.mycore.libmeta.mycoreclass.model.Mycoreclass;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class MycoreclassProcessor implements IXMLProcessor<Mycoreclass> {

    private static final MycoreclassProcessor INSTANCE = new MycoreclassProcessor();

    //private constructor to avoid client applications to use constructor
    private MycoreclassProcessor() {
    }

    public static MycoreclassProcessor getInstance() {
        return INSTANCE;
    }

    public Document marshalToDOM(Mycoreclass pica) throws Exception {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        JAXBContext jaxbContext = JAXBContext.newInstance(Mycoreclass.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.marshal(pica, doc);

        return doc;
    }

    public void marshal(Mycoreclass pica, StreamResult streamResult) throws Exception {
        Document doc = marshalToDOM(pica);
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

    public void marshal(Mycoreclass pica, Path p) throws Exception {
        StreamResult stream = new StreamResult(Files.newBufferedWriter(p));
        marshal(pica, stream);
    }

    public String marshalToString(Mycoreclass pica) throws Exception {
        StringWriter sw = new StringWriter();
        StreamResult stream = new StreamResult(sw);
        marshal(pica, stream);
        return sw.toString().replaceAll("\\r\\n|\\r", "\n").trim();
    }

    private Unmarshaller createUnmarshaller() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Mycoreclass.class);
        return jaxbContext.createUnmarshaller();
    }

    public Mycoreclass unmarshal(Node xml) throws Exception {
        return (Mycoreclass) createUnmarshaller().unmarshal(xml);
    }

    public Mycoreclass unmarshal(String xml) throws Exception {
        return (Mycoreclass) createUnmarshaller().unmarshal(new StringReader(xml));
    }

    public Mycoreclass unmarshal(Path p) throws Exception {
        return (Mycoreclass) createUnmarshaller().unmarshal(p.toFile());
    }

    public Mycoreclass unmarshal(URL url) throws Exception {
        return (Mycoreclass) createUnmarshaller().unmarshal(url);
    }

    @Override
    public String marshalToString(Mycoreclass mc, String schemaLocations) throws Exception {
        return marshalToString(mc);
    }

    @Override
    public Document marshalToDOM(Mycoreclass mc, String schemaLocations) throws Exception {
        return marshalToDOM(mc);
    }

    @Override
    public void marshal(Mycoreclass mc, Path p, String schemaLocations) throws Exception {
        marshal(mc, p);

    }

    @Override
    public void marshal(Mycoreclass mc, StreamResult streamResult, String schemaLocations) throws Exception {
        marshal(mc, streamResult);
    }

}
