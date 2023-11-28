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
package org.mycore.libmeta.mods.model.origininfo;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * MODS OriginInfo Subelement: Frequency
 * 
 * {@code
 * <xs:element name="frequency" type="stringPlusLanguagePlusAuthority"/>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Frequency extends StringPlusLanguagePlusAuthority implements IOriginInfoSubelement {

    public static Builder builderForFreqency() {
        return builder(new Frequency());
    }

    public static Builder builder(Frequency f) {
        return new Builder(f);
    }

    public static class Builder extends BuilderBase<Frequency, Builder> implements IXsStringBuilder<Frequency, Builder>,
        ILanguageAttributeGroupBuilder<Frequency, Builder>, IAuthorityAttributeGroupBuilder<Frequency, Builder> {
        protected Builder(Frequency f) {
            super(f);
        }
    }
}
