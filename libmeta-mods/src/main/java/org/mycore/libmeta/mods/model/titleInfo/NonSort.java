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
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class NonSort extends StringPlusLanguage implements ITitleInfoSubelement, ISubjectTitleInfoSubelement {
    /**
     * {@code
     * <xs:attribute name="supplied" type="yes"/>
     * }
     */
    @XmlAttribute(name = "space", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    String xmlSpace;

    public String getXmlSpace() {
        return xmlSpace;
    }

    public void setXmlSpace(String xmlSpace) {
        this.xmlSpace = xmlSpace;
    }

    public static Builder builder() {
        return builder(new NonSort());
    }

    public static Builder builder(NonSort ns) {
        return new Builder(ns);
    }

    public static class Builder extends BuilderBase<NonSort, Builder> implements IXsStringBuilder<NonSort, Builder>, ILanguageAttributeGroupBuilder<NonSort, Builder> {

        protected Builder(NonSort nonSort) {
            super(nonSort);
        }
    }
}
