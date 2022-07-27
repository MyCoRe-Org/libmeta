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
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.mods.model.subject.name.ISubjectNameSubelement;

public class Affiliation extends StringPlusLanguage implements INameSubelement, ISubjectNameSubelement {

    public static Builder builder() {
        return builder(new Affiliation());
    }

    public static Builder builder(Affiliation aff) {
        return new Builder(aff);
    }

    public static class Builder extends BuilderBase<Affiliation, Builder> implements IXsStringBuilder<Affiliation, Builder>, ILanguageAttributeGroupBuilder<Affiliation, Builder> {

        protected Builder(Affiliation aff) {
            super(aff);
        }
    }
}
