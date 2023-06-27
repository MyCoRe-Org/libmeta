package org.mycore.libmeta.dfgviewer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dfgviewer.model.Links;

public class DVLinksTest {

    @Test
    public void testLinks() {
        Links links = Links.builder().build();
        try {
            String actual = DVLinksXMLProcessor.getInstance().marshalToString(links);
            System.out.println(actual);

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:links xmlns:dv=\"http://dfg-viewer.de/DV/\"/>";
            System.out.println(expected);

            System.out.println("---");
            assertTrue("testLinks failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
