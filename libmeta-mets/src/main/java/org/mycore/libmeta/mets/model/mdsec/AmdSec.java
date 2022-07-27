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
 * <xsd:complexType name="amdSecType">
 *   <xsd:sequence>
 *     <xsd:element name="techMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded" />
 *     <xsd:element name="rightsMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded" />
 *     <xsd:element name="sourceMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded" />
 *     <xsd:element name="digiprovMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded" />
 *	</xsd:sequence>
 *	}
 *
 * amdSecType: Complex Type for Administrative Metadata Sections
 * 
 * The administrative metadata section consists of four possible subsidiary
 * sections: techMD (technical metadata for text/image/audio/video files),
 * rightsMD (intellectual property rights metadata), sourceMD (analog/digital
 * source metadata), and digiprovMD (digital provenance metadata, that is, the
 * history of migrations/translations performed on a digital library object from
 * it's original digital capture/encoding).
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "techMD", "rightsMD", "sourceMD", "digiprovMD" })
public class AmdSec {
    // <xsd:sequence>

    /**
     * {@code
     * <xsd:element name="techMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * A technical metadata element &lt;techMD&gt; records technical metadata
     * about a component of the METS object, such as a digital content file. The
     * &lt;techMD&gt; element conforms to same generic datatype as the
     * &lt;dmdSec&gt;, &lt;rightsMD&gt;, &lt;sourceMD&gt; and &lt;digiprovMD&gt;
     * elements, and supports the same sub-elements and attributes. A technical
     * metadata element can either wrap the metadata (mdWrap) or reference it in
     * an external location (mdRef) or both. METS allows multiple &lt;techMD&gt;
     * elements; and technical metadata can be associated with any METS element
     * that supports an ADMID attribute. Technical metadata can be expressed
     * according to many current technical description standards (such as MIX
     * and textMD) or a locally produced XML schema.
     */
    @XmlElement(name = "techMD", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<MdSec> techMD = new Vector<MdSec>();

    /**
     * {@code
     * <xsd:element name="rightsMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * An intellectual property rights metadata element &lt;rightsMD&gt; records
     * information about copyright and licensing pertaining to a component of
     * the METS object. The &lt;rightsMD&gt; element conforms to same generic
     * datatype as the &lt;dmdSec&gt;, &lt;techMD>, &lt;sourceMD&gt; and
     * &lt;digiprovMD&gt; elements, and supports the same sub-elements and
     * attributes. A rights metadata element can either wrap the metadata
     * (mdWrap) or reference it in an external location (mdRef) or both. METS
     * allows multiple &lt;rightsMD&gt; elements; and rights metadata can be
     * associated with any METS element that supports an ADMID attribute. Rights
     * metadata can be expressed according current rights description standards
     * (such as CopyrightMD and rightsDeclarationMD) or a locally produced XML
     * schema.
     */
    @XmlElement(name = "rightsMD", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<MdSec> rightsMD = new Vector<MdSec>();

    /**
     * {@code
     * <xsd:element name="sourceMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * A source metadata element &lt;sourceMD&gt; records descriptive and
     * administrative metadata about the source format or media of a component
     * of the METS object such as a digital content file. It is often used for
     * discovery, data administration or preservation of the digital object. The
     * &lt;sourceMD&gt; element conforms to same generic datatype as the
     * &lt;dmdSec&gt;, &lt;techMD&gt;, &lt;rightsMD&gt;, and &lt;digiprovMD&gt;
     * elements, and supports the same sub-elements and attributes. A source
     * metadata element can either wrap the metadata (mdWrap) or reference it in
     * an external location (mdRef) or both. METS allows multiple
     * &lt;sourceMD&gt; elements; and source metadata can be associated with any
     * METS element that supports an ADMID attribute. Source metadata can be
     * expressed according to current source description standards (such as
     * PREMIS) or a locally produced XML schema.
     */
    @XmlElement(name = "sourceMD", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<MdSec> sourceMD = new Vector<MdSec>();

    /**
     * {@code
     * <xsd:element name="digiprovMD" type="mdSecType" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * A digital provenance metadata element &lt;digiprovMD&gt; can be used to
     * record any preservation-related actions taken on the various files which
     * comprise a digital object (e.g., those subsequent to the initial
     * digitization of the files such as transformation or migrations) or, in
     * the case of born digital materials, the files' creation. In short,
     * digital provenance should be used to record information that allows both
     * archival/library staff and scholars to understand what modifications have
     * been made to a digital object and/or its constituent parts during its
     * life cycle. This information can then be used to judge how those
     * processes might have altered or corrupted the object's ability to
     * accurately represent the original item. One might, for example, record
     * master derivative relationships and the process by which those
     * derivations have been created. Or the &lt;digiprovMD&gt; element could
     * contain information regarding the migration/transformation of a file from
     * its original digitization (e.g., OCR, TEI, etc.,)to its current
     * incarnation as a digital object (e.g., JPEG2000). The &lt;digiprovMD&gt;
     * element conforms to same generic datatype as the &lt;dmdSec&gt;,
     * &lt;techMD&gt;, &lt;rightsMD&gt;, and &lt;sourceMD&gt; elements, and
     * supports the same sub-elements and attributes. A digital provenance
     * metadata element can either wrap the metadata (mdWrap) or reference it in
     * an external location (mdRef) or both. METS allows multiple
     * &lt;digiprovMD> elements; and digital provenance metadata can be
     * associated with any METS element that supports an ADMID attribute.
     * Digital provenance metadata can be expressed according to current digital
     * provenance description standards (such as PREMIS) or a locally produced
     * XML schema.
     */

    @XmlElement(name = "digiprovMD", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<MdSec> digiprovMD = new Vector<MdSec>();

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
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<MdSec> getTechMD() {
        return techMD;
    }

    public List<MdSec> getRightsMD() {
        return rightsMD;
    }

    public List<MdSec> getSourceMD() {
        return sourceMD;
    }

    public List<MdSec> getDigiprovMD() {
        return digiprovMD;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new AmdSec());
    }

    public static Builder builder(AmdSec as) {
        return new Builder(as);
    }

    public static class Builder extends BuilderBase<AmdSec, Builder> {

        protected Builder(AmdSec as) {
            super(as);
        }

        public Builder addTechMD(MdSec mdSec) {
            _target().getTechMD().add(mdSec);
            return _self();
        }

        public Builder addRightsMD(MdSec mdSec) {
            _target().getRightsMD().add(mdSec);
            return _self();
        }

        public Builder addSourceMD(MdSec mdSec) {
            _target().getSourceMD().add(mdSec);
            return _self();
        }

        public Builder addDigiProvMD(MdSec mdSec) {
            _target().getDigiprovMD().add(mdSec);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
