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
package org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS CopyInformation Subelement: Form
 * 
 * {@code
 *  <xs:complexType name="formDefinition">
 *       <xs:simpleContent>
 *           <xs:extension base="stringPlusLanguagePlusAuthority">
 *               <xs:attribute name="type" type="xs:string"/>
 *           </xs:extension>
 *       </xs:simpleContent>
 *   </xs:complexType>
 * }
 * 
 * @author Robert Stephanb
 * @version MODS 3.6
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name="copyinformation_form")
public class Form extends StringPlusLanguagePlusAuthority implements ICopyInformationSubelement {

    @XmlAttribute(name = "type", required = false)
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Builder builderForForm() {
        return builder(new Form());
    }

    public static Builder builder(Form form) {
        return new Builder(form);
    }

    public static class Builder extends BuilderBase<Form, Builder> implements IXsStringBuilder<Form, Builder>, ILanguageAttributeGroupBuilder<Form, Builder>, IAuthorityAttributeGroupBuilder<Form, Builder> {

        protected Builder(Form form) {
            super(form);
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }
    }
}