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
package org.mycore.libmeta.mods.model._toplevel;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model._misc.builder.INameDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.NameDefinition;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 *   Top Level Element {@literal {@literal <name>}}
 *   {@code 
 *   	<xs:complexType name="nameDefinition">
 *		<xs:choice>
 *			
 *			<!-- this choice give two ways to do this.  
 *				The second way allows the element <etal>,  to express "et. al."
 *		Choice one. WITHOUT <etal>. -->
 *			<xs:choice minOccurs="0" maxOccurs="unbounded">
 *				<xs:element ref="namePart"/>
 *				<xs:element ref="displayForm"/>
 *				<xs:element ref="affiliation"/>
 *				<xs:element ref="role"/>
 *				<xs:element ref="description"/>
 *			<!-- 
 *				the following element, <nameIdentifier>, is introduced in version 3.6,
 *				to allow the inclusion of an identifier for the object named by this <name>.
 *				It is typed as "indentifierDefinition", the same definition that 
 *				top-level element <identifier> uses. 
 *				-->
 *				<xs:element ref="nameIdentifier"/>
 *		<!--   -->		
 *		</xs:choice>
 *			<!-- 
 *       Choice two.	With <etal>.
 *               The presence of <etal> indicates that there are names that cannot 
 *              be explicitily included. It may be empty, or it may have simple content
 *               - e.g. <etal>et al.</etal>.  In the latter case the content is what is 
 *              suggested for display. 
 *               When <etal> occurs:
 *                 - <namePart>, <displayForm>, and <identifier> MAY NOT occur;
 *                  - <affiliation>, <role>, <description>   MAY occur (but are NOT repeatable).
 *              <etal> is not repeatable within a given <name>, however there may be 
 *              mutilple <etal> elements, each within in a separate <name> element.
 * -->
 *			<xs:sequence>
 *				<!--   
 *            <etal> is mandatory, nonrepeatable, and must occur first. 
 *            After that <affiliation>, <role>, and <description> may occur, in any order or number. 
 *            <nameIdentifier> is not used with <etal>
 * -->
 *				<xs:element ref="etal"/>
 *				<xs:choice minOccurs="0" maxOccurs="unbounded">
 *					<xs:element ref="affiliation"/>
 *					<xs:element ref="role"/>
 *					<xs:element ref="description"/>
 *				</xs:choice>
 *			</xs:sequence>
 *			<!-- -->
 *		</xs:choice>
 *		<xs:attribute name="ID" type="xs:ID"/>
 *		<xs:attributeGroup ref="authorityAttributeGroup"/>
 *		<xs:attributeGroup ref="xlink:simpleLink"/>
 *		<xs:attributeGroup ref="languageAttributeGroup"/>
 *		<xs:attribute name="displayLabel" type="xs:string"/>
 *		<xs:attribute name="altRepGroup" type="xs:string"/>
 *		<xs:attribute name="nameTitleGroup" type="xs:string"/>
 *		<xs:attribute name="usage" type="primary"/>
 *		<xs:attribute name="type">
 *			<xs:simpleType>
 *				<xs:restriction base="xs:string">
 *					<xs:enumeration value="personal"/>
 *					<xs:enumeration value="corporate"/>
 *					<xs:enumeration value="conference"/>
 *					<xs:enumeration value="family"/>
 *				</xs:restriction>
 *			</xs:simpleType>
 *		</xs:attribute>
 *	</xs:complexType>
 *}
 *   
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Name extends NameDefinition<INameSubelement> implements ITopLevelElement {

    public static Builder builder() {
        return builder(new Name());
    }

    public static Builder builder(Name name) {
        return new Builder(name);
    }

    public static class Builder extends BuilderBase<Name, Builder>
        implements INameDefinitionBuilder<INameSubelement, Name, Builder> {

        protected Builder(Name name) {
            super(name);
        }
    }

}
