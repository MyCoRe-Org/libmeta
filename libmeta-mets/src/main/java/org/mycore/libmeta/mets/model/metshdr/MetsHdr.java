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
package org.mycore.libmeta.mets.model.metshdr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * {@code
 * <xsd:element name="metsHdr" minOccurs="0">
 * }
 * 
 * The mets header element &lt;metsHdr&gt; captures metadata about the METS
 * document itself, not the digital object the METS document encodes. Although
 * it records a more limited set of metadata, it is very similar in function and
 * purpose to the headers employed in other schema such as the Text Encoding
 * Initiative (TEI) or in the Encoded Archival Description (EAD).
 * 
 * @author Robert Stephan
 * @version METS 1.10
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "agent", "altRecordID", "metsDocumentID" })
public class MetsHdr {
    // <xsd:sequence>

    /**
     * {@code
     * <xsd:element name="agent" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * The agent element &lt;agent&gt; provides for various parties and their
     * roles with respect to the METS record to be documented.
     */
    @XmlElement(name = "agent", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Agent> agent = new Vector<Agent>();

    /**
     * {@code
     * <xsd:element name="altRecordID" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * The alternative record identifier element &lt;altRecordID&gt; allows one
     * to use alternative record identifier values for the digital object
     * represented by the METS document; the primary record identifier is stored
     * in the OBJID attribute in the root &lt;mets&gt; element.
     */
    @XmlElement(name = "altRecordID", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Identifier> altRecordID = new Vector<Identifier>();

    /**
     * {@code
     * <xsd:element name="metsDocumentID" minOccurs="0">
     * }
     * 
     * The metsDocument identifier element &lt;metsDocumentID&gt; allows a
     * unique identifier to be assigned to the METS document itself. This may be
     * different from the OBJID attribute value in the root &lt;mets&gt;
     * element, which uniquely identifies the entire digital object represented
     * by the METS document.
     */
    @XmlElement(name = "metsDocumentID", namespace = "http://www.loc.gov/METS/", required = false)
    protected Identifier metsDocumentID;

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
     * xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values of the &lt;techMD&gt;,
     * &lt;sourceMD&gt;, &lt;rightsMD&gt; and/or &lt;digiprovMD&gt; elements
     * within the &lt;amdSec&gt; of the METS document that contain
     * administrative metadata pertaining to the METS document itself. For more
     * information on using METS IDREFS and IDREF type attributes for internal
     * linking, see Chapter 4 of the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * {@code
     * <xsd:attribute name="CREATEDATE" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATEDATE (dateTime/O): Records the date/time the METS document was
     * created.
     */
    @XmlAttribute(name = "CREATEDATE", required = false)
    protected String CREATEDATE;

    /**
     * {@code
     * <xsd:attribute name="LASTMODDATE" type="xsd:dateTime" use="optional">
     * }
     * 
     * LASTMODDATE (dateTime/O): Is used to indicate the date/time the METS
     * document was last modified.
     */
    @XmlAttribute(name = "LASTMODDATE", required = false)
    protected String LASTMODDATE;

    /**
     * {@code
     * <xsd:attribute name="RECORDSTATUS" type="xsd:string" use="optional">
     * }
     * 
     * RECORDSTATUS (string/O): Specifies the status of the METS document. It is
     * used for internal processing purposes.
     */
    @XmlAttribute(name = "RECORDSTATUS", required = false)
    protected String RECORDSTATUS;

    /**
     * {@code
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<Agent> getAgent() {
        return agent;
    }

    public List<Identifier> getAltRecordID() {
        return altRecordID;
    }

    public void setAltRecordID(List<Identifier> altRecordID) {
        this.altRecordID = altRecordID;
    }

    public Identifier getMetsDocumentID() {
        return metsDocumentID;
    }

    public void setMetsDocumentID(Identifier metsDocumentID) {
        this.metsDocumentID = metsDocumentID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String aDMID) {
        ADMID = aDMID;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String createDate) {
        CREATEDATE = createDate;
    }

    public String getLASTMODDATE() {
        return LASTMODDATE;
    }

    /**
     *use Instant.now().toString()
     *to set current timestamp
     */
    public void setLASTMODDATE(String lastModDate) {
        LASTMODDATE = lastModDate;
    }

    public String getRECORDSTATUS() {
        return RECORDSTATUS;
    }

    public void setRECORDSTATUS(String recordStatus) {
        RECORDSTATUS = recordStatus;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new MetsHdr());
    }

    public static Builder builder(MetsHdr mh) {
        return new Builder(mh);
    }

    public static class Builder extends BuilderBase<MetsHdr, Builder> {

        protected Builder(MetsHdr mh) {
            super(mh);
        }

        public Builder addAgent(Agent agent) {
            _target().getAgent().add(agent);
            return _self();
        }

        public Builder addAltRecordID(Identifier altRecordID) {

            _target().getAltRecordID().add(altRecordID);
            return _self();
        }

        public Builder metsDocumentID(Identifier metsDocumentID) {
            _target().setMetsDocumentID(metsDocumentID);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }

        public Builder CREATEDATE(String createDate) {
            _target().setCREATEDATE(createDate);
            return _self();
        }

        /**
         *use Instant.now().toString()
         *to set current timestamp
         */
        public Builder LASTMODDATE(String lastModDate) {
            _target().setLASTMODDATE(lastModDate);
            return _self();
        }

        public Builder RECORDSTATUS(String recordStatus) {
            _target().setRECORDSTATUS(recordStatus);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
