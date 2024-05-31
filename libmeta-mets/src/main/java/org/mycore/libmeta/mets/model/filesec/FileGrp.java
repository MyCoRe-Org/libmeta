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

/**
 * {@code
 * <xsd:complexType name="fileGrpType">
 * }
 * 
 * fileGrpType: Complex Type for File Groups
 * 
 * The file group is used to cluster all of the digital files composing a
 * digital library object in a hierarchical arrangement (fileGrp is recursively
 * defined to enable the creation of the hierarchy). Any file group may contain
 * zero or more file elements. File elements in turn can contain one or more
 * FLocat elements (a pointer to a file containing content for this object)
 * and/or a FContent element (the contents of the file, in either XML or Base64
 * encoding).
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class FileGrp {
    // <xsd:choice>

    /**
     * {@code
     * <xsd:element name="fileGrp" type="fileGrpType" minOccurs="0"
     * maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "fileGrp", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<FileGrp> fileGrp = new Vector<FileGrp>();

    /**
     * {@code
     * <xsd:element name="file" minOccurs="0" maxOccurs="unbounded" type="fileType" >
     * }
     * 
     * The file element &lt;file&gt; provides access to the content files for
     * the digital object being described by the METS document. A &lt;file&gt;
     * element may contain one or more &lt;FLocat&gt; elements which provide
     * pointers to a content file and/or a &lt;FContent&gt; element which wraps
     * an encoded version of the file. Embedding files using &lt;FContent&gt;
     * can be a valuable feature for exchanging digital objects between
     * repositories or for archiving versions of digital objects for off-site
     * storage. All &lt;FLocat&gt; and &lt;FContent&gt; elements should identify
     * and/or contain identical copies of a single file. The &lt;file&gt;
     * element is recursive, thus allowing sub-files or component files of a
     * larger file to be listed in the inventory. Alternatively, by using the
     * &lt;stream&gt; element, a smaller component of a file or of a related
     * file can be placed within a &lt;file&gt; element. Finally, by using the
     * &lt;transformFile&gt; element, it is possible to include within a
     * &lt;file&gt; element a different version of a file that has undergone a
     * transformation for some reason, such as format migration.
     */
    @XmlElement(name = "file", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<File> file = new Vector<File>();

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
     * <xsd:attribute name="VERSDATE" type="xsd:dateTime" use="optional">
     * }
     * 
     * VERSDATE (dateTime/O): An optional dateTime attribute specifying the date
     * this version/fileGrp of the digital object was created.
     */
    @XmlAttribute(name = "VERSDATE", required = false)
    protected String VERSDATE;

    /**
     * {@code
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREF/O): Contains the ID attribute values of the &lt;techMD&gt;,
     * &lt;sourceMD&gt;, &lt;rightsMD&gt; and/or &lt;digiprovMD&gt; elements
     * within the &lt;amdSec&gt; of the METS document applicable to all of the
     * files in a particular file group. For more information on using METS
     * IDREFS and IDREF type attributes for internal linking, see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    /**
     * {@code
     * <xsd:attribute name="USE" type="xsd:string" use="optional">
     * }
     * 
     * USE (string/O): A tagging attribute to indicate the intended use of files
     * within this file group (e.g., master, reference, thumbnails for image
     * files). A USE attribute can be expressed at the&lt;fileGrp&gt; level, the
     * &lt;file&gt; level, the &lt;FLocat&gt; level and/or the &lt;FContent&gt;
     * level. A USE attribute value at the &lt;fileGrp&gt; level should pertain
     * to all of the files in the &lt;fileGrp&gt;. A USE attribute at the
     * &lt;file&gt; level should pertain to all copies of the file as
     * represented by subsidiary &lt;FLocat&gt; and/or &lt;FContent&gt;
     * elements. A USE attribute at the &lt;FLocat&gt; or &lt;FContent&gt; level
     * pertains to the particular copy of the file that is either referenced
     * (&lt;FLocat&gt;) or wrapped (&lt;FContent&gt;).
     */
    @XmlAttribute(name = "USE", required = false)
    protected String USE;

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

    public List<File> getFile() {
        return file;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String getOtherAttribute(QName qname) {
        return otherAttributes.get(qname);
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getVERSDATE() {
        return VERSDATE;
    }

    public void setVERSDATE(String versDate) {
        VERSDATE = versDate;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String admId) {
        ADMID = admId;
    }

    public String getUSE() {
        return USE;
    }

    public void setUSE(String use) {
        USE = use;
    }

    public static Builder builder() {
        return builder(new FileGrp());
    }

    public static Builder builder(FileGrp fg) {
        return new Builder(fg);
    }

    public static class Builder extends BuilderBase<FileGrp, Builder> {

        protected Builder(FileGrp fg) {
            super(fg);
        }

        public Builder addFileGrp(FileGrp fg) {
            _target().getFileGrp().add(fg);
            return _self();
        }

        public Builder addFile(File f) {
            _target().getFile().add(f);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder VERSDATE(String versDate) {
            _target().setVERSDATE(versDate);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }

        public Builder USE(String use) {
            _target().setUSE(use);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
