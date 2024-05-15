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
package org.mycore.libmeta.alto__4.model.styles;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Styles define properties of layout elements. A style defined in a parent
 * element is used as default style for all related children elements.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 */

@XmlAccessorType(XmlAccessType.NONE)
public class Styles {

	@XmlElement(name = "TextStyle", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected List<TextStyle> textStyle = new Vector<TextStyle>();

	@XmlElement(name = "ParagraphStyle", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected List<ParagraphStyle> paragraphStyle = new Vector<ParagraphStyle>();

	public List<TextStyle> getTextStyle() {
		return textStyle;
	}

	public List<ParagraphStyle> getParagraphStyle() {
		return paragraphStyle;
	}

	public static Builder builder() {
		return builder(new Styles());
	}

	public static Builder builder(Styles styles) {
		return new Builder(styles);
	}

	public static class Builder extends BuilderBase<Styles, Builder> {

		protected Builder(Styles styles) {
			super(styles);
		}

		public Builder addTextStyle(TextStyle textStyle) {
			_target().getTextStyle().add(textStyle);
			return _self();
		}

		public Builder addParagraphStyle(ParagraphStyle paragraphStyle) {
			_target().getParagraphStyle().add(paragraphStyle);
			return _self();
		}
	}
}