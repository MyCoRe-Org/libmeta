
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
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;
import org.mycore.libmeta.common.XMLSchemaValidator;

public class XMLSchemaValidatorTest {

    @Test
    public void testValidate() {
        String actual
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <pica:record xmlns:pica="info:srw/schema/5/picaXML-v1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                             xsi:schemaLocation="info:srw/schema/5/picaXML-v1.0 https://www.loc.gov/standards/sru/recordSchemas/pica-xml-v1-0.xsd">
                  <pica:datafield tag="001@">
                    <pica:subfield code="0">382</pica:subfield>
                    <pica:subfield code="a">U</pica:subfield>
                  </pica:datafield>
                  <pica:datafield tag="001A">
                    <pica:subfield code="0">4382:19-06-19</pica:subfield>
                  </pica:datafield>
                  <pica:datafield tag="001B">
                    <pica:subfield code="0">4382:19-06-19</pica:subfield>
                    <pica:subfield code="t">14:18:47.000</pica:subfield>
                  </pica:datafield>
                  <pica:datafield tag="001D">
                    <pica:subfield code="0">4382:19-06-19</pica:subfield>
                  </pica:datafield>
                  <pica:datafield tag="028C">
                    <pica:subfield code="9">728438135</pica:subfield>
                    <pica:subfield code="V">Tpv3</pica:subfield>
                    <pica:subfield code="7">gnd/1027147291</pica:subfield>
                    <pica:subfield code="3">372520952</pica:subfield>
                    <pica:subfield code="w">piz</pica:subfield>
                    <pica:subfield code="A">Stephan</pica:subfield>
                    <pica:subfield code="D">Robert</pica:subfield>
                    <pica:subfield code="E">1979</pica:subfield>
                    <pica:subfield code="B">VerfasserIn</pica:subfield>
                    <pica:subfield code="4">aut</pica:subfield>
                  </pica:datafield>
                </pica:record>
                """;
        XMLSchemaValidator xsv = new XMLSchemaValidator();
        xsv.validate(new StringReader(actual), "testPica");
        assertTrue(xsv.getErrorMsg(), xsv.isValid());
    }
    
    @Test
    public void testValidateError() {
        String actual
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <pica:record xmlns:pica="info:srw/schema/5/picaXML-v1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                             xsi:schemaLocation="info:srw/schema/5/picaXML-v1.0 https://www.loc.gov/standards/sru/recordSchemas/pica-xml-v1-0.xsd">
                  <pica:datafield1 tag="028C">
                    <pica:subfield code="9">728438135</pica:subfield>
                    <pica:subfield code="7">gnd/1027147291</pica:subfield>
                  </pica:datafield1>
                </pica:record>
                """;
        XMLSchemaValidator xsv = new XMLSchemaValidator(true);
        xsv.validate(new StringReader(actual), "testPica");
        assertTrue("Error not detected: 'Element datafield1 unknown'", !xsv.isValid() && xsv.getErrorMsg().contains("datafield1"));
    }
}
