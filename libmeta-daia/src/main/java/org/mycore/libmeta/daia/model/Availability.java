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
 * Availability of an item in a specific service.
 * 
 * @author Robert Stephan
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Availability {
    @XmlElement(name = "message", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Message> message = new Vector<Message>();
    
    /**
     * Information about a more specific limitation of the availability.
     *  Semantics of limitations are not part of the core DAIA standard.
     *  If you use this element, a general client can only see that there is 
     *  a limitation but not which kind of limitation. You can provide a textual
     *  description, a link and/or an id.
     */
    @XmlElement(name = "limitation", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<SimpleElement> limitation = new Vector<SimpleElement>();
    
    @XmlAttribute(name = "service", required = false)
    protected Service service;
    
    /**
     * URL to get or reserve the service
     */
    @XmlAttribute(name = "href", required = false)
    protected String href;
    
    @XmlEnum
    public enum Service {
        /**
         * Item can be used inside the institution (in their rooms, in their intranet etc.)
         */
        @XmlEnumValue("presentation")
        PRESENTATION,

        /**
         * Item can be used outside of the institution (by lending or online access)
         */
        @XmlEnumValue("loan")
        LOAN,

        /**
         * Item can be used mediated by another institution. 
         * That means you do not have to interact with the institution that was queried for this item. 
         * This include interlibrary loan as well as public online ressources 
         * that are not hosted or made available by the queried institution.
         */
        @XmlEnumValue("interloan")
        INTERLOAN,
        /**
         * Item can be used without any restrictions by the institution. 
         * This applies to free online publications or free give-aways.
         */
        @XmlEnumValue("openaccess")
        OPENACCESS;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<SimpleElement> getLimitation() {
        return limitation;
    }

    public void setLimitation(List<SimpleElement> limitation) {
        this.limitation = limitation;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}