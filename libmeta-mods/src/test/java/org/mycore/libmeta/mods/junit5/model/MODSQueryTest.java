package org.mycore.libmeta.mods.junit5.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSQuery;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._toplevel.Extension;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model._toplevel.RecordInfo;
import org.mycore.libmeta.mods.model._toplevel.TitleInfo;
import org.mycore.libmeta.mods.model.name.Affiliation;
import org.mycore.libmeta.mods.model.recordinfo.RecordContentSource;
import org.mycore.libmeta.mods.model.recordinfo.RecordIdentifier;
import org.mycore.libmeta.mods.model.recordinfo.RecordOrigin;
import org.mycore.libmeta.mods.model.titleInfo.Title;
import org.w3c.dom.Node;

public class MODSQueryTest {

    @Test
    public void test1() {
        String expected
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                  <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <mods:extension type="degree">
                      <edtms>
                        <name>Ph.D.</name>
                        <level>2</level>
                        <discipline>Comparitive and International Education</discipline>
                        <grantor>Coumbia University</grantor>
                      </edtms>
                    </mods:extension>
                  </mods:mods>
                """;

        Mods mods;
        try {
            mods = MODSXMLProcessor.getInstance().unmarshal(expected);
            Extension extension = MODSQuery.streamFilteredContent(mods, Extension.class).findFirst().get();
            Node node = (Node) extension.getContent().stream().filter(Node.class::isInstance).findFirst().get();
            assertEquals("Test 1 failed", node.getLocalName(), "edtms");
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void test2() {
        /*
        <recordInfo usage="primary">
          <recordContentSource authority="marcorg">MH</recordContentSource>
          <recordContentSource authority="marcorg">830804</recordContentSource>
          <recordContentSource authority="marcorg">20080122</recordContentSource>
          <recordIdentifier source="ALMA">990000035150203941_FHCL.HOUGH:37522572</recordIdentifier>
          <recordOrigin>Converted from MARCXML to MODS version 3.8</recordOrigin>
        </recordInfo>
        */

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

        RecordInfo recordInfo = MODSQuery.streamFilteredContent(mods, RecordInfo.class).findFirst().get();
        assertEquals("Test 2 failed", MODSQuery.listFilteredContent(recordInfo, RecordContentSource.class).size(), 3);
    }

    @Test
    public void test3() {
        String r
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                  <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <mods:titleInfo>
                      <mods:title>Bush Cheney</mods:title>
                    </mods:titleInfo>
                  </mods:mods>
                """;

        Mods mods;
        try {
            mods = MODSXMLProcessor.getInstance().unmarshal(r);
            TitleInfo titleInfo = MODSQuery.streamFilteredContent(mods, TitleInfo.class).findFirst().get();
            Title title = MODSQuery.listFilteredContent(titleInfo, Title.class).get(0);
            assertEquals("Test 3 failed", title.getContent(), "Bush Cheney");
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void test4() {
        String expected
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                  <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:name authority="naf" authorityURI="http://id.loc.gov/authorities/names" type="personal" valueURI="http://id.loc.gov/authorities/names/n79022889">
                    <mods:namePart>Einstein, Albert, 1879-1955</mods:namePart>
                    <mods:affiliation authority="ROR" authorityURI="https://ror.org" valueURI="https://ror.org/00f809463">Institute for Advance Study</mods:affiliation>
                  </mods:name>
                </mods:mods>
                """;
        try {
            Mods mods = MODSXMLProcessor.getInstance().unmarshal(expected);
            Name name = MODSQuery.streamFilteredContent(mods, Name.class).findFirst().get();
            Affiliation affiliation = MODSQuery.listFilteredContent(name, Affiliation.class).get(0);
            assertEquals("Test 4 failed", affiliation.getAuthority(), "ROR");
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
