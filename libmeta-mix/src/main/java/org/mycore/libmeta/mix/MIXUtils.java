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
package org.mycore.libmeta.mix;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mycore.libmeta.mix.model.Mix;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class MIXUtils {
    public static void marshal(Mix mix, File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mix.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                "http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix.xsd");
            
            jaxbMarshaller.marshal(mix, f);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshal(Mix mix, Path p) {
        marshal(mix, p.toFile());
    }

    public static Document marshalToDOM(Mix mix) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            JAXBContext jaxbContext = JAXBContext.newInstance(Mix.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.marshal(mix, doc);

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Mix unmarshal(File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mix.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Mix mix = (Mix) jaxbUnmarshaller.unmarshal(f);

            return mix;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Mix unmarshal(Path p) {
        return unmarshal(p.toFile());
    }

    public static Mix unmarshal(URL url) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mix.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Mix p = (Mix) jaxbUnmarshaller.unmarshal(url);

            return p;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Mix unmarshal(Node n) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mix.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Mix mix = (Mix) jaxbUnmarshaller.unmarshal(n);

            return mix;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

}
