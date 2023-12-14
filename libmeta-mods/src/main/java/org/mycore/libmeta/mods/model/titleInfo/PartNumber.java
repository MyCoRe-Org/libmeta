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
package org.mycore.libmeta.mods.model.titleInfo;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.mods.model.subject.titleInfo.ISubjectTitleInfoSubelement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.NONE)
public class PartNumber extends StringPlusLanguage implements ITitleInfoSubelement, ISubjectTitleInfoSubelement {

    public static Builder builder() {
        return builder(new PartNumber());
    }

    public static Builder builder(PartNumber partNumber) {
        return new Builder(partNumber);
    }

    public static class Builder extends BuilderBase<PartNumber, Builder>
        implements IXsStringBuilder<PartNumber, Builder>, ILanguageAttributeGroupBuilder<PartNumber, Builder> {

        protected Builder(PartNumber partNumber) {
            super(partNumber);
        }
    }
}
