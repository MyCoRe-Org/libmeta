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

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeArc;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkArcLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkArcLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xsd:element name="smArcLink" minOccurs="1" maxOccurs="unbounded">
 * }
 * 
 * The structMap arc link element &lt;smArcLink&gt; is of xlink:type
 * &quot;arc&quot; It can be used to establish a traversal link between two
 * &lt;div&gt; elements as identified by &lt;smLocatorLink&gt; elements within
 * the same smLinkGrp element. The associated xlink:from and xlink:to attributes
 * identify the from and to sides of the arc link by referencing the xlink:label
 * attribute values on the participating smLocatorLink elements.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SmArcLink implements IAttributeGroupXlinkArcLink {
    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID"> //TODO-CHECK required=true?
     * }
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. For more information
     * on using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     * 
     */
    @XmlAttribute(name = "ID", required = true)
    protected String ID;

    // attributeGroup xlink:arcLink - begin

    /**
     * {@code
     * <attribute name="type" type="string" fixed="arc" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected XlinkTypeArc xlinkType = XlinkTypeArc.ARC;

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

    /**
     * {@code
     * <attribute ref="xlink:from" use="optional"/>
     * }
     */
    @XmlAttribute(name = "from", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkFrom;

    /**
     * {@code
     * <attribute ref="xlink:to" use="optional"/>
     * }
     */
    @XmlAttribute(name = "to", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTo;

    // attributeGroup xlink:arcLink - end

    /**
     * {@code
     * <xsd:attribute name="ARCTYPE" type="xsd:string">
     * }
     * 
     * ARCTYPE (string/O):The ARCTYPE attribute provides a means of specifying
     * the relationship between the &lt;div&gt; elements participating in the
     * arc link, and hence the purpose or role of the link. While it can be
     * considered analogous to the xlink:arcrole attribute, its type is a simple
     * string, rather than anyURI. ARCTYPE has no xlink specified meaning, and
     * the xlink:arcrole attribute should be used instead of or in addition to
     * the ARCTYPE attribute when full xlink compliance is desired with respect
     * to specifying the role or purpose of the arc link.
     */
    @XmlAttribute(name = "ARCTYPE", required = true)
    protected String ARCTYPE;

    /**
     * {@code
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;sourceMD&gt;, &lt;techMD&gt;, &lt;digiprovMD&gt; and/or
     * &lt;rightsMD&gt; elements within the &lt;amdSec&gt; of the METS document
     * that contain or link to administrative metadata pertaining to
     * &lt;smArcLink&gt;. Typically the &lt;smArcLink&gt; ADMID attribute would
     * be used to identify one or more &lt;sourceMD&gt; and/or &lt;techMD&gt;
     * elements that refine or clarify the relationship between the xlink:from
     * and xlink:to sides of the arc. For more information on using METS IDREFS
     * and IDREF type attributes for internal linking, see Chapter 4 of the METS
     * Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public XlinkTypeArc getXlinkType() {
        return xlinkType;
    }

    public void setXlinkType(XlinkTypeArc xlinkType) {
        this.xlinkType = xlinkType;
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

    public String getXlinkFrom() {
        return xlinkFrom;
    }

    public void setXlinkFrom(String xlinkFrom) {
        this.xlinkFrom = xlinkFrom;
    }

    public String getXlinkTo() {
        return xlinkTo;
    }

    public void setXlinkTo(String xlinkTo) {
        this.xlinkTo = xlinkTo;
    }

    public String getARCTYPE() {
        return ARCTYPE;
    }

    public void setARCTYPE(String aRCTYPE) {
        ARCTYPE = aRCTYPE;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String aDMID) {
        ADMID = aDMID;
    }

    public static Builder builder() {
        return builder(new SmArcLink());
    }

    public static Builder builder(SmArcLink sal) {
        return new Builder(sal);
    }

    public static class Builder extends BuilderBase<SmArcLink, Builder> implements IAttributeGroupXlinkArcLinkBuilder<SmArcLink, Builder> {

        protected Builder(SmArcLink sal) {
            super(sal);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder ARCTYPE(String arcType) {
            _target().setARCTYPE(arcType);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }
    }
}
