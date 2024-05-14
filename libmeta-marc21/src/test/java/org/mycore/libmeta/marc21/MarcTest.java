package org.mycore.libmeta.marc21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.StringReader;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.common.XMLSchemaValidator;
import org.mycore.libmeta.marc21.json.MarcInJSONProcessor;
import org.mycore.libmeta.marc21.json.MarcJSONProcessor;
import org.mycore.libmeta.marc21.model.MarcRecord;

public class MarcTest {

    // https://lccn.loc.gov/09028059/marcxml
    private static String XML_DARWIN = """
    	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    	<marc:record xmlns:marc="http://www.loc.gov/MARC21/slim" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    	  <marc:leader>01017cam a22002891  4500</marc:leader>
    	  <marc:controlfield tag="001">7284460</marc:controlfield>
    	  <marc:controlfield tag="005">20110712103730.0</marc:controlfield>
    	  <marc:controlfield tag="008">750117s1909    nyu           000 0 eng  </marc:controlfield>
    	  <marc:datafield ind1=" " ind2=" " tag="035">
    	    <marc:subfield code="9">(DLC)   09028059</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1="0" ind2="0" tag="050">
    	    <marc:subfield code="a">QH365</marc:subfield>
    	    <marc:subfield code="b">.O2 1909</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1=" " ind2=" " tag="051">
    	    <marc:subfield code="a">AC1</marc:subfield>
    	    <marc:subfield code="b">.A4 vol. 11</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1="1" ind2=" " tag="100">
    	    <marc:subfield code="a">Darwin, Charles,</marc:subfield>
    	    <marc:subfield code="d">1809-1882</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1="1" ind2="0" tag="240">
    	    <marc:subfield code="a">On the origin of species</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1="1" ind2="4" tag="245">
    	    <marc:subfield code="a">The origin of species,</marc:subfield>
    	    <marc:subfield code="c">by Charles Darwin, with introductions, notes and illustrations.</marc:subfield>
    	  </marc:datafield>
    	  <marc:datafield ind1=" " ind2=" " tag="260">
    	    <marc:subfield code="a">New York,</marc:subfield>
    	    <marc:subfield code="b">P.F. Collier &amp; son</marc:subfield>
    	    <marc:subfield code="c">[c1909]</marc:subfield>
    	  </marc:datafield>
    	</marc:record>""";

    @Test
    public void testMarcXMLProcessor() {
        try {
            MarcRecord mr = MarcXMLProcessor.getInstance().unmarshal(XML_DARWIN);
            String xml2 = MarcXMLProcessor.getInstance().marshalToString(mr);
            assertEquals("Transformation failed", XML_DARWIN, xml2);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testXMLValidation() {
        XMLSchemaValidator validator = new XMLSchemaValidator("http://www.loc.gov/MARC21/slim https://www.loc.gov/standards/marcxml/schema/MARC21slim.xsd");
        assertTrue(validator.validate(new StringReader(XML_DARWIN), "MARC record of Darwin's Origin ..."));
    }

    @Test
    public void testMarcInJSONProcessor() {
        String json
            = """
            {"leader":"01017cam a22002891  4500","fields":[{"001":"7284460"},{"005":"20110712103730.0"},{"008":"750117s1909    nyu           000 0 eng  "},{"035":{"ind1":" ","ind2":" ","subfields":[{"9":"(DLC)   09028059"}]}},{"050":{"ind1":"0","ind2":"0","subfields":[{"a":"QH365"},{"b":".O2 1909"}]}},{"051":{"ind1":" ","ind2":" ","subfields":[{"a":"AC1"},{"b":".A4 vol. 11"}]}},{"100":{"ind1":"1","ind2":" ","subfields":[{"a":"Darwin, Charles,"},{"d":"1809-1882"}]}},{"240":{"ind1":"1","ind2":"0","subfields":[{"a":"On the origin of species"}]}},{"245":{"ind1":"1","ind2":"4","subfields":[{"a":"The origin of species,"},{"c":"by Charles Darwin, with introductions, notes and illustrations."}]}},{"260":{"ind1":" ","ind2":" ","subfields":[{"a":"New York,"},{"b":"P.F. Collier & son"},{"c":"[c1909]"}]}}]}""";
        MarcRecord mr2 = MarcInJSONProcessor.getInstance().unmarshal(json);
        String json2 = MarcInJSONProcessor.getInstance().marshalToString(mr2);
        assertEquals("Transformation failed", json, json2);
    }

    @Test
    public void testMarcJSONProcessor() {
        try {
            String json = """
                 [["LDR",null,null,"_","01017cam a22002891  4500"],["001",null,null,"_","7284460"],["005",null,null,"_","20110712103730.0"],["008",null,null,"_","750117s1909    nyu           000 0 eng  "],["035"," "," ","9","(DLC)   09028059"],["050","0","0","a","QH365","b",".O2 1909"],["051"," "," ","a","AC1","b",".A4 vol. 11"],["100","1"," ","a","Darwin, Charles,","d","1809-1882"],["240","1","0","a","On the origin of species"],["245","1","4","a","The origin of species,","c","by Charles Darwin, with introductions, notes and illustrations."],["260"," "," ","a","New York,","b","P.F. Collier & son","c","[c1909]"]]""";
            MarcRecord mr = MarcJSONProcessor.getInstance().unmarshal(json);
            String json2 = MarcJSONProcessor.getInstance().marshalToString(mr);
            assertEquals("Transformation failed", json, json2);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
