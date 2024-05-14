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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.dcsimple.DCQuery;
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCTitle;
import org.mycore.libmeta.oaidc.model.OaiDc;

public class OaiDcXMLProcessorTest {

    @Test
    public void testMarshalToString() {
        DCTitle title = DCTitle.builder().value("Using Structural Metadata to Localize Experience of Digital Content").build();
        DCContributor contributor = DCContributor.builder().lang("de").value("Max Meier").build();

        OaiDc oaiDc = OaiDc.builder()
            .add(title)
            .add(contributor)
            .build();
        try {
            String actual = OaiDcXMLProcessor.getInstance().marshalToString(oaiDc);
            String expected = """
            	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            	<oai_dc:dc xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:oai_dc="http://www.openarchives.org/OAI/2.0/oai_dc/">
            	  <dc:title>Using Structural Metadata to Localize Experience of Digital Content</dc:title>
            	  <dc:contributor xml:lang="de">Max Meier</dc:contributor>
            	</oai_dc:dc>""";
            assertTrue("testMarshalToString failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        String expected
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <oai_dc:dc xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:oai_dc="http://www.openarchives.org/OAI/2.0/oai_dc/">
                  <dc:title>Using Structural Metadata to Localize Experience of Digital Content</dc:title>
                  <dc:contributor xml:lang="de">Max Meier</dc:contributor>
                </oai_dc:dc>""";
        try {
            OaiDc odaDC = OaiDcXMLProcessor.getInstance().unmarshal(expected);
            DCContributor dcContributor = DCQuery.streamFilteredContent(odaDC, DCContributor.class).findFirst().get();
            assertEquals("Test 2 failed for DCContributor", dcContributor.getValue(), "Max Meier");
            
            DCTitle dcTitle = DCQuery.listFilteredContent(odaDC, DCTitle.class).get(0);
            assertEquals("Test 2 failed for DCTitle", dcTitle.getValue(),
                "Using Structural Metadata to Localize Experience of Digital Content");

        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
}
