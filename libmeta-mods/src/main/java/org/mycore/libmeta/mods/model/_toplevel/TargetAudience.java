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
package org.mycore.libmeta.mods.model._toplevel;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Top Level Element {@literal <targetAudience>} 
 * 
 * {@code 
 * <xs:complexType name="targetAudienceDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguagePlusAuthority">
 *				<xs:attribute name="displayLabel" type="xs:string"/>
 *				<xs:attribute name="altRepGroup" type="xs:string"/>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TargetAudience extends StringPlusLanguagePlusAuthority {
 	/**
 	 * {@code 
     * <xs:attribute name="displayLabel" type="xs:string"/>
     * }
     */
    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;
    
   /**
     * {@code 
     * <xs:attribute name="altRepGroup" type="xs:string"/> 
     * }
     * 
     * altRepGroup new in 3.4
     */
    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;
    
    public String getDisplayLabel() {
 		return displayLabel;
 	}

 	public void setDisplayLabel(String displayLabel) {
 		this.displayLabel = displayLabel;
 	}

 	public String getAltRepGroup() {
 		return altRepGroup;
 	}

 	public void setAltRepGroup(String altRepGroup) {
 		this.altRepGroup = altRepGroup;
 	}
 	
	public static Builder builderForTargetAudience() {
		return builder(new TargetAudience());
	}
	
	public static Builder builder(TargetAudience spl) {
		return new Builder(spl);
	}
	
	public static class Builder extends BuilderBase<TargetAudience, Builder> implements IXsStringBuilder<TargetAudience, Builder>, ILanguageAttributeGroupBuilder<TargetAudience, Builder>, IAuthorityAttributeGroupBuilder<TargetAudience, Builder>{
	    protected Builder(TargetAudience spl) {
			super(spl);
		}
	    
		public Builder displayLabel(String displayLabel) {
			_target().setDisplayLabel(displayLabel);
			return _self();
		}
		
		public Builder altRepGroup(String altRepGroup) {
			_target().setAltRepGroup(altRepGroup);
			return _self();
		}
	}
}
