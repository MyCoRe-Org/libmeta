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
package org.mycore.libmeta.mets.model.mdsec;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupFILECOREBuilder;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupLOCATIONBuilder;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupMETADATABuilder;
import org.mycore.libmeta.mets.model._enums.CHECKSUMTYPE;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model._enums.MDTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupFILECORE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupLOCATION;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupMETADATA;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * The metadata reference element &lt;mdRef&gt; element is a generic element
 * used throughout the METS schema to provide a pointer to metadata which
 * resides outside the METS document. NB: &lt;mdRef&gt; is an empty element. The
 * location of the metadata must be recorded in the xlink:href attribute,
 * supplemented by the XPTR attribute as needed.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 * 		<xsd:attributeGroup ref="LOCATION" />
		<xsd:attributeGroup ref="xlink:simpleLink" />
		<xsd:attributeGroup ref="METADATA" />
		<xsd:attributeGroup ref="FILECORE" />
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class MdRef implements IAttributeGroupLOCATION, IAttributeGroupXlinkSimpleLink, IAttributeGroupMETADATA,
    IAttributeGroupFILECORE {
    /**
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
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
     * <xsd:attribute name="LOCTYPE" use="required">
     * 
     * LOCTYPE (string/R): Specifies the locator type used in the xlink:href
     * attribute. Valid values for LOCTYPE are:
     */
    @XmlAttribute(name = "LOCTYPE", required = true)
    protected LOCTYPE LOCTYPE;

    /**
     * <xsd:attribute name="OTHERLOCTYPE" type="xsd:string" use="optional">
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
     * <attribute name="type" type="string" fixed="simple" form="qualified"/>
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkType;

    /**
     * <attribute ref="xlink:href" use="optional"/>
     */
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkHref;

    /**
     * <attribute ref="xlink:role" use="optional"/>
     */
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkRole;

    /**
     * <attribute ref="xlink:arcrole" use="optional"/>
     */
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkArcrole;

    /**
     * <attribute ref="xlink:title" use="optional"/>
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * <attribute ref="xlink:show" use="optional"/>
     */
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkShow xlinkShow;

    /**
     * <attribute ref="xlink:actuate" use="optional"/>
     */
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkActuate xlinkActuate;

    // attributeGroup xlink:simpleLink - end

    // attributeGroup METADATA - begin

    /**
     * <xsd:attribute name="MDTYPE" use="required">
     * 
     * MDTYPE (string/R): Is used to indicate the type of the associated
     * metadata.
     */
    @XmlAttribute(name = "MDTYPE", required = true)
    protected MDTYPE MDTYPE;

    /**
     * <xsd:attribute name="OTHERMDTYPE" type="xsd:string" use="optional">
     * 
     * OTHERMDTYPE (string/O): Specifies the form of metadata in use when the
     * value OTHER is indicated in the MDTYPE attribute.
     */
    @XmlAttribute(name = "OTHERMDTYPE", required = false)
    protected String OTHERMDTYPE;

    /**
     * <xsd:attribute name="MDTYPEVERSION" type="xsd:string" use="optional">
     * 
     * MDTYPEVERSION(string/O): Provides a means for recording the version of
     * the type of metadata (as recorded in the MDTYPE or OTHERMDTYPE attribute)
     * that is being used. This may represent the version of the underlying data
     * dictionary or metadata model rather than a schema version.
     * </xsd:documentation>
     */
    @XmlAttribute(name = "MDTYPEVERSION", required = false)
    protected String MDTYPEVERSION;

    // attributeGroup METADATA - end

    // attributeGroup FILECORE - begin
    /**
     * <xsd:attribute name="MIMETYPE" type="xsd:string" use="optional">
     * 
     * MIMETYPE (string/O): The IANA MIME media type for the associated file or
     * wrapped content. Some values for this attribute can be found on the IANA
     * website.
     */
    @XmlAttribute(name = "MIMETYPE", required = false)
    protected String MIMETYPE;

    /**
     * <xsd:attribute name="SIZE" type="xsd:long" use="optional">
     * 
     * SIZE (long/O): Specifies the size in bytes of the associated file or
     * wrapped content.
     */
    @XmlAttribute(name = "SIZE", required = false)
    protected Long SIZE;

    /**
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * 
     * CREATED (dateTime/O): Specifies the date and time of creation for the
     * associated file or wrapped content.
     */
    @XmlAttribute(name = "CREATED", required = false)
    protected String CREATED;

    /**
     * <xsd:attribute name="CHECKSUM" type="xsd:string" use="optional">
     * 
     * CHECKSUM (string/O): Provides a checksum value for the associated file or
     * wrapped content.
     */
    @XmlAttribute(name = "CHECKSUM", required = false)
    protected String CHECKSUM;

    /**
     * <xsd:attribute name="CHECKSUMTYPE" use="optional">
     * 
     * CHECKSUMTYPE (enumerated string/O): Specifies the checksum algorithm used
     * to produce the value contained in the CHECKSUM attribute.
     */
    @XmlAttribute(name = "CHECKSUMTYPE", required = false)
    protected CHECKSUMTYPE CHECKSUMTYPE;

    // attributeGroup FILECORE - end
    /**
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * 
     * LABEL (string/O): Provides a label to display to the viewer of the METS
     * document that identifies the associated metadata.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    /**
     * <xsd:attribute name="XPTR" type="xsd:string" use="optional">
     * 
     * XPTR (string/O): Locates the point within a file to which the
     * &lt;mdRef&gt; element refers, if applicable.
     */
    @XmlAttribute(name = "XPTR", required = false)
    protected String XPTR;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public LOCTYPE getLOCTYPE() {
        return LOCTYPE;
    }

    public void setLOCTYPE(LOCTYPE lOCTYPE) {
        LOCTYPE = lOCTYPE;
    }

    public String getOTHERLOCTYPE() {
        return OTHERLOCTYPE;
    }

    public void setOTHERLOCTYPE(String oTHERLOCTYPE) {
        OTHERLOCTYPE = oTHERLOCTYPE;
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

    public MDTYPE getMDTYPE() {
        return MDTYPE;
    }

    public void setMDTYPE(MDTYPE mDTYPE) {
        MDTYPE = mDTYPE;
    }

    public String getOTHERMDTYPE() {
        return OTHERMDTYPE;
    }

    public void setOTHERMDTYPE(String oTHERMDTYPE) {
        OTHERMDTYPE = oTHERMDTYPE;
    }

    public String getMDTYPEVERSION() {
        return MDTYPEVERSION;
    }

    public void setMDTYPEVERSION(String mDTYPEVERSION) {
        MDTYPEVERSION = mDTYPEVERSION;
    }

    public String getMIMETYPE() {
        return MIMETYPE;
    }

    public void setMIMETYPE(String mIMETYPE) {
        MIMETYPE = mIMETYPE;
    }

    public Long getSIZE() {
        return SIZE;
    }

    public void setSIZE(Long sIZE) {
        SIZE = sIZE;
    }

    public String getCREATED() {
        return CREATED;
    }

    public void setCREATED(String cREATED) {
        CREATED = cREATED;
    }

    public String getCHECKSUM() {
        return CHECKSUM;
    }

    public void setCHECKSUM(String cHECKSUM) {
        CHECKSUM = cHECKSUM;
    }

    public CHECKSUMTYPE getCHECKSUMTYPE() {
        return CHECKSUMTYPE;
    }

    public void setCHECKSUMTYPE(CHECKSUMTYPE cHECKSUMTYPE) {
        CHECKSUMTYPE = cHECKSUMTYPE;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String lABEL) {
        LABEL = lABEL;
    }

    public String getXPTR() {
        return XPTR;
    }

    public void setXPTR(String xPTR) {
        XPTR = xPTR;
    }

    public static Builder builder() {
        return builder(new MdRef());
    }

    public static Builder builder(MdRef mr) {
        return new Builder(mr);
    }

    public static class Builder extends BuilderBase<MdRef, Builder> implements IAttributeGroupLOCATIONBuilder<MdRef, Builder>,
        IAttributeGroupMETADATABuilder<MdRef, Builder>, IAttributeGroupFILECOREBuilder<MdRef, Builder>,
        IAttributeGroupXlinkSimpleLinkBuilder<MdRef, Builder> {

        protected Builder(MdRef mr) {
            super(mr);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder xlinkType(String xlinkType) {
            _target().setXlinkType(xlinkType);
            return _self();
        }

        public Builder LABEL(String label) {
            _target().setLABEL(label);
            return _self();
        }

        public Builder XPTR(String xptr) {
            _target().setXPTR(xptr);
            return _self();
        }
    }
}
