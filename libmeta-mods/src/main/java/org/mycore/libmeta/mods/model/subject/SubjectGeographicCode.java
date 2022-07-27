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
package org.mycore.libmeta.mods.model.subject;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.GeographicCodeAuthority;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 *  MODS Subject Subelement {@literal <geographicCode>}
 *  
 *  {@code
 *  <xs:complexType name="geographicCodeDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguage">
 *				<xs:attribute name="authorityURI" type="xs:anyURI"/>
 *				<xs:attribute name="valueURI" type="xs:anyURI"/>
 *				<xs:attribute name="authority">
 *					<xs:simpleType>
 *						<xs:restriction base="xs:string">
 *							<xs:enumeration value="marcgac"/>
 *							<xs:enumeration value="marccountry"/>
 *							<xs:enumeration value="iso3166"/>
 *						</xs:restriction>
 *					</xs:simpleType>
 *				</xs:attribute>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SubjectGeographicCode extends StringPlusLanguage {

	 @XmlAttribute(name="authority", required=false)
	 protected GeographicCodeAuthority authority;
	
	 @XmlAttribute(name="authorityURI", required=false)
	 protected String authorityURI;

	 @XmlAttribute(name="valueURI", required=false)
	 protected String valueURI;
	 
	public GeographicCodeAuthority getAuthority() {
		return authority;
	}

	public void setAuthority(GeographicCodeAuthority authority) {
		this.authority = authority;
	}

	public String getAuthorityURI() {
		return authorityURI;
	}

	public void setAuthorityURI(String authorityURI) {
		this.authorityURI = authorityURI;
	}

	public String getValueURI() {
		return valueURI;
	}

	public void setValueURI(String valueURI) {
		this.valueURI = valueURI;
	}
	
	public static Builder builder() {
		return new Builder(new SubjectGeographicCode());
	}
	
	public static Builder builder(SubjectGeographicCode sgc) {
		return new Builder(sgc);
	}
	
	public static class Builder extends BuilderBase<SubjectGeographicCode, Builder> implements IXsStringBuilder<SubjectGeographicCode, Builder>, ILanguageAttributeGroupBuilder<SubjectGeographicCode, Builder> {
		 protected Builder(SubjectGeographicCode sgc) {
			super(sgc);
		}

		 public Builder authority(GeographicCodeAuthority authority) {
	    	_target().setAuthority(authority);
	    	return _self();
	    }
	    
	    public Builder authorityURI(String authorityURI) {
	    	_target().setAuthorityURI(authorityURI);
	    	return _self();
	    }
	    
	    public Builder valueURI(String valueURI) {
	    	_target().setValueURI(valueURI);
	    	return _self();
	    }
	}
}