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
package org.mycore.libmeta.mets.model.structmap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupORDERLABELSBuilder;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupORDERLABELS;
import org.mycore.libmeta.mets.model._misc.URIs;
import org.mycore.libmeta.mets.model.div.Fptr;
import org.mycore.libmeta.mets.model.div.Mptr;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <xsd:complexType name="divType">
 * 
 * divType: Complex Type for Divisions
 * 
 * The METS standard represents a document structurally as a series of nested
 * div elements, that is, as a hierarchy (e.g., a book, which is composed of
 * chapters, which are composed of subchapters, which are composed of text).
 * Every div node in the structural map hierarchy may be connected (via
 * subsidiary mptr or fptr elements) to content files which represent that div's
 * portion of the whole document. SPECIAL NOTE REGARDING DIV ATTRIBUTE VALUES:
 * to clarify the differences between the ORDER, ORDERLABEL, and LABEL
 * attributes for the &lt;div&gt; element, imagine a text with 10 roman numbered
 * pages followed by 10 arabic numbered pages. Page iii would have an ORDER of
 * &quot;3&quot;, an ORDERLABEL of &quot;iii&quot; and a LABEL of &quot;Page
 * iii&quot;, while page 3 would have an ORDER of &quot;13&quot;, an ORDERLABEL
 * of &quot;3&quot; and a LABEL of &quot;Page 3&quot;.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "mptr", "fptr", "div" })
public class Div implements IAttributeGroupORDERLABELS {
    // <xsd:sequence>

    /**
     * <xsd:element name="mptr" minOccurs="0" maxOccurs="unbounded">
     * 
     * Like the &lt;fptr&gt; element, the METS pointer element &lt;mptr&gt;
     * represents digital content that manifests its parent &lt;div&gt; element.
     * Unlike the &lt;fptr&gt;, which either directly or indirectly points to
     * content represented in the &lt;fileSec&gt; of the parent METS document,
     * the &lt;mptr&gt; element points to content represented by an external
     * METS document. Thus, this element allows multiple discrete and separate
     * METS documents to be organized at a higher level by a separate METS
     * document. For example, METS documents representing the individual issues
     * in the series of a journal could be grouped together and organized by a
     * higher level METS document that represents the entire journal series.
     * Each of the &lt;div&gt; elements in the &lt;structMap&gt; of the METS
     * document representing the journal series would point to a METS document
     * representing an issue. It would do so via a child &lt;mptr&gt; element.
     * Thus the &lt;mptr&gt; element gives METS users considerable flexibility
     * in managing the depth of the &lt;structMap&gt; hierarchy of individual
     * METS documents. The &lt;mptr&gt; element points to an external METS
     * document by means of an xlink:href attribute and associated XLink
     * attributes.
     */
    @XmlElement(name = "mptr", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Mptr> mptr = new Vector<Mptr>();

    /**
     * <xsd:element name="fptr" minOccurs="0" maxOccurs="unbounded">
     * 
     * The &lt;fptr&gt; or file pointer element represents digital content that
     * manifests its parent &lt;div&gt; element. The content represented by an
     * &lt;fptr&gt; element must consist of integral files or parts of files
     * that are represented by &lt;file&gt; elements in the &lt;fileSec&gt;. Via
     * its FILEID attribute, an &lt;fptr&gt; may point directly to a single
     * integral &lt;file&gt; element that manifests a structural division.
     * However, an &lt;fptr&gt; element may also govern an &lt;area&gt; element,
     * a &lt;par&gt;, or a &lt;seq&gt; which in turn would point to the relevant
     * file or files. A child &lt;area&gt; element can point to part of a
     * &lt;file&gt; that manifests a division, while the &lt;par&gt; and
     * &lt;seq&gt; elements can point to multiple files or parts of files that
     * together manifest a division. More than one &lt;fptr&gt; element can be
     * associated with a &lt;div&gt; element. Typically sibling &lt;fptr&gt;
     * elements represent alternative versions, or manifestations, of the same
     * content
     */
    @XmlElement(name = "fptr", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Fptr> fptr = new Vector<Fptr>();

    /**
     * <xsd:element name="div" type="divType" minOccurs="0"
     * maxOccurs="unbounded"/>
     */
    @XmlElement(name = "div", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Div> div = new Vector<Div>();

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
     * <xsd:attribute name="ORDER" type="xsd:integer" use="optional">
     * 
     * ORDER (integer/O): A representation of the div's order among its siblings
     * (e.g., its absolute, numeric sequence). For an example, and clarification
     * of the distinction between ORDER and ORDERLABEL, see the description of
     * the ORDERLABEL attribute.
     */
    @XmlAttribute(name = "ORDER", required = false)
    protected Integer ORDER;

    /**
     * <xsd:attribute name="ORDERLABEL" type="xsd:string" use="optional">
     * 
     * ORDERLABEL (string/O): A representation of the div's order among its
     * siblings (e.g., "xii"), or of any non-integer native numbering system. It
     * is presumed that this value will still be machine actionable (e.g., it
     * would support 'go to page ___' function), and it should not be used as a
     * replacement/substitute for the LABEL attribute. To understand the
     * differences between ORDER, ORDERLABEL and LABEL, imagine a text with 10
     * roman numbered pages followed by 10 arabic numbered pages. Page iii would
     * have an ORDER of "3", an ORDERLABEL of "iii" and a LABEL of "Page iii",
     * while page 3 would have an ORDER of "13", an ORDERLABEL of "3" and a
     * LABEL of "Page 3".
     */
    @XmlAttribute(name = "ORDERLABEL", required = false)
    protected String ORDERLABEL;

    /**
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * 
     * LABEL (string/O): An attribute used, for example, to identify a
     * &lt;div&gt; to an end user viewing the document. Thus a hierarchical
     * arrangement of the &lt;div&gt; LABEL values could provide a table of
     * contents to the digital content represented by a METS document and
     * facilitate the users' navigation of the digital object. Note that a
     * &lt;div&gt; LABEL should be specific to its level in the structural map.
     * In the case of a book with chapters, the book &lt;div&gt; LABEL should
     * have the book title and the chapter &lt;div&gt;; LABELs should have the
     * individual chapter titles, rather than having the chapter &lt;div&gt;
     * LABELs combine both book title and chapter title . For further of the
     * distinction between LABEL and ORDERLABEL see the description of the
     * ORDERLABEL attribute.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    /**
     * <xsd:attribute name="DMDID" type="xsd:IDREFS" use="optional">
     * 
     * DMDID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;dmdSec&gt;, elements in the METS document that contain or link to
     * descriptive metadata pertaining to the structural division represented by
     * the current &lt;div&gt; element. For more information on using METS
     * IDREFS and IDREF type attributes for internal linking, see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "DMDID", required = false)
    protected String DMDID;

    /**
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * 
     * ADMID (IDREFS/O): Contains the ID attribute values identifying the
     * &lt;rightsMD&gt;, &lt;sourceMD&gt;, &lt;techMD&gt; and/or
     * &lt;digiprovMD&gt; elements within the &lt;amdSec&gt; of the METS
     * document that contain or link to administrative metadata pertaining to
     * the structural division represented by the &lt;div&gt; element. Typically
     * the &lt;div&gt; ADMID attribute would be used to identify the
     * &lt;rightsMD&gt; element or elements that pertain to the &lt;div&gt;, but
     * it could be used anytime there was a need to link a &lt;div&gt; with
     * pertinent administrative metadata. For more information on using METS
     * IDREFS and IDREF type attributes for internal linking, see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * <xsd:attribute name="TYPE" type="xsd:string" use="optional">
     * 
     * TYPE (string/O): An attribute that specifies the type of structural
     * division that the &lt;div&gt; element represents. Possible &lt;div&gt;
     * TYPE attribute values include: chapter, article, page, track, segment,
     * section etc. METS places no constraints on the possible TYPE values.
     * Suggestions for controlled vocabularies for TYPE may be found on the METS
     * website.
     */
    @XmlAttribute(name = "TYPE", required = false)
    protected String TYPE;

    /**
     * <xsd:attribute name="CONTENTIDS" type="URIs" use="optional">
     * 
     * CONTENTIDS (URI/O): Content IDs for the content represented by the
     * &lt;div&gt; (equivalent to DIDL DII or Digital Item Identifier, a unique
     * external ID).
     */
    @XmlAttribute(name = "CONTENTIDS", required = false)
    protected URIs CONTENTIDS = new URIs();

    /**
     * <xsd:attribute ref="xlink:label">
     * 
     * xlink:label - an xlink label to be referred to by an smLink
     * element</xsd:documentation>
     */
    @XmlAttribute(name = "label", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkLabel;

    public List<Mptr> getMptr() {
        return mptr;
    }

    public List<Fptr> getFptr() {
        return fptr;
    }

    public List<Div> getDiv() {
        return div;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public Integer getORDER() {
        return ORDER;
    }

    public void setORDER(Integer oRDER) {
        ORDER = oRDER;
    }

    public String getORDERLABEL() {
        return ORDERLABEL;
    }

    public void setORDERLABEL(String oRDERLABEL) {
        ORDERLABEL = oRDERLABEL;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String lABEL) {
        LABEL = lABEL;
    }

    public String getDMDID() {
        return DMDID;
    }

    public void setDMDID(String dmdID) {
        this.DMDID = dmdID;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String admID) {
        this.ADMID = admID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String type) {
        this.TYPE = type;
    }

    public URIs getCONTENTIDS() {
        return CONTENTIDS;
    }

    public void setCONTENTIDS(URIs cONTENTIDS) {
        CONTENTIDS = cONTENTIDS;
    }

    public String getXlinkLabel() {
        return xlinkLabel;
    }

    public void setXlinkLabel(String xlinkLabel) {
        this.xlinkLabel = xlinkLabel;
    }

    public static Builder builder() {
        return builder(new Div());
    }

    public static Builder builder(Div d) {
        return new Builder(d);
    }

    public static class Builder extends BuilderBase<Div, Builder> implements IAttributeGroupORDERLABELSBuilder<Div, Builder> {

        protected Builder(Div d) {
            super(d);
        }

        public Builder addMptr(Mptr mptr) {
            _target().getMptr().add(mptr);
            return _self();
        }

        public Builder addFptr(Fptr fptr) {
            _target().getFptr().add(fptr);
            return _self();
        }

        public Builder addDiv(Div div) {
            _target().getDiv().add(div);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder DMDID(String dmdID) {
            _target().setDMDID(dmdID);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }

        public Builder TYPE(String type) {
            _target().setTYPE(type);
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

        public Builder xlinkLabel(String xlinkLabel) {
            _target().setXlinkLabel(xlinkLabel);
            return _self();
        }
    }
}
