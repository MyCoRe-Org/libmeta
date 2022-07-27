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
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model.language.LanguageTerm;
import org.mycore.libmeta.mods.model.language.ScriptTerm;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Top Level Element {@literal <language>}
 * 
 * {@literal <scriptTerm>} is introduced into {@literal <language>} in 3.4.
 * 
 * In 3.3 {@literal <language>} consists solely of {@literal <languageTerm>} so if {@literal <language>} is
 * present then there must be at least one instance of {@literal <languageTerm>} and there
 * may be more than one.
 * 
 * Now, in 3.4, if {@literal <language>} is present, still there must be at least one
 * {@literal <languageTerm>} element, and there may be more than one; and there may be any
 * number of {@literal <scriptTerm>} elements, including zero.
 * 
 * {@code
 * <xs:complexType name="languageDefinition">
 *       <xs:sequence>
 *           <xs:element ref="languageTerm" maxOccurs="unbounded"/>
 *           <xs:element ref="scriptTerm" minOccurs="0" maxOccurs="unbounded"/>
 *       </xs:sequence>
 *       <xs:attribute name="objectPart" type="xs:string"/>
 *        <xs:attributeGroup ref="languageAttributeGroup"/>
 *        <xs:attribute name="displayLabel" type="xs:string"/>
 *        <xs:attribute name="altRepGroup" type="xs:string"/>
 *        <xs:attribute name="usage" fixed="primary"/>
 *    </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "languageTerm", "scriptTerm" })
public class Language implements ITopLevelElement, ILanguageAttributeGroup {

    @XmlElement(name = "languageTerm", namespace = "http://www.loc.gov/mods/v3", required = true)
    protected List<LanguageTerm> languageTerm = new Vector<>();

    @XmlElement(name = "scriptTerm", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<ScriptTerm> scriptTerm = new Vector<>();

    @XmlAttribute(name = "objectPart")
    protected String objectPart;
    
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
    
    /**
     * altRepGroup new in 3.4
     */
    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    /**
     * usage added to {@literal <language>} in 3.4
     */
    @XmlAttribute(name = "usage")
    protected Usage usage;

    public List<LanguageTerm> getLanguageTerm() {
        return languageTerm;
    }

    public void setLanguageTerm(List<LanguageTerm> languageTerm) {
        this.languageTerm = languageTerm;
    }

    public List<ScriptTerm> getScriptTerm() {
        return scriptTerm;
    }

    public void setScriptTerm(List<ScriptTerm> scriptTerm) {
        this.scriptTerm = scriptTerm;
    }

    public String getObjectPart() {
        return objectPart;
    }

    public void setObjectPart(String objectPart) {
        this.objectPart = objectPart;
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

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
    
    public static Builder builderForLanguage() {
        return builder (new Language());
    }
    
    public static Builder builder(Language l) {
        return new Builder(l);
    }
    
    public static class Builder extends BuilderBase<Language, Builder> implements ILanguageAttributeGroupBuilder<Language, Builder>{
        protected Builder(Language spl) {
            super(spl);
        }

        public Builder addLanguageTerm(LanguageTerm languageTerm) {
            _target().getLanguageTerm().add(languageTerm);
            return _self();
        }
        
        public Builder addScriptTerm(ScriptTerm scriptTerm) {
            _target().getScriptTerm().add(scriptTerm);
            return _self();
        }
        
        public Builder objectPart(String objectPart) {
            _target().setObjectPart(objectPart);
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
        
        public Builder usage(Usage usage) {
            _target().setUsage(usage);
            return _self();
        }
    }
}
