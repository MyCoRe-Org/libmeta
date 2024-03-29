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
package org.mycore.libmeta.mods.model.physicaldescription;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * MODS PhysicalDescription Subelement: ReformattingQuality
 * 
 * {@code
 * <xs:simpleType name="reformattingQualityDefinition">
 *       <xs:restriction base="xs:string">
 *           <xs:enumeration value="access"/>
 *           <xs:enumeration value="preservation"/>
 *          <xs:enumeration value="replacement"/>
 *      </xs:restriction>
 *  </xs:simpleType>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlEnum
public enum ReformattingQuality {
    @XmlEnumValue("access")
    ACCESS,
    @XmlEnumValue("preservation")
    PRESERVATION,
    @XmlEnumValue("replacement")
    REPLACEMENT;
}
