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
package org.mycore.libmeta.mods.model.location;

import org.mycore.libmeta.mods.model._misc.enums.Usage;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 *  MODS Location URL attribute: Usage 
 *
 * This value,"primary display”, is deprecated in version 3.8;
 *  “primary” is the only value that should be used in 3.8 and beyond.
 *  ("primary display” remains a legal value in the schema, 
 *  for compatibility with earlier versions.)
 *  
 *  The enum can be replaces with {@link Usage} in MODS >= 4.0
 *  
 * {@code
 * <xs:attribute name="usage">
 *   <xs:simpleType>
 *     <xs:restriction base="xs:string">
 *       <xs:enumeration value="primary display"/>
 *       <xs:enumeration value="primary"/>
 *     </xs:restriction>
 *   </xs:simpleType>
 * </xs:attribute>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6 / MODS 3.8
 * 
 */
@XmlEnum
public enum UrlUsage {
    @XmlEnumValue("primary display")
    PRIMARY_DISPLAY__DEPRECATED,
    @XmlEnumValue("primary")
    PRIMARY;
}
