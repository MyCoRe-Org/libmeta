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
package org.mycore.libmeta.mets.model.div;

import java.net.URI;
import java.net.URISyntaxException;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupLOCATIONBuilder;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupLOCATION;
import org.mycore.libmeta.mets.model._misc.URIs;
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
 * <xsd:element name="mptr" minOccurs="0" maxOccurs="unbounded">
 * }
 * 
 * Like the &lt;fptr&gt; element, the METS pointer element &lt;mptr&gt;
 * represents digital content that manifests its parent &lt;div&gt; element.
 * Unlike the &lt;fptr&gt;, which either directly or indirectly points to
 * content represented in the &lt;fileSec&gt; of the parent METS document, the
 * &lt;mptr&gt; element points to content represented by an external METS
 * document. Thus, this element allows multiple discrete and separate METS
 * documents to be organized at a higher level by a separate METS document. For
 * example, METS documents representing the individual issues in the series of a
 * journal could be grouped together and organized by a higher level METS
 * document that represents the entire journal series. Each of the &lt;div&gt;
 * elements in the &lt;structMap&gt; of the METS document representing the
 * journal series would point to a METS document representing an issue. It would
 * do so via a child &lt;mptr&gt; element. Thus the &lt;mptr&gt; element gives
 * METS users considerable flexibility in managing the depth of the
 * &lt;structMap&gt; hierarchy of individual METS documents. The &lt;mptr&gt;
 * element points to an external METS document by means of an xlink:href
 * attribute and associated XLink attributes.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Mptr implements IAttributeGroupLOCATION, IAttributeGroupXlinkSimpleLink {

    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
     * }
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. For more information
     * on using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    // attributeGroup LOCATION - begin
    /**
     * {@code
     * <xsd:attribute name="LOCTYPE" use="required">
     * }
     * 
     * LOCTYPE (string/R): Specifies the locator type used in the xlink:href
     * attribute. Valid values for LOCTYPE are:
     */
    @XmlAttribute(name = "LOCTYPE", required = true)
    protected LOCTYPE LOCTYPE;

    /**
     * {@code
     * <xsd:attribute name="OTHERLOCTYPE" type="xsd:string" use="optional">
     * }
     * 
     * OTHERLOCTYPE (string/O): Specifies the locator type when the value OTHER
     * is used in the LOCTYPE attribute. Although optional, it is strongly
     * recommended when OTHER is used.
     */
    @XmlAttribute(name = "OTHERLOCTYPE", required = false)
    protected String OTHERLOCTYPE;

    // attributeGroup LOCATION - end

    // attributeGroup xlink:simpleLink - begin

    /**
     * {@code
     * <attribute name="type" type="string" fixed="simple" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
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

    // attributeGroup xlink:simpleLink - end

    /**
     * {@code
     * <xsd:attribute name="CONTENTIDS" type="URIs" use="optional">
     * }
     * 
     * CONTENTIDS (URI/O): Content IDs for the content represented by the
     * &lt;mptr&gt; (equivalent to DIDL DII or Digital Item Identifier, a unique
     * external ID).
     */
    @XmlAttribute(name = "CONTENTIDs", required = false)
    protected URIs CONTENTIDS = new URIs();

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public LOCTYPE getLOCTYPE() {
        return LOCTYPE;
    }

    public void setLOCTYPE(LOCTYPE locType) {
        LOCTYPE = locType;
    }

    public String getOTHERLOCTYPE() {
        return OTHERLOCTYPE;
    }

    public void setOTHERLOCTYPE(String otherLoctype) {
        OTHERLOCTYPE = otherLoctype;
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

    public URIs getCONTENTIDS() {
        return CONTENTIDS;
    }

    public void setCONTENTIDS(URIs cONTENTIDS) {
        CONTENTIDS = cONTENTIDS;
    }

    public static Builder builder() {
        return builder(new Mptr());
    }

    public static Builder builder(Mptr m) {
        return new Builder(m);
    }

    public static class Builder extends BuilderBase<Mptr, Builder>
        implements IAttributeGroupLOCATIONBuilder<Mptr, Builder>, IAttributeGroupXlinkSimpleLinkBuilder<Mptr, Builder> {

        protected Builder(Mptr m) {
            super(m);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder addCONTENTID(URI uri) {
            _target().getCONTENTIDS().add(uri);
            return _self();
        }

        public Builder addCONTENTID(String uri) {
            URI u = null;
            try {
                u = new URI(uri);
            } catch (URISyntaxException e) {
                //ignore
            }
            return addCONTENTID(u);
        }
    }
}
