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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAlternativeNameSubelement;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model._misc.NameDefinition;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.INameDefinitionBuilder;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 *   Subelement {@literal <alternativeName>} of {@literal <name>}
 *   
 * {@code
 * <xs:complexType name="alternativeNameDefinition">
 *     <xs:choice minOccurs="0" maxOccurs="unbounded">
 *         <xs:element ref="namePart"/>
 *         <xs:element ref="displayForm"/>
 *         <xs:element ref="affiliation"/>
 *         <xs:element ref="role"/>
 *         <xs:element ref="description"/>
 *         <xs:element ref="nameIdentifier"/>              
 *     </xs:choice>
 *     <xs:attributeGroup ref="xlink:simpleLink"/>
 *     <xs:attributeGroup ref="languageAttributeGroup"/>
 *     <xs:attribute name="displayLabel" type="xs:string"/>
 *     <xs:attribute name="altType" type="xs:string"/>
 * </xs:complexType>
 * }
 *   
 * @author Robert Stephan
 * @version MODS 3.7
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class AlternativeName extends NameDefinition<IAlternativeNameSubelement>
    implements INameSubelement, IAttributeGroupXlinkSimpleLink, ILanguageAttributeGroup {

    //well-known values for altType attribute
    public static final String ALT_TYPE_FORMAL_NAME = "formal name";
    public static final String ALT_TYPE_PREFERRED_NAME = "preferred name";
    public static final String ALT_TYPE_ACRONYM = "acronym";
    public static final String ALT_TYPE_NICKNAME = "nickname";
    public static final String ALT_TYPE_NO_SPECIFIC_TYPE = "no specific type";

    @XmlElements({
        @XmlElement(name = "namePart", namespace = "http://www.loc.gov/mods/v3", type = NamePart.class),
        @XmlElement(name = "displayForm", namespace = "http://www.loc.gov/mods/v3", type = DisplayForm.class),
        @XmlElement(name = "affiliation", namespace = "http://www.loc.gov/mods/v3", type = Affiliation.class),
        @XmlElement(name = "role", namespace = "http://www.loc.gov/mods/v3", type = Role.class),
        @XmlElement(name = "description", namespace = "http://www.loc.gov/mods/v3", type = Description.class),
        @XmlElement(name = "nameIdentifier", namespace = "http://www.loc.gov/mods/v3", type = NameIdentifier.class) })
    protected List<IAlternativeNameSubelement> content = new Vector<>();

    //IXlinkSimpleLinkAttributeGroup - begin

    /**
     * {@code
     * <attribute ref="xlink:href" use="optional"/>
     * }
     */
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkHref;

    /**
     * {@code
     * <attribute ref="xlink:role" use="optional"/>
     * }
     */
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkRole;

    /**
     * {@code
     * <attribute ref="xlink:arcrole" use="optional"/>
     * }
     */
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkArcrole;

    /**
     * {@code
     * <attribute ref="xlink:title" use="optional"/>
     * }
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * {@code
     * <attribute ref="xlink:show" use="optional"/>
     * }
     */
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkShow xlinkShow;

    /**
     * {@code
     * <attribute ref="xlink:actuate" use="optional"/>
     * }
     */
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkActuate xlinkActuate;

    //IXlinkSimpleLinkAttributeGroup - end

    //ILanguageAttributeGroup - begin

    @XmlAttribute(name = "lang")
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    protected String xmlLang;

    @XmlAttribute(name = "script")
    protected String script;

    @XmlAttribute(name = "transliteration")
    protected String transliteration;

    //ILanguageAttributeGroup - end

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altType")
    protected String altType;

    public String getAltType() {
        return altType;
    }

    public void setAltType(String altType) {
        this.altType = altType;
    }

    public static Builder builder() {
        return builder(new AlternativeName());
    }

    public static Builder builder(AlternativeName name) {
        return new Builder(name);
    }

    public static class Builder extends BuilderBase<AlternativeName, Builder>
        implements INameDefinitionBuilder<IAlternativeNameSubelement, AlternativeName, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<AlternativeName, Builder>,
        ILanguageAttributeGroupBuilder<AlternativeName, Builder> {

        protected Builder(AlternativeName name) {
            super(name);
        }

        public Builder altType(String altType) {
            _target().setAltType(altType);
            return _self();
        }
    }
}
