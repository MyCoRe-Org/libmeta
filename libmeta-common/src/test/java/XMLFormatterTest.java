
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.common.XMLFormatter;
import org.w3c.dom.Document;

public class XMLFormatterTest {

    @Test
    public void test1() throws IOException {
        try {
            Document doc = XMLFormatter.parseFromResource("/deeply_nested.xml");
            String expected
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <sample>
                      <level id="l01">
                        <level id="l01.02">
                          <level id="l01.02.03">
                            <level id="l01.02.03.04">
                              <level id="l01.02.03.04.05">
                                <level id="l01.02.03.04.05.06">
                                  <level id="l01.02.03.04.05.06.07">
                                    <level id="l01.02.03.04.05.06.07.08">
                                      <level id="l01.02.03.04.05.06.07.08.09">
                                        <level id="l01.02.03.04.05.06.07.08.09.10">
                                          <level id="l01.02.03.04.05.06.07.08.09.10.11">
                                            <level id="l01.02.03.04.05.06.07.08.09.10.11.12">
                                              <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13">
                                                <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14">
                                                  <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15">
                                                    <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15.16">
                                                      <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15.16.17">
                                                        <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15.16.17.18">
                                                          <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15.16.17.18.19">
                                                            <level id="l01.02.03.04.05.06.07.08.09.10.11.12.13.14.15.16.17.18.19.20">hello</level>
                                                          </level>
                                                        </level>
                                                      </level>
                                                    </level>
                                                  </level>
                                                </level>
                                              </level>
                                            </level>
                                          </level>
                                        </level>
                                      </level>
                                    </level>
                                  </level>
                                </level>
                              </level>
                            </level>
                          </level>
                        </level>
                      </level>
                    </sample>""";
            XMLFormatter.cleanEmptyTextNodes(doc);
            String xml = XMLFormatter.prettyPrintXMLAsString(doc);
            assertEquals("Test 1 failed", expected, xml);
        } catch (LibmetaProcessorException e) {
            fail(e.getMessage());
        }
    }

}
