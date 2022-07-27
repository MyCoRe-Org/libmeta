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
package org.mycore.libmeta.daia;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.daia.model.DAIA;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class DAIAXMLProcessor {
 private static final DAIAXMLProcessor INSTANCE = new DAIAXMLProcessor();
    
    //private constructor to avoid client applications to use constructor
    private DAIAXMLProcessor() {}
    
    public static DAIAXMLProcessor getInstance() {
        return INSTANCE;
    }
    
    public static void marshal(DAIA daia, Path p) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DAIA.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                "http://ws.gbv.de/daia/ https://raw.githubusercontent.com/gbv/daia/master/schemas/daia.xsd");
            // NamespacePrefixMapper mapper = new NamespacePrefixMapper(){
            // jaxbMarshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper",
            // mapper);
            StreamResult stream = new StreamResult(p.toFile());
            jaxbMarshaller.marshal(daia, stream);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Document marshalToDOM(DAIA daia) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            JAXBContext jaxbContext = JAXBContext.newInstance(DAIA.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.marshal(daia, doc);

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DAIA unmarshal(Path p) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DAIA.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            DAIA daia = (DAIA) jaxbUnmarshaller.unmarshal(p.toFile());

            return daia;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DAIA unmarshal(URL url) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DAIA.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            DAIA p = (DAIA) jaxbUnmarshaller.unmarshal(url);

            return p;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static DAIA unmarshal(Node n) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DAIA.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            DAIA daia = (DAIA) jaxbUnmarshaller.unmarshal(n);

            return daia;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            DAIA daia = DAIAXMLProcessor.unmarshal(new URL("http://daia.gbv.de/?format=xml&id=opac-de-28%3Appn%3A56147334X"));
            System.out.println(daia.getTimestamp());
            System.out.println(daia.getDocument().get(0).getItem().get(0).getAvailable().get(0).getHref());

            DAIA daia2 = DAIAXMLProcessor.unmarshal(new URL("http://daia.gbv.de/?format=xml&id=opac-de-28%3Appn%3A782683118"));
            System.out.println(daia2.getTimestamp());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
