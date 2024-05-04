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

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAltFormatAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAltFormatAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IExtensionDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.ExtensionDefinition;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeSimple;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xs:complexType name="accessConditionDefinition" mixed="true">
 *    <xs:complexContent mixed="true">
 *      <xs:extension base="extensionDefinition">
 *        <xs:attributeGroup ref="xlink:simpleLink"/>
 *        <xs:attributeGroup ref="languageAttributeGroup"/>
 *        <xs:attribute name="type" type="xs:string"/>
 *        <xs:attribute name="altRepGroup" type="xs:string"/>
 *        <xs:attributeGroup ref="altFormatAttributeGroup"/>
 *      </xs:extension>
 *    </xs:complexContent>
 *  </xs:complexType> 
 * }
 * 
 * @author Robert Stephan
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
public class AccessCondition extends ExtensionDefinition
    implements ITopLevelElement, IIDAttributeGroup, IAttributeGroupXlinkSimpleLink, IAltFormatAttributeGroup,
    ILanguageAttributeGroup, IAuthorityAttributeGroup {

    // attributeGroup xlink:simpleLink - begin

    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected XlinkTypeSimple xlinkType;

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

    // attributeGroup xlink:simpleLink - end

    //<xs:attributeGroup name="languageAttributeGroup"> - begin

    @XmlAttribute(name = "lang")
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String xmlLang;

    @XmlAttribute(name = "script")
    protected String script;

    @XmlAttribute(name = "transliteration")
    protected String transliteration;

    // <xs:attributeGroup name="languageAttributeGroup"> - end

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    // begin: altFormatAttributeGroup

    @XmlAttribute(name = "altFormat")
    protected String altFormat;

    @XmlAttribute(name = "contentType")
    protected String contentType;

    // end: altFormatAttributeGroup

    // IAuthorityAttributeGroup - begin

    @XmlAttribute(name = "authority")
    protected String authority;

    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    @XmlAttribute(name = "valueURI")
    protected String valueURI;

    //IAuthorityAttributeGroup - end

    public XlinkTypeSimple getXlinkType() {
        return xlinkType;
    }

    public void setXlinkType(XlinkTypeSimple xlinkType) {
        this.xlinkType = xlinkType;
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

    public String getAltRepGroup() {
        return altRepGroup;
    }

    public void setAltRepGroup(String altRepGroup) {
        this.altRepGroup = altRepGroup;
    }

    public String getAltFormat() {
        return altFormat;
    }

    public void setAltFormat(String attrAltFormat) {
        this.altFormat = attrAltFormat;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String attrContentType) {
        this.contentType = attrContentType;
    }

    // end: altFormatAttributeGroup

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

    public static Builder builder() {
        return builder(new AccessCondition());
    }

    public static Builder builder(AccessCondition ac) {
        return new Builder(ac);
    }

    public static class Builder extends BuilderBase<AccessCondition, Builder>
        implements IExtensionDefinitionBuilder<AccessCondition, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<AccessCondition, Builder>,
        IAltFormatAttributeGroupBuilder<AccessCondition, Builder>,
        ILanguageAttributeGroupBuilder<AccessCondition, Builder>,
        IAuthorityAttributeGroupBuilder<AccessCondition, Builder> {

        protected Builder(AccessCondition spl) {
            super(spl);
        }

        public Builder altRepGroup(String s) {
            _target().setAltRepGroup(s);
            return _self();
        }
    }
}
