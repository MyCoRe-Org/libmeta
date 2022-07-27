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
 * {@code
 * <xsd:attribute name="MDTYPE" use="required">
 *   <xsd:simpleType>
 *     <xsd:restriction base="xsd:string">
 *       <xsd:enumeration value="MARC" />
 *       <xsd:enumeration value="MODS" />
 *       <xsd:enumeration value="EAD" />
 *       <xsd:enumeration value="DC" />
 *       <xsd:enumeration value="NISOIMG" />
 *       <xsd:enumeration value="LC-AV" />
 *       <xsd:enumeration value="VRA" />
 *       <xsd:enumeration value="TEIHDR" />
 *       <xsd:enumeration value="DDI" />
 *       <xsd:enumeration value="FGDC" />
 *       <xsd:enumeration value="LOM" />
 *       <xsd:enumeration value="PREMIS" />
 *       <xsd:enumeration value="PREMIS:OBJECT" />
 *       <xsd:enumeration value="PREMIS:AGENT" />
 *       <xsd:enumeration value="PREMIS:RIGHTS" />
 *       <xsd:enumeration value="PREMIS:EVENT" />
 *       <xsd:enumeration value="TEXTMD" />
 *       <xsd:enumeration value="METSRIGHTS" />
 *       <xsd:enumeration value="ISO 19115:2003 NAP" />
 *       <xsd:enumeration value="EAC-CPF" />
 *       <xsd:enumeration value="LIDO" />
 *       <xsd:enumeration value="OTHER" />
 *     </xsd:restriction>
 *   </xsd:simpleType>
 * </xsd:attribute>
 * }
 * 
 * MDTYPE (string/R): Is used to indicate the type of the associated metadata. 
 * It must have one of the following values:
 *
 *   MARC: any form of MARC record
 *   MODS: metadata in the Library of Congress MODS format
 *   EAD: Encoded Archival Description finding aid
 *   DC: Dublin Core
 *   NISOIMG: NISO Technical Metadata for Digital Still Images
 *   LC-AV: technical metadata specified in the Library of Congress A/V prototyping project
 *   VRA: Visual Resources Association Core
 *   TEIHDR: Text Encoding Initiative Header
 *   DDI: Data Documentation Initiative
 *   FGDC: Federal Geographic Data Committee metadata
 *   LOM: Learning Object Model
 *   PREMIS:  PREservation Metadata: Implementation Strategies
 *   PREMIS:OBJECT: PREMIS Object entiry
 *   PREMIS:AGENT: PREMIS Agent entity
 *   PREMIS:RIGHTS: PREMIS Rights entity
 *   PREMIS:EVENT: PREMIS Event entity
 *   TEXTMD: textMD Technical metadata for text
 *   METSRIGHTS: Rights Declaration Schema
 *   ISO 19115:2003 NAP: North American Profile of ISO 19115:2003 descriptive metadata
 *   EAC-CPF: Encoded Archival Context - Corporate Bodies, Persons, and Families
 *   LIDO: Lightweight Information Describing Objects
 *   OTHER: metadata in a format not specified above
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
@XmlEnum
public enum MDTYPE {
	@XmlEnumValue("MARC") MARC, 
	@XmlEnumValue("MODS") MODS, 
	@XmlEnumValue("EAD") EAD, 
	@XmlEnumValue("DC") DC, 
	@XmlEnumValue("NISOIMG") NISOIMG,
	@XmlEnumValue("LC-AV") LC_AV, 
	@XmlEnumValue("VRA") VRA, 
	@XmlEnumValue("TEIHDR") TEIHDR, 
	@XmlEnumValue("DDI") DDI, 
	@XmlEnumValue("FGDC") FGDC, 
	@XmlEnumValue("LOM") LOM, 
	@XmlEnumValue("PREMIS") PREMIS, 
	@XmlEnumValue("PREMIS:OBJECT") PREMIS_OBJECT, 
	@XmlEnumValue("PREMIS:AGENT") PREMIS_AGENT, 
	@XmlEnumValue("PREMIS:RIGHTS") PREMIS_RIGHTS, 
	@XmlEnumValue("PREMIS:EVENT") PREMIS_EVENT, 
	@XmlEnumValue("TEXTMD") TEXTMD, 
	@XmlEnumValue("METSRIGHTS") METSRIGHTS, 
	@XmlEnumValue("ISO 19115:2003 NAP") ISO_19115_2003_NAP, 
	@XmlEnumValue("EAC-CPF") EAC_CPF,
	@XmlEnumValue("LIDO") LIDO, 
	@XmlEnumValue("OTHER") OTHER;
}
