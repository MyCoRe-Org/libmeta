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
package org.mycore.libmeta.mets.model.structlink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._enums.SmLinkGrpARCLINKORDER;
import org.mycore.libmeta.xlink.model.XlinkTypeExtended;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkExtendedLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkExtendedLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <xsd:element name="smLinkGrp">
 * 
 * The structMap link group element &lt;smLinkGrp&gt; provides an implementation
 * of xlink:extendLink, and provides xlink compliant mechanisms for establishing
 * xlink:arcLink type links between 2 or more &lt;div&gt; elements in
 * &lt;structMap&gt; element(s) occurring within the same METS document or
 * different METS documents. The smLinkGrp could be used as an alternative to
 * the &lt;smLink&gt; element to establish a one-to-one link between &lt;div&gt;
 * elements in the same METS document in a fully xlink compliant manner.
 * However, it can also be used to establish one-to-many or many-to-many links
 * between &lt;div&gt; elements. For example, if a METS document contains two
 * &lt;structMap&gt; elements, one of which represents a purely logical
 * structure and one of which represents a purely physical structure, the
 * &lt;smLinkGrp&gt; element would provide a means of mapping a &lt;div&gt;
 * representing a logical entity (for example, a newspaper article) with
 * multiple &lt;div&gt; elements in the physical &lt;structMap&gt; representing
 * the physical areas that together comprise the logical entity (for example,
 * the &lt;div&gt; elements representing the page areas that together comprise
 * the newspaper article).
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "smLocatorLink", "smArcLink" })
public class SmLinkGrp extends SmLinkOrSmLinkGrp implements IAttributeGroupXlinkExtendedLink {

    // <xsd:sequence>
    /**
     * <xsd:element name="smLocatorLink" minOccurs="2" maxOccurs="unbounded" >
     * 
     * The structMap locator link element &lt;smLocatorLink&gt; is of xlink:type
     * &quot;locator&quot;. It provides a means of identifying a &lt;div&gt;
     * element that will participate in one or more of the links specified by
     * means of &lt;smArcLink&gt; elements within the same &lt;smLinkGrp&gt;.
     * The participating &lt;div&gt; element that is represented by the
     * &lt;smLocatorLink&gt; is identified by means of a URI in the associate
     * xlink:href attribute. The lowest level of this xlink:href URI value
     * should be a fragment identifier that references the ID value that
     * identifies the relevant &lt;div&gt; element. For example,
     * &quot;xlink:href=&apos;#div20&apos;&quot; where &quot;div20&quot; is the
     * ID value that identifies the pertinent &lt;div&gt; in the current METS
     * document. Although not required by the xlink specification, an
     * &lt;smLocatorLink&gt; element will typically include an xlink:label
     * attribute in this context, as the &lt;smArcLink&gt; elements will
     * reference these labels to establish the from and to sides of each arc
     * link.
     */
    @XmlElement(name = "smLocatorLink", namespace = "http://www.loc.gov/METS/", required = true)
    protected List<SmLocatorLink> smLocatorLink = new Vector<>();

    /**
     * <xsd:element name="smArcLink" minOccurs="1" maxOccurs="unbounded">
     * 
     * The structMap arc link element &lt;smArcLink&gt; is of xlink:type
     * &quot;arc&quot; It can be used to establish a traversal link between two
     * &lt;div&gt; elements as identified by &lt;smLocatorLink&gt; elements
     * within the same smLinkGrp element. The associated xlink:from and xlink:to
     * attributes identify the from and to sides of the arc link by referencing
     * the xlink:label attribute values on the participating smLocatorLink
     * elements.
     */
    @XmlElement(name = "smArcLink", namespace = "http://www.loc.gov/METS/", required = true)
    protected List<SmArcLink> smArcLink = new Vector<>();

    /**
     * <xsd:attribute name="ID" type="xsd:ID"/> //TODO-CHECK no documentation
     */
    @XmlAttribute(name = "ID", required = true)
    protected String ID;

    /**
     * <xsd:attribute name="ARCLINKORDER" default="unordered">
     * 
     * ARCLINKORDER (enumerated string/O): ARCLINKORDER is used to indicate
     * whether the order of the smArcLink elements aggregated by the smLinkGrp
     * element is significant. If the order is significant, then a value of
     * &quot;ordered&quot; should be supplied. Value defaults to
     * &quot;unordered&quot; Note that the ARLINKORDER attribute has no xlink
     * specified meaning.</xsd:documentation>
     */
    @XmlAttribute(name = "ARCLINKORDER", required = true)
    protected SmLinkGrpARCLINKORDER ARCLINKORDER = SmLinkGrpARCLINKORDER.UNORDERED;

    // attributeGroup xlink:extendedLink - begin

    /**
     * <attribute name="type" type="string" fixed="extended" form="qualified"/>
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected XlinkTypeExtended xlinkType = XlinkTypeExtended.EXTENDED;

    /**
     * <attribute ref="xlink:role" use="optional"/>
     */
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkRole;

    /**
     * <attribute ref="xlink:title" use="optional"/>
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<SmLocatorLink> getSmLocatorLink() {
        return smLocatorLink;
    }

    public List<SmArcLink> getSmArcLink() {
        return smArcLink;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public SmLinkGrpARCLINKORDER getARCLINKORDER() {
        return ARCLINKORDER;
    }

    public void setARCLINKORDER(SmLinkGrpARCLINKORDER arclinkOrder) {
        ARCLINKORDER = arclinkOrder;
    }

    public XlinkTypeExtended getXlinkType() {
        return xlinkType;
    }

    public void setXlinkType(XlinkTypeExtended xlinkType) {
        this.xlinkType = xlinkType;
    }

    public String getXlinkRole() {
        return xlinkRole;
    }

    public void setXlinkRole(String xlinkRole) {
        this.xlinkRole = xlinkRole;
    }

    public String getXlinkTitle() {
        return xlinkTitle;
    }

    public void setXlinkTitle(String xlinkTitle) {
        this.xlinkTitle = xlinkTitle;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new SmLinkGrp());
    }

    public static Builder builder(SmLinkGrp slg) {
        return new Builder(slg);
    }

    public static class Builder extends BuilderBase<SmLinkGrp, Builder> implements IAttributeGroupXlinkExtendedLinkBuilder<SmLinkGrp, Builder> {

        protected Builder(SmLinkGrp slg) {
            super(slg);
        }

        public Builder addSmLocatorLink(SmLocatorLink smLocatorLink) {
            _target().getSmLocatorLink().add(smLocatorLink);
            return _self();
        }

        public Builder addSmArcLink(SmArcLink smArcLink) {
            _target().getSmArcLink().add(smArcLink);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder ARCLINKORDER(SmLinkGrpARCLINKORDER arcLinkOrder) {
            _target().setARCLINKORDER(arcLinkOrder);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
