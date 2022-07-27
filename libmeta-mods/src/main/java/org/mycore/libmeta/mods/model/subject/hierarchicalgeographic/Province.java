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
package org.mycore.libmeta.mods.model.subject.hierarchicalgeographic;

import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

/**
 *  MODS HierarchicalGeographic Subelement {@literal <province>}
 *  
 *  {@code
 *  <xs:element name="province" type="stringPlusLanguage"/>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Province extends StringPlusLanguage implements IHierarchicalGeographicSubelement {

}
