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
package org.mycore.libmeta.mods.model._misc.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 *  <xs:attribute name="type">
 *    <xs:simpleType>
 *      <xs:restriction base="xs:string">
 *        <xs:enumeration value="preceding"/>
 *        <xs:enumeration value="succeeding"/>
 *        <xs:enumeration value="original"/>
 *        <xs:enumeration value="host"/>
 *        <xs:enumeration value="constituent"/>
 *        <xs:enumeration value="series"/>
 *        <xs:enumeration value="otherVersion"/>
 *        <xs:enumeration value="otherFormat"/>
 *        <xs:enumeration value="isReferencedBy"/>
 *        <xs:enumeration value="references"/>
 *        <xs:enumeration value="reviewOf"/>
 *      </xs:restriction>
 *    </xs:simpleType>
 *  </xs:attribute>
 *  
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlEnum
public enum RelatedItemType {
	@XmlEnumValue("preceding") PRECEDING,
	@XmlEnumValue("succeeding") SUCCEEDING,
	@XmlEnumValue("original") ORIGINAL,
	@XmlEnumValue("host") HOST,
	@XmlEnumValue("constituent") CONSTITUENT,
	@XmlEnumValue("series") SERIES,
	@XmlEnumValue("otherVersion") OTHER_VERSION,
	@XmlEnumValue("otherFormat") OTHER_FORMAT,
	@XmlEnumValue("isReferencedBy") IS_REFERENCED_BY,
	
	// following two new in 3.4.
	@XmlEnumValue("references") REFERENCES,
	@XmlEnumValue("reviewOf") REVIEW_OF;
}
