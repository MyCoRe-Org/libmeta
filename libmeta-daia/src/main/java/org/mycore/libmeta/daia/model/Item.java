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
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * An identified information object. This record corresponds to the class Item
   in FRBR. That means multiple copies are encoded with multiple occurrences of this element.
   
 * @author Robert Stephan
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "message", "label", "department", "storage", "available", "unavailable" })
public class Item {

    // <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>
    @XmlElement(name = "message", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Message> message = new Vector<Message>();

    /**
     * Textual label for an item (for instance the call number)
     */
    // <xs:element maxOccurs="1" minOccurs="0" ref="label"/>
    @XmlElement(name = "label", namespace = "http://ws.gbv.de/daia/", required = false)
    protected String label;

    /**
     * an administrative sub-entitity of the institution that is responsible for this item
     */
    // <xs:element maxOccurs="1" minOccurs="0" ref="department"/>
    @XmlElement(name = "department", namespace = "http://ws.gbv.de/daia/", required = false)
    protected SimpleElement department;

    /**
     * a physical location of the item (building, stack, floor etc.)
     */
    // <xs:element maxOccurs="1" minOccurs="0" ref="storage"/>
    @XmlElement(name = "storage", namespace = "http://ws.gbv.de/daia/", required = false)
    protected SimpleElement storage;
    
    
    @XmlElement(name = "available", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Available> available = new Vector<Available>();
    
    @XmlElement(name = "unavailable", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Unavailable> unavailable = new Vector<Unavailable>();  

    /**
     * An item must be identified by an URI. Real URIs of a given schema should be used, 
     * but you can also use pseudo URIs that only match the lexical form of an URI.
    */
    //<xs:attribute name="id" type="xs:anyURI" use="optional">

    @XmlAttribute(name = "id", required = false)
    protected String id;

    /**
     * Indicates that the availability information is only valid for a part if
     * the requested item. You should avoid this flag but giving partial information is better
     * then giving no information at all.
     */
    //<xs:attribute name="part" type="partType">
    @XmlAttribute(name = "part", required = false)
    protected Part part;

    /**
     * Hyperlink to information about the item
     */
    //<xs:attribute name="href" type="xs:anyURI">
    @XmlAttribute(name = "href", required = false)
    protected String href;

    /**
     * Either 'broader' or 'narrower'
     * @author Robert Stephan
     *
     */
    @XmlEnum
    public enum Part {
        /**
         * Item can be used inside the institution (in their rooms, in their intranet etc.)
         */
        @XmlEnumValue("broader")
        BROADER,

        /**
         * Item can be used outside of the institution (by lending or online access)
         */
        @XmlEnumValue("narrower")
        NARROWER;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public SimpleElement getDepartment() {
        return department;
    }

    public void setDepartment(SimpleElement department) {
        this.department = department;
    }

    public SimpleElement getStorage() {
        return storage;
    }

    public void setStorage(SimpleElement storage) {
        this.storage = storage;
    }

    public List<Available> getAvailable() {
        return available;
    }

    public void setAvailable(List<Available> available) {
        this.available = available;
    }

    public List<Unavailable> getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(List<Unavailable> unavailable) {
        this.unavailable = unavailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
