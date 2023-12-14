package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._toplevel.Extension;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ExtensionTest {

    @Test
    public void test1() {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
            + "<mods:mods xmlns:mods=\"http://www.loc.gov/mods/v3\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
            + "  <mods:extension type=\"degree\">\n"
            + "    <edtms>\n"
            + "      <name>Ph.D.</name>\n"
            + "      <level>2</level>\n"
            + "      <discipline>Comparitive and International Education</discipline>\n"
            + "      <grantor>Coumbia University</grantor>\n"
            + "    </edtms>\n"
            + "  </mods:extension>\n"
            + "</mods:mods>";

        String edtmsXML = "<edtms>"
            + "<name>Ph.D.</name>"
            + "<level>2</level>"
            + "<discipline>Comparitive and International Education</discipline>"
            + "<grantor>Coumbia University</grantor>"
            + "</edtms>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(edtmsXML)));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            Mods mods = Mods.builder()
                .addContent(Extension.builder()
                    .type("degree")
                    .addContent(root)
                    .build())
                .build();
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            assertEquals("Test 1 failed", expected, s);
        } catch (ParserConfigurationException | SAXException | IOException | LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
