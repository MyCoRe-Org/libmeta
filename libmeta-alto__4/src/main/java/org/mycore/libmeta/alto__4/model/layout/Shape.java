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
package org.mycore.libmeta.alto__4.model.layout;

import org.mycore.libmeta.alto__4.model.layout.block.textline.ITextlineChild;
import org.mycore.libmeta.alto__4.model.layout.block.textline.ITextlineStringChild;
import org.mycore.libmeta.alto__4.model.layout.shape.Circle;
import org.mycore.libmeta.alto__4.model.layout.shape.Ellipse;
import org.mycore.libmeta.alto__4.model.layout.shape.IShapeChild;
import org.mycore.libmeta.alto__4.model.layout.shape.Polygon;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * Describes the bounding shape of a block, if it is not rectangular.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Shape implements ITextlineChild, ITextlineStringChild{
	@XmlElements(value = {
			@XmlElement(name = "Polygon", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false, type = Polygon.class),
			@XmlElement(name = "Ellipse", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false, type = Ellipse.class),
			@XmlElement(name = "Circle", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false, type = Circle.class) })
	protected IShapeChild Shape;

	public IShapeChild getShape() {
		return Shape;
	}

	public void setShape(IShapeChild shape) {
		Shape = shape;
	}
	
	public static Builder builder() {
		return builder(new Shape());
	}

	public static Builder builder(Shape shape) {
		return new Builder(shape);
	}

	public static class Builder extends BuilderBase<Shape, Builder> {

		protected Builder(Shape shape) {
			super(shape);
		}

		public Builder shape(IShapeChild shape) {
			_target().setShape(shape);
			return _self();
		}

	}

}
