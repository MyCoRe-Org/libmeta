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
package org.mycore.libmeta.marc21.model;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * MARC21 Variable Data Fields 010-999
 * 
 *  &lt;xsd:complexType name="dataFieldType" id="datafield.ct"&gt;
 *    &lt;xsd:annotation&gt;
 *      &lt;xsd:documentation&gt;MARC21 Variable Data Fields 010-999&lt;/xsd:documentation&gt;
 *    &lt;/xsd:annotation&gt;
 *    &lt;xsd:sequence maxOccurs="unbounded"&gt;
 *      &lt;xsd:element name="subfield" type="subfieldatafieldType"/&gt;
 *    &lt;/xsd:sequence&gt;
 *    &lt;xsd:attribute name="id" type="idDataType" use="optional"/&gt;
 *    &lt;xsd:attribute name="tag" type="tagDataType" use="required"/&gt;
 *    &lt;xsd:attribute name="ind1" type="indicatorDataType" use="required"/&gt;
 *    &lt;xsd:attribute name="ind2" type="indicatorDataType" use="required"/&gt;
 *  &lt;/xsd:complexType&gt;
 *  &lt;xsd:simpleType name="tagDataType" id="tag.st"&gt;
 *    &lt;xsd:restriction base="xsd:string"&gt;
 *     &lt;xsd:whiteSpace value="preserve"/&gt;
 *      &lt;xsd:pattern value="(0([1-9A-Z][0-9A-Z])|0([1-9a-z][0-9a-z]))|(([1-9A-Z][0-9A-Z]{2})|([1-9a-z][0-9a-z]{2}))"/&gt;
 *    &lt;/xsd:restriction&gt;
 *  &lt;/xsd:simpleType&gt;
 *  &lt;xsd:simpleType name="indicatorDataType" id="ind.st"&gt;
 *    &lt;xsd:restriction base="xsd:string"&gt;
 *      &lt;xsd:whiteSpace value="preserve"/&gt;
 *      &lt;xsd:pattern value="[\da-z ]{1}"/&gt;
 *    &lt;/xsd:restriction&gt;
 *  &lt;/xsd:simpleType&gt;
 * 
 * 
 * @author Robert Stephan
 * @version MARC21 1.2
 * 
 */

@XmlRootElement(name = "datafield", namespace = "http://www.loc.gov/MARC21/slim")
@XmlAccessorType(XmlAccessType.NONE)
public class MarcDatafield extends MarcObject {
    /**
     * 
     */
    @XmlElement(name = "subfield", namespace = "http://www.loc.gov/MARC21/slim", required = true)
    protected List<MarcSubfield> subfields = new Vector<MarcSubfield>();

    @XmlAttribute(name = "id", required = false)
    protected String id;

    /**
     * &lt;xsd:pattern value="(0([1-9A-Z][0-9A-Z])|0([1-9a-z][0-9a-z]))|(([1-9A-Z][0-9A-Z]{2})|([1-9a-z][0-9a-z]{2}))"/&gt;
     */
    @XmlAttribute(name = "tag", required = true)
    protected String tag;

    /**
     *  &lt;xsd:pattern value="[\da-z ]{1}"/&gt;
     */
    @XmlAttribute(name = "ind1", required = true)
    protected String ind1;

    /**
     *  &lt;xsd:pattern value="[\da-z ]{1}"/&gt;
     */
    @XmlAttribute(name = "ind2", required = true)
    protected String ind2;

    public List<MarcSubfield> getSubfields() {
        return subfields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getInd1() {
        return ind1;
    }

    public void setInd1(String ind1) {
        this.ind1 = ind1;
    }

    public String getInd2() {
        return ind2;
    }

    public void setInd2(String ind2) {
        this.ind2 = ind2;
    }

    public static Builder builder() {
        return builder(new MarcDatafield());
    }

    public static Builder builder(MarcDatafield datafield) {
        return new Builder(datafield);
    }

    public static class Builder extends BuilderBase<MarcDatafield, Builder> {

        protected Builder(MarcDatafield datafield) {
            super(datafield);
        }

        public Builder addSubfield(MarcSubfield subfield) {
            _target().getSubfields().add(subfield);
            return _self();
        }

        public Builder addSubfield(String code, String content) {
            MarcSubfield sf = new MarcSubfield();
            sf.setCode(code);
            sf.setContent(content);
            return addSubfield(sf);
        }

        public Builder id(String id) {
            _target().setId(id);
            return _self();
        }

        public Builder tag(String tag) {
            _target().setTag(tag);
            return _self();
        }

        public Builder ind1(String ind1) {
            _target().setInd1(ind1);
            return _self();
        }

        public Builder ind2(String ind2) {
            _target().setInd2(ind2);
            return _self();
        }
    }
}
