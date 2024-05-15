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

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A paragraph style defines formatting properties of text blocks.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ParagraphStyle {

	@XmlAttribute(name = "ID", required = true)
	protected String ID;
	
	@XmlAttribute(name = "ALIGN", required = false)
	protected ParagraphALIGN ALIGN;
	
	@XmlAttribute(name = "LEFT", required = false)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float LEFT;
	
	@XmlAttribute(name = "RIGHT", required = false)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float RIGHT;
	
	@XmlAttribute(name = "LINESPACE", required = false)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float LINESPACE;
	
	@XmlAttribute(name = "FIRSTLINE", required = false)
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float FIRSTLINE;
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public ParagraphALIGN getALIGN() {
		return ALIGN;
	}

	public void setALIGN(ParagraphALIGN aLIGN) {
		ALIGN = aLIGN;
	}

	public Float getLEFT() {
		return LEFT;
	}

	public void setLEFT(Float lEFT) {
		LEFT = lEFT;
	}

	public Float getRIGHT() {
		return RIGHT;
	}

	public void setRIGHT(Float rIGHT) {
		RIGHT = rIGHT;
	}

	public Float getLINESPACE() {
		return LINESPACE;
	}

	public void setLINESPACE(Float lINESPACE) {
		LINESPACE = lINESPACE;
	}

	public Float getFIRSTLINE() {
		return FIRSTLINE;
	}

	public void setFIRSTLINE(Float fIRSTLINE) {
		FIRSTLINE = fIRSTLINE;
	}
	
	
	public static Builder builder() {
		return builder(new ParagraphStyle());
	}

	public static Builder builder(ParagraphStyle paragraphStyle) {
		return new Builder(paragraphStyle);
	}

	public static class Builder extends BuilderBase<ParagraphStyle, Builder> {

		protected Builder(ParagraphStyle paragraphStyle) {
			super(paragraphStyle);
		}

		public Builder ID(String id) {
			_target().setID(id);
			return _self();
		}
		
		public Builder ALIGN(ParagraphALIGN align) {
			_target().setALIGN(align);
			return _self();
		}
		
		public Builder LEFT(Float left) {
			_target().setLEFT(left);
			return _self();
		}
		
		public Builder LINESPACE(Float linespace) {
			_target().setLINESPACE(linespace);
			return _self();
		}
		
		public Builder FIRSTLINE(Float firstline) {
			_target().setFIRSTLINE(firstline);
			return _self();
		}
	}
}
