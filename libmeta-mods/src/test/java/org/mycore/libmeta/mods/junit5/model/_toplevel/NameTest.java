package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._toplevel.AccessCondition;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model.name.Affiliation;
import org.mycore.libmeta.mods.model.name.NamePart;

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
            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "  <mods:name authority=\"naf\" authorityURI=\"http://id.loc.gov/authorities/names\" type=\"personal\" valueURI=\"http://id.loc.gov/authorities/names/n79022889\">\n"
                + "    <mods:namePart>Einstein, Albert, 1879-1955</mods:namePart>\n"
                + "    <mods:affiliation authority=\"ROR\" authorityURI=\"https://ror.org\" valueURI=\"https://ror.org/00f809463\">Institute for Advance Study</mods:affiliation>\n"
                + "  </mods:name>\n"
                + "</mods:mods>";
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
            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "  <mods:accessCondition authority=\"rightsstatements\" authorityURI=\"http://rightsstatements.org/vocab\" type=\"use and reproduction\" "
                + "valueURI=\"http://rightsstatements.org/vocab/NoC-US/1.0/\">NO COPYRIGHT - UNITED STATES</mods:accessCondition>\n"
                + "</mods:mods>";
            assertEquals("Test 2 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
}
