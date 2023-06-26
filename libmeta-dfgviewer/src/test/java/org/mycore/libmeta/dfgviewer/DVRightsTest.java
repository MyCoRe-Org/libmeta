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
    
    @Test
    public void testRightsOwner() {
        Rights rights = Rights.builder()
            .owner("SLUB Dresden")
            .ownerContact("mailto:sebastian.meyer@slub-dresden.de")
            .ownerLogo("http://digital.slub-dresden.de/logo.gif")
            .ownerSiteUrl("http://digital.slub-dresden.de/")
            .build();
        try {
            String actual = DVRightsXMLProcessor.getInstance().marshalToString(rights);
            System.out.println(actual);

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:rights xmlns:dv=\"http://dfg-viewer.de/DV/\">\n"
                + "  <dv:owner>SLUB Dresden</dv:owner>\n"
                + "  <dv:ownerLogo>http://digital.slub-dresden.de/logo.gif</dv:ownerLogo>\n"
                + "  <dv:ownerSiteURL>http://digital.slub-dresden.de/</dv:ownerSiteURL>\n"
                + "  <dv:ownerContact>mailto:sebastian.meyer@slub-dresden.de</dv:ownerContact>\n"
                + "</dv:rights>";
            System.out.println(expected);

            System.out.println("---");
            assertTrue("testRightsOwner failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
