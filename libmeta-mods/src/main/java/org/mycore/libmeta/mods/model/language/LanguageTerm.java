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
package org.mycore.libmeta.mods.model.language;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.CodeOrText;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.LanguageTermAuthority;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xs:complexType name="languageTermDefinition">
 *   <xs:simpleContent>
 *     <xs:extension base="stringPlusLanguage">
 *       <xs:attribute name="authorityURI" type="xs:anyURI"/>
 *       <xs:attribute name="valueURI" type="xs:anyURI"/>
 *       <xs:attribute name="authority">
 *         <xs:simpleType>
 *           <xs:restriction base="xs:string">
 *             <xs:enumeration value="rfc3066"/>
 *             <xs:enumeration value="iso639-2b"/>
 *             <xs:enumeration value="iso639-3"/>
 *             <xs:enumeration value="rfc4646"/>
 *             <xs:enumeration value="rfc5646"/>
 *             <!-- -->
 *           </xs:restriction>
 *         </xs:simpleType>
 *       </xs:attribute>
 *       <xs:attribute name="type" type="codeOrText"/>
 *     </xs:extension>
 *   </xs:simpleContent>
 * </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class LanguageTerm extends StringPlusLanguage implements ILanguageSubelement {

    @XmlAttribute(name="authorityURI", required=false)
    String authorityURI;

    @XmlAttribute(name="valueURI", required=false)
    String valueURI;
    
    @XmlAttribute(name="authority", required=false)
    LanguageTermAuthority authority;
    
    @XmlAttribute(name="type", required=false)
    CodeOrText type;

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

    public LanguageTermAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(LanguageTermAuthority authority) {
        this.authority = authority;
    }

    public CodeOrText getType() {
        return type;
    }

    public void setType(CodeOrText type) {
        this.type = type;
    }
    
    public static Builder builderForLanguaeTerm() {
        return builder(new LanguageTerm());
    }
    
    public static Builder builder(LanguageTerm nlt) {
        return new Builder(nlt);
    }
    
    public static class Builder extends BuilderBase<LanguageTerm, Builder> implements IXsStringBuilder<LanguageTerm, Builder>, ILanguageAttributeGroupBuilder<LanguageTerm, Builder>{
                
        protected Builder(LanguageTerm lt) {
            super(lt);
        }
        
        public Builder authorityURI(String authorityURI) {
            _target().setAuthorityURI(authorityURI);
            return _self();
        }
        
        public Builder valueURI(String valueURI) {
            _target().setValueURI(valueURI);
            return _self();
        }
        
        public Builder authority(LanguageTermAuthority authority) {
            _target().setAuthority(authority);
            return _self();
        }
        
        public Builder type(CodeOrText type) {
            _target().setType(type);
            return _self();
        }
    }
   
}
