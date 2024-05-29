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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * {@code
 * <xsd:element name="fileSec" minOccurs="0">
 * }
 * 
 * The overall purpose of the content file section element &lt;fileSec&gt; is to
 * provide an inventory of and the location for the content files that comprise
 * the digital object being described in the METS document.
 * 
 * @author Robert Stephan
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "fileGrp" })
public class FileSec {
    // <xsd:sequence>

    /**
     * {@code
     * <xsd:element name="fileGrp" maxOccurs="unbounded">
     * }
     * 
     * A sequence of file group elements &lt;fileGrp&gt; can be used group the
     * digital files comprising the content of a METS object either into a flat
     * arrangement or, because each file group element can itself contain one or
     * more file group elements, into a nested (hierarchical) arrangement. In
     * the case where the content files are images of different formats and
     * resolutions, for example, one could group the image content files by
     * format and create a separate &lt;fileGrp&gt;
     * 
     * for each image format/resolution such as:
     * 
     * -- one &lt;fileGrp&gt; for the thumbnails of the images
     * 
     * -- one &lt;fileGrp&gt; for the higher resolution JPEGs of the image
     * 
     * -- one &lt;fileGrp&gt; for the master archival TIFFs of the images
     * 
     * For a text resource with a variety of content file types one might group
     * the content files at the highest level by type, and then use the
     * &lt;fileGrp&gt; element's nesting capabilities to subdivide a
     * &lt;fileGrp&gt; by format within the type, such as:
     * 
     * -- one &lt;fileGrp&gt; for all of the page images with nested
     * &lt;fileGrp&gt; elements for each image format/resolution (tiff, jpeg,
     * gif)
     * 
     * -- one &lt;fileGrp&gt; for a PDF version of all the pages of the document
     * 
     * -- one &lt;fileGrp&gt; for a TEI encoded XML version of the entire
     * document or each of its pages.
     * 
     * A &lt;fileGrp&gt; may contain zero or more &lt;fileGrp&gt; elements and
     * or &lt;file&gt; elements.
     * 
     * //TODO-CHECK - named vocabulary (enumeration)
     */
    @XmlElement(name = "fileGrp", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<FileGrp> fileGrp = new Vector<>();

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

    public List<FileGrp> getFileGrp() {
        return fileGrp;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String getOtherAttribute(QName qname) {
        return otherAttributes.get(qname);
    }

    public static Builder builder() {
        return builder(new FileSec());
    }

    public static Builder builder(FileSec fs) {
        return new Builder(fs);
    }

    public static class Builder extends BuilderBase<FileSec, Builder> {

        protected Builder(FileSec fs) {
            super(fs);
        }

        public Builder addFileGrp(FileGrp fg) {
            _target().getFileGrp().add(fg);
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
