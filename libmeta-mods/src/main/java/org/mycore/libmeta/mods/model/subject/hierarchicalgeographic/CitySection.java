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
 * MODS HierarchicalGeographic Subelement {@literal <citySection>}
 * 
 * {@code
 *  <xs:complexType name="citySectionDefinition">
 *      <xs:simpleContent>
 *          <xs:extension base="hierarchicalPart">
 *              <xs:attribute name="citySectionType"/>
 *          </xs:extension>
 *      </xs:simpleContent>
 *  </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class CitySection extends HierarchicalPart implements IHierarchicalGeographicSubelement {

    @XmlAttribute(name = "citySectionType", required=false)
    protected String citySectionType;
    
    public String getCitySectionType() {
        return citySectionType;
    }

    public void setCitySectionType(String citySectionType) {
        this.citySectionType = citySectionType;
    }

    public static Builder builder() {
        return builder(new CitySection());
    }
    
    public static Builder builder(CitySection toc) {
        return new Builder(toc);
    }
    
    public static class Builder extends BuilderBase<CitySection, Builder> implements IHierarchicalPartBuilder<CitySection, Builder>{
        protected Builder(CitySection cs) {
            super(cs);
        }
        
        public Builder citySectionType(String citySectionType) {
            _target().setCitySectionType(citySectionType);
            return _self();
        }
    }
}
