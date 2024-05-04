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
import org.mycore.libmeta.mods.model._misc.IAlternativeNameSubelement;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model._misc.builder.IIdentifierDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.IdentifierDefinition;
import org.mycore.libmeta.mods.model.subject.name.ISubjectNameSubelement;

public class NameIdentifier extends IdentifierDefinition
    implements INameSubelement, IAlternativeNameSubelement, ISubjectNameSubelement {

    public static Builder builder() {
        return builder(new NameIdentifier());
    }

    public static Builder builder(NameIdentifier ni) {
        return new Builder(ni);
    }

    public static class Builder extends BuilderBase<NameIdentifier, Builder>
        implements IIdentifierDefinitionBuilder<NameIdentifier, Builder> {

        protected Builder(NameIdentifier ni) {
            super(ni);
        }

    }
}
