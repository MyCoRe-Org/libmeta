package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.common.XMLFormatter;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._toplevel.Extension;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExtensionTest {

    @Test
    public void test1() {
        String expected = """
             <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
             <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
               <mods:extension type="degree">
                 <edtms>
                   <name>Ph.D.</name>
                   <level>2</level>
                   <discipline>Comparitive and International Education</discipline>
                   <grantor>Coumbia University</grantor>
                 </edtms>
               </mods:extension>
             </mods:mods>""";

        String edtmsXML = """
            <edtms>
              <name>Ph.D.</name>
              <level>2</level>
              <discipline>Comparitive and International Education</discipline>
              <grantor>Coumbia University</grantor>
            </edtms>""";
        try {
            Document document = XMLFormatter.parseFromString(edtmsXML);
            XMLFormatter.cleanEmptyTextNodes(document);
            Element root = document.getDocumentElement();
            Mods mods = Mods.builder()
                .addContent(Extension.builder()
                    .type("degree")
                    .addContent(root)
                    .build())
                .build();
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            assertEquals("Test 1 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test2() {
        String expected = """
             <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
             <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
               <mods:extension>
                 <vra xml:ns="http://www.vraweb.org/vracore4.htm" xsi:schemaLocation="http://www.vraweb.org/vracore4.htm http://www.loc.gov/standards/vracore/vra-strict.xsd">
                   <image>
                     <techniqueSet>
                       <technique>digital imaging</technique>
                     </techniqueSet>
                   </image>
                 </vra>
               </mods:extension>
             </mods:mods>""";
        String vraXML = """
             <vra xml:ns="http://www.vraweb.org/vracore4.htm" xsi:schemaLocation="http://www.vraweb.org/vracore4.htm http://www.loc.gov/standards/vracore/vra-strict.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
               <image> 
                 <techniqueSet>
                 <technique>digital imaging</technique>
                 </techniqueSet>
               </image>
             </vra>""";
        try {
            Document document = XMLFormatter.parseFromString(vraXML);
            XMLFormatter.cleanEmptyTextNodes(document);
            Element root = document.getDocumentElement();
            Mods mods = Mods.builder()
                .addContent(Extension.builder()
                    .addContent(root)
                    .build())
                .build();
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            assertEquals("Test 2 failed", expected, s);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
