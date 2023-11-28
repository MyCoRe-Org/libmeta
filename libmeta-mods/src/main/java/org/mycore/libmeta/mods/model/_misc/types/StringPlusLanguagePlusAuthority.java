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
package org.mycore.libmeta.mods.model._misc.types;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public class StringPlusLanguagePlusAuthority extends StringPlusLanguage implements IAuthorityAttributeGroup {

    /**
     * {@code
     * <xs:attribute name="authority" type="xs:string"/>
     * }
     */
    @XmlAttribute(name = "authority", required = false)
    String authority;

    /**
     * {@code
     * <xs:attribute name="authorityURI" type="xs:anyURI"/>
     * }
     */
    @XmlAttribute(name = "authorityURI", required = false)
    String authorityURI;

    /**
     * {@code
     * <xs:attribute name="valueURI" type="xs:anyURI"/>
     * }
     */
    @XmlAttribute(name = "valueURI", required = false)
    String valueURI;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityURI() {
        return authorityURI;
    }

    public void setAuthorityURI(String authorityURI) {
        this.authorityURI = authorityURI;
    }

    public String getValueURI() {
        return valueURI;
    }

    public void setValueURI(String valueURI) {
        this.valueURI = valueURI;
    }

    public static class Builder extends BuilderBase<StringPlusLanguagePlusAuthority, Builder>
        implements IXsStringBuilder<StringPlusLanguagePlusAuthority, Builder>,
        ILanguageAttributeGroupBuilder<StringPlusLanguagePlusAuthority, Builder>,
        IAuthorityAttributeGroupBuilder<StringPlusLanguagePlusAuthority, Builder> {

        protected Builder(StringPlusLanguagePlusAuthority spl) {
            super(spl);
        }
    }
}
