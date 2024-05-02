package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.CodeOrText;
import org.mycore.libmeta.mods.model._misc.DateEncoding;
import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model._toplevel.OriginInfo;
import org.mycore.libmeta.mods.model.cartographics.Cartographics;
import org.mycore.libmeta.mods.model.cartographics.Coordinates;
import org.mycore.libmeta.mods.model.name.NamePart;
import org.mycore.libmeta.mods.model.name.Role;
import org.mycore.libmeta.mods.model.name.RoleTerm;
import org.mycore.libmeta.mods.model.origininfo.Agent;
import org.mycore.libmeta.mods.model.origininfo.DateIssued;
import org.mycore.libmeta.mods.model.origininfo.DateOther;
import org.mycore.libmeta.mods.model.origininfo.DisplayDate;
import org.mycore.libmeta.mods.model.origininfo.Place;
import org.mycore.libmeta.mods.model.origininfo.place.PlaceIdentifier;
import org.mycore.libmeta.mods.model.origininfo.place.PlaceTerm;

public class OriginInfoTest {

    @Test
    public void test1() {
        Mods mods = Mods.builder()
            .addContent(OriginInfo.builderForOriginInfo()
                .eventType("publication")
                .addContent(Place.builderForPlace()
                    .supplied(Yes.YES)
                    .addContent(PlaceIdentifier.builder()
                        .content("https://www.wikidata.org/wiki/Q60")
                        .build())
                    .addContent(PlaceTerm.builderForPlaceTerm()
                        .authority("wikidata")
                        .content("New York City")
                        .build())
                    .build())
                .addContent(Agent.builder()
                    .type(NameType.CORPORATE)
                    .addContent(NamePart.builder()
                        .content("H. Hagemeister")
                        .build())
                    .addContent(Role.builder()
                        .addRoleTerm(RoleTerm.builder()
                            .valueURI("http://id.loc.gov/vocabulary/relators/pbl")
                            .content("Publisher")
                            .build())
                        .build())
                    .build())
                .addContent(DateOther.builderForDateOther()
                    .encoding(DateEncoding.EDTF)
                    .content("1910")
                    .build())
                .addContent(DisplayDate.builder()
                    .content("Postmark date: 1910")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:originInfo eventType="publication">
                    <mods:place supplied="yes">
                      <mods:placeIdentifier>https://www.wikidata.org/wiki/Q60</mods:placeIdentifier>
                      <mods:placeTerm authority="wikidata">New York City</mods:placeTerm>
                    </mods:place>
                    <mods:agent type="corporate">
                      <mods:namePart>H. Hagemeister</mods:namePart>
                      <mods:role>
                        <mods:roleTerm valueURI="http://id.loc.gov/vocabulary/relators/pbl">Publisher</mods:roleTerm>
                      </mods:role>
                    </mods:agent>
                    <mods:dateOther encoding="edtf">1910</mods:dateOther>
                    <mods:displayDate>Postmark date: 1910</mods:displayDate>
                  </mods:originInfo>
                </mods:mods>""";
            assertEquals("Test 1 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        Mods mods = Mods.builder()
            .addContent(OriginInfo.builderForOriginInfo()
                .eventType("publication")
                .addContent(Place.builderForPlace()
                    .addContent(PlaceTerm.builderForPlaceTerm()
                        .type(CodeOrText.TEXT)
                        .content("Rostock")
                        .build())
                    .addContent(Cartographics.builder()
                        .authority("ISO 6709")
                        .addCoordinates(Coordinates.builder()
                            .content("+54.0755+012.1035")
                            .build())
                        .build())
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """ 
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:originInfo eventType="publication">
                    <mods:place>
                      <mods:placeTerm type="text">Rostock</mods:placeTerm>
                      <mods:cartographics authority="ISO 6709">
                        <mods:coordinates>+54.0755+012.1035</mods:coordinates>
                      </mods:cartographics>
                    </mods:place>
                  </mods:originInfo>
                </mods:mods>""";
            assertEquals("Test 2 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void test3() {
        Mods mods = Mods.builder()
            .addContent(OriginInfo.builderForOriginInfo()
                .eventType("publication")
                .eventTypeURI("http://example.org/vocab/originInfo/publication")
                .addContent(Place.builderForPlace()
                    .addContent(PlaceTerm.builderForPlaceTerm()
                        .type(CodeOrText.TEXT)
                        .content("Rostock")
                        .build())
                    .build())
                .addContent(DateIssued.builderForDateIssued()
                    .encoding(DateEncoding.ISO8601)
                    .content("1797")
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected = """ 
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                  <mods:originInfo eventType="publication" eventTypeURI="http://example.org/vocab/originInfo/publication">
                    <mods:place>
                      <mods:placeTerm type="text">Rostock</mods:placeTerm>
                    </mods:place>
                    <mods:dateIssued encoding="iso8601">1797</mods:dateIssued>
                  </mods:originInfo>
                </mods:mods>""";
            assertEquals("Test 3 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
