import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;
import org.mycore.libmeta.common.XMLSchemaValidator;

public class XMLSchemaValidatorTest {
                                                                                
    @Test
    public void testValidate() {
        String actual = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<pica:record xmlns:pica=\"info:srw/schema/5/picaXML-v1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"info:srw/schema/5/picaXML-v1.0 https://www.loc.gov/standards/sru/recordSchemas/pica-xml-v1-0.xsd\" >\n"
            + "  <pica:datafield tag=\"001@\">\n"
            + "    <pica:subfield code=\"0\">382</pica:subfield>\n"
            + "    <pica:subfield code=\"a\">U</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001A\">\n"
            + "    <pica:subfield code=\"0\">4382:19-06-19</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001B\">\n"
            + "    <pica:subfield code=\"0\">4382:19-06-19</pica:subfield>\n"
            + "    <pica:subfield code=\"t\">14:18:47.000</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001D\">\n"
            + "    <pica:subfield code=\"0\">4382:19-06-19</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"028C\">\n"
            + "    <pica:subfield code=\"9\">728438135</pica:subfield>\n"
            + "    <pica:subfield code=\"V\">Tpv3</pica:subfield>\n"
            + "    <pica:subfield code=\"7\">gnd/1027147291</pica:subfield>\n"
            + "    <pica:subfield code=\"3\">372520952</pica:subfield>\n"
            + "    <pica:subfield code=\"w\">piz</pica:subfield>\n"
            + "    <pica:subfield code=\"A\">Stephan</pica:subfield>\n"
            + "    <pica:subfield code=\"D\">Robert</pica:subfield>\n"
            + "    <pica:subfield code=\"E\">1979</pica:subfield>\n"
            + "    <pica:subfield code=\"B\">VerfasserIn</pica:subfield>\n"
            + "    <pica:subfield code=\"4\">aut</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "</pica:record>";
        XMLSchemaValidator xsv = new XMLSchemaValidator("");
        assertTrue(xsv.validate(new StringReader(actual), "testPica"));
    }
}
