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
 *  MODS PhysicialDescription Subelement: DigitalOrigin
 *  
 *  {@code
 *  <xs:simpleType name="digitalOriginDefinition">
 *       <xs:restriction base="xs:string">
 *           <xs:enumeration value="born digital"/>
 *           <xs:enumeration value="reformatted digital"/>
 *           <xs:enumeration value="digitized microfilm"/>
 *           <xs:enumeration value="digitized other analog"/>
 *       </xs:restriction>
 *   </xs:simpleType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlEnum
public enum DigitalOrigin implements IPhysicalDescriptionSubelement {
	@XmlEnumValue("born digital") BORN_DIGITAL,
	@XmlEnumValue("reformatted digital") REFORMATTED_DIGITAL,
	@XmlEnumValue("digitized microfilm") DIGITIZED_MICROFILM ,
	@XmlEnumValue("digitized other analog") DIGITIZED_OTHER_ANALOG;
}
