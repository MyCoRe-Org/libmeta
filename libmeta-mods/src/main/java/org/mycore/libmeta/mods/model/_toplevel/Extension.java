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
import org.mycore.libmeta.mods.model._misc.builder.IExtensionDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.ExtensionDefinition;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 *    Top Level Element {@literal <extension>}
 *    
 * {@code
 *  <xs:complexType name="extensionDefinition" mixed="true">
 *	  <xs:sequence>
 *	    <xs:any processContents="lax" minOccurs="0" maxOccurs="unbounded"/>
 *	  </xs:sequence>
 *	  <xs:attribute name="displayLabel" type="xs:string"/>
 *	  <!-- displayLabel added  to extension in 3.4. -->
 *    <xs:attribute name="type" type="xs:string"/>
 *	</xs:complexType>
 * }
 * 
 *   @author Robert Stephan
 *   @version MODS 3.6
 */

@XmlAccessorType(XmlAccessType.NONE)
public class Extension extends ExtensionDefinition implements ITopLevelElement, IIDAttributeGroup {

    public static Builder builder() {
        return builder(new Extension());
    }

    public static Builder builder(Extension spl) {
        return new Builder(spl);
    }

    public static class Builder extends BuilderBase<Extension, Builder>
        implements IExtensionDefinitionBuilder<Extension, Builder> {

        protected Builder(Extension ext) {
            super(ext);
        }
    }
}
