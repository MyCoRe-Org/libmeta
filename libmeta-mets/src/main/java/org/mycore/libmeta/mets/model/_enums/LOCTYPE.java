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
package org.mycore.libmeta.mets.model._enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * Location LOCTYPE
 * {@code
 * <xsd:attribute name="LOCTYPE" use="required">
 *   <xsd:simpleType>
 *     <xsd:restriction base="xsd:string">
 *       <xsd:enumeration value="ARK" />
 *       <xsd:enumeration value="URN" />
 *       <xsd:enumeration value="URL" />
 *       <xsd:enumeration value="PURL" />
 *       <xsd:enumeration value="HANDLE" />
 *       <xsd:enumeration value="DOI" />
 *       <xsd:enumeration value="OTHER" />
 *     </xsd:restriction>
 *   </xsd:simpleType>
 * </xsd:attribute>
 * }
 * 
 * LOCTYPE (string/R): Specifies the locator type used in the xlink:href
 * attribute. Valid values for LOCTYPE are:
 * ARK  URN  URL  PURL  HANDLE  DOI  OTHER
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlEnum
public enum LOCTYPE {
    @XmlEnumValue("ARK")
    ARK,
    @XmlEnumValue("URN")
    URN,
    @XmlEnumValue("URL")
    URL,
    @XmlEnumValue("PURL")
    PURL,
    @XmlEnumValue("HANDLE")
    HANDLE,
    @XmlEnumValue("DOI")
    DOI,
    @XmlEnumValue("OTHER")
    OTHER;
}
