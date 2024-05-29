package org.mycore.libmeta.mods.junit5.model;

import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Test;
import org.mycore.libmeta.common.XMLSchemaValidator;

public class MODSSchemaValidatorTest {

    @Test
    public void test1() {
        String mods_xml
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                           xsi:schemaLocation="http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-8.xsd">

                  <mods:recordInfo1 usage="primary">
                    <mods:recordContentSource authority="marcorg">MH</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">830804</mods:recordContentSource>
                    <mods:recordContentSource authority="marcorg">20080122</mods:recordContentSource>
                    <mods:recordIdentifier source="ALMA">990000035150203941_FHCL.HOUGH:37522572</mods:recordIdentifier>
                    <mods:recordOrigin>Converted from MARCXML to MODS version 3.8</mods:recordOrigin>
                  </mods:recordInfo1>
                </mods:mods>""";

        XMLSchemaValidator schemaValidator = new XMLSchemaValidator();
        schemaValidator.validate(new StringReader(mods_xml), "mods_sample.xml");
        assertTrue(schemaValidator.getErrorMsg(), schemaValidator.isValid());
    }
}
