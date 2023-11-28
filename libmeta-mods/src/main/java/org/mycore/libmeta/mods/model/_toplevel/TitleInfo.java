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
import org.mycore.libmeta.mods.model._misc.IAltFormatAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IOtherTypeAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAltFormatAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IOtherTypeAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.enums.TitleInfoType;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model.titleInfo.ITitleInfoSubelement;
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
 * Top Level Element {@literal <titleInfo>} 
 * 
 * {@code 
 *  <xs:complexType name="titleInfoDefinition">
 *		<xs:choice minOccurs="0" maxOccurs="unbounded">
 *			<xs:element ref="title"/>
 *			 <xs:element ref="subTitle"/>
 *			<xs:element ref="partNumber"/>
 *			<xs:element ref="partName"/>
 *			<xs:element ref="nonSort"/>
 *		</xs:choice>
 *		<xs:attribute name="type">
 *			<xs:simpleType>
 *				<xs:restriction base="xs:string">
 *					<xs:enumeration value="abbreviated"/>
 *					<xs:enumeration value="translated"/>
 *					<xs:enumeration value="alternative"/>
 *					<xs:enumeration value="uniform"/>
 *				</xs:restriction>
 *			</xs:simpleType>
 *		</xs:attribute> 
 *
 *		<xs:attribute name="otherType"/>
 *		<xs:attribute name="supplied" type="yes"/>
 *		<xs:attribute name="altRepGroup" type="xs:string"/>
 *		<xs:attributeGroup ref="altFormatAttributeGroup"/>
 *		<xs:attribute name="nameTitleGroup" type="xs:string"/>
 *		<xs:attribute name="usage" type="primary"/>
 *		<xs:attribute name="ID" type="xs:ID"/>
 *		<xs:attributeGroup ref="authorityAttributeGroup"/>
 *		<xs:attributeGroup ref="xlink:simpleLink"/>
 *		<xs:attributeGroup ref="languageAttributeGroup"/>
 *		<xs:attribute name="displayLabel" type="xs:string"/>
 *	</xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TitleInfo implements ITopLevelElement, IIDAttributeGroup, IAltFormatAttributeGroup, IAuthorityAttributeGroup,
    IOtherTypeAttributeGroup, IAttributeGroupXlinkSimpleLink, ILanguageAttributeGroup {

    @XmlElements({
        @XmlElement(name = "title", namespace = "http://www.loc.gov/mods/v3", type = Title.class),
        @XmlElement(name = "subTitle", namespace = "http://www.loc.gov/mods/v3", type = SubTitle.class),
        @XmlElement(name = "partNumber", namespace = "http://www.loc.gov/mods/v3", type = PartNumber.class),
        @XmlElement(name = "partName", namespace = "http://www.loc.gov/mods/v3", type = PartName.class),
        @XmlElement(name = "nonSort", namespace = "http://www.loc.gov/mods/v3", type = NonSort.class) })
    protected List<ITitleInfoSubelement> content = new Vector<>();

    @XmlAttribute(name = "type")
    protected TitleInfoType type;

    @XmlAttribute(name = "otherType")
    protected String otherType;
    
    /**
     * @version MODS 3.8
     */
    @XmlAttribute(name = "otherTypeAuth", required = false)
    protected String otherTypeAuth;

    /**
     * @version MODS 3.8
     */
    @XmlAttribute(name = "otherTypeAuthURI", required = false)
    protected String otherTypeAuthURI;

    /**
     * @version MODS 3.8
     */
    @XmlAttribute(name = "otherTypeURI", required = false)
    protected String otherTypeURI;

    @XmlAttribute(name = "supplied")
    protected Yes supplied;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    //IAltFormatAttributeGroup - begin
    //new in 3.5
    @XmlAttribute(name = "altFormat")
    protected String altFormat;

    //new in 3.5
    @XmlAttribute(name = "contentType")
    protected String contentType;

    //IAltFormatAttributeGroup - end

    @XmlAttribute(name = "nameTitleGroup")
    protected String nameTitleGroup;

    @XmlAttribute(name = "usage")
    protected Usage usage;

    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    //IAuthorityAttributeGroup - begin

    @XmlAttribute(name = "authority")
    protected String authority;

    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    @XmlAttribute(name = "valueURI")
    protected String valueURI;

    //IAuthorityAttributeGroup - end

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

    public List<ITitleInfoSubelement> getContent() {
        return content;
    }

    public void setContent(List<ITitleInfoSubelement> content) {
        this.content = content;
    }

    public TitleInfoType getType() {
        return type;
    }

    public void setType(TitleInfoType type) {
        this.type = type;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }
    
    public String getOtherTypeAuth() {
        return otherTypeAuth;
    }

    public void setOtherTypeAuth(String otherTypeAuth) {
        this.otherTypeAuth = otherTypeAuth;
    }

    public String getOtherTypeAuthURI() {
        return otherTypeAuthURI;
    }

    public void setOtherTypeAuthURI(String otherTypeAuthURI) {
        this.otherTypeAuthURI = otherTypeAuthURI;
    }

    public String getOtherTypeURI() {
        return otherTypeURI;
    }

    public void setOtherTypeURI(String otherTypeURI) {
        this.otherTypeURI = otherTypeURI;
    }

    public Yes getSupplied() {
        return supplied;
    }

    public void setSupplied(Yes supplied) {
        this.supplied = supplied;
    }

    public String getAltRepGroup() {
        return altRepGroup;
    }

    public void setAltRepGroup(String attrAltRepGroup) {
        this.altRepGroup = attrAltRepGroup;
    }

    public String getAltFormat() {
        return altFormat;
    }

    public void setAltFormat(String altFormat) {
        this.altFormat = altFormat;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public static Builder builder() {
        return builder(new TitleInfo());
    }

    public static Builder builder(TitleInfo ti) {
        return new Builder(ti);
    }
    
    public static class Builder extends BuilderBase<TitleInfo, Builder>
        implements IIDAttributeGroupBuilder<TitleInfo, Builder>, 
        IAltFormatAttributeGroupBuilder<TitleInfo, Builder>, 
        IAuthorityAttributeGroupBuilder<TitleInfo, Builder>,
        ILanguageAttributeGroupBuilder<TitleInfo, Builder>,
        IOtherTypeAttributeGroupBuilder<TitleInfo, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<TitleInfo, Builder> {
      
        protected Builder(TitleInfo ti) {
            super(ti);
        }

        public Builder addContent(ITitleInfoSubelement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder type(TitleInfoType type) {
            _target().setType(type);
            return _self();
        }

        public Builder supplied(Yes supplied) {
            _target().setSupplied(supplied);
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

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }
    }
}
