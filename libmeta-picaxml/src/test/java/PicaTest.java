import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.pica.json.PicaInJSONProcessor;
import org.mycore.libmeta.pica.model.PicaRecord;
import org.mycore.libmeta.pica.xml.PicaXMLProcessor;

public class PicaTest {
    
 //   @Test
    public void testPicaInJSONProcessor() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<pica:record xmlns:pica=\"info:srw/schema/5/picaXML-v1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
            + "  <pica:datafield tag=\"001@\">\n"
            + "    <pica:subfield code=\"0\">11,40</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001A\">\n"
            + "    <pica:subfield code=\"0\">0007:09-03-94</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001B\">\n"
            + "    <pica:subfield code=\"0\">BSZ:10-02-21</pica:subfield>\n"
            + "    <pica:subfield code=\"t\">09:36:37.000</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001D\">\n"
            + "    <pica:subfield code=\"0\">9999:99-99-99</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001U\">\n"
            + "    <pica:subfield code=\"0\">utf8</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield tag=\"001X\">\n"
            + "    <pica:subfield code=\"0\">0</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "  <pica:datafield occurrence=\"01\" tag=\"203@\">\n"
            + "    <pica:subfield code=\"0\">116363150</pica:subfield>\n"
            + "  </pica:datafield>\n"
            + "</pica:record>";
        
        try {
            PicaRecord mr = PicaXMLProcessor.getInstance().unmarshal(xml);
            String xml2 = PicaXMLProcessor.getInstance().marshalToString(mr);
            assertEquals("Transformation failed", xml, xml2);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
        
    }
        
    @Test
    public void testPicaJSONProcessor() {
        String actual = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<pica:record xmlns:pica=\"info:srw/schema/5/picaXML-v1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
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
        
        try {
            PicaRecord pr = PicaXMLProcessor.getInstance().unmarshal(actual);
            String json = PicaInJSONProcessor.getInstance().marshalToString(pr);
            PicaRecord pr2 = PicaInJSONProcessor.getInstance().unmarshal(json);
            String xml = PicaXMLProcessor.getInstance().marshalToString(pr2);
            assertEquals("Transformation failed", actual, xml);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
