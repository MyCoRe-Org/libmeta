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
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IIdentifierDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.IdentifierDefinition;

/**
 *  Top Level Element {@literal <identifier>}
 *  
 *  {@code
 *  <xs:complexType name="identifierDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguage">
 *				<xs:attribute name="displayLabel" type="xs:string"/>
 *				<xs:attribute name="type" type="xs:string"/>
 *				<xs:attribute name="typeURI" type="xs:anyURI"/>
 *				<xs:attribute name="invalid" type="yes"/>
 *				<xs:attribute name="altRepGroup" type="xs:string"/>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Identifier extends IdentifierDefinition implements ITopLevelElement, IIDAttributeGroup {

    public static Builder builder() {
        return builder(new Identifier());
    }

    public static Builder builder(Identifier toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<Identifier, Builder>
        implements IIdentifierDefinitionBuilder<Identifier, Builder> {

        protected Builder(Identifier spl) {
            super(spl);
        }

    }

}
