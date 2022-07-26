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
package org.mycore.libmeta.mets.model.filesec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupFILECOREBuilder;
import org.mycore.libmeta.mets.model._enums.BETYPE;
import org.mycore.libmeta.mets.model._enums.CHECKSUMTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupFILECORE;
import org.mycore.libmeta.mets.model.filesec.file.FContent;
import org.mycore.libmeta.mets.model.filesec.file.FLocat;
import org.mycore.libmeta.mets.model.filesec.file.Stream;
import org.mycore.libmeta.mets.model.filesec.file.TransformFile;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <xsd:complexType name="fileType">
 * 
 * fileType: Complex Type for Files
 * 
 * The file element provides access to content files for a METS object. A file
 * element may contain one or more FLocat elements, which provide pointers to a
 * content file, and/or an FContent element, which wraps an encoded version of
 * the file. Note that ALL FLocat and FContent elements underneath a single file
 * element should identify/contain identical copies of a single file.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "fLocat", "fContent", "stream", "transformFile", "file" })
public class File implements IAttributeGroupFILECORE {
    // <xsd:sequence>
    /**
     * <xsd:element name="FLocat" minOccurs="0" maxOccurs="unbounded">
     * 
     * The file location element &lt;FLocat&gt; provides a pointer to the
     * location of a content file. It uses the XLink reference syntax to provide
     * linking information indicating the actual location of the content file,
     * along with other attributes specifying additional linking information.
     * NOTE: &lt;FLocat&gt; is an empty element. The location of the resource
     * pointed to MUST be stored in the xlink:href attribute.
     */
    @XmlElement(name = "FLocat", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<FLocat> fLocat = new Vector<>();

    /**
     * <xsd:element name="FContent" minOccurs="0">
     * 
     * The file content element &lt;FContent&gt; is used to identify a content
     * file contained internally within a METS document. The content file must
     * be either Base64 encoded and contained within the subsidiary
     * &lt;binData&gt; wrapper element, or consist of XML information and be
     * contained within the subsidiary &lt;xmlData&gt; wrapper element.
     */
    @XmlElement(name = "FContent", namespace = "http://www.loc.gov/METS/", required = false)
    protected FContent fContent;

    /**
     * <xsd:element name="stream" minOccurs="0" maxOccurs="unbounded">
     * 
     * A component byte stream element &lt;stream&gt; may be composed of one or
     * more subsidiary streams. An MPEG4 file, for example, might contain
     * separate audio and video streams, each of which is associated with
     * technical metadata. The repeatable &lt;stream&gt; element provides a
     * mechanism to record the existence of separate data streams within a
     * particular file, and the opportunity to associate &lt;dmdSec&gt; and
     * &lt;amdSec&gt; with those subsidiary data streams if desired.
     * </xsd:documentation>
     */
    @XmlElement(name = "stream", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Stream> stream = new Vector<>();

    /**
     * <xsd:element name="transformFile" minOccurs="0" maxOccurs="unbounded">
     * 
     * The transform file element &lt;transformFile&gt; provides a means to
     * access any subsidiary files listed below a &lt;file&gt; element by
     * indicating the steps required to "unpack" or transform the subsidiary
     * files. This element is repeatable and might provide a link to a
     * &lt;behavior&gt; in the &lt;behaviorSec&gt; that performs the
     * transformation.</xsd:documentation>
     */
    @XmlElement(name = "transformFile", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<TransformFile> transformFile = new Vector<>();

    /**
     * <xsd:element name="file" type="fileType" minOccurs="0"
     * maxOccurs="unbounded" />
     */
    @XmlElement(name = "file", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<File> file = new Vector<>();

    /**
     * <xsd:attribute name="ID" type="xsd:ID" use="required"> //TODO-CHECK: ID
     * required
     * 
     * ID (ID/R): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. Typically, the ID
     * attribute value on a &lt;file&gt; element would be referenced from one or
     * more FILEID attributes (which are of type IDREF) on &lt;fptr&gt;and/or
     * &lt;area&gt; elements within the &lt;structMap&gt;. Such references
     * establish links between structural divisions (&lt;div&gt; elements) and
     * the specific content files or parts of content files that manifest them.
     * For more information on using ID attributes for internal and external
     * linking see Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ID", required = true)
    protected String ID;

    /**
     * <xsd:attribute name="SEQ" type="xsd:int" use="optional">
     * 
     * SEQ (integer/O): Indicates the sequence of this &lt;file&gt; relative to
     * the others in its &lt;fileGrp&gt;.
     */
    @XmlAttribute(name = "SEQ", required = false)
    protected String SEQ;

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
     * <xsd:attribute name="OWNERID" type="xsd:string" use="optional">
     * 
     * OWNERID (string/O): A unique identifier assigned to the file by its
     * owner. This may be a URI which differs from the URI used to retrieve the
     * file.
     */
    @XmlAttribute(name = "OWNERID", required = false)
    protected String OWNERID;

    /**
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values of the &lt;techMD&gt;,
     * &lt;sourceMD&gt;, &lt;rightsMD&gt; and/or &lt;digiprovMD&gt; elements
     * within the &lt;amdSec&gt; of the METS document that contain
     * administrative metadata pertaining to the file. For more information on
     * using METS IDREFS and IDREF type attributes for internal linking, see
     * Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * <xsd:attribute name="DMDID" type="xsd:IDREFS" use="optional">
     * 
     * >DMDID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;dmdSec&gt;, elements in the METS document that contain or link to
     * descriptive metadata pertaining to the content file represented by the
     * current &lt;file&gt; element. For more information on using METS IDREFS
     * and IDREF type attributes for internal linking, see Chapter 4 of the METS
     * Primer.
     */
    @XmlAttribute(name = "DMDID", required = false)
    protected String DMDID;

    /**
     * <xsd:attribute name="GROUPID" type="xsd:string" use="optional">
     * 
     * GROUPID (string/O): An identifier that establishes a correspondence
     * between this file and files in other file groups. Typically, this will be
     * used to associate a master file in one file group with the derivative
     * files made from it in other file groups.
     */
    @XmlAttribute(name = "GROUPID", required = false)
    protected String GROUPID;

    /**
     * <xsd:attribute name="USE" type="xsd:string" use="optional">
     * 
     * USE (string/O): A tagging attribute to indicate the intended use of all
     * copies of the file aggregated by the &lt;file&gt; element (e.g., master,
     * reference, thumbnails for image files). A USE attribute can be expressed
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

    /**
     * <xsd:attribute name="BEGIN" type="xsd:string" use="optional">
     * 
     * BEGIN (string/O): An attribute that specifies the point in the parent
     * &lt;file&gt; where the current &lt;file&gt; begins. When used in
     * conjunction with a &lt;file&gt; element, this attribute is only
     * meaningful when this element is nested, and its parent &lt;file&gt;
     * element represents a container file. It can be used in conjunction with
     * the END attribute as a means of defining the location of the current file
     * within its parent file. However, the BEGIN attribute can be used with or
     * without a companion END attribute. When no END attribute is specified,
     * the end of the parent file is assumed also to be the end point of the
     * current file. The BEGIN and END attributes can only be interpreted
     * meaningfully in conjunction with a BETYPE attribute, which specifies the
     * kind of beginning/ending point values that are being used.
     */
    @XmlAttribute(name = "BEGIN", required = false)
    protected String BEGIN;

    /**
     * <xsd:attribute name="END" type="xsd:string" use="optional">
     * 
     * END (string/O): An attribute that specifies the point in the parent
     * &lt;file&gt; where the current, nested &lt;file&gt; ends. It can only be
     * interpreted meaningfully in conjunction with the BETYPE, which specifies
     * the kind of ending point values being used. Typically the END attribute
     * would only appear in conjunction with a BEGIN attribute.
     */
    @XmlAttribute(name = "END", required = false)
    protected String END;

    /**
     * <xsd:attribute name="BETYPE" use="optional">
     * 
     * BETYPE: Begin/End Type.
     * 
     * BETYPE (string/O): An attribute that specifies the kind of BEGIN and/or
     * END values that are being used. Currently BYTE is the only valid value
     * that can be used in conjunction with nested &lt;file&gt; or
     * &lt;stream&gt; elements.
     */
    @XmlAttribute(name = "BETYPE", required = false)
    protected BETYPE BETYPE;

    /**
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public File() {

    }

    public List<FLocat> getFLocat() {
        return fLocat;
    }

    public FContent getFContent() {
        return fContent;
    }

    public void setFContent(FContent fContent) {
        this.fContent = fContent;
    }

    public List<Stream> getStream() {
        return stream;
    }

    public List<TransformFile> getTransformFile() {
        return transformFile;
    }

    public List<File> getFile() {
        return file;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getSEQ() {
        return SEQ;
    }

    public void setSEQ(String seq) {
        SEQ = seq;
    }

    public String getMIMETYPE() {
        return MIMETYPE;
    }

    public void setMIMETYPE(String mimetype) {
        MIMETYPE = mimetype;
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

    public String getOWNERID() {
        return OWNERID;
    }

    public void setOWNERID(String ownerId) {
        OWNERID = ownerId;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String admId) {
        ADMID = admId;
    }

    public String getDMDID() {
        return DMDID;
    }

    public void setDMDID(String dmdId) {
        DMDID = dmdId;
    }

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String groupId) {
        GROUPID = groupId;
    }

    public String getUSE() {
        return USE;
    }

    public void setUSE(String use) {
        USE = use;
    }

    public String getBEGIN() {
        return BEGIN;
    }

    public void setBEGIN(String begin) {
        BEGIN = begin;
    }

    public String getEND() {
        return END;
    }

    public void setEND(String end) {
        END = end;
    }

    public BETYPE getBETYPE() {
        return BETYPE;
    }

    public void setBETYPE(BETYPE beType) {
        BETYPE = beType;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new File());
    }

    public static Builder builder(File f) {
        return new Builder(f);
    }

    public static class Builder extends BuilderBase<File, Builder> implements IAttributeGroupFILECOREBuilder<File, Builder> {

        protected Builder(File f) {
            super(f);
        }

        public Builder addFLocat(FLocat fLocat) {
            _target().getFLocat().add(fLocat);
            return _self();
        }

        public Builder fContent(FContent fContent) {
            _target().setFContent(fContent);
            return _self();
        }

        public Builder addStream(Stream stream) {
            _target().getStream().add(stream);
            return _self();
        }

        public Builder addTransformFile(TransformFile transformFile) {
            _target().getTransformFile().add(transformFile);
            return _self();
        }

        public Builder addFile(File file) {
            _target().getFile().add(file);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder SEQ(String seq) {
            _target().setSEQ(seq);
            return _self();
        }

        public Builder OWNERID(String ownerID) {
            _target().setOWNERID(ownerID);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }

        public Builder DMDID(String dmdID) {
            _target().setDMDID(dmdID);
            return _self();
        }

        public Builder GROUPID(String groupID) {
            _target().setGROUPID(groupID);
            return _self();
        }

        public Builder USE(String use) {
            _target().setUSE(use);
            return _self();
        }

        public Builder BEGIN(String begin) {
            _target().setBEGIN(begin);
            return _self();
        }

        public Builder END(String end) {
            _target().setEND(end);
            return _self();
        }

        public Builder BETYPE(BETYPE beType) {
            _target().setBETYPE(beType);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
