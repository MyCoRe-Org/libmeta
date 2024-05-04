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
package org.mycore.libmeta.mods.model.subject;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.DateDefinition;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IDateDefinitionBuilder;

import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 *   <xs:complexType name="temporalDefinition">
 *       <xs:simpleContent>
 *           <xs:extension base="dateDefinition">
 *               <xs:attributeGroup ref="authorityAttributeGroup"/>
 *           </xs:extension>
 *       </xs:simpleContent>
 *   </xs:complexType>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.6
 */

public class SubjectTemporal extends DateDefinition implements ISubjectSubelement, IAuthorityAttributeGroup {

    // IAuthorityAttributeGroup - begin

    @XmlAttribute(name = "authority", required = false)
    protected String authority;

    @XmlAttribute(name = "authorityURI", required = false)
    protected String authorityURI;

    @XmlAttribute(name = "valueURI", required = false)
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

    // IAuthorityAttributeGroup - end

    public static Builder builderForSubjectTemporal() {
        return builder(new SubjectTemporal());
    }

    public static Builder builder(SubjectTemporal subjectTemporal) {
        return new Builder(subjectTemporal);
    }

    public static class Builder extends BuilderBase<SubjectTemporal, Builder> implements
        IDateDefinitionBuilder<SubjectTemporal, Builder>,
        IAuthorityAttributeGroupBuilder<SubjectTemporal, Builder> {

        protected Builder(SubjectTemporal subjectTemporal) {
            super(subjectTemporal);
        }
    }
}
