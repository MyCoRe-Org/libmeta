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
package org.mycore.libmeta.mods.model.name;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.CodeOrText;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Mods Name Role Subelement <roleTerm>
 * 
 * <xs:complexType name="roleTermDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguagePlusAuthority">
 *				<xs:attribute name="type" type="codeOrText"/>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class RoleTerm extends StringPlusLanguagePlusAuthority {

	@XmlAttribute(name = "type", required=false)
	protected CodeOrText type;

	public CodeOrText getType() {
		return type;
	}

	public void setType(CodeOrText type) {
		this.type = type;
	}

	public static Builder builder() {
		return builder(new RoleTerm());
	}
	
	public static Builder builder(RoleTerm roleTerm) {
		return new Builder(roleTerm);
	}
	
	public static class Builder extends BuilderBase<RoleTerm, Builder> implements IXsStringBuilder<RoleTerm, Builder>, ILanguageAttributeGroupBuilder<RoleTerm, Builder>, IAuthorityAttributeGroupBuilder<RoleTerm, Builder> {
		protected Builder(RoleTerm role) {
			super(role);
		}
	    
	    public Builder type(CodeOrText type) {
	    	_target().setType(type);
	    	return _self();
	    }
	}
}