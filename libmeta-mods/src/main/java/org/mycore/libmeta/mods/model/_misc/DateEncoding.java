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
package org.mycore.libmeta.mods.model._misc;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * {@code
 * <xs:attribute name="encoding">
 *    <xs:simpleType>
 *      <xs:restriction base="xs:string">
 *        <xs:enumeration value="w3cdtf"/>
 *        <xs:enumeration value="iso8601"/>
 *        <xs:enumeration value="marc"/>
 *        <xs:enumeration value="temper"/>
 *        <xs:enumeration value="edtf"/>
 *      </xs:restriction>
 *    </xs:simpleType>
 *  </xs:attribute>
 *  }
 *  
 * 
 * @author Robert Stephan
 * @version 3.6
 * 
 */
@XmlEnum
public enum DateEncoding {
    @XmlEnumValue("w3cdtf")
    W3CDTF,
    @XmlEnumValue("iso8601")
    ISO8601,
    @XmlEnumValue("marc")
    MARC,

    // following two, "temper" and "edft", new in 3.4 -->
    @XmlEnumValue("temper")
    TEMPER,
    @XmlEnumValue("edtf")
    EDTF;
}
