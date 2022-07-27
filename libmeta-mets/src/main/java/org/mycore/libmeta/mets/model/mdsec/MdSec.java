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

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * {@code
 * <xsd:complexType name="mdSecType">
 * }
 * 
 * mdSecType: Complex Type for Metadata Sections
 * 
 * A generic framework for pointing to/including metadata within a METS
 * document, a la Warwick Framework.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class MdSec {

    // <xsd:all>

    /**
     * {@code
     * <xsd:element name="mdRef" minOccurs="0">
     * }
     * 
     * The metadata reference element &lt;mdRef&gt; element is a generic element
     * used throughout the METS schema to provide a pointer to metadata which
     * resides outside the METS document. NB: &lt;mdRef&gt; is an empty element.
     * The location of the metadata must be recorded in the xlink:href
     * attribute, supplemented by the XPTR attribute as needed.
     */
    @XmlElement(name = "mdRef", namespace = "http://www.loc.gov/METS/", required = false)
    protected MdRef mdRef;

    /**
     * {@code
     * <xsd:element name="mdWrap" minOccurs="0">
     * }
     * 
     * A metadata wrapper element &lt;mdWrap&gt; provides a wrapper around
     * metadata embedded within a METS document. The element is repeatable. Such
     * metadata can be in one of two forms: 1) XML-encoded metadata, with the
     * XML-encoding identifying itself as belonging to a namespace other than
     * the METS document namespace. 2) Any arbitrary binary or textual form,
     * PROVIDED that the metadata is Base64 encoded and wrapped in a
     * &lt;binData&gt; element within the internal descriptive metadata element.
     */
    @XmlElement(name = "mdWrap", namespace = "http://www.loc.gov/METS/", required = false)
    protected MdWrap mdWrap;

    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID" use="required">
     * }
     * 
     * ID (ID/R): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. The ID attribute on
     * the &lt;dmdSec&gt;, &lt;techMD&gt;, &lt;sourceMD&gt;, &lt;rightsMD&gt;
     * and &lt;digiprovMD&gt; elements (which are all of mdSecType) is required,
     * and its value should be referenced from one or more DMDID attributes
     * (when the ID identifies a &lt;dmdSec&gt; element) or ADMID attributes
     * (when the ID identifies a &lt;techMD&gt;, &lt;sourceMD&gt;,
     * &lt;rightsMD&gt; or &lt;digiprovMD&gt; element) that are associated with
     * other elements in the METS document. The following elements support
     * references to a &lt;dmdSec&gt; via a DMDID attribute: &lt;file&gt;,
     * &lt;stream&gt;, &lt;div&gt;. The following elements support references to
     * &lt;techMD&gt;, &lt;sourceMD&gt;, &lt;rightsMD&gt; and &lt;digiprovMD&gt;
     * elements via an ADMID attribute: &lt;metsHdr&gt;, &lt;dmdSec&gt;,
     * &lt;techMD&gt;, &lt;sourceMD&gt;, &lt;rightsMD&gt;, &lt;digiprovMD&gt;,
     * &lt;fileGrp&gt;, &lt;file&gt;, &lt;stream&gt;, &lt;div&gt;, &lt;area&gt;,
     * &lt;behavior&gt;. For more information on using ID attributes for
     * internal and external linking see Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    /**
     * {@code
     * <xsd:attribute name="GROUPID" type="xsd:string" use="optional">
     * }
     * 
     * GROUPID (string/O): This identifier is used to indicate that different
     * metadata sections may be considered as part of a group. Two metadata
     * sections with the same GROUPID value are to be considered part of the
     * same group. For example this facility might be used to group changed
     * versions of the same metadata if previous versions are maintained in a
     * file for tracking purposes.
     */
    @XmlAttribute(name = "GROUPID", required = false)
    protected String GROUPID;

    /**
     * {@code
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values of the
     * &lt;digiprovMD&gt;, &lt;techMD&gt;, &lt;sourceMD&gt; and/or
     * &lt;rightsMD&gt; elements within the &lt;amdSec&gt; of the METS document
     * that contain administrative metadata pertaining to the current mdSecType
     * element. Typically used in this context to reference preservation
     * metadata (digiprovMD) which applies to the current metadata. For more
     * information on using METS IDREFS and IDREF type attributes for internal
     * linking, see Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * {@code
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATED (dateTime/O): Specifies the date and time of creation for the
     * metadata.
     */
    @XmlAttribute(name = "CREATED", required = false)
    protected String CREATED;

    /**
     * {@code
     * <xsd:attribute name="STATUS" type="xsd:string" use="optional">
     * }
     * 
     * STATUS (string/O): Indicates the status of this metadata (e.g.,
     * superseded, current, etc.).
     */
    @XmlAttribute(name = "STATUS", required = false)
    protected String STATUS;

    /**
     * {@code
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public MdRef getMdRef() {
        return mdRef;
    }

    public void setMdRef(MdRef mdRef) {
        this.mdRef = mdRef;
    }

    public MdWrap getMdWrap() {
        return mdWrap;
    }

    public void setMdWrap(MdWrap mdWrap) {
        this.mdWrap = mdWrap;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String groupID) {
        GROUPID = groupID;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String admID) {
        ADMID = admID;
    }

    public String getCREATED() {
        return CREATED;
    }

    public void setCREATED(String created) {
        CREATED = created;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String status) {
        STATUS = status;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new MdSec());
    }

    public static Builder builder(MdSec ms) {
        return new Builder(ms);
    }

    public static class Builder extends BuilderBase<MdSec, Builder> {

        protected Builder(MdSec ms) {
            super(ms);
        }

        public Builder mdRef(MdRef mdRef) {
            _target().setMdRef(mdRef);
            return _self();
        }

        public Builder mdWrap(MdWrap mdWrap) {
            _target().setMdWrap(mdWrap);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder GROUPID(String groupID) {
            _target().setGROUPID(groupID);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }

        public Builder CREATED(String created) {
            _target().setCREATED(created);
            return _self();
        }

        public Builder STATUS(String status) {
            _target().setSTATUS(status);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
