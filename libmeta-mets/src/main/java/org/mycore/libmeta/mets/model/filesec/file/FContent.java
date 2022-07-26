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
import org.mycore.libmeta.mets.model.mdsec.XMLData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * <xsd:element name="FContent" minOccurs="0">
 * 
 * The file content element &lt;FContent&gt; is used to identify a content file
 * contained internally within a METS document. The content file must be either
 * Base64 encoded and contained within the subsidiary &lt;binData&gt; wrapper
 * element, or consist of XML information and be contained within the subsidiary
 * &lt;xmlData&gt; wrapper element.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class FContent {
    // <xsd:choice>
    /**
     * <xsd:element name="binData" type="xsd:base64Binary" minOccurs="0">
     * 
     * A binary data wrapper element &lt;binData&gt; is used to contain a Base64
     * encoded file.
     */
    @XmlElement(name = "binData", required = false)
    private String binData;

    /**
     * <xsd:element name="xmlData" minOccurs="0">
     * 
     * An xml data wrapper element &lt;xmlData&gt; is used to contain an XML
     * encoded file. The content of an &lt;xmlData&gt; element can be in any
     * namespace or in no namespace. As permitted by the XML Schema Standard,
     * the processContents attribute value for the metadata in an
     * &lt;xmlData&gt; element is set to "lax". Therefore, if the source schema
     * and its location are identified by means of an xsi:schemaLocation
     * attribute, then an XML processor will validate the elements for which it
     * can find declarations. If a source schema is not identified, or cannot be
     * found at the specified schemaLocation, then an XML validator will check
     * for well-formedness, but otherwise skip over the elements appearing in
     * the &lt;xmlData&gt; element.
     */
    @XmlElement(name = "xmlData", required = false)
    private XMLData xmlData;

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
    private String ID;

    /**
     * <xsd:attribute name="USE" type="xsd:string" use="optional">
     * 
     * USE (string/O): A tagging attribute to indicate the intended use of the
     * specific copy of the file represented by the &lt;FContent&gt; element
     * (e.g., service master, archive master). A USE attribute can be expressed
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
    private String USE;

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

    public String getUSE() {
        return USE;
    }

    public void setUSE(String use) {
        USE = use;
    }

    public static Builder builder() {
        return builder(new FContent());
    }

    public static Builder builder(FContent fc) {
        return new Builder(fc);
    }

    public static class Builder extends BuilderBase<FContent, Builder> {

        protected Builder(FContent fc) {
            super(fc);
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

        public Builder USE(String use) {
            _target().setUSE(use);
            return _self();
        }
    }
}
