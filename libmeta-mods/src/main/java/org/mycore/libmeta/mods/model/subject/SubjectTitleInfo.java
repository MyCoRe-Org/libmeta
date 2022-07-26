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
package org.mycore.libmeta.mods.model.subject;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.enums.SubjectTitleInfoType;
import org.mycore.libmeta.mods.model.subject.titleInfo.ISubjectTitleInfoSubelement;
import org.mycore.libmeta.mods.model.titleInfo.NonSort;
import org.mycore.libmeta.mods.model.titleInfo.PartName;
import org.mycore.libmeta.mods.model.titleInfo.PartNumber;
import org.mycore.libmeta.mods.model.titleInfo.SubTitle;
import org.mycore.libmeta.mods.model.titleInfo.Title;
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
 * <xs:complexType name="subjectTitleInfoDefinition">
 * 		<xs:choice minOccurs="0" maxOccurs="unbounded">
 * 			<xs:element ref="title"/>
 * 			<xs:element ref="subTitle"/>
 * 			<xs:element ref="partNumber"/>
 * 			<xs:element ref="partName"/>
 * 			<xs:element ref="nonSort"/>
 * 		</xs:choice>
 * 		<xs:attribute name="ID" type="xs:ID"/>
 * 		<xs:attributeGroup ref="authorityAttributeGroup"/>
 * 		<xs:attributeGroup ref="xlink:simpleLink"/>
 * 		<xs:attributeGroup ref="languageAttributeGroup"/>
 * 		<xs:attribute name="displayLabel" type="xs:string"/>
 * 		<xs:attribute name="type">
 * 			<xs:simpleType>
 * 				<xs:restriction base="xs:string">
 * 					<xs:enumeration value="abbreviated"/>
 * 					<xs:enumeration value="translated"/>
 * 					<xs:enumeration value="alternative"/>
 * 					<xs:enumeration value="uniform"/>
 * 				</xs:restriction>
 * 			</xs:simpleType>
 * 		</xs:attribute>
 * 	</xs:complexType>
 *
 * @author Robert Stephan
 * @version MODS 3.6
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SubjectTitleInfo implements ISubjectSubelement, IAuthorityAttributeGroup, ILanguageAttributeGroup,
        IAttributeGroupXlinkSimpleLink {

    @XmlElements({ @XmlElement(name = "title", namespace = "http://www.loc.gov/mods/v3", type = Title.class),
            @XmlElement(name = "subTitle", namespace = "http://www.loc.gov/mods/v3", type = SubTitle.class),
            @XmlElement(name = "partNumber", namespace = "http://www.loc.gov/mods/v3", type = PartNumber.class),
            @XmlElement(name = "partName", namespace = "http://www.loc.gov/mods/v3", type = PartName.class),
            @XmlElement(name = "nonSort", namespace = "http://www.loc.gov/mods/v3", type = NonSort.class) })

    protected List<ISubjectTitleInfoSubelement> content = new Vector<>();

    @XmlAttribute(name = "type", required = false)
    protected SubjectTitleInfoType type;

    @XmlAttribute(name = "displayLabel", required = false)
    protected String displayLabel;

    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    // IXlinkSimpleLinkAttributeGroup - begin

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

    // IXlinkSimpleLinkAttributeGroup - end

    // --- <xs:attributeGroup name="authorityAttributeGroup"> - begin
    /**
     * <xs:attribute name="authority" type="xs:string"/>
     */
    @XmlAttribute(name = "authority")
    protected String authority;

    /**
     * <xs:attribute name="authorityURI" type="xs:anyURI"/>
     */
    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    /**
     * <xs:attribute name="valueURI" type="xs:anyURI"/>
     */
    @XmlAttribute(name = "valueURI")
    protected String valueURI;
    // --- <xs:attributeGroup name="authorityAttributeGroup"> - end

    // ILanguageAttributeGroup - begin

    @XmlAttribute(name = "lang")
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    protected String xmlLang;

    @XmlAttribute(name = "script")
    protected String script;

    @XmlAttribute(name = "transliteration")
    protected String transliteration;

    // ILanguageAttributeGroup - end

    public List<ISubjectTitleInfoSubelement> getContent() {
        return content;
    }

    public void setContent(List<ISubjectTitleInfoSubelement> content) {
        this.content = content;
    }

    public SubjectTitleInfoType getType() {
        return type;
    }

    public void setType(SubjectTitleInfoType type) {
        this.type = type;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setAttrDisplayLabel(String DisplayLabel) {
        this.displayLabel = DisplayLabel;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public static Builder builder() {
        return new Builder(new SubjectTitleInfo());
    }

    public static Builder builder(SubjectTitleInfo s) {
        return new Builder(s);
    }

    public static class Builder extends BuilderBase<SubjectTitleInfo, Builder>  implements IAttributeGroupXlinkSimpleLinkBuilder<SubjectTitleInfo, Builder>{

        protected Builder(SubjectTitleInfo subjectTitleInfo) {
            super(subjectTitleInfo);
        }

        public Builder addContent(ISubjectTitleInfoSubelement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder type(SubjectTitleInfoType type) {
            _target().setType(type);
            return _self();
        }

        public Builder displayLabel(String s) {
            _target().setAttrDisplayLabel(s);
            return _self();
        }

        public Builder ID(String s) {
            _target().setID(s);
            return _self();
        }

        public Builder authority(String s) {
            _target().setAuthority(s);
            return _self();
        }

        public Builder authorityURI(String s) {
            _target().setAuthorityURI(s);
            return _self();
        }

        public Builder valueURI(String s) {
            _target().setValueURI(s);
            return _self();
        }

        public Builder lang(String s) {
            _target().setLang(s);
            return _self();
        }

        public Builder xmlLang(String s) {
            _target().setXmlLang(s);
            return _self();
        }

        public Builder script(String s) {
            _target().setScript(s);
            return _self();
        }

        public Builder transliteration(String s) {
            _target().setTransliteration(s);
            return _self();
        }
    }
}