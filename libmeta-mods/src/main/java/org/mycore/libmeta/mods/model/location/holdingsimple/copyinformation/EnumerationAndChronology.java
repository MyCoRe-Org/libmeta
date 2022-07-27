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
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.mods.model.location.ILocationSublement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;


/**
 * MODS Location Subelement: EnumerationAndChronology
 * 
 * {@code
 * <xs:complexType name="enumerationAndChronologyDefinition">
 *       <xs:simpleContent>
 *           <xs:extension base="stringPlusLanguage">
 *               <xs:attribute name="unitType">
 *                   <xs:simpleType>
 *                       <xs:restriction base="xs:string">
 *                           <xs:enumeration value="1"/>
 *                           <xs:enumeration value="2"/>
 *                           <xs:enumeration value="3"/>
 *                       </xs:restriction>
 *                   </xs:simpleType>
 *               </xs:attribute>
 *           </xs:extension>
 *       </xs:simpleContent>
 *   </xs:complexType>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class EnumerationAndChronology extends StringPlusLanguage implements ILocationSublement {

    @XmlAttribute(name = "unitType")
    protected EnumerationAndChronologyUnitType unitType;

    public EnumerationAndChronologyUnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(EnumerationAndChronologyUnitType unitType) {
        this.unitType = unitType;
    }

    public static Builder builderForEnumerationAndChronology() {
        return builder(new EnumerationAndChronology());
    }

    public static Builder builder(EnumerationAndChronology uac) {
        return new Builder(uac);
    }

    public static class Builder extends BuilderBase<EnumerationAndChronology, Builder> implements IXsStringBuilder<EnumerationAndChronology, Builder>, ILanguageAttributeGroupBuilder<EnumerationAndChronology, Builder> {
        protected Builder(EnumerationAndChronology eac) {
            super(eac);
        }

        public Builder unitType(EnumerationAndChronologyUnitType unitType) {
            _target().setUnitType(unitType);
            return _self();
        }
    }
}
