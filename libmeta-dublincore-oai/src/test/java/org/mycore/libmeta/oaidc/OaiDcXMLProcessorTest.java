package org.mycore.libmeta.oaidc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCTitle;
import org.mycore.libmeta.dcsimple.model.ElementType;
import org.mycore.libmeta.oaidc.model.OaiDc;

import jakarta.xml.bind.JAXBElement;

public class OaiDcXMLProcessorTest {

    @Test
    public void testMarshalToString() {
        JAXBElement<ElementType> title
            = DCTitle.builder().value("Using Structural Metadata to Localize Experience of Digital Content").build();
        JAXBElement<ElementType> contributor = DCContributor.builder().language("de").value("Max Meier").build();

        OaiDc oaiDc = OaiDc.builder()
            .add(title)
            .add(contributor)
            .build();
        try {
            String actual = OaiDcXMLProcessor.getInstance().marshalToString(oaiDc);
            System.out.println(actual);

            System.out.println("---");

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<oai_dc:dc xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\">\n"
                + "  <dc:title>Using Structural Metadata to Localize Experience of Digital Content</dc:title>\n"
                + "  <dc:contributor xml:lang=\"de\">Max Meier</dc:contributor>\n"
                + "</oai_dc:dc>";
            System.out.println(expected);

            assertTrue("testMarshalToString failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
