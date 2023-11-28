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
package org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS CopyLocation Subelement: Note
 * 
 * {@code
 * <xs:element name="note" minOccurs="0" maxOccurs="unbounded">
 *   <xs:complexType>
 *     <xs:simpleContent>
 *       <xs:extension base="stringPlusLanguage">
 *         <xs:attribute name="displayLabel" type="xs:string"/>
 *         <xs:attribute name="type" type="xs:string"/>
 *         <xs:attributeGroup ref="xlink:simpleLink"/>
 *         <xs:attribute name="ID" type="xs:ID"/>
 *       </xs:extension>
 *     </xs:simpleContent>
 *   </xs:complexType>
 * </xs:element>
 * }
 *
 *   @author Robert Stephan
 *   @version MODS 3.6
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "copyinformation_note")
public class Note extends StringPlusLanguage implements ICopyInformationSubelement, IAttributeGroupXlinkSimpleLink {

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "type")
    protected String type;

    // attributeGroup xlink:simpleLink - begin

    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkType;

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

    @XmlAttribute(name = "ID")
    protected String ID;

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

    public String getXlinkType() {
        return xlinkType;
    }

    public void setXlinkType(String xlinkType) {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static Builder builderForNote() {
        return builder(new Note());
    }

    public static Builder builder(Note n) {
        return new Builder(n);
    }

    public static class Builder extends BuilderBase<Note, Builder> implements IXsStringBuilder<Note, Builder>,
        ILanguageAttributeGroupBuilder<Note, Builder>, IAttributeGroupXlinkSimpleLinkBuilder<Note, Builder> {
        protected Builder(Note n) {
            super(n);
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder xlinkType(String xlinkType) {
            _target().setXlinkType(xlinkType);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }
    }
}
