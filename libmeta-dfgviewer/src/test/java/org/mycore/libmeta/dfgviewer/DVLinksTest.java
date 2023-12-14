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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.dfgviewer.model.Links;
import org.mycore.libmeta.dfgviewer.model.links.Reference;

public class DVLinksTest {

    @Test
    public void testLinks() {
        Links links = Links.builder()
            .iiif("https://api.digitale-sammlungen.de/iiif/presentation/v2/bsb10128295/manifest")
            .presentation("https://mdz-nbn-resolving.de/urn:nbn:de:bvb:12-bsb10128295-4")
            .sru("https://api.digitale-sammlungen.de/sru/bsb10128295")
            .build();
        try {
            String actual = DVLinksXMLProcessor.getInstance().marshalToString(links);
            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:links xmlns:dv=\"http://dfg-viewer.de/\">\n"
                + "  <dv:presentation>https://mdz-nbn-resolving.de/urn:nbn:de:bvb:12-bsb10128295-4</dv:presentation>\n"
                + "  <dv:sru>https://api.digitale-sammlungen.de/sru/bsb10128295</dv:sru>\n"
                + "  <dv:iiif>https://api.digitale-sammlungen.de/iiif/presentation/v2/bsb10128295/manifest</dv:iiif>\n"
                + "</dv:links>";
            assertTrue("testLinks failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testLinksReferences() {
        Reference referenceOpac = Reference.builder()
            .linktext("OPAC")
            .content("https://opacplus.bsb-muenchen.de/title/BV022758208")
            .build();
        Reference referenceMarcXml = Reference.builder()
            .linktext("MARC-XML")
            .content("https://opacplus.bsb-muenchen.de/title/BV022758208?format=marc")
            .build();

        Links links = Links.builder()
            .addReference(referenceOpac)
            .addReference(referenceMarcXml)
            .build();
        try {
            String actual = DVLinksXMLProcessor.getInstance().marshalToString(links);
            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:links xmlns:dv=\"http://dfg-viewer.de/\">\n"
                + "  <dv:reference linktext=\"OPAC\">https://opacplus.bsb-muenchen.de/title/BV022758208</dv:reference>\n"
                + "  <dv:reference linktext=\"MARC-XML\">https://opacplus.bsb-muenchen.de/title/BV022758208?format=marc</dv:reference>\n"
                + "</dv:links>";
            assertTrue("testLinksReferences failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
