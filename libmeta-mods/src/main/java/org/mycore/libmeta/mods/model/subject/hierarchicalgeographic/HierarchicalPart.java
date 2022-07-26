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
package org.mycore.libmeta.mods.model.subject.hierarchicalgeographic;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IHierarchicalPartBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 *  Abstract class for  <HierachricalPart>
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class HierarchicalPart extends StringPlusLanguage
        implements IAuthorityAttributeGroup {

    @XmlAttribute(name = "level", required=false)
    protected String level;

    @XmlAttribute(name = "period", required=false)
    protected String period;

    // IAuthorityAttributeGroup - begin

     @XmlAttribute(name="authority", required=false)
     protected String authority;
    
    /**
     * <xs:attribute name="authorityURI" type="xs:anyURI"/>
     */
     @XmlAttribute(name="authorityURI", required=false)
     protected String authorityURI;
     /**
      * <xs:attribute name="valueURI" type="xs:anyURI"/>
      */
     @XmlAttribute(name="valueURI", required=false)
     protected String valueURI;
     
    // IAuthorityAttributeGroup - end


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
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

    public static class Builder extends BuilderBase<HierarchicalPart, Builder> implements IHierarchicalPartBuilder<HierarchicalPart, Builder> {
        
    	protected Builder(HierarchicalPart hp) {
            super(hp);
        }
    }
}
