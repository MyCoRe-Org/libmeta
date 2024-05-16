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
package org.mycore.libmeta.alto__4.model.layout.block.textline;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxHolder;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A hyphenation char. Can appear only at the end of a line.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class HYP implements ITextlineChild, IBoundingBoxHolder {
	@XmlAttribute(name = "HEIGHT", required = true)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float HEIGHT;

	@XmlAttribute(name = "WIDTH", required = false)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float WIDTH;

	@XmlAttribute(name = "HPOS", required = false)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float HPOS;

	@XmlAttribute(name = "VPOS", required = false)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float VPOS;
	
	@XmlAttribute(name = "CONTENT", required = true)
	@XmlSchemaType(name = "CONTENT")
	protected TextlineString CONTENT;

	public TextlineString getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(TextlineString content) {
		CONTENT = content;
	}

	public Float getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(Float hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public Float getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(Float wIDTH) {
		WIDTH = wIDTH;
	}

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
	
	public static Builder builder() {
		return builder(new HYP());
	}

	public static Builder builder(HYP  hyp) {
		return new Builder(hyp);
	}

	public static class Builder extends BuilderBase<HYP, Builder> implements
			IBoundingBoxBuilder<HYP, Builder> {

		protected Builder(HYP hyp) {
			super(hyp);
		}

		public Builder CONTENT(TextlineString content) {
			_target().setCONTENT(content);
			return _self();
		}
	}
}
