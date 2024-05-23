
/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mycore.libmeta.alto__4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.alto__4.Alto4XMLProcessor;
import org.mycore.libmeta.alto__4.model.Alto;
import org.mycore.libmeta.alto__4.model.description.Description;
import org.mycore.libmeta.alto__4.model.description.Processing;
import org.mycore.libmeta.alto__4.model.description.ProcessingSoftware;

public class Alto4ProcessingTest {
    @Test
    public void testProcessingBuilder() {
        try {
            String xml
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <alto xmlns="http://www.loc.gov/standards/alto/ns-v4#" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                      <Description>
                        <Processing ID="OCR_0">
                          <processingDateTime>2024-04-26T10:57:59.806747+00:00</processingDateTime>
                          <processingStepSettings>--psm 6</processingStepSettings>
                          <processingSoftware>
                            <softwareName>tesseract</softwareName>
                            <softwareVersion>5.3.1.20230401</softwareVersion>
                          </processingSoftware>
                        </Processing>
                      </Description>
                    </alto>""";

            Alto alto = Alto.builder()
                .Description(Description.builder()
                    .addProcessing(Processing.builder()
                        .ID("OCR_0")
                        .processingDateTime("2024-04-26T10:57:59.806747+00:00")
                        .processingStepSettings("--psm 6")
                        .processingSoftware(ProcessingSoftware.builder()
                            .softwareName("tesseract")
                            .softwareVersion("5.3.1.20230401")
                            .build())
                        .build())
                    .build())
                .build();
            String altoXml = Alto4XMLProcessor.getInstance().marshalToString(alto);
            System.out.println(altoXml);
            assertEquals("Generated XML for Processing is wrong", xml, altoXml);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
