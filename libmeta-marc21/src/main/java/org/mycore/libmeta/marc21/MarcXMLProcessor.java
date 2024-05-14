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
package org.mycore.libmeta.marc21;

import org.mycore.libmeta.common.DefaultXMLProcessor;
import org.mycore.libmeta.marc21.model.MarcRecord;

public class MarcXMLProcessor extends DefaultXMLProcessor<MarcRecord> {

    private static final MarcXMLProcessor INSTANCE = new MarcXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private MarcXMLProcessor() {
        super(MarcRecord.class);
    }

    public static MarcXMLProcessor getInstance() {
        return INSTANCE;
    }

}
