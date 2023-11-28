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
package org.mycore.libmeta.dcsimple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCElement;
import org.mycore.libmeta.dcsimple.xml.DCSimpleXMLProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DCSimpleXMLProcessorTest {

    @Test
    public void testMarshalToString() {
        DCElement contributor = DCContributor.builder().lang("de").value("Max Meier").build();
        try {
            String actual = DCSimpleXMLProcessor.getInstance().marshalToString(contributor);
            System.out.println(actual);

            System.out.println("---");

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dc:contributor xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xml:lang=\"de\">Max Meier</dc:contributor>";
            System.out.println(expected);

            assertTrue("testMarshalToString failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMarshalToDom() {
        DCElement contributor = DCContributor.builder().lang("de").value("Max Meier").build();
        try {
            Document actual = DCSimpleXMLProcessor.getInstance().marshalToDOM(contributor);
            Element documentElement = actual.getDocumentElement();
            String nodeName = documentElement.getNodeName();
            String lang = documentElement.getAttribute("xml:lang");
            String value = documentElement.getTextContent();

            assertEquals("dc:contributor", nodeName);
            assertEquals("de", lang);
            assertEquals("Max Meier", value);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    //@Test
    public void testUnMarshalFromString() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<dc:contributor xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xml:lang=\"de\">Max Meier</dc:contributor>";
        try {
            DCElement actual = DCSimpleXMLProcessor.getInstance().unmarshal(xml);
            assertEquals(actual.getClass(), DCContributor.class);
            DCContributor ctb = (DCContributor) actual;
            assertEquals("de", ctb.getLang());
            assertEquals("Max Meier", ctb.getValue());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
