package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.CodeOrText;
import org.mycore.libmeta.mods.model._misc.enums.NamePartType;
import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._toplevel.AccessCondition;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model.name.Affiliation;
import org.mycore.libmeta.mods.model.name.NamePart;
import org.mycore.libmeta.mods.model.name.Role;
import org.mycore.libmeta.mods.model.name.RoleTerm;

public class NameTest {

    @Test
    public void test1() {
        Mods mods = Mods.builder()
            .addContent(Name.builder()
                .type(NameType.PERSONAL)
                .authority("naf")
                .authorityURI("http://id.loc.gov/authorities/names")
                .valueURI("http://id.loc.gov/authorities/names/n79022889")
                .addContent(NamePart.builder()
                    .content("Einstein, Albert, 1879-1955")
                    .build())
                .addContent(Affiliation.builder()
                    .authority("ROR")
                    .authorityURI("https://ror.org")
                    .valueURI("https://ror.org/00f809463")
                    .content("Institute for Advance Study")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes\"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:name authority="naf" authorityURI="http://id.loc.gov/authorities/names" type="personal" valueURI="http://id.loc.gov/authorities/names/n79022889">
                    <mods:namePart>Einstein, Albert, 1879-1955</mods:namePart>
                    <mods:affiliation authority="ROR" authorityURI="https://ror.org" valueURI="https://ror.org/00f809463">Institute for Advance Study</mods:affiliation>
                  </mods:name>
                </mods:mods>""";
            assertEquals("Test 1 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test2() {
        Mods mods = Mods.builder()
            .addContent(AccessCondition.builderForAccessCondition()
                .type("use and reproduction")
                .authority("rightsstatements")
                .authorityURI("http://rightsstatements.org/vocab")
                .valueURI("http://rightsstatements.org/vocab/NoC-US/1.0/")
                .content("NO COPYRIGHT - UNITED STATES")
                .build())
            .build();
        try {
            
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            System.out.println(s);
            String expected = """ 
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:accessCondition authority="rightsstatements" authorityURI="http://rightsstatements.org/vocab" type="use and reproduction" valueURI="http://rightsstatements.org/vocab/NoC-US/1.0/">NO COPYRIGHT - UNITED STATES</mods:accessCondition>
                </mods:mods>""";
            assertEquals("Test 2 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test3() {
        Mods mods = Mods.builder()
            .addContent(Name.builder()
                .authority("naf")
                .type(NameType.PERSONAL)
                .addContent(NamePart.builder()
                    .content("Evans, Walker, 1903-1975")
                    .build())
                .addContent(Role.builder()
                    .addRoleTerm(RoleTerm.builder()
                        .type(CodeOrText.CODE)
                        .authority("marcrelator")
                        .content("pht")
                        .build())
                    .addRoleTerm(RoleTerm.builder()
                        .type(CodeOrText.TEXT)
                        .authority("marcrelator")
                        .content("Photographer")
                        .build())
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """ 
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:name authority="naf" type="personal">
                    <mods:namePart>Evans, Walker, 1903-1975</mods:namePart>
                    <mods:role>
                      <mods:roleTerm authority="marcrelator" type="code">pht</mods:roleTerm>
                      <mods:roleTerm authority="marcrelator" type="text">Photographer</mods:roleTerm>
                    </mods:role>
                  </mods:name>
                </mods:mods>""";
            assertEquals("Test 3 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test4() {
        Mods mods = Mods.builder()
            .addContent(Name.builder()
                .type(NameType.PERSONAL)
                .addContent(NamePart.builder()
                    .type(NamePartType.GIVEN)
                    .content("John Paul")
                    .build())
                .addContent(NamePart.builder()
                    .type(NamePartType.TERMSOFADDRESS)
                    .content("II")
                    .build())
                .addContent(NamePart.builder()
                    .type(NamePartType.TERMSOFADDRESS)
                    .content("Pope")
                    .build())
                .addContent(NamePart.builder()
                    .type(NamePartType.DATE)
                    .content("1905-1995")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """ 
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:name type="personal">
                    <mods:namePart type="given">John Paul</mods:namePart>
                    <mods:namePart type="termsOfAddress">II</mods:namePart>
                    <mods:namePart type="termsOfAddress">Pope</mods:namePart>
                    <mods:namePart type="date">1905-1995</mods:namePart>
                  </mods:name>
                </mods:mods>""";
            assertEquals("Test 4 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
}
