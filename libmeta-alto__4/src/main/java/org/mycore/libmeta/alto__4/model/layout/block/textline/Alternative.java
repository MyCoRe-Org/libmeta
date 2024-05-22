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

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * Any alternative for the word.
 * 
 * @author Robert Stephan
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
public class TextlineStringALTERNATIVE implements ITextlineStringChild {

	/** Identifies the purpose of the alternative. */
	@XmlValue
	protected TextlineString value;

	@XmlAttribute(name = "PURPOSE", required = false)
	@XmlSchemaType(name = "string")
	protected TextlineString PURPOSE;

	public TextlineString getValue() {
		return value;
	}

	public void setValue(TextlineString value) {
		this.value = value;
	}

	public TextlineString getPURPOSE() {
		return PURPOSE;
	}

	public void setPURPOSE(TextlineString pURPOSE) {
		PURPOSE = pURPOSE;
	}

	public static Builder builder() {
		return builder(new TextlineStringALTERNATIVE());
	}

	public static Builder builder(TextlineStringALTERNATIVE alternative) {
		return new Builder(alternative);
	}

	public static class Builder extends BuilderBase<TextlineStringALTERNATIVE, Builder> {

		protected Builder(TextlineStringALTERNATIVE alternative) {
			super(alternative);
		}

		public Builder value(TextlineString value) {
			_target().setValue(value);
			return _self();
		}

		public Builder PURPOSE(TextlineString purpose) {
			_target().setPURPOSE(purpose);
			return _self();
		}
	}
}
