
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
package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._toplevel.RecordInfo;
import org.mycore.libmeta.mods.model.recordinfo.RecordContentSource;
import org.mycore.libmeta.mods.model.recordinfo.RecordIdentifier;
import org.mycore.libmeta.mods.model.recordinfo.RecordOrigin;

public class RecordInfoTest {

    @Test
    public void test1() {
        String expected
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:recordInfo usage="primary">
                    <mods:recordContentSource authority="marcorg">MH</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">830804</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">20080122</mods:recordContentSource>
                    <mods:recordIdentifier source="ALMA">990000035150203941_FHCL.HOUGH:37522572</mods:recordIdentifier>
                    <mods:recordOrigin>Converted from MARCXML to MODS version 3.8</mods:recordOrigin>
                  </mods:recordInfo>
                </mods:mods>""";
        Mods mods = Mods.builder()
            .addContent(RecordInfo.builder()
                .usage(Usage.PRIMARY)
                .addContent(RecordContentSource.builder()
                    .authority("marcorg")
                    .content("MH")
                    .build())
                .addContent(RecordContentSource.builder()
                    .authority("marcorg")
                    .content("830804")
                    .build())
                .addContent(RecordContentSource.builder()
                    .authority("marcorg")
                    .content("20080122")
                    .build())
                .addContent(RecordIdentifier.builder()
                    .source("ALMA")
                    .content("990000035150203941_FHCL.HOUGH:37522572")
                    .build())
                .addContent(RecordOrigin.builder()
                    .content("Converted from MARCXML to MODS version 3.8")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            assertEquals("Test 1 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
}
