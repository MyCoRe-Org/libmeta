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
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupORDERLABELSBuilder;
import org.mycore.libmeta.mets.model._enums.AreaBETYPE;
import org.mycore.libmeta.mets.model._enums.AreaEXTTYPE;
import org.mycore.libmeta.mets.model._enums.AreaSHAPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupORDERLABELS;
import org.mycore.libmeta.mets.model._misc.URIs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * <xsd:complexType name="areaType">
 * 
 * areaType: Complex Type for Area Linking
 * 
 * The area element provides for more sophisticated linking between a div
 * element and content files representing that div, be they text, image, audio,
 * or video files. An area element can link a div to a point within a file, to a
 * one-dimension segment of a file (e.g., text segment, image line, audio/video
 * clip), or a two-dimensional section of a file (e.g, subsection of an image,
 * or a subsection of the video display of a video file. The area element has no
 * content; all information is recorded within its various attributes.
 * 
 * @author Robert Stephan
 * @version METS 1.11
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Area extends AreaOrSeqOrPar implements IAttributeGroupORDERLABELS{

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

    /**
     * <xsd:attribute name="FILEID" type="xsd:IDREF" use="required">
     * 
     * FILEID (IDREF/R): An attribute which provides the XML ID value that
     * identifies the &lt;file&gt; element in the &lt;fileSec&gt; that then
     * points to and/or contains the digital content represented by the
     * &lt;area&gt; element. It must contain an ID value represented in an ID
     * attribute associated with a &lt;file&gt; element in the &lt;fileSec&gt;
     * element in the same METS document.
     */
    @XmlAttribute(name = "FILEID", required = true)
    protected String FILEID;

    /**
     * <xsd:attribute name="SHAPE" use="optional">
     * 
     * SHAPE (string/O): An attribute that can be used as in HTML to define the
     * shape of the relevant area within the content file pointed to by the
     * &lt;area&gt; element. Typically this would be used with image content
     * (still image or video frame) when only a portion of an integal image map
     * pertains. If SHAPE is specified then COORDS must also be present. SHAPE
     * should be used in conjunction with COORDS in the manner defined for the
     * shape and coords attributes on an HTML4 &lt;area&gt; element.
     * 
     * SHAPE must contain one of the following values:
     * 
     * RECT
     * 
     * CIRCLE
     * 
     * POLY
     */
    @XmlAttribute(name = "SHAPE", required = false)
    protected AreaSHAPE SHAPE;

    /**
     * <xsd:attribute name="COORDS" type="xsd:string" use="optional">
     * 
     * COORDS (string/O): Specifies the coordinates in an image map for the
     * shape of the pertinent area as specified in the SHAPE attribute. While
     * technically optional, SHAPE and COORDS must both appear together to
     * define the relevant area of image content. COORDS should be used in
     * conjunction with SHAPE in the manner defined for the COORDs and SHAPE
     * attributes on an HTML4 &lt;area&gt; element. COORDS must be a comma
     * delimited string of integer value pairs representing coordinates (plus
     * radius in the case of CIRCLE) within an image map. Number of coordinates
     * pairs depends on shape: RECT: x1, y1, x2, y2; CIRC: x1, y1; POLY: x1, y1,
     * x2, y2, x3, y3 . . .
     */
    @XmlAttribute(name = "COORDS", required = false)
    protected String COORDS;

    /**
     * <xsd:attribute name="BEGIN" type="xsd:string" use="optional">
     * 
     * BEGIN (string/O): An attribute that specifies the point in the content
     * file where the relevant section of content begins. It can be used in
     * conjunction with either the END attribute or the EXTENT attribute as a
     * means of defining the relevant portion of the referenced file precisely.
     * It can only be interpreted meaningfully in conjunction with the BETYPE or
     * EXTTYPE, which specify the kind of beginning/ending point values or
     * beginning/extent values that are being used. The BEGIN attribute can be
     * used with or without a companion END or EXTENT element. In this case, the
     * end of the content file is assumed to be the end point.
     */
    @XmlAttribute(name = "BEGIN", required = false)
    protected String BEGIN;

    /**
     * <xsd:attribute name="END" type="xsd:string" use="optional">
     * 
     * END (string/O): An attribute that specifies the point in the content file
     * where the relevant section of content ends. It can only be interpreted
     * meaningfully in conjunction with the BETYPE, which specifies the kind of
     * ending point values being used. Typically the END attribute would only
     * appear in conjunction with a BEGIN element.
     */
    @XmlAttribute(name = "END", required = false)
    protected String END;

    /**
     * <xsd:attribute name="BETYPE" use="optional">
     * 
     * BETYPE: Begin/End Type.
     * 
     * BETYPE (string/O): An attribute that specifies the kind of BEGIN and/or
     * END values that are being used. For example, if BYTE is specified, then
     * the BEGIN and END point values represent the byte offsets into a file. If
     * IDREF is specified, then the BEGIN element specifies the ID value that
     * identifies the element in a structured text file where the relevant
     * section of the file begins; and the END value (if present) would specify
     * the ID value that identifies the element with which the relevant section
     * of the file ends.
     * 
     * Must be one of the following values:
     * 
     * BYTE
     * IDREF
     * SMIL
     * MIDI
     * SMPTE-25
     * SMPTE-24
     * SMPTE-DF30
     * SMPTE-NDF30
     * SMPTE-DF29.97
     * SMPTE-NDF29.97
     * TIME
     * TCF
     * XPTR
     */
    @XmlAttribute(name = "BETYPE", required = false)
    protected AreaBETYPE BETYPE;

    /**
     * <xsd:attribute name="EXTENT" type="xsd:string" use="optional">
     * 
     * EXTENT (string/O): An attribute that specifies the extent of the relevant
     * section of the content file. Can only be interpreted meaningfully in
     * conjunction with the EXTTYPE which specifies the kind of value that is
     * being used. Typically the EXTENT attribute would only appear in
     * conjunction with a BEGIN element and would not be used if the BEGIN point
     * represents an IDREF.
     */
    @XmlAttribute(name = "EXTEND", required = false)
    protected String EXTEND;

    /**
     * <xsd:attribute name="EXTTYPE" use="optional">
     * 
     * EXTTYPE (string/O): An attribute that specifies the kind of EXTENT values
     * that are being used. For example if BYTE is specified then EXTENT would
     * represent a byte count. If TIME is specified the EXTENT would represent a
     * duration of time.
     * 
     * EXTTYPE must be one of the following values:
     * 
     * BYTE
     * 
     * SMIL
     * 
     * MIDI
     * 
     * SMPTE-25
     * 
     * SMPTE-24
     * 
     * SMPTE-DF30
     * 
     * SMPTE-NDF30
     * 
     * SMPTE-DF29.97
     * 
     * SMPTE-NDF29.97
     * 
     * TIME
     * 
     * TCF.
     */
    @XmlAttribute(name = "EXTTYPE", required = false)
    protected AreaEXTTYPE EXTTYPE;

    /**
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;rightsMD&gt;, &lt;sourceMD&gt;, &lt;techMD&gt; and/or
     * &lt;digiprovMD&gt; elements within the &lt;amdSec&gt; of the METS
     * document that contain or link to administrative metadata pertaining to
     * the content represented by the &lt;area&gt; element. Typically the
     * &lt;area&gt; ADMID attribute would be used to identify the
     * &lt;rightsMD&gt; element or elements that pertain to the &lt;area&gt;,
     * but it could be used anytime there was a need to link an &lt;area&gt;
     * with pertinent administrative metadata. For more information on using
     * METS IDREFS and IDREF type attributes for internal linking, see Chapter 4
     * of the METS Primer
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * <xsd:attribute name="CONTENTIDS" type="URIs" use="optional">
     * 
     * CONTENTIDS (URI/O): Content IDs for the content represented by the
     * &lt;area&gt; (equivalent to DIDL DII or Digital Item Identifier, a unique
     * external ID).
     */
    @XmlAttribute(name = "CONTENTIDS", required = false)
    protected URIs CONTENTIDS = new URIs();
    
    //AttributeGroup ORDERLABELS - begin
    
    @XmlAttribute(name = "ORDER", required = false)
    protected Integer ORDER;
    
    @XmlAttribute(name = "ORDERLABEL", required = false)
    protected String ORDERLABEL;
    
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;
    
    //AttributeGroup ORDERLABES - end
    
    /**
   	 * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
   	 */
   	@XmlAnyAttribute
   	protected Map<QName, String> otherAttributes = new HashMap<QName, String>();


	public String getID() {
		return ID;
	}


	public void setID(String id) {
		ID = id;
	}


	public String getFILEID() {
		return FILEID;
	}


	public void setFILEID(String fileId) {
		FILEID = fileId;
	}


	public AreaSHAPE getSHAPE() {
		return SHAPE;
	}


	public void setSHAPE(AreaSHAPE shape) {
		SHAPE = shape;
	}


	public String getCOORDS() {
		return COORDS;
	}

	public void setCOORDS(String coords) {
		COORDS = coords;
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

	public AreaBETYPE getBETYPE() {
		return BETYPE;
	}

	public void setBETYPE(AreaBETYPE beType) {
		BETYPE = beType;
	}

	public String getEXTEND() {
		return EXTEND;
	}

	public void setEXTEND(String extend) {
		EXTEND = extend;
	}

	public AreaEXTTYPE getEXTTYPE() {
		return EXTTYPE;
	}

	public void setEXTTYPE(AreaEXTTYPE extType) {
		EXTTYPE = extType;
	}

	public String getADMID() {
		return ADMID;
	}

	public void setADMID(String admId) {
		ADMID = admId;
	}

	public URIs getCONTENTIDS() {
		return CONTENTIDS;
	}

	public void setCONTENTIDS(URIs contentIDs) {
		CONTENTIDS = contentIDs;
	}

	public Integer getORDER() {
		return ORDER;
	}

	public void setORDER(Integer order) {
		ORDER = order;
	}

	public String getORDERLABEL() {
		return ORDERLABEL;
	}

	public void setORDERLABEL(String orderLabel) {
		ORDERLABEL = orderLabel;
	}

	public String getLABEL() {
		return LABEL;
	}

	public void setLABEL(String label) {
		LABEL = label;
	}

	public Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}

	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
   	
	 public static Builder builder() {
	        return builder(new Area());
	    }

	    public static Builder builder(Area a) {
	        return new Builder(a);
	    }

	    public static class Builder extends BuilderBase<Area, Builder> implements IAttributeGroupORDERLABELSBuilder<Area, Builder> {

	        protected Builder(Area a) {
	            super(a);
	        }

		public Builder ID(String id) {
			_target().setID(id);
			return _self();
		}

		public Builder FILEID(String fileID) {
		    _target().setFILEID(fileID);
			return _self();
		}
		
		public Builder SHAPE(AreaSHAPE shape) {
			_target().setSHAPE(shape);
			return _self();
		}

		public Builder COORDS(String coords) {
			_target().setCOORDS(coords);
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

		public Builder BETYPE(AreaBETYPE beType) {
		    _target().setBETYPE(beType);
			return _self();
		}

		public Builder EXTEND(String extend) {
		    _target().setEXTEND(extend);
			return _self();
		}
		
		public Builder EXTTYPE(AreaEXTTYPE extType) {
		    _target().setEXTTYPE(extType);
			return _self();
		}
		
		public Builder ADMID(String admID) {
		    _target().setADMID(admID);
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
		    }
		    catch(URISyntaxException e) {
		        //ignore
		    }
            
            return addCONTENTID(u);
        }
				
		public Builder addOtherAttribute(QName name, String value) {
			_target().getOtherAttributes().put(name, value);
			return _self();
		}
	}
}
