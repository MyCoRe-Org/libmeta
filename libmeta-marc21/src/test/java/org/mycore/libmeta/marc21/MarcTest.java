package org.mycore.libmeta.marc21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.marc21.json.MarcInJSONProcessor;
import org.mycore.libmeta.marc21.json.MarcJSONProcessor;
import org.mycore.libmeta.marc21.model.MarcRecord;
import org.mycore.libmeta.marc21.xml.MarcXMLProcessor;

public class MarcTest {

    @Test
    public void testMarcXMLProcessor() {
        try {
            // https://lccn.loc.gov/09028059/marcxml
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<marc:record xmlns:marc=\"http://www.loc.gov/MARC21/slim\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "  <marc:leader>01017cam a22002891  4500</marc:leader>\n"
                + "  <marc:controlfield tag=\"001\">7284460</marc:controlfield>\n"
                + "  <marc:controlfield tag=\"005\">20110712103730.0</marc:controlfield>\n"
                + "  <marc:controlfield tag=\"008\">750117s1909    nyu           000 0 eng  </marc:controlfield>\n"
                + "  <marc:datafield ind1=\" \" ind2=\" \" tag=\"035\">\n"
                + "    <marc:subfield code=\"9\">(DLC)   09028059</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\"0\" ind2=\"0\" tag=\"050\">\n"
                + "    <marc:subfield code=\"a\">QH365</marc:subfield>\n"
                + "    <marc:subfield code=\"b\">.O2 1909</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\" \" ind2=\" \" tag=\"051\">\n"
                + "    <marc:subfield code=\"a\">AC1</marc:subfield>\n"
                + "    <marc:subfield code=\"b\">.A4 vol. 11</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\"1\" ind2=\" \" tag=\"100\">\n"
                + "    <marc:subfield code=\"a\">Darwin, Charles,</marc:subfield>\n"
                + "    <marc:subfield code=\"d\">1809-1882</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\"1\" ind2=\"0\" tag=\"240\">\n"
                + "    <marc:subfield code=\"a\">On the origin of species</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\"1\" ind2=\"4\" tag=\"245\">\n"
                + "    <marc:subfield code=\"a\">The origin of species,</marc:subfield>\n"
                + "    <marc:subfield code=\"c\">by Charles Darwin, with introductions, notes and illustrations.</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "  <marc:datafield ind1=\" \" ind2=\" \" tag=\"260\">\n"
                + "    <marc:subfield code=\"a\">New York,</marc:subfield>\n"
                + "    <marc:subfield code=\"b\">P.F. Collier &amp; son</marc:subfield>\n"
                + "    <marc:subfield code=\"c\">[c1909]</marc:subfield>\n"
                + "  </marc:datafield>\n"
                + "</marc:record>";
            
            MarcRecord mr = (MarcRecord) MarcXMLProcessor.getInstance().unmarshal(xml);
            String xml2 = MarcXMLProcessor.getInstance().marshalToString(mr);
            assertEquals("Transformation failed", xml, xml2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    //@Test
    public void testMarcInJSONProcessor() {
        try {
            String json = "{\"leader\":\"01017cam a22002891  4500\",\"fields\":[{\"001\":\"7284460\"},{\"005\":\"20110712103730.0\"},{\"008\":\"750117s1909    nyu           000 0 eng  \"},{\"035\":{\"ind1\":\" \",\"ind2\":\" \",\"subfields\":[{\"9\":\"(DLC)   09028059\"}]}},{\"050\":{\"ind1\":\"0\",\"ind2\":\"0\",\"subfields\":[{\"a\":\"QH365\"},{\"b\":\".O2 1909\"}]}},{\"051\":{\"ind1\":\" \",\"ind2\":\" \",\"subfields\":[{\"a\":\"AC1\"},{\"b\":\".A4 vol. 11\"}]}},{\"100\":{\"ind1\":\"1\",\"ind2\":\" \",\"subfields\":[{\"a\":\"Darwin, Charles,\"},{\"d\":\"1809-1882\"}]}},{\"240\":{\"ind1\":\"1\",\"ind2\":\"0\",\"subfields\":[{\"a\":\"On the origin of species\"}]}},{\"245\":{\"ind1\":\"1\",\"ind2\":\"4\",\"subfields\":[{\"a\":\"The origin of species,\"},{\"c\":\"by Charles Darwin, with introductions, notes and illustrations.\"}]}},{\"260\":{\"ind1\":\" \",\"ind2\":\" \",\"subfields\":[{\"a\":\"New York,\"},{\"b\":\"P.F. Collier & son\"},{\"c\":\"[c1909]\"}]}}]}";
            System.out.println(json);
            MarcRecord mr2 = MarcInJSONProcessor.getInstance().unmarshal(json);
            String json2 = MarcInJSONProcessor.getInstance().marshalToString(mr2);
            System.out.println(json2);
            assertEquals("Transformation failed", json, json2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testMarcJSONProcessor() {
        try {
            String json = "[[\"LDR\",null,null,\"_\",\"01017cam a22002891  4500\"],[\"001\",null,null,\"_\",\"7284460\"],[\"005\",null,null,\"_\",\"20110712103730.0\"],[\"008\",null,null,\"_\",\"750117s1909    nyu           000 0 eng  \"],[\"035\",\" \",\" \",\"9\",\"(DLC)   09028059\"],[\"050\",\"0\",\"0\",\"a\",\"QH365\",\"b\",\".O2 1909\"],[\"051\",\" \",\" \",\"a\",\"AC1\",\"b\",\".A4 vol. 11\"],[\"100\",\"1\",\" \",\"a\",\"Darwin, Charles,\",\"d\",\"1809-1882\"],[\"240\",\"1\",\"0\",\"a\",\"On the origin of species\"],[\"245\",\"1\",\"4\",\"a\",\"The origin of species,\",\"c\",\"by Charles Darwin, with introductions, notes and illustrations.\"],[\"260\",\" \",\" \",\"a\",\"New York,\",\"b\",\"P.F. Collier & son\",\"c\",\"[c1909]\"]]";
            MarcRecord mr = (MarcRecord) MarcJSONProcessor.getInstance().unmarshal(json);
            String json2 = MarcJSONProcessor.getInstance().marshalToString(mr);
            assertEquals("Transformation failed", json, json2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
    }
}
