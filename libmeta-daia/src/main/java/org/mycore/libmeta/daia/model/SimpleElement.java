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
package org.mycore.libmeta.daia.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * This is an abstract element type that allows the two 
 * attributes 'id' and 'href' (both optional) and textual content.
 *      
 * @author Robert Stephan
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class SimpleElement {

    /**
     * Identifier of this element
     *
     * //<xs:attribute name="id" type="xs:anyURI" use="optional">
     */
    @XmlAttribute(name = "id", required = false)
    protected String id;

    /**
     * Hyperlink to information about this element
     * 
     * //<xs:attribute name="href" type="xs:anyURI" use="optional">
     */
    @XmlAttribute(name = "href", required = false)
    protected String href;

    @XmlValue
    protected String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
