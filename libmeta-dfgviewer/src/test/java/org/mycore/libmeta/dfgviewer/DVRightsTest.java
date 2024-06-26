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
import org.mycore.libmeta.dfgviewer.model.Rights;

public class DVRightsTest {

    @Test
    public void testRights() {
        Rights rights = Rights.builder().build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <dv:rights xmlns:dv="http://dfg-viewer.de/"/>""";
            assertTrue("testRights failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testRightsOwner() {
        Rights rights = Rights.builder()
            .owner("SLUB Dresden")
            .ownerContact("mailto:sebastian.meyer@slub-dresden.de")
            .ownerLogo("http://digital.slub-dresden.de/logo.gif")
            .ownerSiteURL("http://digital.slub-dresden.de/")
            .build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <dv:rights xmlns:dv="http://dfg-viewer.de/">
                  <dv:owner>SLUB Dresden</dv:owner>
                  <dv:ownerLogo>http://digital.slub-dresden.de/logo.gif</dv:ownerLogo>
                  <dv:ownerSiteURL>http://digital.slub-dresden.de/</dv:ownerSiteURL>
                  <dv:ownerContact>mailto:sebastian.meyer@slub-dresden.de</dv:ownerContact>
                </dv:rights>""";
            assertTrue("testRightsOwner failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testRightsAggregator() {
        Rights rights = Rights.builder()
            .aggregator("Deutsche Digitale Bibliothek")
            .aggregatorLogo(
                "https://www.deutsche-digitale-bibliothek.de/assets/ddb-logo-lg-rgb-4b633e7f7a160aa54ced8b0b2c0609ac.svg")
            .aggregatorSiteURL("https://www.deutsche-digitale-bibliothek.de/")
            .build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            String expected
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <dv:rights xmlns:dv="http://dfg-viewer.de/">
                      <dv:aggregator>Deutsche Digitale Bibliothek</dv:aggregator>
                      <dv:aggregatorLogo>https://www.deutsche-digitale-bibliothek.de/assets/ddb-logo-lg-rgb-4b633e7f7a160aa54ced8b0b2c0609ac.svg</dv:aggregatorLogo>
                      <dv:aggregatorSiteURL>https://www.deutsche-digitale-bibliothek.de/</dv:aggregatorSiteURL>
                    </dv:rights>""";
            assertTrue("testRightsAggregator failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testRightsSponsor() {
        Rights rights = Rights.builder()
            .sponsor("Deutsche Forschungsgemeinschaft")
            .sponsorLogo("https://www.dfg.de/zentralablage/bilder/service/logos_corporate_design/logo_blau_267.png")
            .sponsorSiteURL("https://www.dfg.de/")
            .build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            String expected
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <dv:rights xmlns:dv="http://dfg-viewer.de/">
                      <dv:sponsor>Deutsche Forschungsgemeinschaft</dv:sponsor>
                      <dv:sponsorLogo>https://www.dfg.de/zentralablage/bilder/service/logos_corporate_design/logo_blau_267.png</dv:sponsorLogo>
                      <dv:sponsorSiteURL>https://www.dfg.de/</dv:sponsorSiteURL>
                    </dv:rights>""";
            assertTrue("testRightsSponsor failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testRightsLicense() {
        Rights rights = Rights.builder()
            .license("pdm")
            .build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <dv:rights xmlns:dv="http://dfg-viewer.de/">
                  <dv:license>pdm</dv:license>
                </dv:rights>""";
            assertTrue("testRightsLicense failed", expected.equals(actual));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
