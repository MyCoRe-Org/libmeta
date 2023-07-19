package org.mycore.libmeta.dcsimple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.ElementType;
import org.mycore.libmeta.dcsimple.model.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jakarta.xml.bind.JAXBElement;

public class DCSimpleXMLProcessorTest {

    @Test
    public void testMarshalToString() {
        JAXBElement<ElementType> contributor = DCContributor.builder().language("de").value("Max Meier").build();
        try {
            String actual = DCSimpleXMLProcessor.getInstance().marshalToString(contributor);
            System.out.println(actual);

            System.out.println("---");
            
            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dc:contributor xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xml:lang=\"de\">Max Meier</dc:contributor>";
            System.out.println(expected);

            assertTrue("testMarshalToString failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMarshalToDom() {
        ObjectFactory dcObjectFactory = new ObjectFactory();
        JAXBElement<ElementType> contributor = dcObjectFactory.createContributor(ElementType.builder().language("de").value("Max Meier").build());
        try {
            Document actual = DCSimpleXMLProcessor.getInstance().marshalToDOM(contributor);
            Element documentElement = actual.getDocumentElement();
            String nodeName = documentElement.getNodeName();
            String lang = documentElement.getAttribute("xml:lang");
            String value = documentElement.getTextContent();

            assertEquals("dc:contributor", nodeName);
            assertEquals("de", lang);
            assertEquals("Max Meier", value);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
