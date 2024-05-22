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
package org.mycore.libmeta.alto__4.model.layout.shape;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *  A circle shape. 
 *  HPOS and VPOS describe the center of the circle.
 *  
 *  @author Robert Stephan
 *  @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Circle implements IShapeChild {

	@XmlAttribute(name = "HPOS", required = true)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	@XmlSchemaType(name = "float")
	protected Float HPOS;
	
	@XmlAttribute(name = "VPOS", required = true)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	@XmlSchemaType(name = "float")
	protected Float VPOS;
	
	@XmlAttribute(name = "RADIUS", required = true)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	@XmlSchemaType(name = "float")
	protected Float RADIUS;

	public Float getHPOS() {
		return HPOS;
	}

	public void setHPOS(Float hPOS) {
		HPOS = hPOS;
	}

	public Float getVPOS() {
		return VPOS;
	}

	public void setVPOS(Float vPOS) {
		VPOS = vPOS;
	}

	public Float getRADIUS() {
		return RADIUS;
	}

	public void setRADIUS(Float rADIUS) {
		RADIUS = rADIUS;
	}
	
	public static Builder builder() {
		return builder(new Circle());
	}

	public static Builder builder(Circle circle) {
		return new Builder(circle);
	}

	public static class Builder extends BuilderBase<Circle, Builder> {

		protected Builder(Circle circle) {
			super(circle);
		}
		
		public Builder HPOS(Float hpos) {
			_target().setHPOS(hpos);
			return _self();
		}
		
		public Builder VPOS(Float vpos) {
			_target().setVPOS(vpos);
			return _self();
		}
		
		public Builder RADIUS(Float radius) {
			_target().setRADIUS(radius);
			return _self();
		}
	}
}
