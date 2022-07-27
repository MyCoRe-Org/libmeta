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
package org.mycore.libmeta.mods.model.physicaldescription;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ISuppliedAttributeBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusSupplied;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * MODS PhysicalDescription Subelement: Extent
 * 
 * {@code
 *  <xs:element name="extent">
 *       <xs:complexType>
 *           <xs:simpleContent>
 *               <xs:extension base="stringPlusLanguagePlusSupplied">
 *                   <xs:attribute name="unit"/>
 *               </xs:extension>
 *               </xs:simpleContent>
 *       </xs:complexType>
 *  </xs:element>
 * }
 *    
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Extent extends StringPlusLanguagePlusSupplied implements IPhysicalDescriptionSubelement {

    @XmlAttribute(name = "unit")
    protected String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static Builder builder() {
        return  builder(new Extent());
    }

    public static Builder builder(Extent e) {
        return new Builder(e);
    }

    public static class Builder  extends BuilderBase<Extent, Builder> implements IXsStringBuilder<Extent, Builder>, ILanguageAttributeGroupBuilder<Extent, Builder>,  ISuppliedAttributeBuilder<Extent, Builder> {
        protected Builder(Extent ext) {
            super(ext);
        }

        public Builder unit(String unit) {
            _target().setUnit(unit);
            return _self();
        }
    }
}
