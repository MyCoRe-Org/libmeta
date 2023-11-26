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
import org.mycore.libmeta.mods.model.recordinfo.DescriptionStandard;
import org.mycore.libmeta.mods.model.recordinfo.IRecordInfoSubelement;
import org.mycore.libmeta.mods.model.recordinfo.LanguageOfCataloging;
import org.mycore.libmeta.mods.model.recordinfo.RecordChangeDate;
import org.mycore.libmeta.mods.model.recordinfo.RecordContentSource;
import org.mycore.libmeta.mods.model.recordinfo.RecordCreationDate;
import org.mycore.libmeta.mods.model.recordinfo.RecordIdentifier;
import org.mycore.libmeta.mods.model.recordinfo.RecordInfoNote;
import org.mycore.libmeta.mods.model.recordinfo.RecordOrigin;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * {@code 
 * <xs:complexType name="recordInfoDefinition">
 *   <xs:choice maxOccurs="unbounded">
 *     <xs:element ref="recordContentSource"/>
 *     <xs:element ref="recordCreationDate"/>
 *     <xs:element ref="recordChangeDate"/>
 *     <xs:element ref="recordIdentifier"/>
 *     <xs:element ref="languageOfCataloging"/>
 *     <xs:element ref="recordOrigin"/>
 *     <xs:element ref="descriptionStandard"/>
 *     <!-- ***************** following added in 3.6 -->
 *     <xs:element ref="recordInfoNote"/>
 *     <!-- -->            
 *   </xs:choice>
 *   <xs:attributeGroup ref="languageAttributeGroup"/>
 *   <xs:attribute name="displayLabel" type="xs:string"/>
 *   <xs:attribute name="altRepGroup" type="xs:string"/>
 * </xs:complexType>   
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class RecordInfo implements ITopLevelElement, ILanguageAttributeGroup {
    @XmlElements({
            @XmlElement(name = "recordContentSource", namespace = "http://www.loc.gov/mods/v3", type = RecordContentSource.class),
            @XmlElement(name = "recordCreationDate", namespace = "http://www.loc.gov/mods/v3", type = RecordCreationDate.class),
            @XmlElement(name = "recordChangeDate", namespace = "http://www.loc.gov/mods/v3", type = RecordChangeDate.class),
            @XmlElement(name = "recordIdentifier", namespace = "http://www.loc.gov/mods/v3", type = RecordIdentifier.class),
            @XmlElement(name = "languageOfCataloging", namespace = "http://www.loc.gov/mods/v3", type = LanguageOfCataloging.class),
            @XmlElement(name = "recordOrigin", namespace = "http://www.loc.gov/mods/v3", type = RecordOrigin.class),
            @XmlElement(name = "descriptionStandard", namespace = "http://www.loc.gov/mods/v3", type = DescriptionStandard.class),
            @XmlElement(name = "recordInfoNote", namespace = "http://www.loc.gov/mods/v3", type = RecordInfoNote.class) })
    protected List<IRecordInfoSubelement> recordInfoElement = new Vector<>();

    @XmlAttribute(name = "lang", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    protected String xmlLang;

    @XmlAttribute(name = "script", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected String script;

    @XmlAttribute(name = "transliteration", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected String transliteration;

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;
    
    @XmlAttribute(name = "usage")
    protected Usage usage;

    public List<IRecordInfoSubelement> getContent() {
        return recordInfoElement;
    }

    public void setContent(List<IRecordInfoSubelement> recordInfoElement) {
        this.recordInfoElement = recordInfoElement;
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
    
    public static Builder builderForRecordInfo() {
        return builder(new RecordInfo());
    }
    
    public static Builder builder(RecordInfo spl) {
        return new Builder(spl);
    }
    
    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
    
    public static class Builder extends BuilderBase<RecordInfo, Builder> implements ILanguageAttributeGroupBuilder<RecordInfo, Builder>{
            
        protected Builder(RecordInfo ri) {
            super(ri);
        }
        
        public Builder addContent(IRecordInfoSubelement content) {
            _target().getContent().add(content);
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
