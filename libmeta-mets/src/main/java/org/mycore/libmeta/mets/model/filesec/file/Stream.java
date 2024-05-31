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
import org.mycore.libmeta.mets.model._enums.BETYPE;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xsd:element name="stream" minOccurs="0" maxOccurs="unbounded">
 * }
 * 
 * A component byte stream element &lt;stream&gt; may be composed of one or more
 * subsidiary streams. An MPEG4 file, for example, might contain separate audio
 * and video streams, each of which is associated with technical metadata. The
 * repeatable &lt;stream&gt; element provides a mechanism to record the
 * existence of separate data streams within a particular file, and the
 * opportunity to associate &lt;dmdSec&gt; and &lt;amdSec&gt; with those
 * subsidiary data streams if desired.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Stream {
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

    /**
     * {@code
     * <xsd:attribute name="streamType" type="xsd:string" use="optional">
     * }
     * 
     * streamType (string/O): The IANA MIME media type for the
     * bytestream.
     */
    @XmlAttribute(name = "streamType", required = false)
    protected String streamType;

    /**
     * {@code
     * <xsd:attribute name="OWNERID" type="xsd:string" use="optional">
     * }
     * 
     * OWNERID (string/O): Used to provide a unique identifier (which could
     * include a URI) assigned to the file. This identifier may differ from the
     * URI used to retrieve the file.
     */
    @XmlAttribute(name = "OWNERID", required = false)
    protected String OWNERID;

    /**
     * {@code
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values of the &lt;techMD&gt;,
     * &lt;sourceMD&gt;, &lt;rightsMD&gt; and/or &lt;digiprovMD&gt; elements
     * within the &lt;amdSec&gt; of the METS document that contain
     * administrative metadata pertaining to the bytestream. For more
     * information on using METS IDREFS and IDREF type attributes for internal
     * linking, see Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * {@code
     * <xsd:attribute name="DMDID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * DMDID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;dmdSec&gt;, elements in the METS document that contain or link to
     * descriptive metadata pertaining to the content file stream represented by
     * the current &lt;stream&gt; element. For more information on using METS
     * IDREFS and IDREF type attributes for internal linking, see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "DMDID", required = false)
    protected String DMDID;

    /**
     * {@code
     * <xsd:attribute name="BEGIN" type="xsd:string" use="optional">
     * }
     * 
     * BEGIN (string/O): An attribute that specifies the point in the parent
     * &lt;file&gt; where the current &lt;stream&gt; begins. It can be used in
     * conjunction with the END attribute as a means of defining the location of
     * the stream within its parent file. However, the BEGIN attribute can be
     * used with or without a companion END attribute. When no END attribute is
     * specified, the end of the parent file is assumed also to be the end point
     * of the stream. The BEGIN and END attributes can only be interpreted
     * meaningfully in conjunction with a BETYPE attribute, which specifies the
     * kind of beginning/ending point values that are being used.
     */
    @XmlAttribute(name = "BEGIN", required = false)
    protected String BEGIN;

    /**
     * {@code
     * <xsd:attribute name="END" type="xsd:string" use="optional">
     * }
     * 
     * END (string/O): An attribute that specifies the point in the parent
     * &lt;file&gt; where the &lt;stream&gt; ends. It can only be interpreted
     * meaningfully in conjunction with the BETYPE, which specifies the kind of
     * ending point values being used. Typically the END attribute would only
     * appear in conjunction with a BEGIN attribute.
     */
    @XmlAttribute(name = "END", required = false)
    protected String END;

    /**
     * {@code
     * <xsd:attribute name="BETYPE" use="optional">
     * }
     * 
     * BETYPE: Begin/End Type.
     * 
     * BETYPE (string/O): An attribute that specifies the kind of BEGIN and/or
     * END values that are being used. Currently BYTE is the only valid value
     * that can be used in conjunction with nested &lt;file&gt; or
     * &lt;stream&gt; elements.
     */
    @XmlAttribute(name = "BETYPE, required=false")
    protected BETYPE BETYPE;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
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

    public static Builder builder() {
        return builder(new Stream());
    }

    public static Builder builder(Stream s) {
        return new Builder(s);
    }

    public static class Builder extends BuilderBase<Stream, Builder> {

        protected Builder(Stream s) {
            super(s);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder streamType(String streamType) {
            _target().setStreamType(streamType);
            return _self();
        }

        public Builder OWNERID(String ownerId) {
            _target().setOWNERID(ownerId);
            return _self();
        }

        public Builder ADMID(String admId) {
            _target().setADMID(admId);
            return _self();
        }

        public Builder DMDID(String dmdID) {
            _target().setDMDID(dmdID);
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
    }
}
