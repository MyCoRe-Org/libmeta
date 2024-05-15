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
package org.mycore.libmeta.alto__4.model.layout.block;

import org.mycore.libmeta.alto.model.layout.Block;
import org.mycore.libmeta.alto.model.layout.IBlockBuilder;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * A graphic used to separate blocks. Usually a line or rectangle.
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class GraphicalElement extends Block{
	
	public static Builder builder() {
		return builder(new GraphicalElement());
	}

	public static Builder builder(GraphicalElement graphicalElement) {
		return new Builder(graphicalElement);
	}

	public static class Builder extends BuilderBase<GraphicalElement, Builder> implements
			IBlockBuilder<GraphicalElement, Builder> {

		protected Builder(GraphicalElement graphicalElement) {
			super(graphicalElement);
		}
	}
}
