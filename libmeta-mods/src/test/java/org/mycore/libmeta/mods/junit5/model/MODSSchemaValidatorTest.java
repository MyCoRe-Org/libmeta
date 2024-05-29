package org.mycore.libmeta.mods.junit5.model;

import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;
import org.mycore.libmeta.common.XMLSchemaValidator;

public class MODSSchemaValidatorTest {

    @Test
    public void testRecordInfo() {
        String mods_xml
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           xsi:schemaLocation="http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-8.xsd">

                  <mods:recordInfo usage="primary">
                    <mods:recordContentSource authority="marcorg">MH</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">830804</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">20080122</mods:recordContentSource>
                    <mods:recordIdentifier source="ALMA">990000035150203941_FHCL.HOUGH:37522572</mods:recordIdentifier>
                    <mods:recordOrigin>Converted from MARCXML to MODS version 3.8</mods:recordOrigin>
                  </mods:recordInfo>
                </mods:mods>""";

        XMLSchemaValidator schemaValidator = new XMLSchemaValidator();
        schemaValidator.validate(new StringReader(mods_xml), "mods_sample.xml");
        assertTrue(schemaValidator.getErrorMsg(), schemaValidator.isValid());
    }
    
    @Test
    public void testExtension() {
        String mods_xml
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:hi="https://example.com/xsd/hello_world" 
                           xsi:schemaLocation="http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-8.xsd
                                               https://example.com/xsd/hello_world http://example.com/xsd/hello_world.xsd">
                  <mods:note>Beispiel XML MODS Extension</mods:note>
                  <mods:extension>
                      <hello_world ID="hello1" xmlns="https://example.com/xsd/hello_world">
                        <salutation>Guten Morgen</salutation>
                        <target>Herr X</target>
                      </hello_world>
                  </mods:extension>
                </mods:mods>""";

        XMLSchemaValidator schemaValidator = new XMLSchemaValidator();
        schemaValidator.validate(new StringReader(mods_xml), "mods_extension.xml");
        assertTrue(schemaValidator.getErrorMsg(), schemaValidator.isValid());
    }
}
