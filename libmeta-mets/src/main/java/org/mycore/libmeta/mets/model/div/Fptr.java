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
import org.mycore.libmeta.mets.model._misc.URIs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * <xsd:element name="fptr" minOccurs="0" maxOccurs="unbounded">
 * 
 * The &lt;fptr&gt; or file pointer element represents digital content that
 * manifests its parent &lt;div&gt; element. The content represented by an
 * &lt;fptr&gt; element must consist of integral files or parts of files that
 * are represented by &lt;file&gt; elements in the &lt;fileSec&gt;. Via its
 * FILEID attribute, an &lt;fptr&gt; may point directly to a single integral
 * &lt;file&gt; element that manifests a structural division. However, an
 * &lt;fptr&gt; element may also govern an &lt;area&gt; element, a &lt;par&gt;,
 * or a &lt;seq&gt; which in turn would point to the relevant file or files. A
 * child &lt;area&gt; element can point to part of a &lt;file&gt; that manifests
 * a division, while the &lt;par&gt; and &lt;seq&gt; elements can point to
 * multiple files or parts of files that together manifest a division. More than
 * one &lt;fptr&gt; element can be associated with a &lt;div&gt; element.
 * Typically sibling &lt;fptr&gt; elements represent alternative versions, or
 * manifestations, of the same content
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Fptr {
    // <xsd:choice>

    /**
     * <xsd:element name="par" type="parType" minOccurs="0">
     * 
     * The &lt;par&gt; or parallel files element aggregates pointers to files,
     * parts of files, and/or sequences of files or parts of files that must be
     * played or displayed simultaneously to manifest a block of digital content
     * represented by an &lt;fptr&gt; element. This might be the case, for
     * example, with multi-media content, where a still image might have an
     * accompanying audio track that comments on the still image. In this case,
     * a &lt;par&gt; element would aggregate two &lt;area&gt; elements, one of
     * which pointed to the image file and one of which pointed to the audio
     * file that must be played in conjunction with the image. The &lt;area&gt;
     * element associated with the image could be further qualified with SHAPE
     * and COORDS attributes if only a portion of the image file was pertinent
     * and the &lt;area&gt; element associated with the audio file could be
     * further qualified with BETYPE, BEGIN, EXTTYPE, and EXTENT attributes if
     * only a portion of the associated audio file should be played in
     * conjunction with the image.
     */

    /**
     * <xsd:element name="seq" type="seqType" minOccurs="0">
     * 
     * The sequence of files element &lt;seq&gt; aggregates pointers to files,
     * parts of files and/or parallel sets of files or parts of files that must
     * be played or displayed sequentially to manifest a block of digital
     * content. This might be the case, for example, if the parent &lt;div&gt;
     * element represented a logical division, such as a diary entry, that
     * spanned multiple pages of a diary and, hence, multiple page image files.
     * In this case, a &lt;seq&gt; element would aggregate multiple,
     * sequentially arranged &lt;area&gt; elements, each of which pointed to one
     * of the image files that must be presented sequentially to manifest the
     * entire diary entry. If the diary entry started in the middle of a page,
     * then the first &lt;area&gt; element (representing the page on which the
     * diary entry starts) might be further qualified, via its SHAPE and COORDS
     * attributes, to specify the specific, pertinent area of the associated
     * image file.
     */

    /**
     * <xsd:element name="area" type="areaType" minOccurs="0">
     * 
     * The area element &lt;area&gt; typically points to content consisting of
     * just a portion or area of a file represented by a &lt;file&gt; element in
     * the &lt;fileSec&gt;. In some contexts, however, the &lt;area&gt; element
     * can also point to content represented by an integral file. A single
     * &lt;area&gt; element would appear as the direct child of a &lt;fptr&gt;
     * element when only a portion of a &lt;file&gt;, rather than an integral
     * &lt;file&gt;, manifested the digital content represented by the
     * &lt;fptr&gt;. Multiple &lt;area&gt; elements would appear as the direct
     * children of a &lt;par&gt; element or a &lt;seq&gt; element when multiple
     * files or parts of files manifested the digital content represented by an
     * &lt;fptr&gt; element. When used in the context of a &lt;par&gt; or
     * &lt;seq&gt; element an &lt;area&gt; element can point either to an
     * integral file or to a segment of a file as necessary.
     */

    @XmlElements({ @XmlElement(name = "area", namespace = "http://www.loc.gov/METS/", type = Area.class),
        @XmlElement(name = "seq", namespace = "http://www.loc.gov/METS/", type = Seq.class),
        @XmlElement(name = "par", namespace = "http://www.loc.gov/METS/", type = Par.class) })
    private AreaOrSeqOrPar parOrSeqOrArea;

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
     * <xsd:attribute name="FILEID" type="xsd:IDREF" use="optional">
     * 
     * FILEID (IDREF/O): An optional attribute that provides the XML ID
     * identifying the &lt;file&gt; element that links to and/or contains the
     * digital content represented by the &lt;fptr&gt;. A &lt;fptr&gt; element
     * should only have a FILEID attribute value if it does not have a child
     * &lt;area&gt;, &lt;par&gt; or &lt;seq&gt; element. If it has a child
     * element, then the responsibility for pointing to the relevant content
     * falls to this child element or its descendants.
     */
    @XmlAttribute(name = "FILEID", required = false)
    protected String FILEID;

    /**
     * <xsd:attribute name="CONTENTIDS" type="URIs" use="optional">
     * 
     * CONTENTIDS (URI/O): Content IDs for the content represented by the
     * &lt;fptr&gt; (equivalent to DIDL DII or Digital Item Identifier, a unique
     * external ID).
     */
    @XmlAttribute(name = "CONTENTIDS", required = false)
    protected URIs CONTENTIDS = new URIs();

    /**
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public Par getPar() {
        if (parOrSeqOrArea != null && parOrSeqOrArea instanceof Par) {
            return (Par) parOrSeqOrArea;
        }
        return null;
    }

    public void setPar(Par par) {
        this.parOrSeqOrArea = par;
    }

    public Seq getSeq() {
        if (parOrSeqOrArea != null && parOrSeqOrArea instanceof Seq) {
            return (Seq) parOrSeqOrArea;
        }
        return null;
    }

    public void setSeq(Seq seq) {
        this.parOrSeqOrArea = seq;
    }

    public Area getArea() {
        if (parOrSeqOrArea != null && parOrSeqOrArea instanceof Area) {
            return (Area) parOrSeqOrArea;
        }
        return null;
    }

    public void setArea(Area area) {
        this.parOrSeqOrArea = area;
    }

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

    public URIs getCONTENTIDS() {
        return CONTENTIDS;
    }
    
    public void setCONTENTIDS(URIs contentIDs) {
        CONTENTIDS = contentIDs;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new Fptr());
    }

    public static Builder builder(Fptr f) {
        return new Builder(f);
    }

    public static class Builder extends BuilderBase<Fptr, Builder> {

        protected Builder(Fptr f) {
            super(f);
        }

        public Builder par(Par par) {
            _target().setPar(par);
            return _self();
        }

        public Builder seq(Seq seq) {
            _target().setSeq(seq);
            return _self();
        }

        public Builder area(Area area) {
            _target().setArea(area);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder FILEID(String fileID) {
            _target().setFILEID(fileID);
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

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }

    }
}
