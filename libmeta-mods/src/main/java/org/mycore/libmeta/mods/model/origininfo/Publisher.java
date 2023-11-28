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
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ISuppliedAttributeBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusSupplied;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * MODSOriginInfo Subelement publisher
 * 
 * {@code
 * <xs:complexType  name="publisherDefinition">
 *     <xs:simpleContent>
 *         <xs:extension base="stringPlusLanguagePlusSupplied">
 *             <xs:attributeGroup ref="authorityAttributeGroup"/>
 *         </xs:extension>
 *     </xs:simpleContent>
 * </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * @version MODS 3.7 (authority attributes added)
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Publisher extends StringPlusLanguagePlusSupplied
    implements IOriginInfoSubelement, IAuthorityAttributeGroup {

    // IAuthorityAttributeGroup - begin

    /**
     * @version MODS 3.7
     */
    @XmlAttribute(name = "authority")
    protected String authority;

    /**
     * @version MODS 3.7
     */
    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    /**
     * @version MODS 3.7
     */
    @XmlAttribute(name = "valueURI")
    protected String valueURI;

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

    //IAuthorityAttributeGroup - end
    public static Builder builderForPublisher() {
        return builder(new Publisher());
    }

    public static Builder builder(Publisher e) {
        return new Builder(e);
    }

    public static class Builder extends BuilderBase<Publisher, Builder>
        implements IXsStringBuilder<Publisher, Builder>, ILanguageAttributeGroupBuilder<Publisher, Builder>,
        ISuppliedAttributeBuilder<Publisher, Builder>, IAuthorityAttributeGroupBuilder<Publisher, Builder> {
        protected Builder(Publisher p) {
            super(p);
        }
    }
}
