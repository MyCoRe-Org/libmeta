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
package org.mycore.libmeta.oaidc.model;

import java.util.ArrayList;
import java.util.List;

import org.mycore.libmeta.dcsimple.model.ElementType;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java-Klasse für oai_dcType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="oai_dcType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}title"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}creator"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}subject"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}description"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}publisher"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}contributor"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}date"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}type"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}format"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}identifier"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}source"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}language"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}relation"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}coverage"/&gt;
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}rights"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oai_dcType", namespace = "http://www.openarchives.org/OAI/2.0/oai_dc/", propOrder = {
    "elements"
})
@XmlRootElement(name = "dc")
public class OaiDc {

    @XmlElementRefs({
        @XmlElementRef(name = "title", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "creator", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "subject", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "description", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "publisher", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "contributor", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "date", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "type", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "format", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "identifier", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "source", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "language", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "relation", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "coverage", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false),
        @XmlElementRef(name = "rights", namespace = "http://purl.org/dc/elements/1.1/", type = JAXBElement.class,
            required = false)
    })
    protected List<JAXBElement<ElementType>> elements;

    /**
     * Gets the value of the elements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the elements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElements().add(newItem);
     * </pre>
     */
    public List<JAXBElement<ElementType>> getElements() {
        if (elements == null) {
            elements = new ArrayList<JAXBElement<ElementType>>();
        }
        return this.elements;
    }

    public static OaiDcBuilder builder() {
        return new OaiDcBuilder();
    }

    public static class OaiDcBuilder {
        private OaiDc oaiDc;

        protected OaiDcBuilder() {
            this.oaiDc = new OaiDc();
        }

        public OaiDcBuilder add(JAXBElement<ElementType> element) {
            oaiDc.getElements().add(element);
            return this;
        }

        public OaiDcBuilder addAll(List<JAXBElement<ElementType>> elements) {
            oaiDc.getElements().addAll(elements);
            return this;
        }

        public OaiDc build() {
            return oaiDc;
        }
    }
}
