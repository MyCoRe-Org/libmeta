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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model.cartographics.Cartographics;
import org.mycore.libmeta.mods.model.origininfo.place.IPlaceSubelement;
import org.mycore.libmeta.mods.model.origininfo.place.PlaceIdentifier;
import org.mycore.libmeta.mods.model.origininfo.place.PlaceTerm;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * MODS OriginInfo Subelement: Place
 * 
 * {@code
 * <xs:complexType name="placeDefinition">
 *      <xs:choice minOccurs="1" maxOccurs="unbounded">
 *        <xs:element ref="placeTerm"/>
 *        <xs:element ref="placeIdentifier"/>
 *        <xs:element ref="cartographics"/>
 *      </xs:choice>
 *      <xs:attribute name="supplied" fixed="yes"/>
 *   </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.8
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Place implements IOriginInfoSubelement {

    @XmlElement(name = "placeTerm", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<PlaceTerm> placeTerm = new Vector<>();

    @XmlElements({ @XmlElement(name = "placeTerm", namespace = "http://www.loc.gov/mods/v3", type = PlaceTerm.class),
        @XmlElement(name = "placeIdentifier", namespace = "http://www.loc.gov/mods/v3", type = PlaceIdentifier.class),
        @XmlElement(name = "cartographics", namespace = "http://www.loc.gov/mods/v3", type = Cartographics.class) })
    protected List<IPlaceSubelement> content = new Vector<>();

    @XmlAttribute(name = "supplied")
    protected Yes supplied;

    public List<IPlaceSubelement> getContent() {
        return content;
    }

    public Yes getSupplied() {
        return supplied;
    }

    public void setSupplied(Yes supplied) {
        this.supplied = supplied;
    }

    public static Builder builderForPlace() {
        return builder(new Place());
    }

    public static Builder builder(Place place) {
        return new Builder(place);
    }

    public static class Builder extends BuilderBase<Place, Builder> {
        protected Builder(Place place) {
            super(place);
        }

        public Builder addContent(IPlaceSubelement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder supplied(Yes supplied) {
            _target().setSupplied(supplied);
            return _self();
        }
    }
}
