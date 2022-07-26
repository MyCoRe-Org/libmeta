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

import java.util.List;
import java.util.Vector;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * a group of items that can be refered to with one identifier
 * 
 * @author Robert Stephan
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Document {
    @XmlElement(name = "message", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Message> message = new Vector<Message>();
    
    @XmlElement(name = "item", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Item> item = new Vector<Item>();
    
    /**
     * Identifier of a document
     */
    //<xs:attribute name="id" type="xs:anyURI" use="required">
    @XmlAttribute(name = "id", required = true)
    protected String id;
    
    /**
     * Hyperlink to information about the document
     */
    @XmlAttribute(name = "href", required = false)
    protected String href;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

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
}
