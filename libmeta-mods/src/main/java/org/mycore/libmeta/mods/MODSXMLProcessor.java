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
package org.mycore.libmeta.mods;

import org.mycore.libmeta.common.DefaultXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;

public class MODSXMLProcessor extends DefaultXMLProcessor<Mods> {

    private static final MODSXMLProcessor INSTANCE = new MODSXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private MODSXMLProcessor() {
        super(Mods.class);
    }

    public static MODSXMLProcessor getInstance() {
        return INSTANCE;
    }

}
