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
 * Agent Type
 * {@code
 * <xsd:attribute name="TYPE" use="optional">
 *   <xsd:simpleType>
 *     <xsd:restriction base="xsd:string">
 *       <xsd:enumeration value="INDIVIDUAL" />
 *       <xsd:enumeration value="ORGANIZATION" />
 *       <xsd:enumeration value="OTHER" />
 *     </xsd:restriction>
 *   </xsd:simpleType>
 * </xsd:attribute>
 * }
 * 
 * TYPE (string/O): is used to specify the type of AGENT. 
 * It must be one of the following values:
 *   INDIVIDUAL: Use if an individual has served as the agent.
 *   ORGANIZATION: Use if an institution, corporate body, association, non-profit enterprise, government, religious body, etc.
 *                 has served as the agent.
 *   OTHER: Use OTHER if none of the preceding values pertain and clarify the type of agent specifier being used in the
 *    		OTHERTYPE attribute
 *    					
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
@XmlEnum
public enum AgentTYPE {
    @XmlEnumValue("INDIVIDUAL")
    INDIVIDUAL,
    @XmlEnumValue("ORGANIZATION")
    ORGANIZATION,
    @XmlEnumValue("OTHER")
    OTHER;
}
