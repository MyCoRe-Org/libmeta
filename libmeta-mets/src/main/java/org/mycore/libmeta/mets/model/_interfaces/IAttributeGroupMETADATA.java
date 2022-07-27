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
package org.mycore.libmeta.mets.model._interfaces;

import org.mycore.libmeta.mets.model._enums.MDTYPE;

/**
 * Attribute Group METADATA
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
public interface IAttributeGroupMETADATA {

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
	 *   PREMIS: PREservation Metadata: Implementation Strategies
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
	 *   @return the metadata type
	 **/
	public MDTYPE getMDTYPE();

	public void setMDTYPE(MDTYPE mdtype);

	/**
	 * {@code
	 * <xsd:attribute name="OTHERMDTYPE" type="xsd:string" use="optional" />
	 * }
	 * 
	 * OTHERMDTYPE (string/O): Specifies the form of metadata in use when the
	 * value OTHER is indicated in the MDTYPE attribute.
	 * 
	 * @return the other metadata type
	 **/
	public String getOTHERMDTYPE();

	public void setOTHERMDTYPE(String otherMdTtype);

	/**
	 * {@code
	 * <xsd:attribute name="MDTYPEVERSION" type="xsd:string" use="optional" />
	 * }
	 * 
	 * MDTYPEVERSION(string/O): Provides a means for recording the version of
	 * the type of metadata (as recorded in the MDTYPE or OTHERMDTYPE attribute) that is being used. This may represent
	 * the version of the underlying data dictionary or metadata model rather than a schema version.
	 * 
	 * @return the metadata type version
	 **/
	public String getMDTYPEVERSION();

	public void setMDTYPEVERSION(String mdTypeVersion);
}
