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
package org.mycore.libmeta.mods.junit5.model.physicaldescription;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._toplevel.PhysicalDescription;
import org.mycore.libmeta.mods.model.physicaldescription.DigitalOrigin;
import org.mycore.libmeta.mods.model.physicaldescription.Extent;
import org.mycore.libmeta.mods.model.physicaldescription.Form;
import org.mycore.libmeta.mods.model.physicaldescription.InternetMediaType;

/**
 * Examples from: https://www.loc.gov/standards/mods/userguide/physicaldescription.html
 * @author Robert Stephan
 *
 */
public class PhysicalDescriptionTest {
    public PhysicalDescriptionTest() {

    }

    @Test
    public void test1() {
        Mods mods = Mods.builder()
            .addContent(PhysicalDescription.builder()
                .addContent((Form) Form.builderForForm().authority("marcform").content("electronic").build())
                .addContent(InternetMediaType.builder().content("image/jpeg").build())
                .addContent(InternetMediaType.builder().content("text/html").build())
                .addContent(Extent.builder().content("5 digital files").build())
                .addContent(DigitalOrigin.BORN_DIGITAL)
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:physicalDescription>
                    <mods:form authority="marcform">electronic</mods:form>
                    <mods:internetMediaType>image/jpeg</mods:internetMediaType>
                    <mods:internetMediaType>text/html</mods:internetMediaType>
                    <mods:extent>5 digital files</mods:extent>
                    <mods:digitalOrigin>born digital</mods:digitalOrigin>
                  </mods:physicalDescription>
                </mods:mods>""";
            assertTrue("Test 3 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
}
