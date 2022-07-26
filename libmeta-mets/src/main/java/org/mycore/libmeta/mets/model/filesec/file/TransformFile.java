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
import org.mycore.libmeta.mets.model._enums.TRANSFORMTYPE;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * <xsd:element name="transformFile" minOccurs="0" maxOccurs="unbounded">
 * 
 * The transform file element &lt;transformFile&gt; provides a means to access
 * any subsidiary files listed below a &lt;file&gt; element by indicating the
 * steps required to "unpack" or transform the subsidiary files. This element is
 * repeatable and might provide a link to a &lt;behavior&gt; in the
 * &lt;behaviorSec&gt; that performs the transformation.</xsd:documentation>
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class TransformFile {
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
     * <xsd:attribute name="TRANSFORMTYPE" use="required">
     * 
     * TRANSFORMTYPE (string/R): Is used to indicate the type of transformation
     * needed to render content of a file accessible. This may include unpacking
     * a file into subsidiary files/streams. The controlled value constraints
     * for this XML string include "decompression" and "decryption".
     * Decompression is defined as the action of reversing data compression,
     * i.e., the process of encoding information using fewer bits than an
     * unencoded representation would use by means of specific encoding schemas.
     * Decryption is defined as the process of restoring data that has been
     * obscured to make it unreadable without special knowledge (encrypted data)
     * to its original form. </xsd:documentation>
     */
    @XmlAttribute(name = "TRANSFORMTYPE", required = true)
    protected TRANSFORMTYPE TRANSFORMTYPE;

    /**
     * <xsd:attribute name="TRANSFORMALGORITHM" type="xsd:string"
     * use="required">
     * 
     * TRANSFORM-ALGORITHM (string/R): Specifies the decompression or decryption
     * routine used to access the contents of the file. Algorithms for
     * compression can be either loss-less or lossy.</xsd:documentation>
     */
    @XmlAttribute(name = "TRANSFORMALGORITHMN", required = true)
    protected String TRANSFORMALGORITHMN;

    /**
     * <xsd:attribute name="TRANSFORMKEY" type="xsd:string" use="optional">
     * 
     * <xsd:documentation xml:lang="en">TRANSFORMKEY (string/O): A key to be
     * used with the transform algorithm for accessing the file's
     * contents.</xsd:documentation>
     */
    @XmlAttribute(name = "TRANSFORMKEY", required = false)
    protected String TRANSFORMKEY;

    /**
     * <xsd:attribute name="TRANSFORMBEHAVIOR" type="xsd:IDREF" use="optional">
     * 
     * TRANSFORMBEHAVIOR (string/O): An IDREF to a behavior element for this
     * transformation.</xsd:documentation>
     */
    @XmlAttribute(name = "TRANSFORMBEHAVIOR", required = false)
    protected String TRANSFORMBEHAVIOR;

    /**
     * <xsd:attribute name="TRANSFORMORDER" type="xsd:positiveInteger"
     * use="required">
     * 
     * TRANSFORMORDER (postive-integer/R): The order in which the instructions
     * must be followed in order to unpack or transform the container
     * file.</xsd:documentation>
     */
    @XmlAttribute(name = "TRANSFORMORDER", required = true)
    protected String TRANSFORMORDER;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public TRANSFORMTYPE getTRANSFORMTYPE() {
        return TRANSFORMTYPE;
    }

    public void setTRANSFORMTYPE(TRANSFORMTYPE transformType) {
        TRANSFORMTYPE = transformType;
    }

    public String getTRANSFORMALGORITHMN() {
        return TRANSFORMALGORITHMN;
    }

    public void setTRANSFORMALGORITHMN(String transformAlgorithmn) {
        TRANSFORMALGORITHMN = transformAlgorithmn;
    }

    public String getTRANSFORMKEY() {
        return TRANSFORMKEY;
    }

    public void setTRANSFORMKEY(String transformKey) {
        TRANSFORMKEY = transformKey;
    }

    public String getTRANSFORMBEHAVIOR() {
        return TRANSFORMBEHAVIOR;
    }

    public void setTRANSFORMBEHAVIOR(String transformBehavior) {
        TRANSFORMBEHAVIOR = transformBehavior;
    }

    public String getTRANSFORMORDER() {
        return TRANSFORMORDER;
    }

    public void setTRANSFORMORDER(String transformOrder) {
        TRANSFORMORDER = transformOrder;
    }

    public static Builder builder() {
        return builder(new TransformFile());
    }

    public static Builder builder(TransformFile tf) {
        return new Builder(tf);
    }

    public static class Builder extends BuilderBase<TransformFile, Builder> {

        protected Builder(TransformFile tf) {
            super(tf);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder TRANSFORMTYPE(TRANSFORMTYPE transformType) {
            _target().setTRANSFORMTYPE(transformType);
            return _self();
        }

        public Builder TRANSFORMALGORITHMN(String transformAlgorithmn) {
            _target().setTRANSFORMALGORITHMN(transformAlgorithmn);
            return _self();
        }

        public Builder TRANSFORMKEY(String transformKey) {
            _target().setTRANSFORMKEY(transformKey);
            return _self();
        }

        public Builder TRANSFORMBEHAVIOR(String transformBehavior) {
            _target().setTRANSFORMBEHAVIOR(transformBehavior);
            return _self();
        }

        public Builder TRANSFORMORDER(String transformOrder) {
            _target().setTRANSFORMORDER(transformOrder);
            return _self();
        }
    }
}
