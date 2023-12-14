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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.CodeOrText;
import org.mycore.libmeta.mods.model._misc.enums.NamePartType;
import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._misc.enums.TitleInfoType;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model._toplevel.TitleInfo;
import org.mycore.libmeta.mods.model.name.NamePart;
import org.mycore.libmeta.mods.model.name.Role;
import org.mycore.libmeta.mods.model.name.RoleTerm;
import org.mycore.libmeta.mods.model.titleInfo.NonSort;
import org.mycore.libmeta.mods.model.titleInfo.PartName;
import org.mycore.libmeta.mods.model.titleInfo.PartNumber;
import org.mycore.libmeta.mods.model.titleInfo.SubTitle;
import org.mycore.libmeta.mods.model.titleInfo.Title;

/**
 * Examples from: http://www.loc.gov/standards/mods/userguide/titleinfo.html
 * @author Robert Stephan
 *
 */
public class TitleInfoTest {
    public TitleInfoTest() {

    }

    @Test
    public void test1() {
        Mods mods = Mods.builder()
            .addContent(
                TitleInfo.builder()
                    .addContent(Title.builder().content("Bush Cheney").build())
                    .build())
            .build();

        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo>"
                + "\n    <mods:title>Bush Cheney</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 1 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        Mods mods = Mods.builder()
            .addContent(
                TitleInfo.builder()
                    .type(TitleInfoType.ALTERNATIVE)
                    .displayLabel("also known as")
                    .addContent(Title.builder().content("Bush-Cheney 2000").build())
                    .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo displayLabel=\"also known as\" type=\"alternative\">"
                + "\n    <mods:title>Bush-Cheney 2000</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 2 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test3() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .addContent(NonSort.builder().content("The ").build())
                .addContent(Title.builder().content("\"wintermind\"").build())
                .addContent(SubTitle.builder().content("William Bonk and American letters").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo>"
                + "\n    <mods:nonSort>The </mods:nonSort>"
                + "\n    <mods:title>\"wintermind\"</mods:title>"
                + "\n    <mods:subTitle>William Bonk and American letters</mods:subTitle>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 3 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test4() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .xmlLang("fr").type(TitleInfoType.TRANSLATED)
                .addContent(NonSort.builder().content("L'").build())
                .addContent(Title.builder().content("homme qui voulut être roi").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo type=\"translated\" xml:lang=\"fr\">"
                + "\n    <mods:nonSort>L'</mods:nonSort>"
                + "\n    <mods:title>homme qui voulut être roi</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 4 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test5() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .addContent(NonSort.builder().content("The ").build())
                .addContent(Title.builder().content("Olympics").build())
                .addContent(SubTitle.builder().content("a history").build())
                .addContent(PartNumber.builder().content("Part 1").build())
                .addContent(PartName.builder().content("Ancient").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo>"
                + "\n    <mods:nonSort>The </mods:nonSort>"
                + "\n    <mods:title>Olympics</mods:title>"
                + "\n    <mods:subTitle>a history</mods:subTitle>"
                + "\n    <mods:partNumber>Part 1</mods:partNumber>"
                + "\n    <mods:partName>Ancient</mods:partName>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 5 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test6() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .addContent(Title.builder()
                    .content("Zentralblatt für Bakteriologie, Parasitenkunde, Infektionkrankheiten und Hygiene")
                    .build())
                .addContent(PartNumber.builder().content("1. Abt. Originale").build())
                .addContent(PartNumber.builder().content("Reihe B").build())
                .addContent(PartName.builder()
                    .content("Hygiene. Krankenhaushygiene. Betriebshygiene, präventive Medizin").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo>"
                + "\n    <mods:title>Zentralblatt für Bakteriologie, Parasitenkunde, Infektionkrankheiten und Hygiene</mods:title>"
                + "\n    <mods:partNumber>1. Abt. Originale</mods:partNumber>"
                + "\n    <mods:partNumber>Reihe B</mods:partNumber>"
                + "\n    <mods:partName>Hygiene. Krankenhaushygiene. Betriebshygiene, präventive Medizin</mods:partName>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 6 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test7() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .lang("rus").script("Latn").transliteration("ALA-LC Romanization Tables")
                .addContent(Title.builder().content("Geodezii︠a︡ i fotogrammetrii︠a︡").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo lang=\"rus\" script=\"Latn\" transliteration=\"ALA-LC Romanization Tables\">"
                + "\n    <mods:title>Geodezii︠a︡ i fotogrammetrii︠a︡</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 7 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test8() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .type(TitleInfoType.UNIFORM).authority("naf")
                .valueURI("http://id.loc.gov/authorities/n93028706")
                .addContent(Title.builder().content("Missale Carnotense").build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo authority=\"naf\" type=\"uniform\" valueURI=\"http://id.loc.gov/authorities/n93028706\">"
                + "\n    <mods:title>Missale Carnotense</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n</mods:mods>";
            assertTrue("Test 8 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test9() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .addContent(Title.builder().content("Canticum canticorum").build())
                .build())
            .addContent(TitleInfo.builder()
                .type(TitleInfoType.UNIFORM).nameTitleGroup("1")
                .addContent(Title.builder().content("Motets").build())
                .addContent(PartNumber.builder().content("(1583)").build())
                .build())
            .addContent(Name.builder()
                .type(NameType.PERSONAL).nameTitleGroup("1").usage(Usage.PRIMARY)
                .addContent(NamePart.builder().content("Palestrina, Giovanni Pierluigi da").build())
                .addContent(NamePart.builder().type(NamePartType.DATE).content("1525?-1594").build())
                .build())
            .addContent(Name.builder()
                .type(NameType.PERSONAL)
                .addContent(NamePart.builder().content("Picotti, Livio.").build())
                .addContent(Role.builder()
                    .addRoleTerm(
                        RoleTerm.builder().authority("marcrelator").type(CodeOrText.CODE).content("prf").build())
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                + "\n  <mods:titleInfo>"
                + "\n    <mods:title>Canticum canticorum</mods:title>"
                + "\n  </mods:titleInfo>"
                + "\n  <mods:titleInfo nameTitleGroup=\"1\" type=\"uniform\">"
                + "\n    <mods:title>Motets</mods:title>"
                + "\n    <mods:partNumber>(1583)</mods:partNumber>"
                + "\n  </mods:titleInfo>"
                + "\n  <mods:name nameTitleGroup=\"1\" type=\"personal\" usage=\"primary\">"
                + "\n    <mods:namePart>Palestrina, Giovanni Pierluigi da</mods:namePart>"
                + "\n    <mods:namePart type=\"date\">1525?-1594</mods:namePart>"
                + "\n  </mods:name>"
                + "\n  <mods:name type=\"personal\">"
                + "\n    <mods:namePart>Picotti, Livio.</mods:namePart>"
                + "\n    <mods:role>"
                + "\n      <mods:roleTerm authority=\"marcrelator\" type=\"code\">prf</mods:roleTerm>"
                + "\n    </mods:role>"
                + "\n  </mods:name>"
                + "\n</mods:mods>";
            assertTrue("Test 9 failed", r.equals(s));
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test10() {
        String expected =
              "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
              + "<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
              + "  <mods:titleInfo otherType=\"transcribed\" otherTypeAuthURI=\"https://w3id.org/arm/core/vocabularies/origin/0.1/transcribed\">\n"
              + "    <mods:title>110th St. Elevator Station, New York</mods:title>\n"
              + "  </mods:titleInfo>\n"
              + "</mods:mods>";
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .otherType("transcribed")
                .otherTypeAuthURI("https://w3id.org/arm/core/vocabularies/origin/0.1/transcribed")
                .addContent(Title.builder()
                    .content("110th St. Elevator Station, New York")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            assertEquals("Test 10 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test11() {
        Mods mods = Mods.builder()
            .addContent(TitleInfo.builder()
                .otherType("test")
                .otherTypeURI("http://example.org/title_types/test")
                .otherTypeAuth("example.org")
                .otherTypeAuthURI("http://example.org/title_types")
                .addContent(Title.builder()
                    .content("The Test Example")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected =
                  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                  + "<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                  + "  <mods:titleInfo otherType=\"test\" otherTypeAuth=\"example.org\" otherTypeAuthURI=\"http://example.org/title_types\" otherTypeURI=\"http://example.org/title_types/test\">\n"
                  + "    <mods:title>The Test Example</mods:title>\n"
                  + "  </mods:titleInfo>\n"
                  + "</mods:mods>";
            assertEquals("Test 11 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
}
