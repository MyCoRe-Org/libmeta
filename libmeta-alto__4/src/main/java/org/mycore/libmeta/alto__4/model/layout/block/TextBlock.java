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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.alto.model.layout.Block;
import org.mycore.libmeta.alto.model.layout.IBlockBuilder;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * A block of text.
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TextBlock extends Block {
	@XmlElement(name = "TextLine", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected List<Textline> textline = new Vector<Textline>();

	/** Attribute deprecated. LANG should be used instead. */
	@XmlAttribute(name = "language", required = false)
	@XmlSchemaType(name = "language")
	protected String language;

	@XmlAttribute(name = "LANG", required = false)
	@XmlSchemaType(name = "language")
	protected String LANG;

	//return the LANG value instead of the deprecated LANG
	public String getLanguage() {
		return language == null ? LANG : language;
	}

	// also set the new attribute LANG - if this method is called
	public void setLanguage(String language) {
		this.language = language;
		this.LANG = language;
	}

	public String getLANG() {
		return LANG;
	}

	public void setLANG(String lANG) {
		LANG = lANG;
	}


	public List<Textline> getTextline() {
		return textline;
	}

	public static Builder builder() {
		return builder(new TextBlock());
	}

	public static Builder builder(TextBlock textBlock) {
		return new Builder(textBlock);
	}

	public static class Builder extends BuilderBase<TextBlock, Builder> implements
			IBlockBuilder<TextBlock, Builder> {

		protected Builder(TextBlock textBlock) {
			super(textBlock);
		}

		public Builder addTextline(Textline textline) {
			_target().getTextline().add(textline);
			return _self();
		}

		public Builder LANG(String lang) {
			_target().setLANG(lang);
			return _self();
		}
	}
}
