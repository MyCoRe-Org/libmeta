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
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model.location.HoldingExternal;
import org.mycore.libmeta.mods.model.location.HoldingSimple;
import org.mycore.libmeta.mods.model.location.PhysicalLocation;
import org.mycore.libmeta.mods.model.location.ShelfLocator;
import org.mycore.libmeta.mods.model.location.Url;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS Top Level Element: Location
 * 
 * <xs:complexType name="locationDefinition">
 *   <xs:sequence>
 *     <xs:element ref="physicalLocation" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element ref="shelfLocator" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element ref="url" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element ref="holdingSimple" minOccurs="0"/>
 *     <xs:element ref="holdingExternal" minOccurs="0"/>
 *   </xs:sequence>
 *   <xs:attributeGroup ref="languageAttributeGroup"/>
 *   <xs:attribute name="displayLabel" type="xs:string"/>
 *   <xs:attribute name="altRepGroup" type="xs:string"/>
 * </xs:complexType>
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "physicalLocation", "shelfLocator", "url", "holdingSimple", "holdingExternal" })
public class Location implements ITopLevelElement, ILanguageAttributeGroup {

    /**
     * <xs:element ref="physicalLocation" minOccurs="0" maxOccurs="unbounded"/>
     */
    @XmlElement(name = "physicalLocation", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<PhysicalLocation> physicalLocation = new Vector<>();

    /**
     * <xs:element ref="shelfLocator" minOccurs="0" maxOccurs="unbounded"/>
     */
    @XmlElement(name = "shelfLocator", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<ShelfLocator> shelfLocator = new Vector<>();

    /**
     *<xs:element ref="url" minOccurs="0" maxOccurs="unbounded"/>
     */
    @XmlElement(name = "url", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<Url> url = new Vector<>();

    /**
     * <xs:element ref="holdingSimple" minOccurs="0"/>
     */
    @XmlElement(name = "holdingSimple", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected HoldingSimple holdingSimple;

    /**
     *<xs:element ref="holdingExternal" minOccurs="0"/>
     */
    @XmlElement(name = "holdingExternal", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected HoldingExternal holdingExternal;

    // <xs:attributeGroup ref="languagePlusDisplayLabelAttributeGroup"/> - begin

    @XmlAttribute(name = "lang")
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String xmlLang;

    @XmlAttribute(name = "script")
    protected String script;

    @XmlAttribute(name = "transliteration")
    protected String transliteration;

    // <xs:attributeGroup ref="languagePlusDisplayLabelAttributeGroup"/> - end

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

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

    public List<PhysicalLocation> getPhysicalLocation() {
        return physicalLocation;
    }

    public List<ShelfLocator> getShelfLocator() {
        return shelfLocator;
    }

    public List<Url> getUrl() {
        return url;
    }

    public HoldingSimple getHoldingSimple() {
        return holdingSimple;
    }

    public void setHoldingSimple(HoldingSimple holdingSimple) {
        this.holdingSimple = holdingSimple;
    }

    public HoldingExternal getHoldingExternal() {
        return holdingExternal;
    }

    public void setHoldingExternal(HoldingExternal holdingExternal) {
        this.holdingExternal = holdingExternal;
    }

    public static Builder builderForLocation() {
        return builder(new Location());
    }

    public static Builder builder(Location l) {
        return new Builder(l);
    }

    public static class Builder extends BuilderBase<Location, Builder> implements ILanguageAttributeGroupBuilder<Location, Builder> {

        protected Builder(Location object) {
            super(object);
        }

        public Builder addPhysicalLocation(PhysicalLocation p) {
            _target().getPhysicalLocation().add(p);
            return _self();
        }

        public Builder addShelfLocator(ShelfLocator s) {
            _target().getShelfLocator().add(s);
            return _self();
        }

        public Builder addUrl(Url u) {
            _target().getUrl().add(u);
            return _self();
        }

        public Builder holdingSimple(HoldingSimple h) {
            _target().setHoldingSimple(h);
            return _self();
        }

        public Builder holdingExternal(HoldingExternal h) {
            _target().setHoldingExternal(h);
            return _self();
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder altRepGroup(String s) {
            _target().setAltRepGroup(s);
            return _self();
        }
    }

}
