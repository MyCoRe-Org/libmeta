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
 * MARC21 subfield
 *  <xsd:complexType name="subfieldatafieldType" id="subfield.ct">
 *    <xsd:simpleContent>
 *      <xsd:extension base="subfieldDataType">
 *        <xsd:attribute name="id" type="idDataType" use="optional"/>
 *        <xsd:attribute name="code" type="subfieldcodeDataType" use="required"/>
 *      </xsd:extension>
 *    </xsd:simpleContent>
 *  </xsd:complexType>
 *  <xsd:simpleType name="subfieldDataType" id="subfield.st">
 *    <xsd:restriction base="xsd:string">
 *      <xsd:whiteSpace value="preserve"/>
 *    </xsd:restriction>
 *  </xsd:simpleType>
 *  <xsd:simpleType name="subfieldcodeDataType" id="code.st">
 *    <xsd:restriction base="xsd:string">
 *      <xsd:whiteSpace value="preserve"/>
 *      <xsd:pattern value="[\dA-Za-z!&quot;#$%&amp;'()*+,-./:;&lt;=&gt;?{}_^`~\[\]\\]{1}"/>
 *      <!-- "A-Z" added after "\d" May 21, 2009 -->
 *    </xsd:restriction>
 *  </xsd:simpleType>
 * 
 * @author Robert Stephan
 * @version MARC21 1.2
 * 
 */

@XmlRootElement(name = "subfield", namespace = "info:srw/schema/5/picaXML-v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class MarcSubfield extends MarcObject {

    @XmlValue
    protected String content;

    /**
     * <xsd:pattern value="[\dA-Za-z!&quot;#$%&amp;'()*+,-./:;&lt;=&gt;?{}_^`~\[\]\\]{1}"/> 
     */
    @XmlAttribute(name = "code", required = true)
    protected String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Builder builder() {
        return builder(new MarcSubfield());
    }

    public static Builder builder(MarcSubfield subfield) {
        return new Builder(subfield);
    }

    public static class Builder extends BuilderBase<MarcSubfield, Builder> {

        protected Builder(MarcSubfield subfield) {
            super(subfield);
        }

        public Builder content(String content) {
            _target().setContent(content);
            return _self();
        }

        public Builder code(String code) {
            _target().setCode(code);
            return _self();
        }
    }
}
