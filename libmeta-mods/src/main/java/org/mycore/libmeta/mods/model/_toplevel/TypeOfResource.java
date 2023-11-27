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
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Top Level Element {@literal <typeOfResource>}
 * 
 * {@code
 * 	<xs:complexType name="typeOfResourceDefinition">
 *       <xs:simpleContent>
 *           <xs:extension base="stringPlusLanguagePlusAuthority">
 *               <xs:attribute name="collection" fixed="yes"/>
 *               <xs:attribute name="manuscript" fixed="yes"/>
 *               <xs:attribute name="displayLabel" type="xs:string"/>
 *               <xs:attribute name="altRepGroup" type="xs:string"/>
 *               <xs:attribute name="usage" fixed="primary"/>
 *           </xs:extension>
 *      </xs:simpleContent>
 *  </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * @version MODS 3.7 (allow any string as content)
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TypeOfResource extends StringPlusLanguagePlusAuthority implements ITopLevelElement, IIDAttributeGroup {

    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;
    
    /**
     * {@code
     * <xs:attribute name="collection" fixed="yes"/>
     * }
     */
    protected Yes collection;
    
    /**
     * {@code
     * <xs:attribute name="manuscript" fixed="yes"/>
     * }
     */
    protected Yes manuscript;
    
    /**
     * {@code
     * <xs:attribute name="displayLabel" type="xs:string"/>
     * }
     */
    protected String displayLabel;
    
    /**
     * {@code
     * <xs:attribute name="altRepGroup" type="xs:string"/>
     * }
     */
    protected String altRepGroup;
    
    /**
     * {@code
     * <xs:attribute name="usage" fixed="primary"/>
     * }
     */
    protected Usage usage;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getIDREF() {
        return IDREF;
    }

    public void setIDREF(String iDREF) {
        IDREF = iDREF;
    }

	public Yes getCollection() {
		return collection;
	}

	public void setCollection(Yes collection) {
		this.collection = collection;
	}

	public Yes getManuscript() {
		return manuscript;
	}

	public void setManuscript(Yes manuscript) {
		this.manuscript = manuscript;
	}

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

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	public static Builder builderForTypeOfResource() {
		return builder(new TypeOfResource());
	}
	
	public static Builder builder(TypeOfResource tor) {
		return new Builder(tor);
	}
	
	public static class Builder extends BuilderBase<TypeOfResource, Builder> implements IXsStringBuilder<TypeOfResource, Builder>, IIDAttributeGroupBuilder<TypeOfResource, Builder>, ILanguageAttributeGroupBuilder<TypeOfResource, Builder>, IAuthorityAttributeGroupBuilder<TypeOfResource, Builder>{
			    
	    protected Builder(TypeOfResource tor) {
			super(tor);
		}
	    
	    public Builder collection(Yes collection) {
			_target().setCollection(collection);
			return _self();
		}
	    
	    public Builder manuscript(Yes manuscript) {
			_target().setManuscript(manuscript);
			return _self();
		}
	    
	    public Builder displayLabel(String displayLabel) {
			_target().setDisplayLabel(displayLabel);
			return _self();
		}
	    
	    public Builder altRepGroup(String altRepGroup) {
	    	_target().setAltRepGroup(altRepGroup);
	    	return _self();
	    }
	    
	    public Builder usage(Usage usage) {
	    	_target().setUsage(usage);
	    	return _self();
	    }
	}
}
