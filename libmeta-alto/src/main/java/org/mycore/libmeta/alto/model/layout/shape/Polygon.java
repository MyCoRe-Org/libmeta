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
package org.mycore.libmeta.alto.model.layout.shape;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class Polygon implements IShape {

	@XmlAttribute(name = "POINTS", required = true)
	protected String POINTS;

	public String getPOINTS() {
		return POINTS;
	}

	public void setPOINTS(String points) {
		POINTS = points;
	}

	public static Builder builder() {
		return builder(new Polygon());
	}

	public static Builder builder(Polygon p) {
		return new Builder(p);
	}

	public static class Builder extends BuilderBase<Polygon, Builder> {

		protected Builder(Polygon p) {
			super(p);
		}

		public Builder POINTS(String points) {
			_target().setPOINTS(points);
			return _self();
		}

	}
}