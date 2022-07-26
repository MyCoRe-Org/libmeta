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
package org.mycore.libmeta.mets.model.filesec.file;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupLOCATIONBuilder;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupLOCATION;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * <xsd:element name="FLocat" minOccurs="0" maxOccurs="unbounded">
 * 
 * The file location element &lt;FLocat&gt; provides a pointer to the location
 * of a content file. It uses the XLink reference syntax to provide linking
 * information indicating the actual location of the content file, along with
 * other attributes specifying additional linking information. NOTE:
 * &lt;FLocat&gt; is an empty element. The location of the resource pointed to
 * MUST be stored in the xlink:href attribute.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class FLocat implements IAttributeGroupLOCATION, IAttributeGroupXlinkSimpleLink {
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

    /**
     * <xsd:attribute name="USE" type="xsd:string" use="optional">
     * 
     * USE (string/O): A tagging attribute to indicate the intended use of the
     * specific copy of the file represented by the &lt;FLocat&gt; element
     * (e.g., service master, archive master). A USE attribute can be expressed
     * at the&lt;fileGrp&gt; level, the &lt;file&gt; level, the &lt;FLocat&gt;
     * level and/or the &lt;FContent&gt; level. A USE attribute value at the
     * &lt;fileGrp&gt; level should pertain to all of the files in the
     * &lt;fileGrp&gt;. A USE attribute at the &lt;file&gt; level should pertain
     * to all copies of the file as represented by subsidiary &lt;FLocat&gt;
     * and/or &lt;FContent&gt; elements. A USE attribute at the &lt;FLocat&gt;
     * or &lt;FContent&gt; level pertains to the particular copy of the file
     * that is either referenced (&lt;FLocat&gt;) or wrapped (&lt;FContent&gt;).
     */
    @XmlAttribute(name = "USE", required = false)
    protected String USE;

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

    public String getUSE() {
        return USE;
    }

    public void setUSE(String use) {
        USE = use;
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

    public static Builder builder() {
        return builder(new FLocat());
    }

    public static Builder builder(FLocat fl) {
        return new Builder(fl);
    }

    public static class Builder extends BuilderBase<FLocat, Builder>
        implements IAttributeGroupLOCATIONBuilder<FLocat, Builder>, IAttributeGroupXlinkSimpleLinkBuilder<FLocat, Builder> {

        protected Builder(FLocat f) {
            super(f);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder USE(String use) {
            _target().setUSE(use);
            return _self();
        }

        public Builder xlinkType(String xlinkType) {
            _target().setXlinkType(xlinkType);
            return _self();
        }
    }
}
