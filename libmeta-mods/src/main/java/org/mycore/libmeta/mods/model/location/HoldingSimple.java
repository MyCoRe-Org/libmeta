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
package org.mycore.libmeta.mods.model.location;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model.location.holdingsimple.CopyInformation;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS Location Subelement: HoldingSimple
 * 
 * <xs:complexType name="holdingSimpleDefinition">
 *   <xs:sequence>
 *     <xs:element ref="copyInformation" maxOccurs="unbounded"/>
 *   </xs:sequence>
 * </xs:complexType>
 *
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "copyInformation" })
public class HoldingSimple implements ILocationSublement {
    // <xs:sequence>

    /**
     * <xs:element ref="copyInformation" maxOccurs="unbounded"/>
     */
    @XmlElement(name = "copyInformation", namespace = "http://www.loc.gov/mods/v3", required = true)
    protected List<CopyInformation> copyInformation = new Vector<>();

    public List<CopyInformation> getCopyInformation() {
        return copyInformation;
    }

    
    public static Builder builderForHoldingSimple() {
        return builder(new HoldingSimple());
    }

    public static Builder builder(HoldingSimple hs) {
        return new Builder(hs);
    }

    public static class Builder extends BuilderBase<HoldingSimple, Builder> {
        protected Builder(HoldingSimple hs) {
            super(hs);
        }

        public Builder addCopyInformation(CopyInformation copyInformation){
            _target().getCopyInformation().add(copyInformation);
            return _self();
        }
    }
    
}
