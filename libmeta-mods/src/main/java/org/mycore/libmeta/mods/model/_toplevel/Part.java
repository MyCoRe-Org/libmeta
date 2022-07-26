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
import org.mycore.libmeta.mods.model.part.Date;
import org.mycore.libmeta.mods.model.part.Detail;
import org.mycore.libmeta.mods.model.part.Extent;
import org.mycore.libmeta.mods.model.part.IPartSubelement;
import org.mycore.libmeta.mods.model.part.Text;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * Top Level Element <part>
 * 
 * <xs:complexType name="partDefinition">
 *   <xs:choice minOccurs="0" maxOccurs="unbounded">
 *     <xs:element ref="detail"/>
 *     <xs:element name="extent" type="extentDefinition"/>
 *     <xs:element ref="date"/>
 *     <xs:element ref="text"/>
 *   </xs:choice>
 *   <xs:attribute name="ID" type="xs:ID"/>
 *   <xs:attribute name="type" type="xs:string"/>
 *   <xs:attribute name="order" type="xs:integer"/>
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
public class Part implements ITopLevelElement, ILanguageAttributeGroup {
    @XmlElements({ @XmlElement(name = "detail", namespace = "http://www.loc.gov/mods/v3", type = Detail.class),
            @XmlElement(name = "extend", namespace = "http://www.loc.gov/mods/v3", type = Extent.class),
            @XmlElement(name = "date", namespace = "http://www.loc.gov/mods/v3", type = Date.class),
            @XmlElement(name = "text", namespace = "http://www.loc.gov/mods/v3", type = Text.class) })
    protected List<IPartSubelement> content = new Vector<>();

    /**
    * <xs:attribute name="ID" type="xs:ID"/>
    */
    @XmlAttribute(name = "ID")
    protected String ID;

    /**
    * <xs:attribute name="type" type="xs:string"/>
    */
    @XmlAttribute(name = "type")
    protected String type;

    @XmlAttribute(name = "order")
    protected Integer order;

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

    public List<IPartSubelement> getContent() {
        return content;
    }

    public void setContent(List<IPartSubelement> partElement) {
        this.content = partElement;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public static Builder builderForPart() {
        return builder(new Part());
    }

    public static Builder builder(Part p) {
        return new Builder(p);
    }

    public static class Builder extends BuilderBase<Part, Builder> implements ILanguageAttributeGroupBuilder<Part, Builder>{
        protected Builder(Part p) {
           super(p);
        }

        public Builder addContent(IPartSubelement ps) {
            _target().getContent().add(ps);
            return _self();
        }

        public Builder ID(String iD) {
            _target().setID(iD);
            return _self();
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder order(Integer order) {
            _target().setOrder(order);
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
    }
}
