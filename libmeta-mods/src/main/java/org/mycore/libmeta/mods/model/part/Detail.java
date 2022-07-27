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
package org.mycore.libmeta.mods.model.part;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model.part.detail.Caption;
import org.mycore.libmeta.mods.model.part.detail.IPartDetailSubelement;
import org.mycore.libmeta.mods.model.part.detail.Title;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * detailDefinition  
 *  {@literal <detail>}  is a subelement of {@literal <part>}
 *  
 *  {@code
 *  <xs:complexType name="detailDefinition">
 *    <xs:choice maxOccurs="unbounded">
 *      <xs:element ref="number"/>
 *      <xs:element ref="caption"/>
 *      <xs:element ref="title"/>
 *    </xs:choice>
 *    <xs:attribute name="type" type="xs:string"/>
 *    <xs:attribute name="level" type="xs:positiveInteger"/>
 *  </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Detail implements IPartSubelement {
    
    // <xs:choice maxOccurs="unbounded">
    @XmlElements({
        @XmlElement(name = "number", namespace = "http://www.loc.gov/mods/v3", type = org.mycore.libmeta.mods.model.part.detail.Number.class),
        @XmlElement(name = "caption", namespace = "http://www.loc.gov/mods/v3", type = Caption.class),
        @XmlElement(name = "title", namespace = "http://www.loc.gov/mods/v3", type = Title.class) })

    protected List<IPartDetailSubelement> content = new Vector<>();

    @XmlAttribute(name = "type", required = false)
    protected String type;

    @XmlAttribute(name = "level", required = false)
    protected Integer level;

    public List<IPartDetailSubelement> getContent() {
        return content;
    }

    public void setContent(List<IPartDetailSubelement> content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public static Builder builder() {
        return new Builder(new Detail());
    }
    
    public static Builder builder(Detail d) {
        return new Builder(d);
    }
    
    public static class Builder extends BuilderBase<Detail, Builder> {
        
        protected Builder(Detail d) {
            super(d);
        }
        
        public Builder addContent(IPartDetailSubelement e) {
            _target().getContent().add(e);
            return _self();
        }
        
        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }
        
        public Builder level(Integer level) {
            _target().setLevel(level);
            return _self();
        }
    }
}
