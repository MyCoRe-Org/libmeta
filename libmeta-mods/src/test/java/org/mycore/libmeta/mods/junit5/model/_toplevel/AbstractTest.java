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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.enums.No;
import org.mycore.libmeta.mods.model._toplevel.Abstract;

/**
 * examples taken from http://www.loc.gov/standards/mods/userguide/abstract.html
 * @author Robert Stephan
 */

public class AbstractTest {
    public AbstractTest() {

    }

    @Test
    public void test1() {
        Mods mods = Mods.builder().addContent(Abstract.builder().displayLabel("Content description")
            .content("Broadside advertising ... Academy Hall").build()).build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            System.out.println(s);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:abstract displayLabel=\"Content description\">Broadside advertising ... Academy Hall</mods:abstract>"
                + "\n</mods:mods>";
            System.out.println(r);
            assertTrue("Test 1 failed", r.equals(s));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        Mods mods = Mods.builder().addContent(Abstract.builder().shareable(No.NO)
            .content("Describes the results of an ongoing evaluation ...").build()).build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            System.out.println(s);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:abstract shareable=\"no\">Describes the results of an ongoing evaluation ...</mods:abstract>"
                + "\n</mods:mods>";
            assertTrue("Test 2 failed", r.equals(s));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test3() {
        Mods mods = Mods.builder()
            .addContent(Abstract.builder().xmlLang("fr").type("summary")
                .xlinkHref("http://www.allocine.fr/film/fichefilm_gen_cfilm=808.html")
                .content("A la fin du XIXème siècle, Rudyard Kipling, ...").build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            System.out.println(s);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:abstract type=\"summary\" xlink:href=\"http://www.allocine.fr/film/fichefilm_gen_cfilm=808.html\" xml:lang=\"fr\">A la fin du XIXème siècle, Rudyard Kipling, ...</mods:abstract>"
                + "\n</mods:mods>";
            System.out.println(r);
            assertTrue("Test 3 failed", r.equals(s));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test4() {
        Mods mods = Mods.builder()
            .addContent(Abstract.builder().xlinkHref("http://sunsite.berkeley.edu/CurrentCites/2003/cc03.14.3.html")
                .displayLabel("Review")
                .content("Written in a rather whimsical style ...").build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            System.out.println(s);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:abstract displayLabel=\"Review\" xlink:href=\"http://sunsite.berkeley.edu/CurrentCites/2003/cc03.14.3.html\">Written in a rather whimsical style ...</mods:abstract>"
                + "\n</mods:mods>";
            assertTrue("Test 4 failed", r.equals(s));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}