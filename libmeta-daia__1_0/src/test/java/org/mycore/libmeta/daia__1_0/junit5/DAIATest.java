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
package org.mycore.libmeta.daia__1_0.junit5;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URL;

import org.junit.Test;
import org.mycore.libmeta.daia__1_0.DAIAJSONProcessor;
import org.mycore.libmeta.daia__1_0.model.DAIA;

/**
 * examples taken from http://www.loc.gov/standards/mods/userguide/abstract.html
 * @author Robert Stephan
 */

public class DAIATest {
    public DAIATest() {

    }

    @Test
    public void test1() {
        try {
            URL url = new URL("https://paia.gbv.de/DE-28/daia?id=ppn%3A356781534&format=json");
            DAIA daia = (DAIA) DAIAJSONProcessor.getInstance().unmarshal(url);
            daia.setSchema(new URL("http://gbv.github.io/daia/daia.schema.json"));
            daia.setContext(url);
            String json = DAIAJSONProcessor.getInstance().marshalToString(daia);
            System.out.println(json);
            DAIA daia2 = DAIAJSONProcessor.getInstance().unmarshal(json);
            System.out.println(DAIAJSONProcessor.getInstance().marshalToString(daia2));
            assertTrue(true);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}