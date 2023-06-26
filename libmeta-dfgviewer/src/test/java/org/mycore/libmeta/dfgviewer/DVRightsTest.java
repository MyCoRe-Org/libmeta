package org.mycore.libmeta.dfgviewer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dfgviewer.model.Rights;

public class DVRightsTest {

    @Test
    public void testRights() {
        Rights rights = Rights.builder().build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            System.out.println(actual);

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:rights xmlns:dv=\"http://dfg-viewer.de/DV/\"/>";
            System.out.println(expected);

            System.out.println("---");
            assertTrue("testRights failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
