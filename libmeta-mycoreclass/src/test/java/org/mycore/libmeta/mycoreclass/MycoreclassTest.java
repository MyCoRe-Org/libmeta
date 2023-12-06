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
package org.mycore.libmeta.mycoreclass;

import java.net.URL;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.Test;
import org.mycore.libmeta.mycoreclass.model.Category;
import org.mycore.libmeta.mycoreclass.model.Label;
import org.mycore.libmeta.mycoreclass.model.Mycoreclass;

public class MycoreclassTest {

    @Test
    public void test1() {
        MycoreclassXMLProcessor processor = MycoreclassXMLProcessor.getInstance();
        try {
            Mycoreclass m = processor
                .unmarshal(new URL("https://rosdok.uni-rostock.de/api/v1/classifications/accesscondition"));
            Assert.assertEquals("nicht zugänglich", MycoreclassQuery.findLabelText(m, "closedaccess", "de"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        MycoreclassXMLProcessor processor = MycoreclassXMLProcessor.getInstance();
        Mycoreclass m2 = Mycoreclass.builder()
            .ID("accesscondition")
            .addLabel(Label.builder().xmlLang("x-openaire").text("info:eu-repo/semantics/openAccess").build())
            .addLabel(Label.builder().xmlLang("de").text("Zugangsbedingung").build())
            .addLabel(Label.builder().xmlLang("en").text("access condition").build())
            .addCategory(Category.builder().ID("openaccess")
                .addLabel(Label.builder().xmlLang("x-openaire").text("info:eu-repo/semantics/openAccess").build())
                .addLabel(Label.builder().xmlLang("de").text("frei zugänglich (Open Access)").build())
                .addLabel(Label.builder().xmlLang("de").text("frei zugänglich")
                    .description("frei zugänglich (Open Access)").build())
                .build())
            .addCategory(Category.builder().ID("restrictedaccess")
                .addLabel(Label.builder().xmlLang("x-openaire").text("info:eu-repo/semantics/openAccess").build())
                .addLabel(Label.builder().xmlLang("de").text("beschränkter Zugang").build())
                .addLabel(Label.builder().xmlLang("de").text("beschränkter Zugang").build())
                .addCategory(Category.builder().ID("restictedaccess.unirostock")
                    .addLabel(
                        Label.builder().xmlLang("de").text("beschränkter Zugang: Universität Rostock").build())
                    .addLabel(Label.builder().xmlLang("en").text("restricted access: Rostock University").build())
                    .build())
                .build())
            .build();
        try {
            processor.marshal(m2, Files.createTempFile("collection", ".xml"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3() {
        MycoreclassXMLProcessor processor = MycoreclassXMLProcessor.getInstance();
        try {
            Mycoreclass m3 = processor
                .unmarshal(new URL("https://rosdok.uni-rostock.de/api/v1/classifications/collection"));
            processor.marshal(m3, Files.createTempFile("collection", ".xml"));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4() {
        MycoreclassXMLProcessor processor = MycoreclassXMLProcessor.getInstance();
        try {
            Mycoreclass m4 = processor
                .unmarshal(new URL("https://rosdok.uni-rostock.de/api/v1/classifications/doctype"));

            Assert.assertEquals("Musikhandschrift",
                MycoreclassQuery.findLabelText(m4, "histbest.musicalsource.manuscript", "de"));

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

}
