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
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model.subject.ISubjectSubelement;
import org.mycore.libmeta.mods.model.subject.SubjectCartographics;
import org.mycore.libmeta.mods.model.subject.SubjectGeographic;
import org.mycore.libmeta.mods.model.subject.SubjectGeographicCode;
import org.mycore.libmeta.mods.model.subject.SubjectHierarchicalGeographic;
import org.mycore.libmeta.mods.model.subject.SubjectOccupation;
import org.mycore.libmeta.mods.model.subject.SubjectTemporal;
import org.mycore.libmeta.mods.model.subject.SubjectTopic;
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
 * Top Level Element {@literal <subject>}
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Subject
        implements ITopLevelElement, IAuthorityAttributeGroup, ILanguageAttributeGroup, IAttributeGroupXlinkSimpleLink {
    /**
     * 
     * {@code 
     * <xs:complexType name="subjectDefinition">
     *   <xs:choice minOccurs="0" maxOccurs="unbounded">
     *       <xs:element ref="topic"/>
     *       <xs:element ref="geographic"/>
     *       <xs:element ref="temporal"/>
     *       <xs:element name="titleInfo" type="subjectTitleInfoDefinition"/>
     *       <xs:element name="name" type="subjectNameDefinition"/>
     *       <xs:element ref="geographicCode"/>
     *       <xs:element ref="hierarchicalGeographic"/>
     *       <xs:element ref="cartographics"/>
     *       <xs:element ref="occupation"/>
     *       <xs:element ref="genre"/>
     *       <!-- uses top-level genre definition -->
     *   </xs:choice>
     *   <xs:attribute name="ID" type="xs:ID"/>
     *   <xs:attributeGroup ref="authorityAttributeGroup"/>
     *   <xs:attributeGroup ref="languageAttributeGroup"/>
     *   <xs:attributeGroup ref="xlink:simpleLink"/>
     *   <xs:attribute name="displayLabel" type="xs:string"/>
     *   <xs:attribute name="altRepGroup" type="xs:string"/>
     *   <xs:attribute name="usage" fixed="primary"/>
     * </xs:complexType>
     * }
     */
    @XmlElements({ @XmlElement(name = "topic", namespace = "http://www.loc.gov/mods/v3", type = SubjectTopic.class),
            @XmlElement(name = "geographic", namespace = "http://www.loc.gov/mods/v3", type = SubjectGeographic.class),
            @XmlElement(name = "temporal", namespace = "http://www.loc.gov/mods/v3", type = SubjectTemporal.class),
            @XmlElement(name = "titleInfo", namespace = "http://www.loc.gov/mods/v3", type = TitleInfo.class),
            @XmlElement(name = "name", namespace = "http://www.loc.gov/mods/v3", type = Name.class),
            @XmlElement(name = "geographicCode", namespace = "http://www.loc.gov/mods/v3", type = SubjectGeographicCode.class),
            @XmlElement(name = "hierarchicalGeographic", namespace = "http://www.loc.gov/mods/v3", type = SubjectHierarchicalGeographic.class),
            @XmlElement(name = "cartographics", namespace = "http://www.loc.gov/mods/v3", type = SubjectCartographics.class),
            @XmlElement(name = "occupation", namespace = "http://www.loc.gov/mods/v3", type = SubjectOccupation.class),
            @XmlElement(name = "genre", namespace = "http://www.loc.gov/mods/v3", type = Genre.class) })
    protected List<ISubjectSubelement> content = new Vector<>();

    @XmlAttribute(name = "ID")
    protected String ID;

    //IAuthorityAttributeGroup - begin

    @XmlAttribute(name = "authority")
    protected String authority;

    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    @XmlAttribute(name = "valueURI")
    protected String valueURI;

    //IAuthorityAttributeGroup - end

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

    //IXlinkSimpleLinkAttributeGroup - begin

    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkHref;

    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkRole;

    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkArcrole;

    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkShow xlinkShow;

    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkActuate xlinkActuate;

    //IXlinkSimpleLinkAttributeGroup - end

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    @XmlAttribute(name = "nameTitleGroup")
    protected String nameTitleGroup;

    @XmlAttribute(name = "usage")
    protected Usage usage;

    public List<ISubjectSubelement> getContent() {
        return content;
    }

    public void setContent(List<ISubjectSubelement> content) {
        this.content = content;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
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

    public String getXlinkHref() {
        return xlinkHref;
    }

    public void setXlinkHref(String xlinkHref) {
        this.xlinkHref = xlinkHref;
    }

    public String getXlinkRole() {
        return xlinkRole;
    }

    public void setXlinkRole(String xlinkRole) {
        this.xlinkRole = xlinkRole;
    }

    public String getXlinkArcrole() {
        return xlinkArcrole;
    }

    public void setXlinkArcrole(String xlinkArcrole) {
        this.xlinkArcrole = xlinkArcrole;
    }

    public String getXlinkTitle() {
        return xlinkTitle;
    }

    public void setXlinkTitle(String xlinkTitle) {
        this.xlinkTitle = xlinkTitle;
    }

    public XlinkShow getXlinkShow() {
        return xlinkShow;
    }

    public void setXlinkShow(XlinkShow xlinkShow) {
        this.xlinkShow = xlinkShow;
    }

    public XlinkActuate getXlinkActuate() {
        return xlinkActuate;
    }

    public void setXlinkActuate(XlinkActuate xlinkActuate) {
        this.xlinkActuate = xlinkActuate;
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

    public String getNameTitleGroup() {
        return nameTitleGroup;
    }

    public void setNameTitleGroup(String nameTitleGroup) {
        this.nameTitleGroup = nameTitleGroup;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public static Builder builderForSubject() {
        return builder(new Subject());
    }

    public static Builder builder(Subject subject) {
        return new Builder(subject);
    }

    public static class Builder extends BuilderBase<Subject, Builder> implements IAuthorityAttributeGroupBuilder<Subject, Builder>, ILanguageAttributeGroupBuilder<Subject, Builder>, IAttributeGroupXlinkSimpleLinkBuilder<Subject, Builder>{
        protected Builder(Subject subject) {
            super(subject);
        }

        public Builder addContent(ISubjectSubelement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
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

        public Builder nameTitleGroup(String s) {
            _target().setNameTitleGroup(s);
            return _self();
        }

        public Builder usage(Usage usage) {
            _target().setUsage(usage);
            return _self();
        }
    }
}
