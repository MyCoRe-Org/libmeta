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
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IOtherTypeAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IOtherTypeAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.enums.RelatedItemType;
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
 * Top Level Element {@literal <relatedItem>}
 * 
 * {@code 
 * <xs:complexType name="relatedItemDefinition">
 *        <xs:group ref="modsGroup" minOccurs="0" maxOccurs="unbounded"/>
 *         <xs:attribute name="type">
 *            <xs:simpleType>
 *                <xs:restriction base="xs:string">
 *                    <xs:enumeration value="preceding"/>
 *                    <xs:enumeration value="succeeding"/>
 *                    <xs:enumeration value="original"/>
 *                    <xs:enumeration value="host"/>
 *                    <xs:enumeration value="constituent"/>
 *                    <xs:enumeration value="series"/>
 *                    <xs:enumeration value="otherVersion"/>
 *                    <xs:enumeration value="otherFormat"/>
 *                    <xs:enumeration value="isReferencedBy"/>
 *                    <xs:enumeration value="references"/>
 *                    <xs:enumeration value="reviewOf"/>
 *                </xs:restriction>
 *            </xs:simpleType>
 *        </xs:attribute>
 *        <!-- 
 *        Following four attributes are new in 3.6
 *        --> 
 *        <xs:attribute name="otherType" type="xs:string"/>
 *        <xs:attribute name="otherTypeAuth" type="xs:string"/>
 *        <xs:attribute name="otherTypeAuthURI" type="xs:string"/>
 *        <xs:attribute name="otherTypeURI" type="xs:string"/>
 *        <!-- -->
 *        
 *        <xs:attribute name="displayLabel" type="xs:string"/>
 *        <xs:attribute name="ID" type="xs:ID"/>
 *        <xs:attributeGroup ref="xlink:simpleLink"/>
 *        
 *    </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class RelatedItem
    implements ITopLevelElement, IIDAttributeGroup, IOtherTypeAttributeGroup, IAttributeGroupXlinkSimpleLink {

    /**
     * {@code 
     * 	<xs:group ref="modsGroup" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElements({ @XmlElement(name = "abstract", namespace = "http://www.loc.gov/mods/v3", type = Abstract.class),
        @XmlElement(name = "accessCondition", namespace = "http://www.loc.gov/mods/v3", type = AccessCondition.class),
        @XmlElement(name = "classification", namespace = "http://www.loc.gov/mods/v3", type = Classification.class),
        @XmlElement(name = "extension", namespace = "http://www.loc.gov/mods/v3", type = Extension.class),
        @XmlElement(name = "genre", namespace = "http://www.loc.gov/mods/v3", type = Genre.class),
        @XmlElement(name = "identifier", namespace = "http://www.loc.gov/mods/v3", type = Identifier.class),
        @XmlElement(name = "language", namespace = "http://www.loc.gov/mods/v3", type = Language.class),
        @XmlElement(name = "location", namespace = "http://www.loc.gov/mods/v3", type = Location.class),
        @XmlElement(name = "name", namespace = "http://www.loc.gov/mods/v3", type = Name.class),
        @XmlElement(name = "note", namespace = "http://www.loc.gov/mods/v3", type = Note.class),
        @XmlElement(name = "originInfo", namespace = "http://www.loc.gov/mods/v3", type = OriginInfo.class),
        @XmlElement(name = "part", namespace = "http://www.loc.gov/mods/v3", type = Part.class),
        @XmlElement(name = "physicalDescription", namespace = "http://www.loc.gov/mods/v3",
            type = PhysicalDescription.class),
        @XmlElement(name = "recordInfo", namespace = "http://www.loc.gov/mods/v3", type = RecordInfo.class),
        @XmlElement(name = "relatedItem", namespace = "http://www.loc.gov/mods/v3", type = RelatedItem.class),
        @XmlElement(name = "subject", namespace = "http://www.loc.gov/mods/v3", type = Subject.class),
        @XmlElement(name = "tableOfContents", namespace = "http://www.loc.gov/mods/v3", type = TableOfContents.class),
        @XmlElement(name = "targetAudience", namespace = "http://www.loc.gov/mods/v3", type = TargetAudience.class),
        @XmlElement(name = "titleInfo", namespace = "http://www.loc.gov/mods/v3", type = TitleInfo.class),
        @XmlElement(name = "typeOfResource", namespace = "http://www.loc.gov/mods/v3", type = TypeOfResource.class) })
    protected List<ITopLevelElement> content = new Vector<>();

    @XmlAttribute(name = "type", required = false)
    protected RelatedItemType type;

    /**
     * @version MODS 3.6
     */
    @XmlAttribute(name = "otherType", required = false)
    protected String otherType;

    /**
     * @version MODS 3.6
     */
    @XmlAttribute(name = "otherTypeAuth", required = false)
    protected String otherTypeAuth;

    /**
     * @version MODS 3.6
     */
    @XmlAttribute(name = "otherTypeAuthURI", required = false)
    protected String otherTypeAuthURI;

    /**
     * @version MODS 3.6
     */
    @XmlAttribute(name = "otherTypeURI", required = false)
    protected String otherTypeURI;

    /**
     * @version MODS 3.6
     */
    @XmlAttribute(name = "displayLabel", required = false)
    protected String displayLabel;

    /**
     * {@code 
     * <xs:attribute name="ID" type="xs:ID"/>
     * }
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    @XmlAttribute(name = "IDREF", required = false)
    protected String IDREF;

    // attributeGroup xlink:simpleLink - begin

    /**
     * {@code 
     * <attribute name="type" type="string" type="simple" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkType;
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

    public List<ITopLevelElement> getContent() {
        return content;
    }

    public void setContent(List<ITopLevelElement> content) {
        this.content = content;
    }

    public RelatedItemType getType() {
        return type;
    }

    public void setType(RelatedItemType type) {
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

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
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

    // attributeGroup xlink:simpleLink - end

    /**
     * returns a filtered List of TopLevel elements
     * @param <T> the type of the toplevelElement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS toplevel elements
     */
    public <T extends ITopLevelElement> List<T> filterContentContent(Class<T> type) {
        return content.stream().filter(type::isInstance).map(type::cast).toList();
    }

    public static Builder builderForRelatedItem() {
        return builder(new RelatedItem());
    }

    public static Builder builder(RelatedItem relItem) {
        return new Builder(relItem);
    }

    public static class Builder extends BuilderBase<RelatedItem, Builder>
        implements IIDAttributeGroupBuilder<RelatedItem, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<RelatedItem, Builder>,
        IOtherTypeAttributeGroupBuilder<IOtherTypeAttributeGroup, Builder> {
        protected Builder(RelatedItem relItem) {
            super(relItem);
        }

        public Builder addContent(ITopLevelElement content) {
            _target().getContent().add(content);
            return this;
        }

        public Builder xlinkType(String xlinkType) {
            _target().setXlinkType(xlinkType);
            return this;
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return this;
        }

        public Builder type(RelatedItemType type) {
            _target().setType(type);
            return this;
        }

    }
}
