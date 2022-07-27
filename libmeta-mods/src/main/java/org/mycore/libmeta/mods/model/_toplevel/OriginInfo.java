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
import org.mycore.libmeta.mods.model.origininfo.CopyrightDate;
import org.mycore.libmeta.mods.model.origininfo.DateCaptured;
import org.mycore.libmeta.mods.model.origininfo.DateCreated;
import org.mycore.libmeta.mods.model.origininfo.DateIssued;
import org.mycore.libmeta.mods.model.origininfo.DateModified;
import org.mycore.libmeta.mods.model.origininfo.DateOther;
import org.mycore.libmeta.mods.model.origininfo.DateValid;
import org.mycore.libmeta.mods.model.origininfo.Edition;
import org.mycore.libmeta.mods.model.origininfo.Frequency;
import org.mycore.libmeta.mods.model.origininfo.IOriginInfoSubelement;
import org.mycore.libmeta.mods.model.origininfo.Issuance;
import org.mycore.libmeta.mods.model.origininfo.Place;
import org.mycore.libmeta.mods.model.origininfo.Publisher;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 *  Top Level Element {@literal <originInfo>}  
 * 
 * {@code 
 * <xs:complexType name="originInfoDefinition">
 *       <xs:choice maxOccurs="unbounded">
 *           <xs:element ref="place"/>
 *           <xs:element ref="publisher"/>
 *           <xs:element ref="dateIssued"/>
 *           <xs:element ref="dateCreated"/>
 *           <xs:element ref="dateCaptured"/>
 *           <xs:element ref="dateValid"/>
 *           <xs:element ref="dateModified"/>
 *           <xs:element ref="copyrightDate"/>
 *           <xs:element ref="dateOther"/>
 *           <xs:element ref="edition"/>
 *           <xs:element ref="issuance"/>
 *           <xs:element ref="frequency"/>
 *       </xs:choice>
 *       <xs:attributeGroup ref="languageAttributeGroup"/>
 *       <xs:attribute name="displayLabel" type="xs:string"/>
 *       <xs:attribute name="altRepGroup" type="xs:string"/>
 *       <xs:attribute name="eventType" type="xs:string"/>
 *   </xs:complexType>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class OriginInfo implements ITopLevelElement, ILanguageAttributeGroup {
    
    /**
     * recommended value for eventType
     */
    public static final String EVENTTYPE_PRODUCTION = "production";

    /**
     * recommended value for eventType
     */
    public static final String EVENTTYPE_PUBLICATION = "publication";

    /**
     * recommended value for eventType
     */
    public static final String EVENTTYPE_DISTRIBUTION = "distribution";

    /**
     * recommended value for eventType
     */
    public static final String EVENTTYPE_MANUFACTURE = "manufacture";

    @XmlElements({
        @XmlElement(name = "place", namespace = "http://www.loc.gov/mods/v3", type = Place.class),
        @XmlElement(name = "publisher", namespace = "http://www.loc.gov/mods/v3", type = Publisher.class),
        @XmlElement(name = "dateIssued", namespace = "http://www.loc.gov/mods/v3", type = DateIssued.class),
        @XmlElement(name = "dateCreated", namespace = "http://www.loc.gov/mods/v3", type = DateCreated.class),
        @XmlElement(name = "dateCaptured", namespace = "http://www.loc.gov/mods/v3", type = DateCaptured.class),
        @XmlElement(name = "dateValid", namespace = "http://www.loc.gov/mods/v3", type = DateValid.class),
        @XmlElement(name = "dateModified", namespace = "http://www.loc.gov/mods/v3", type = DateModified.class),
        @XmlElement(name = "copyrightDate", namespace = "http://www.loc.gov/mods/v3", type = CopyrightDate.class),
        @XmlElement(name = "dateOther", namespace = "http://www.loc.gov/mods/v3", type = DateOther.class),
        @XmlElement(name = "edition", namespace = "http://www.loc.gov/mods/v3", type = Edition.class),
        @XmlElement(name = "issuance", namespace = "http://www.loc.gov/mods/v3", type = Issuance.class),
        @XmlElement(name = "frequency", namespace = "http://www.loc.gov/mods/v3", type = Frequency.class) })
    protected List<IOriginInfoSubelement> originInfoElement = new Vector<>();

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

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    /**
    * following attribute, @eventType, is new in version 3.5 -->
    * Recomended values are "production", "publication", "distribution", "manufacture"
    * So when eventType="production"
    * 	- {@literal <publisher>} is the producer
    *   - {@literal <dateIssued>} is the date of production
    *   - {@literal <place>} is the place of production
    *   etc.
    *   Detailed usage rules are supplied in the guidelines. 
    *   
    *   use static properties
    */
    @XmlAttribute(name = "eventType")
    protected String eventType;

    public List<IOriginInfoSubelement> getContent() {
        return originInfoElement;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public static Builder builderForOriginInfo() {
        return builder(new OriginInfo());
    }

    public static Builder builder(OriginInfo oi) {
        return new Builder(oi);
    }

    public static class Builder extends BuilderBase<OriginInfo, Builder> implements ILanguageAttributeGroupBuilder<OriginInfo, Builder> {
        protected Builder(OriginInfo oi) {
            super(oi);
        }

        public Builder addContent(IOriginInfoSubelement content) {
            _target().getContent().add(content);
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

        public Builder eventType(String e) {
            _target().setEventType(e);
            return _self();
        }
    }
}
