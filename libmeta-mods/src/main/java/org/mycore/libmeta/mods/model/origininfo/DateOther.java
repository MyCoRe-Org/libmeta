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
import org.mycore.libmeta.mods.model._misc.DateDefinition;
import org.mycore.libmeta.mods.model._misc.builder.IDateDefinitionBuilder;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xs:complexType name="dateOtherDefinition">
 *   <xs:simpleContent>
 *     <xs:extension base="dateDefinition">
 *       <xs:attribute name="type" type="xs:string"/>
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
public class DateOther extends DateDefinition implements IOriginInfoSubelement {
   
    @XmlAttribute(name = "type")
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Builder builderForDateOther() {
        return builder(new DateOther());
    }
    
    public static Builder builder(DateOther dateOther) {
        return new Builder(dateOther);
    }
    
    public static class Builder extends BuilderBase<DateOther, Builder> implements IDateDefinitionBuilder<DateOther, Builder>{
        protected Builder(DateOther d) {
            super(d);
        }
        
        public Builder type(String type) {
            _target().setType(type);
            return this;
        }
        
    }
}
