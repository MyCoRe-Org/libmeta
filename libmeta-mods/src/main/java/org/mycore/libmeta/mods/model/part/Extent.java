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

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model.part.extend.End;
import org.mycore.libmeta.mods.model.part.extend.List;
import org.mycore.libmeta.mods.model.part.extend.Start;
import org.mycore.libmeta.mods.model.part.extend.Total;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 *  <xs:complexType name="extentDefinition">
 *    <xs:sequence>
 *      <xs:element ref="start" minOccurs="0"/>
 *      <xs:element ref="end" minOccurs="0"/>
 *      <xs:element ref="total" minOccurs="0"/>
 *      <xs:element ref="list" minOccurs="0"/>
 *    </xs:sequence>
 *    <xs:attribute name="unit" type="xs:string"/>
 *  </xs:complexType>
 *    
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name="extentDefinition", propOrder = { "start", "end", "total", "list" })

public class Extent implements IPartSubelement {
    
    //sequence
    @XmlElement(name = "start", namespace = "http://www.loc.gov/mods/v3", required = false)    
    protected Start start;
    
    @XmlElement(name = "end", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected End end;
    
    @XmlElement(name = "total", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected Total total;
    
    @XmlElement(name = "list", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List list;
    
    @XmlAttribute(name="unit")
    protected String unit;

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public static Builder builder() {
        return new Builder(new Extent());
    }
    
    public static Builder builder(Extent e) {
        return new Builder(e);
    }
    
    public static class Builder extends BuilderBase<Extent, Builder> {
                
        protected Builder(Extent lst) {
            super(lst);
        }
        
        public Builder start(Start start) {
            _target().setStart(start);
            return _self();
        }
        
        public Builder end(End end) {
            _target().setEnd(end);
            return _self();
        }
        
        public Builder total(Total total) {
            _target().setTotal(total);
            return _self();
        }
        
        public Builder list(List list) {
            _target().setList(list);
            return _self();
        }
        
        public Builder unit(String unit) {
            _target().setUnit(unit);
            return _self();
        }
    }
}
