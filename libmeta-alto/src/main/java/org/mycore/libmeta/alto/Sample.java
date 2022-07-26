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

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mycore.libmeta.alto.model.Alto;
import org.w3c.dom.Document;

public class Sample {

    public static void main(String[] args) {
        try {
            Path pIn = Paths.get("C:\\workspaces\\varia\\git\\metadata\\samples\\alto\\alto-2-1-draft-tagsample-1.xml");
            Path pOut = Paths
                .get("C:\\workspaces\\varia\\git\\metadata\\samples\\alto\\out_alto-2-1-draft-tagsample-1.xml");

            format(pIn);

            Alto alto = AltoXMLProcessor.getInstance().unmarshal(pIn);
            AltoXMLProcessor.getInstance().marshal(alto, pOut);

            //XMLFormatter.prettyPrintXML(pOut);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void format(Path p) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(p.toFile());

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        try (OutputStream os = Files.newOutputStream(p.getParent().resolve("x_" + p.getFileName().toString()))) {
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
        }

    }

}
