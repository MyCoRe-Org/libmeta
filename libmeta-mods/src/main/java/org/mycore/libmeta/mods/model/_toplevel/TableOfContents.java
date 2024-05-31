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
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAltFormatAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.No;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeSimple;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 *  Top Level Element {@literal <tableOfContents>}
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TableOfContents extends StringPlusLanguage
    implements IIDAttributeGroup, IAltFormatAttributeGroup, IAttributeGroupXlinkSimpleLink {

    @XmlAttribute(name = "ID")
    protected String ID;

    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "type")
    protected String type;

    // IXlinkSimpleLinkAttributeGroup - begin

    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkTypeSimple xlinkType;

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

    // IXlinkSimpleLinkAttributeGroup - end

    @XmlAttribute(name = "shareable")
    protected No shareable;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    // IAltFormatAttributeGroup - begin
    @XmlAttribute(name = "altFormat")
    protected String altFormat;

    @XmlAttribute(name = "contentType")
    protected String contentType;

    // IAltFormatAttributeGroup - end

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

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public No getShareable() {
        return shareable;
    }

    public void setShareable(No shareable) {
        this.shareable = shareable;
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

    public void setAltFormat(String altFormat) {
        this.altFormat = altFormat;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static Builder builder() {
        return new Builder(new TableOfContents());
    }

    public static Builder builder(TableOfContents toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<TableOfContents, Builder>
        implements IXsStringBuilder<TableOfContents, Builder>, IIDAttributeGroupBuilder<TableOfContents, Builder>,
        ILanguageAttributeGroupBuilder<TableOfContents, Builder>,
        IAltFormatAttributeGroupBuilder<TableOfContents, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<TableOfContents, Builder> {
        protected Builder(TableOfContents toc) {
            super(toc);
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder shareable(No shareable) {
            _target().setShareable(shareable);
            return _self();
        }

        public Builder altRepGroup(String s) {
            _target().setAltRepGroup(s);
            return _self();
        }
    }
}
