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
package org.mycore.libmeta.oaidc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCElement;
import org.mycore.libmeta.dcsimple.model.DCTitle;
import org.mycore.libmeta.oaidc.model.OaiDc;
import org.mycore.libmeta.oaidc.xml.OaiDcXMLProcessor;

public class OaiDcXMLProcessorTest {

    @Test
    public void testMarshalToString() {
        DCElement title = DCTitle.builder().value("Using Structural Metadata to Localize Experience of Digital Content").build();
        DCElement contributor = DCContributor.builder().lang("de").value("Max Meier").build();

        OaiDc oaiDc = OaiDc.builder()
            .add(title)
            .add(contributor)
            .build();
        try {
            String actual = OaiDcXMLProcessor.getInstance().marshalToString(oaiDc);
            System.out.println(actual);

            System.out.println("---");

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<oai_dc:dc xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\">\n"
                + "  <dc:title>Using Structural Metadata to Localize Experience of Digital Content</dc:title>\n"
                + "  <dc:contributor xml:lang=\"de\">Max Meier</dc:contributor>\n"
                + "</oai_dc:dc>";
            System.out.println(expected);

            assertTrue("testMarshalToString failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
