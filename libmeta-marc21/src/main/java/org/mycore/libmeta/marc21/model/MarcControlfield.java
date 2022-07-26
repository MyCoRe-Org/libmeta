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

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * MARC21 Fields 001-009
 * 
 *  <xsd:complexType name="controlFieldType" id="controlfield.ct">
 *   <xsd:annotation>
 *     <xsd:documentation>MARC21 Fields 001-009</xsd:documentation>
 *   </xsd:annotation>
 *   <xsd:simpleContent>
 *     <xsd:extension base="controlDataType">
 *       <xsd:attribute name="id" type="idDataType" use="optional"/>
 *       <xsd:attribute name="tag" type="controltagDataType" use="required"/>
 *     </xsd:extension>
 *   </xsd:simpleContent>
 * </xsd:complexType>
 * <xsd:simpleType name="controlDataType" id="controlfield.st">
 *   <xsd:restriction base="xsd:string">
 *     <xsd:whiteSpace value="preserve"/>
 *   </xsd:restriction>
 * </xsd:simpleType>
 * <xsd:simpleType name="controltagDataType" id="controltag.st">
 *   <xsd:restriction base="xsd:string">
 *     <xsd:whiteSpace value="preserve"/>
 *     <xsd:pattern value="00[1-9A-Za-z]{1}"/>
 *   </xsd:restriction>
 * </xsd:simpleType>
 * 
 * @author Robert Stephan
 * @verson MARC21 1.2
 * 
 */

@XmlRootElement(name = "controlfied", namespace = "http://www.loc.gov/MARC21/slim")
@XmlAccessorType(XmlAccessType.NONE)
public class MarcControlfield extends MarcObject {

    @XmlValue
    protected String content;

    @XmlAttribute(name = "id", required = false)
    protected String id;

    /**
     * <xsd:pattern value="00[1-9A-Za-z]{1}"/>
     */
    @XmlAttribute(name = "tag", required = true)
    protected String tag;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public static Builder builder() {
        return builder(new MarcControlfield());
    }

    public static Builder builder(MarcControlfield controlfield) {
        return new Builder(controlfield);
    }

    public static class Builder extends BuilderBase<MarcControlfield, Builder> {

        protected Builder(MarcControlfield controlfield) {
            super(controlfield);
        }

        public Builder content(String content) {
            _target().setContent(content);
            return _self();
        }

        public Builder tag(String tag) {
            _target().setTag(tag);
            return _self();
        }

        public Builder id(String id) {
            _target().setId(id);
            return _self();
        }
    }
}
