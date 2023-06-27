package org.mycore.libmeta.dfgviewer;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.dfgviewer.model.Links;

public class DVLinksTest {

    @Test
    public void testLinks() {
        Links links = Links.builder()
            .iiif("https://api.digitale-sammlungen.de/iiif/presentation/v2/bsb10128295/manifest")
            .presentation("https://mdz-nbn-resolving.de/urn:nbn:de:bvb:12-bsb10128295-4")
            .sru("https://api.digitale-sammlungen.de/sru/bsb10128295")
            .build();
        try {
            String actual = DVLinksXMLProcessor.getInstance().marshalToString(links);
            System.out.println(actual);

            String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<dv:links xmlns:dv=\"http://dfg-viewer.de/DV/\">\n"
                + "  <dv:presentation>https://mdz-nbn-resolving.de/urn:nbn:de:bvb:12-bsb10128295-4</dv:presentation>\n"
                + "  <dv:sru>https://api.digitale-sammlungen.de/sru/bsb10128295</dv:sru>\n"
                + "  <dv:iiif>https://api.digitale-sammlungen.de/iiif/presentation/v2/bsb10128295/manifest</dv:iiif>\n"
                + "</dv:links>";
            System.out.println(expected);

            System.out.println("---");
            assertTrue("testLinks failed", expected.equals(actual));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
