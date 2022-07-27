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
package org.mycore.libmeta.mods.model._misc.types;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ISuppliedAttributeBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Supplied;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public class StringPlusLanguagePlusSupplied extends StringPlusLanguage {
	
	/**
	 * {@code
	 * <xs:attribute name="supplied" fixed="yes"/>
	 * }
	 */
	 @XmlAttribute(name="supplied", namespace="http://www.loc.gov/mods/v3", required=false)
	 Supplied supplied;

	public Supplied getSupplied() {
		return supplied;
	}

	public void setSupplied(Supplied supplied) {
		this.supplied = supplied;
	}

	
	public static class Builder extends BuilderBase<StringPlusLanguagePlusSupplied, Builder> implements IXsStringBuilder<StringPlusLanguagePlusSupplied, Builder>, ILanguageAttributeGroupBuilder<StringPlusLanguagePlusSupplied, Builder>, ISuppliedAttributeBuilder<StringPlusLanguagePlusSupplied, Builder>{
		    
	    protected Builder(StringPlusLanguagePlusSupplied spl) {
			super(spl);
		}

	}
}