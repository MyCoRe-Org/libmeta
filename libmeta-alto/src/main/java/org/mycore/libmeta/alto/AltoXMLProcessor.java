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
package org.mycore.libmeta.alto;

 import org.mycore.libmeta.alto.model.Alto;
import org.mycore.libmeta.common.DefaultXMLProcessor;

/**
 * JAXB Marshaller allows only indentation up to 8th level and starts then on the first column again
 * bug report: https://java.net/jira/browse/JAXB-970
 * 
 * therefore we use xslt transformer for output
 * 
 * @author Robert Stephan
 */

public class AltoXMLProcessor extends DefaultXMLProcessor<Alto> {

    private static final AltoXMLProcessor INSTANCE = new AltoXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private AltoXMLProcessor() {
        super(Alto.class);
    };

    public static AltoXMLProcessor getInstance() {
        return INSTANCE;
    }
}
