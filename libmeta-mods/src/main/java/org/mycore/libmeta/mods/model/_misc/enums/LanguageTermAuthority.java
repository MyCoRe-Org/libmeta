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
 * {@code
 * <xs:attribute name="authority">
 *   <xs:simpleType>
 *     <xs:restriction base="xs:string">
 *       <xs:enumeration value="rfc3066"/>
 *       <xs:enumeration value="iso639-2b"/>
 *       <xs:enumeration value="iso639-3"/>
 *       <xs:enumeration value="rfc4646"/>
 *       <xs:enumeration value="rfc5646"/>
 *     </xs:restriction>
 *   </xs:simpleType>
 * </xs:attribute>
 * }
 * 
 * The restriction was lifted in MODS 3.8
 *   
 * @author Robert Stephan
 * @version MODS 3.6 - MODS 3.7
 * 
 */
@XmlEnum
public enum LanguageTermAuthority {
	@XmlEnumValue("rfc3066") RFC3066,
	@XmlEnumValue("iso639-2b") ISO639_2B,
	@XmlEnumValue("iso639-3") ISO639_3,
	@XmlEnumValue("rfc4646") RFC4646,
	@XmlEnumValue("rfc5646") RFC5646;
	
	public static final String VALUE_RFC3066 = "rfc3066";
	public static final String VALUE_ISO639_2B = "iso639-2b";
	public static final String VALUE_ISO639_3 = "iso639-3";
	public static final String VALUE_RFC4646 = "rfc4646";
	public static final String VALUE_RFC5646 = "rfc5646";
}
