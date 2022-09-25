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
package org.mycore.libmeta.pica.model;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * This class implements a PicaXML subfield
 * 
 * a subfield contains any content
 * 
 * @see <a href="http://www.loc.gov/standards/sru/resources/pica-xml-v1-0.xsd">PicaXML XML Schema</a>
 * 
 * @author Robert Stephan
 * 
 */

@XmlRootElement(name = "subfield", namespace = "info:srw/schema/5/picaXML-v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class PicaSubfield implements PicaObject {
    /**
     * 
     */
    @XmlMixed
    protected List<Object> contents = new Vector<Object>();

    /**
     * &lt;xs:attribute name="" use="required"&gt;
     *   &lt;xs:simpleType&gt;
     *     &lt;xs:restriction base="xs:string"&gt;
     *       &lt;xs:pattern value="[0-9A-Za-z]"/&gt;
     *     &lt;/xs:restriction&gt;
     *   &lt;/xs:simpleType&gt;    
     * &lt;/xs:attribute&gt;      
     */
    @XmlAttribute(name = "code", required = true)
    protected String code;

    public List<Object> getContents() {
        return contents;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        if (contents.isEmpty())
            return null;
        StringBuffer result = new StringBuffer();
        for (Object o : contents) {
            result.append(o.toString());
        }
        return result.toString();
    }

    public void setContent(String content) {
        contents.clear();
        contents.add(content);
    }

    public static Builder builder() {
        return builder(new PicaSubfield());
    }

    public static Builder builder(PicaSubfield sub) {
        return new Builder(sub);
    }

    public static class Builder extends BuilderBase<PicaSubfield, Builder> {

        protected Builder(PicaSubfield sub) {
            super(sub);
        }

        public Builder content(String text) {
            _target().setContent(text);
            return _self();
        }

        public Builder code(String code) {
            _target().setCode(code);
            return _self();
        }
    }
}
