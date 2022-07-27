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
package org.mycore.libmeta.mods.model.subject.hierarchicalgeographic;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IHierarchicalPartBuilder;

import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * MODS HierachicalGeographic Subelement {@literal <area>}
 * 
 * {@code
 *  <xs:complexType name="areaDefinition">
 *      <xs:simpleContent>
 *          <xs:extension base="hierarchicalPart">
 *              <xs:attribute name="areaType"/>
 *          </xs:extension>
 *      </xs:simpleContent>
 *  </xs:complexType>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Area extends HierarchicalPart implements IHierarchicalGeographicSubelement {

    @XmlAttribute(name = "areaType", required=false)
    protected String areaType;
    
    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public static Builder builder() {
        return builder(new Area());
    }
    
    public static Builder builder(Area ar) {
        return new Builder(ar);
    }
    
    public static class Builder extends BuilderBase<Area, Builder> implements IHierarchicalPartBuilder<Area, Builder>{
        protected Builder(Area ar) {
            super(ar);
        }

        public Builder areaType(String areaType) {
            _target().setAreaType(areaType);
            return _self();
        }
    }
}
