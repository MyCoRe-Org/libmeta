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
 * Agent Roles
 * 
 * <xsd:simpleType>
 *   <xsd:restriction base="xsd:string">
 *      <xsd:enumeration value="CREATOR" />
 *       <xsd:enumeration value="EDITOR" />
 *       <xsd:enumeration value="ARCHIVIST" />
 *       <xsd:enumeration value="PRESERVATION" />
 *       <xsd:enumeration value="DISSEMINATOR" />
 *       <xsd:enumeration value="CUSTODIAN" />
 *       <xsd:enumeration value="IPOWNER" />
 *       <xsd:enumeration value="OTHER" />
 *     </xsd:restriction>
 *   </xsd:simpleType>
 *   
 * ROLE (string/R): Specifies the function of the agent with respect to the METS record. 
 * The allowed values are:
 *    CREATOR: The person(s) or institution(s) responsible for the METS document.
 *    EDITOR: The person(s) or institution(s) that prepares the metadata for encoding.
 *    ARCHIVIST: The person(s) or institution(s) responsible for the document/collection.
 *    PRESERVATION: The person(s) or institution(s) responsible for preservation functions.
 *    DISSEMINATOR: The person(s) or institution(s) responsible for dissemination functions.
 *    CUSTODIAN: The person(s) or institution(s) charged with the oversight of a document/collection.
 *    IPOWNER: Intellectual Property Owner: The person(s) or institution holding copyright, trade or service marks or other
 *             intellectual property rights for the object.
 *     OTHER: Use OTHER if none of the preceding values pertains and clarify the type and location specifier being used in
 *		      the OTHERROLE attribute (see below).
 *
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */

@XmlEnum
public enum AgentROLE {
	@XmlEnumValue("CREATOR") CREATOR,
	@XmlEnumValue("EDITOR") EDITOR, 
	@XmlEnumValue("ARCHIVIST") ARCHIVIST, 
	@XmlEnumValue("PRESERVATION") PRESERVATION, 
	@XmlEnumValue("DISSEMINATOR") DISSEMINATOR,
	@XmlEnumValue("CUSTODIAN") CUSTODIAN,
	@XmlEnumValue("IPOWNER") IPOWNER, 
	@XmlEnumValue("OTHER") OTHER;
}
