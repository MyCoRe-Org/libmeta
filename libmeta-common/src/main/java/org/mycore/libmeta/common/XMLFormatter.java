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

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLFormatter {
    private static XPathFactory XPATH_FACTORY = XPathFactory.newInstance();

    private static DocumentBuilderFactory DB_FACTORY = DocumentBuilderFactory.newInstance();
    static {
        DB_FACTORY.setNamespaceAware(true);
    }

    public static Document parseFromResource(String resource) {
        Document doc = null;
        try {
            DocumentBuilder builder = DB_FACTORY.newDocumentBuilder();
            doc = builder.parse(XMLFormatter.class.getResourceAsStream(resource));
            doc.setXmlStandalone(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;

    }

    /**
     * reads the given file into an XML Document,
     * removes empty text nodes
     * overwrites the input file with the formated version
     * 
     * @param p the XML file to be formatted
     */
    public static void prettyPrintXML(Path p) {
        try {
            DocumentBuilder builder = DB_FACTORY.newDocumentBuilder();
            Document doc = null;
            try (InputStream is = Files.newInputStream(p)) {
                doc = builder.parse(is);
                doc.setXmlStandalone(true);
            }
            cleanEmptyTextNodes(doc);
            prettyPrintXML(doc, p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * formats the given XML document and outputs it into a file,
     * removes empty text nodes
     * overwrites the input file with the formated version
     * 
     * @param doc the XML document
     * @param p the XML file for output
     */
    public static void prettyPrintXML(Document doc, Path p) {
        //output with indent
        try (OutputStream os = Files.newOutputStream(p)) {
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            tf.transform(new DOMSource(doc), new StreamResult(os));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * identify "empty" text nodes and remove them 
     * @param doc the XML document
     */
    public static void cleanEmptyTextNodes(Document doc) {
        try {
            XPath xpath = XPATH_FACTORY.newXPath();

            NodeList empty = (NodeList) xpath.evaluate("//text()[normalize-space(.) = '']",
                doc, XPathConstants.NODESET);
            for (int i = 0; i < empty.getLength(); i++) {
                Node node = empty.item(i);
                node.getParentNode().removeChild(node);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
