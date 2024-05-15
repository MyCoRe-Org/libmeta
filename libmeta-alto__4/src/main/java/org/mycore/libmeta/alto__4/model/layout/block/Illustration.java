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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * A picture or image.
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Illustration extends Block {

	/**
	 * A user defined string to identify the type of illustration like photo, map,
	 * drawing, chart, ...
	 */
	@XmlAttribute(name = "TYPE", required = false)
	@XmlSchemaType(name = "string")
	protected String TYPE;

	/** A link to an image which contains only the illustration. */
	@XmlAttribute(name = "FILEID", required = false)
	@XmlSchemaType(name = "string")
	protected String FILEID;

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getFILEID() {
		return FILEID;
	}

	public void setFILEID(String fILEID) {
		FILEID = fILEID;
	}

	public static Builder builder() {
		return builder(new Illustration());
	}

	public static Builder builder(Illustration Illustration) {
		return new Builder(Illustration);
	}

	public static class Builder extends BuilderBase<Illustration, Builder>
			implements IBlockBuilder<Illustration, Builder> {

		protected Builder(Illustration Illustration) {
			super(Illustration);
		}

		public Builder TYPE(String type) {
			_target().setTYPE(type);
			return _self();
		}

		public Builder FILEID(String styleRefs) {
			_target().setSTYLEREFS(styleRefs);
			return _self();
		}
	}
}
