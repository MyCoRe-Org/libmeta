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
import org.mycore.libmeta.mets.model._builder.IAttributeGroupMETADATABuilder;
import org.mycore.libmeta.mets.model._enums.CHECKSUMTYPE;
import org.mycore.libmeta.mets.model._enums.MDTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupFILECORE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupMETADATA;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * A metadata wrapper element &lt;mdWrap&gt; provides a wrapper around metadata
 * embedded within a METS document. The element is repeatable. Such metadata can
 * be in one of two forms: 1) XML-encoded metadata, with the XML-encoding
 * identifying itself as belonging to a namespace other than the METS document
 * namespace. 2) Any arbitrary binary or textual form, PROVIDED that the
 * metadata is Base64 encoded and wrapped in a &lt;binData&gt; element within
 * the internal descriptive metadata element.
 * 
 * {@code
 * 		<xsd:attributeGroup ref="METADATA" />
		<xsd:attributeGroup ref="FILECORE" />
	}
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class MdWrap implements IAttributeGroupMETADATA, IAttributeGroupFILECORE {
    // <xsd:choice>

    /**
     * {@code
     * <xsd:element name="binData" type="xsd:base64Binary" minOccurs="0">
     * }
     * 
     * The binary data wrapper element &lt;binData&gt; is used to contain Base64
     * encoded metadata.
     */
    @XmlElement(name = "binData", namespace = "http://www.loc.gov/METS/", required = false)
    protected String binData;

    /**
     * {@code
     * <xsd:element name="xmlData" minOccurs="0">
     * }
     * 
     * The xml data wrapper element &lt;xmlData&gt; is used to contain XML
     * encoded metadata. The content of an &lt;xmlData&gt; element can be in any
     * namespace or in no namespace. As permitted by the XML Schema Standard,
     * the processContents attribute value for the metadata in an
     * &lt;xmlData&gt; is set to "lax". Therefore, if the source schema and its
     * location are identified by means of an XML schemaLocation attribute, then
     * an XML processor will validate the elements for which it can find
     * declarations. If a source schema is not identified, or cannot be found at
     * the specified schemaLocation, then an XML validator will check for
     * well-formedness, but otherwise skip over the elements appearing in the
     * &lt;xmlData&gt; element.
     */
    @XmlElement(name = "xmlData", namespace = "http://www.loc.gov/METS/", required = false)
    protected XMLData xmlData;

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

    // attribute group METADATA begin

    /**
     * {@code
     * <xsd:attribute name="MDTYPE" use="required">
     * }
     * 
     * MDTYPE (string/R): Is used to indicate the type of the associated
     * metadata.
     */
    @XmlAttribute(name = "MDTYPE", required = true)
    protected MDTYPE MDTYPE;

    /**
     * {@code
     * <xsd:attribute name="OTHERMDTYPE" type="xsd:string" use="optional">
     * }
     * 
     * OTHERMDTYPE (string/O): Specifies the form of metadata in use when the
     * value OTHER is indicated in the MDTYPE attribute.
     */
    @XmlAttribute(name = "OTHERMDTYPE", required = false)
    protected String OTHERMDTYPE;

    /**
     * {@code
     * <xsd:attribute name="MDTYPEVERSION" type="xsd:string" use="optional">
     * }
     * 
     * MDTYPEVERSION(string/O): Provides a means for recording the version of
     * the type of metadata (as recorded in the MDTYPE or OTHERMDTYPE attribute)
     * that is being used. This may represent the version of the underlying data
     * dictionary or metadata model rather than a schema version.
     * 
     */
    @XmlAttribute(name = "MDTYPEVERSION", required = false)
    protected String MDTYPEVERSION;

    // attribute group METADATA end

    // attribute group FILECORE begin
    /**
     * {@code
     * <xsd:attribute name="MIMETYPE" type="xsd:string" use="optional">
     * }
     * 
     * MIMETYPE (string/O): The IANA MIME media type for the associated file or
     * wrapped content. Some values for this attribute can be found on the IANA
     * website.
     */
    @XmlAttribute(name = "MIMETYPE", required = false)
    protected String MIMETYPE;

    /**
     * {@code
     * <xsd:attribute name="SIZE" type="xsd:long" use="optional">
     * }
     * 
     * SIZE (long/O): Specifies the size in bytes of the associated file or
     * wrapped content.
     */
    @XmlAttribute(name = "SIZE", required = false)
    protected Long SIZE;

    /**
     * {@code
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATED (dateTime/O): Specifies the date and time of creation for the
     * associated file or wrapped content.
     */
    @XmlAttribute(name = "CREATED", required = false)
    protected String CREATED;

    /**
     * {@code
     * <xsd:attribute name="CHECKSUM" type="xsd:string" use="optional">
     * }
     * 
     * CHECKSUM (string/O): Provides a checksum value for the associated file or
     * wrapped content.
     */
    @XmlAttribute(name = "CHECKSUM", required = false)
    protected String CHECKSUM;

    /**
     * {@code
     * <xsd:attribute name="CHECKSUMTYPE" use="optional">
     * }
     * 
     * CHECKSUMTYPE (enumerated string/O): Specifies the checksum algorithm used
     * to produce the value contained in the CHECKSUM attribute.
     */
    @XmlAttribute(name = "CHECKSUMTYPE", required = false)
    protected CHECKSUMTYPE CHECKSUMTYPE;

    // attribute group FILECORE - end

    /**
     * {@code
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * }
     * 
     * LABEL: an optional string attribute providing a label to display to the
     * viewer of the METS document identifying the metadata.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    public String getBinData() {
        return binData;
    }

    public void setBinData(String binData) {
        this.binData = binData;
    }

    public XMLData getXmlData() {
        return xmlData;
    }

    public void setXmlData(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public MDTYPE getMDTYPE() {
        return MDTYPE;
    }

    public void setMDTYPE(MDTYPE mdType) {
        MDTYPE = mdType;
    }

    public String getOTHERMDTYPE() {
        return OTHERMDTYPE;
    }

    public void setOTHERMDTYPE(String otherMdType) {
        OTHERMDTYPE = otherMdType;
    }

    public String getMDTYPEVERSION() {
        return MDTYPEVERSION;
    }

    public void setMDTYPEVERSION(String mdTypeVersion) {
        MDTYPEVERSION = mdTypeVersion;
    }

    public String getMIMETYPE() {
        return MIMETYPE;
    }

    public void setMIMETYPE(String mimeType) {
        MIMETYPE = mimeType;
    }

    public Long getSIZE() {
        return SIZE;
    }

    public void setSIZE(Long size) {
        SIZE = size;
    }

    public String getCREATED() {
        return CREATED;
    }

    public void setCREATED(String created) {
        CREATED = created;
    }

    public String getCHECKSUM() {
        return CHECKSUM;
    }

    public void setCHECKSUM(String checksum) {
        CHECKSUM = checksum;
    }

    public CHECKSUMTYPE getCHECKSUMTYPE() {
        return CHECKSUMTYPE;
    }

    public void setCHECKSUMTYPE(CHECKSUMTYPE checksumType) {
        CHECKSUMTYPE = checksumType;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String label) {
        LABEL = label;
    }

    public static Builder builder() {
        return builder(new MdWrap());
    }

    public static Builder builder(MdWrap mw) {
        return new Builder(mw);
    }

    public static class Builder extends BuilderBase<MdWrap, Builder>
        implements IAttributeGroupMETADATABuilder<MdWrap, Builder>, IAttributeGroupFILECOREBuilder<MdWrap, Builder> {

        protected Builder(MdWrap mw) {
            super(mw);
        }

        public Builder binData(String binData) {
            _target().setBinData(binData);
            return _self();
        }

        public Builder xmlData(XMLData xmlData) {
            _target().setXmlData(xmlData);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder LABEL(String label) {
            _target().setLABEL(label);
            return _self();
        }
    }
}
