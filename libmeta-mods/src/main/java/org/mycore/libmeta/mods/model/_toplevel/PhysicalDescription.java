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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model.physicaldescription.DigitalOrigin;
import org.mycore.libmeta.mods.model.physicaldescription.Extent;
import org.mycore.libmeta.mods.model.physicaldescription.Form;
import org.mycore.libmeta.mods.model.physicaldescription.IPhysicalDescriptionSubelement;
import org.mycore.libmeta.mods.model.physicaldescription.InternetMediaType;
import org.mycore.libmeta.mods.model.physicaldescription.ReformattingQuality;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * Top Level Element {@literal <physicalDescription>}
 * 
 * {@code 
 * <xs:complexType name="physicalDescriptionDefinition">
 *        <xs:choice maxOccurs="unbounded">
 *           <xs:element ref="form"/>
 *           <!-- same definition as is used in copyInformation -->
 *           <xs:element ref="reformattingQuality"/>
 *           <xs:element ref="internetMediaType"/>
 *          <xs:element ref="extent"/>
 *           <xs:element ref="digitalOrigin"/>
 *           <xs:element name="note" type="physicalDescriptionNote"/>
 *       </xs:choice>
 *       <xs:attributeGroup ref="languageAttributeGroup"/>
 *       <xs:attribute name="displayLabel" type="xs:string"/>
 *       <xs:attribute name="altRepGroup" type="xs:string"/>
 *   </xs:complexType>
 * }
 *  
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class PhysicalDescription implements ITopLevelElement, IIDAttributeGroup, ILanguageAttributeGroup {
    @XmlElements({
        @XmlElement(name = "form", namespace = "http://www.loc.gov/mods/v3", type = Form.class),
        @XmlElement(name = "reformattingQuality", namespace = "http://www.loc.gov/mods/v3", type = ReformattingQuality.class),
        @XmlElement(name = "internetMediaType", namespace = "http://www.loc.gov/mods/v3", type = InternetMediaType.class),
        @XmlElement(name = "extent", namespace = "http://www.loc.gov/mods/v3", type = Extent.class),
        @XmlElement(name = "digitalOrigin", namespace = "http://www.loc.gov/mods/v3", type = DigitalOrigin.class),
        @XmlElement(name = "note", namespace = "http://www.loc.gov/mods/v3", type = org.mycore.libmeta.mods.model.physicaldescription.Note.class) })
    protected List<IPhysicalDescriptionSubelement> content = new Vector<>();

    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;
    
    //begin languageAttributeGroup

    @XmlAttribute(name = "lang", namespace = "http://www.loc.gov/mods/v3", required = false)
    String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    String xmlLang;

    @XmlAttribute(name = "script", namespace = "http://www.loc.gov/mods/v3", required = false)
    String script;

    @XmlAttribute(name = "transliteration", namespace = "http://www.loc.gov/mods/v3", required = false)
    String transliteration;

    //end languageAttributeGroup

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    public List<IPhysicalDescriptionSubelement> getContent() {
        return content;
    }
    
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public void setXmlLang(String xmlLang) {
        this.xmlLang = xmlLang;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
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

    public static Builder builderForPhysicalDescription() {
        return builder(new PhysicalDescription());
    }

    public static Builder builder(PhysicalDescription p) {
        return new Builder(p);
    }

    public static class Builder extends BuilderBase<PhysicalDescription, Builder> implements IIDAttributeGroupBuilder<PhysicalDescription, Builder>, ILanguageAttributeGroupBuilder<PhysicalDescription, Builder> {
        protected Builder(PhysicalDescription p) {
            super(p);
        }

        public Builder addContent(IPhysicalDescriptionSubelement ps) {
            _target().getContent().add(ps);
            return this;
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return this;
        }

        public Builder altRepGroup(String altRepGroup) {
            _target().setAltRepGroup(altRepGroup);
            return this;
        }
    }
}
