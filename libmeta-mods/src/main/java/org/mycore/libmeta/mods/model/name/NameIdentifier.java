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
package org.mycore.libmeta.mods.model.name;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.INameDefinitionSubelement;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model._toplevel.Identifier;
import org.mycore.libmeta.mods.model.subject.name.ISubjectNameSubelement;

public class NameIdentifier extends Identifier implements INameDefinitionSubelement, ISubjectNameSubelement {
    
    public static Builder builder() {
        return builder(new NameIdentifier());
    }

    public static Builder builder(NameIdentifier ni) {
        return new Builder(ni);
    }

    /**
     * 
     *
     * @see Identifier.Builder for implementation details
     */
    public static class Builder extends BuilderBase<NameIdentifier, Builder> implements IXsStringBuilder<NameIdentifier, Builder>,  ILanguageAttributeGroupBuilder<NameIdentifier, Builder> {
        protected Builder(NameIdentifier spl) {
            super(spl);
        }
        
        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder typeURI(String typeURI) {
            _target().setTypeURI(typeURI);
            return _self();
        }

        public Builder invalid(Yes invalid) {
            _target().setInvalid(invalid);
            return _self();
        }

        public Builder altRepGroup(String altRepGroup) {
            _target().setAltRepGroup(altRepGroup);
            return _self();
        }
    }
}
