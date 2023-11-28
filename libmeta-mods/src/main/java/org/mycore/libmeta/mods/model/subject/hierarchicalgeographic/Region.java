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
 * MODS HierachicalGeographic Subelement {@literal <region>}
 * 
 * {@code
 *  <xs:complexType name="regionDefinition">
 *      <xs:simpleContent>
 *          <xs:extension base="hierarchicalPart">
 *              <xs:attribute name="regionType"/>
 *          </xs:extension>
 *      </xs:simpleContent>
 *  </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Region extends HierarchicalPart implements IHierarchicalGeographicSubelement {

    @XmlAttribute(name = "regionType", required = false)
    protected String regionType;

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public static Builder builder() {
        return builder(new Region());
    }

    public static Builder builder(Region toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<Region, Builder>
        implements IHierarchicalPartBuilder<Region, Builder> {
        protected Builder(Region r) {
            super(r);
        }

        public Builder regionType(String regionType) {
            _target().setRegionType(regionType);
            return _self();
        }
    }
}
