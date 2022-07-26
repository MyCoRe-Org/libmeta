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
package org.mycore.libmeta.mets.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model.behaviorsec.BehaviorSec;
import org.mycore.libmeta.mets.model.filesec.FileSec;
import org.mycore.libmeta.mets.model.mdsec.AmdSec;
import org.mycore.libmeta.mets.model.mdsec.MdSec;
import org.mycore.libmeta.mets.model.metshdr.MetsHdr;
import org.mycore.libmeta.mets.model.structlink.StructLink;
import org.mycore.libmeta.mets.model.structmap.StructMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This class implements a model for METS in tries to be as close as possible to
 * the XML Schema. based on METS XML Schema
 * 
 *         A METS document consists of seven possible subsidiary sections:

 *         metsHdr (METS document header), 
 *         
 *         dmdSec (descriptive metadata section), 
 *         
 *         amdSec (administrative metadata section), 
 *         
 *         fileGrp (file inventory group), 
 *         
 *         structLink (structural map linking), 
 *         
 *         structMap (structural map) 
 *         
 *         and behaviorSec (behaviors section).
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10 
 */

@XmlRootElement(name = "mets", namespace = "http://www.loc.gov/METS/")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "metsHdr", "dmdSec", "amdSec", "fileSec", "structMap", "structLink", "behaviorSec" })
public class Mets {
    //<xsd:sequence>

    /**
     * <xsd:element name="metsHdr" minOccurs="0"> The mets header element
     * &lt;metsHdr&gt; captures metadata about the METS document itself, not the
     * digital object the METS document encodes. Although it records a more
     * limited set of metadata, it is very similar in function and purpose to
     * the headers employed in other schema such as the Text Encoding Initiative
     * (TEI) or in the Encoded Archival Description (EAD).
     */
    @XmlElement(name = "metsHdr", namespace = "http://www.loc.gov/METS/", required = false)
    protected MetsHdr metsHdr;

    /**
     * <xsd:element name="dmdSec" type="mdSecType" minOccurs="0"
     * maxOccurs="unbounded"> A descriptive metadata section &lt;dmdSec&gt;
     * records descriptive metadata pertaining to the METS object as a whole or
     * one of its components. The &lt;dmdSec&gt; element conforms to same
     * generic datatype as the &lt;techMD&gt;, &lt;rightsMD&gt;,
     * &lt;sourceMD&gt; and &lt;digiprovMD&gt; elements, and supports the same
     * sub-elements and attributes. A descriptive metadata element can either
     * wrap the metadata (mdWrap) or reference it in an external location
     * (mdRef) or both. METS allows multiple &lt;dmdSec&gt; elements; and
     * descriptive metadata can be associated with any METS element that
     * supports a DMDID attribute. Descriptive metadata can be expressed
     * according to many current description standards (i.e., MARC, MODS, Dublin
     * Core, TEI Header, EAD, VRA, FGDC, DDI) or a locally produced XML schema.
     */
    @XmlElement(name = "dmdSec", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<MdSec> dmdSec = new Vector<MdSec>();

    /**
     * <xsd:element name="amdSec" type="amdSecType" minOccurs="0"
     * maxOccurs="unbounded"> The administrative metadata section &lt;amdSec&gt;
     * contains the administrative metadata pertaining to the digital object,
     * its components and any original source material from which the digital
     * object is derived. The &lt;amdSec&gt; is separated into four sub-sections
     * that accommodate technical metadata (techMD), intellectual property
     * rights (rightsMD), analog/digital source metadata (sourceMD), and digital
     * provenance metadata (digiprovMD). Each of these subsections can either
     * wrap the metadata (mdWrap) or reference it in an external location
     * (mdRef) or both. Multiple instances of the &lt;amdSec&gt; element can
     * occur within a METS document and multiple instances of its subsections
     * can occur in one &lt;amdSec&gt; element. This allows considerable
     * flexibility in the structuring of the administrative metadata. METS does
     * not define a vocabulary or syntax for encoding administrative metadata.
     * Administrative metadata can be expressed within the amdSec sub-elements
     * according to many current community defined standards, or locally
     * produced XML schemas. </xsd:documentation>
     */
    @XmlElement(name = "amdSec", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<AmdSec> amdSec = new Vector<AmdSec>();

    /**
     * <xsd:element name="fileSec" minOccurs="0"> The overall purpose of the
     * content file section element &lt;fileSec&gt; is to provide an inventory
     * of and the location for the content files that comprise the digital
     * object being described in the METS document.
     */
    @XmlElement(name = "fileSec", namespace = "http://www.loc.gov/METS/", required = false)
    protected FileSec fileSec;

    /**
     * <xsd:element name="structMap" type="structMapType" maxOccurs="unbounded">
     * The structural map section &lt;structMap&gt; is the heart of a METS
     * document. It provides a means for organizing the digital content
     * represented by the &lt;file&gt; elements in the &lt;fileSec&gt; of the
     * METS document into a coherent hierarchical structure. Such a hierarchical
     * structure can be presented to users to facilitate their comprehension and
     * navigation of the digital content. It can further be applied to any
     * purpose requiring an understanding of the structural relationship of the
     * content files or parts of the content files. The organization may be
     * specified to any level of granularity (intellectual and or physical) that
     * is desired. Since the &lt;structMap&gt; element is repeatable, more than
     * one organization can be applied to the digital content represented by the
     * METS document. The hierarchical structure specified by a
     * &lt;structMap&gt; is encoded as a tree of nested &lt;div&gt; elements. A
     * &lt;div&gt; element may directly point to content via child file pointer
     * &lt;fptr&gt; elements (if the content is represented in the
     * &lt;fileSec&lt;) or child METS pointer &lt;mptr&gt; elements (if the
     * content is represented by an external METS document). The &lt;fptr&gt;
     * element may point to a single whole &lt;file&gt; element that manifests
     * its parent &lt;div&lt;, or to part of a &lt;file&gt; that manifests its
     * &lt;div&lt;. It can also point to multiple files or parts of files that
     * must be played/displayed either in sequence or in parallel to reveal its
     * structural division. In addition to providing a means for organizing
     * content, the &lt;structMap&gt; provides a mechanism for linking content
     * at any hierarchical level with relevant descriptive and administrative
     * metadata.
     */
    @XmlElement(name = "structMap", namespace = "http://www.loc.gov/METS/", required = true)
    protected List<StructMap> structMap = new Vector<StructMap>();

    /**
     * <xsd:element name="structLink" minOccurs="0"> The structural link section
     * element &lt;structLink&gt; allows for the specification of hyperlinks
     * between the different components of a METS structure that are delineated
     * in a structural map. This element is a container for a single, repeatable
     * element, &lt;smLink&gt; which indicates a hyperlink between two nodes in
     * the structural map. The &lt;structLink&gt; section in the METS document
     * is identified using its XML ID attributes.
     */
    @XmlElement(name = "structLink", namespace = "http://www.loc.gov/METS/", required = false)
    protected StructLink structLink;

    /**
     * <xsd:element name="behaviorSec" type="behaviorSecType" minOccurs="0"
     * maxOccurs="unbounded"> A behavior section element &lt;behaviorSec&gt;
     * associates executable behaviors with content in the METS document by
     * means of a repeatable behavior &lt;behavior&gt; element. This element has
     * an interface definition &lt;interfaceDef&gt; element that represents an
     * abstract definition of the set of behaviors represented by a particular
     * behavior section. A &lt;behavior&gt; element also has a &lt;mechanism&gt;
     * element which is used to point to a module of executable code that
     * implements and runs the behavior defined by the interface definition. The
     * &lt;behaviorSec&gt; element, which is repeatable as well as nestable, can
     * be used to group individual behaviors within the structure of the METS
     * document. Such grouping can be useful for organizing families of
     * behaviors together or to indicate other relationships between particular
     * behaviors.</xsd:documentation>
     */
    @XmlElement(name = "behaviorSec", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<BehaviorSec> behaviorSec = new Vector<BehaviorSec>();

    /**
     * <xsd:attribute name="ID" type="xsd:ID" use="optional"> ID (ID/O): This
     * attribute uniquely identifies the element within the METS document, and
     * would allow the element to be referenced unambiguously from another
     * element or document via an IDREF or an XPTR. For more information on
     * using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    /**
     * <xsd:attribute name="OBJID" type="xsd:string" use="optional"> OBJID
     * (string/O): Is the primary identifier assigned to the METS object as a
     * whole. Although this attribute is not required, it is strongly
     * recommended. This identifier is used to tag the entire METS object to
     * external systems, in contrast with the ID identifier.
     */
    @XmlAttribute(name = "OBJID", required = false)
    protected String OBJID;

    /**
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional"> LABEL
     * (string/O): Is a simple title string used to identify the object/entity
     * being described in the METS document for the user.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    /**
     * <xsd:attribute name="TYPE" type="xsd:string" use="optional"> TYPE
     * (string/O): Specifies the class or type of the object, e.g.: book,
     * journal, stereograph, dataset, video, etc.
     */
    @XmlAttribute(name = "TYPE", required = false)
    protected String TYPE;

    /**
     * <xsd:attribute name="PROFILE" type="xsd:string" use="optional"> PROFILE
     * (string/O): Indicates to which of the registered profile(s) the METS
     * document conforms. For additional information about PROFILES see Chapter
     * 5 of the METS Primer.
     */
    @XmlAttribute(name = "PROFILE", required = false)
    protected String PROFILE;

    /**
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @XmlAttribute(name = "schemaLocation", namespace = "http://www.w3.org/2001/XMLSchema-instance", required = false)
    protected String xsiSchemaLocation;

    public MetsHdr getMetsHdr() {
        return metsHdr;
    }

    public void setMetsHdr(MetsHdr metsHdr) {
        this.metsHdr = metsHdr;
    }

    public List<MdSec> getDmdSec() {
        return dmdSec;
    }

    public List<AmdSec> getAmdSec() {
        return amdSec;
    }

    public FileSec getFileSec() {
        return fileSec;
    }

    public void setFileSec(FileSec fileSec) {
        this.fileSec = fileSec;
    }

    public List<StructMap> getStructMap() {
        return structMap;
    }

    public StructLink getStructLink() {
        return structLink;
    }

    public void setStructLink(StructLink structLink) {
        this.structLink = structLink;
    }

    public List<BehaviorSec> getBehaviorSec() {
        return behaviorSec;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getOBJID() {
        return OBJID;
    }

    public void setOBJID(String oBJID) {
        OBJID = oBJID;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String lABEL) {
        LABEL = lABEL;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }

    public String getPROFILE() {
        return PROFILE;
    }

    public void setPROFILE(String pROFILE) {
        PROFILE = pROFILE;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }

    public void setXsiSchemaLocation(String xsiSchemaLocation) {
        this.xsiSchemaLocation = xsiSchemaLocation;
    }

    public static Builder builder() {
        return builder(new Mets());
    }

    public static Builder builder(Mets mets) {
        return new Builder(mets);
    }

    public static class Builder extends BuilderBase<Mets, Builder> {

        protected Builder(Mets mets) {
            super(mets);
        }

        public Builder metsHdr(MetsHdr metsHdr) {
            _target().setMetsHdr(metsHdr);
            return _self();
        }

        public Builder addDmdSec(MdSec mdSec) {
            _target().getDmdSec().add(mdSec);
            return _self();
        }

        public Builder addAmdSec(AmdSec amdSec) {
            _target().getAmdSec().add(amdSec);
            return _self();
        }

        public Builder fileSec(FileSec fileSec) {
            _target().setFileSec(fileSec);
            return _self();
        }

        public Builder addStructMap(StructMap sm) {
            _target().getStructMap().add(sm);
            return _self();
        }

        public Builder structLink(StructLink sl) {
            _target().setStructLink(sl);
            return _self();
        }

        public Builder addBehaviorSec(BehaviorSec bs) {
            _target().getBehaviorSec().add(bs);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder OBJID(String objId) {
            _target().setOBJID(objId);
            return _self();
        }

        public Builder LABEL(String label) {
            _target().setLABEL(label);
            return _self();
        }

        public Builder TYPE(String type) {
            _target().setTYPE(type);
            return _self();
        }

        public Builder PROFILE(String profile) {
            _target().setPROFILE(profile);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }

        public Builder xsiSchemaLocation(String schemaLocation) {
            _target().setXsiSchemaLocation(schemaLocation);
            return _self();
        }
    }
}
