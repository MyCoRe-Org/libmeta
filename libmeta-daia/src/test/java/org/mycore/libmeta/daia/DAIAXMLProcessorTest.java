
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.daia.model.Availability;
import org.mycore.libmeta.daia.model.DAIA;

public class DAIAXMLProcessorTest {

    @Test
    public void test() {
        String daiaTest
            = """
                <?xml version="1.0" encoding="UTF-8"?>
                <daia xmlns="http://ws.gbv.de/daia/" timestamp="2023-11-29T10:59:08Z" version="0.5">
                  <institution id="http://uri.gbv.de/organization/isil/DE-28">UB Rostock und Bibliotheken im Regionalverbund</institution>
                  <document id="http://uri.gbv.de/document/opac-de-28:ppn:56147334X" href="http://lbsrow.gbv.de:8080/DB=1/PPNSET?PPN=56147334X">
                    <item id="http://uri.gbv.de/document/opac-de-28:epn:867987251" href="http://lbsrow.gbv.de:8080/DB=1/PPNSET?PPN=56147334X">
                      <department id="http://uri.gbv.de/organization/isil/DE-28">UB Rostock und Bibliotheken im Regionalverbund</department>
                      <available service="presentation" href="http://rosdok.uni-rostock.de/resolve?urn=urn:nbn:de:gbv:28-diss2008-0004-4&amp;pdf" />
                      <unavailable service="openaccess" href="http://rosdok.uni-rostock.de/resolve?urn=urn:nbn:de:gbv:28-diss2008-0004-4&amp;pdf" />
                    </item>
                  </document>
                </daia>""";

        try {
            DAIA daia = DAIAXMLProcessor.getInstance().unmarshal(daiaTest);
            assertEquals("timestamp failed", "2023-11-29T10:59:08Z", daia.getTimestamp());
            assertEquals("url failed", "http://rosdok.uni-rostock.de/resolve?urn=urn:nbn:de:gbv:28-diss2008-0004-4&pdf",
                daia.getDocument().get(0).getItem().get(0).getAvailable().get(0).getHref());
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void test2() {
        String daiaTest
            = """
                <?xml version="1.0" encoding="UTF-8"?>
                <?xml-stylesheet type="text/xsl" href="/daia.xsl"?>
                <daia timestamp="2023-11-29T11:12:29Z" version="0.5" xmlns="http://ws.gbv.de/daia/">
                  <institution id="http://uri.gbv.de/organization/isil/DE-28">UB Rostock und Bibliotheken im Regionalverbund</institution>
                  <document href="http://lbsrow.gbv.de:8080/DB=1/PPNSET?PPN=782683118" id="http://uri.gbv.de/document/opac-de-28:ppn:782683118">
                    <item href="http://lbsrow.gbv.de:8080/DB=1/PPNSET?PPN=782683118" id="http://uri.gbv.de/document/opac-de-28:epn:1518739113">
                      <label>ST 250 J35 U77</label>
                      <department id="http://uri.gbv.de/organization/isil/DE-28">UB Rostock und Bibliotheken im Regionalverbund</department>
                      <storage>BB Südstadt</storage>
                      <available service="loan" />
                      <available service="presentation" />
                      <available service="interloan" />
                    </item>
                  </document>
                </daia>""";

        try {
            DAIA daia = DAIAXMLProcessor.getInstance().unmarshal(daiaTest);
            assertEquals("Storage failed", "BB Südstadt",
                daia.getDocument().get(0).getItem().get(0).getStorage().getContent());
            assertEquals("available failed",
                Arrays.asList(Availability.Service.LOAN, Availability.Service.PRESENTATION,
                    Availability.Service.INTERLOAN),
                daia.getDocument().get(0).getItem().get(0).getAvailable().stream().map(x -> x.getService())
                    .collect(Collectors.toList()));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }

    }
}
