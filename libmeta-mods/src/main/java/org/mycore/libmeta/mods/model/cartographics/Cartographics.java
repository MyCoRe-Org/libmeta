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
package org.mycore.libmeta.mods.model.cartographics;

import java.util.List;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model.origininfo.place.IPlaceSubelement;
import org.mycore.libmeta.mods.model.subject.ISubjectSubelement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS Subject Subelement {@literal <cartographics>}
 * 
 * {@code
 * <xs:complexType name="cartographicsDefinition">
 *		<xs:sequence>
 *			<xs:element ref="scale" minOccurs="0"/>
 *			<xs:element ref="projection" minOccurs="0"/>
 *			<xs:element ref="coordinates" minOccurs="0" maxOccurs="unbounded"/>
 *			<!-- 
  *     *********** Following is new in 3.6, to allow an extension schema.    -->
 *			<xs:element ref="cartographicExtension" minOccurs="0" maxOccurs="unbounded"/>
 *		</xs:sequence>
 *		<xs:attributeGroup ref="authorityAttributeGroup"/>
 *	</xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder= {"scale", "projection", "coordinates", "cartographicExtension"})
public class Cartographics implements ISubjectSubelement, IPlaceSubelement, IAuthorityAttributeGroup {
    // <xs:sequence>
    
    /**
     * {@code
     * <xs:element ref="scale" minOccurs="0"/>
     * }
     */
    @XmlElement(name = "scale", namespace = "http://www.loc.gov/mods/v3", required = false)
     protected Scale scale;
    
    /**
     * {@code
     * <xs:element ref="projection" minOccurs="0"/>
     * }
     */
    @XmlElement(name = "projection", namespace = "http://www.loc.gov/mods/v3", required = false)
     protected Projection projection;
    
    /**
     * {@code
     * <xs:element ref="coordinates" minOccurs="0" maxOccurs="unbounded"/>>
     * }
     */
    @XmlElement(name = "coordinates", namespace = "http://www.loc.gov/mods/v3", required = false)
     protected List<Coordinates> coordinates;
    
    @XmlElement(name = "cartographicExtension", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<CartographicExtension> cartographicExtension;
    
    // --- <xs:attributeGroup name="authorityAttributeGroup"> - begin
    /**
     * {@code
     * <xs:attribute name="authority" type="xs:string"/>
     * }
     */
    @XmlAttribute(name = "authority")
    protected String authority;

    /**
     * {@code
     * <xs:attribute name="authorityURI" type="xs:anyURI"/>
     * }
     */
    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    /**
     * {@code
     * <xs:attribute name="valueURI" type="xs:anyURI"/>
     * }
     */
    @XmlAttribute(name = "valueURI")
    protected String valueURI;
    
    // --- <xs:attributeGroup name="authorityAttributeGroup"> - end
  

	public Scale getScale() {
		return scale;
	}

	public void setScale(Scale scale) {
		this.scale = scale;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public List<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	public List<CartographicExtension> getCartographicExtension() {
		return cartographicExtension;
	}

	public void setCartographicExtension(List<CartographicExtension> cartographicExtension) {
		this.cartographicExtension = cartographicExtension;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthorityURI() {
		return authorityURI;
	}

	public void setAuthorityURI(String authorityURI) {
		this.authorityURI = authorityURI;
	}

	public String getValueURI() {
		return valueURI;
	}

	public void setValueURI(String valueURI) {
		this.valueURI = valueURI;
	}
	
	public static Builder builder() {
		return new Builder(new Cartographics());
	}
	
	public static Builder builder(Cartographics c) {
		return new Builder(c);
	}
	
	public static class Builder extends BuilderBase<Cartographics, Builder> implements IAuthorityAttributeGroupBuilder<Cartographics, Builder>{

		protected Builder(Cartographics spl) {
			super(spl);
		}
	    
	    public Builder scale(Scale scale) {
	    	_target().setScale(scale);
	    	return _self();
	    }
	    
	    public Builder projectiont(Projection projection) {
	    	_target().setProjection(projection);
	    	return _self();
	    }
	    
	    public Builder addCoordinates(Coordinates coordinates) {
	    	_target().getCoordinates().add(coordinates);
	    	return _self();
	    }
	    
	    public Builder addCartographicExtension(CartographicExtension cartEx) {
	    	_target().getCartographicExtension().add(cartEx);
	    	return _self();
	    }
	    
	}
}
