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

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCCoverage;
import org.mycore.libmeta.dcsimple.model.DCCreator;
import org.mycore.libmeta.dcsimple.model.DCDate;
import org.mycore.libmeta.dcsimple.model.DCDescription;
import org.mycore.libmeta.dcsimple.model.DCElement;
import org.mycore.libmeta.dcsimple.model.DCElementRoot;
import org.mycore.libmeta.dcsimple.model.DCFormat;
import org.mycore.libmeta.dcsimple.model.DCIdentifier;
import org.mycore.libmeta.dcsimple.model.DCLanguage;
import org.mycore.libmeta.dcsimple.model.DCPublisher;
import org.mycore.libmeta.dcsimple.model.DCRelation;
import org.mycore.libmeta.dcsimple.model.DCRights;
import org.mycore.libmeta.dcsimple.model.DCSource;
import org.mycore.libmeta.dcsimple.model.DCSubject;
import org.mycore.libmeta.dcsimple.model.DCTitle;
import org.mycore.libmeta.dcsimple.model.DCType;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

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
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "dc", namespace = "http://www.openarchives.org/OAI/2.0/oai_dc/")
public class OaiDc implements DCElementRoot {

    @XmlElements({
        @XmlElement(name = "title", namespace = "http://purl.org/dc/elements/1.1/", type = DCTitle.class,
            required = false),
        @XmlElement(name = "creator", namespace = "http://purl.org/dc/elements/1.1/", type = DCCreator.class,
            required = false),
        @XmlElement(name = "subject", namespace = "http://purl.org/dc/elements/1.1/", type = DCSubject.class,
            required = false),
        @XmlElement(name = "description", namespace = "http://purl.org/dc/elements/1.1/", type = DCDescription.class,
            required = false),
        @XmlElement(name = "publisher", namespace = "http://purl.org/dc/elements/1.1/", type = DCPublisher.class,
            required = false),
        @XmlElement(name = "contributor", namespace = "http://purl.org/dc/elements/1.1/", type = DCContributor.class,
            required = false),
        @XmlElement(name = "date", namespace = "http://purl.org/dc/elements/1.1/", type = DCDate.class,
            required = false),
        @XmlElement(name = "type", namespace = "http://purl.org/dc/elements/1.1/", type = DCType.class,
            required = false),
        @XmlElement(name = "format", namespace = "http://purl.org/dc/elements/1.1/", type = DCFormat.class,
            required = false),
        @XmlElement(name = "identifier", namespace = "http://purl.org/dc/elements/1.1/", type = DCIdentifier.class,
            required = false),
        @XmlElement(name = "source", namespace = "http://purl.org/dc/elements/1.1/", type = DCSource.class,
            required = false),
        @XmlElement(name = "language", namespace = "http://purl.org/dc/elements/1.1/", type = DCLanguage.class,
            required = false),
        @XmlElement(name = "relation", namespace = "http://purl.org/dc/elements/1.1/", type = DCRelation.class,
            required = false),
        @XmlElement(name = "coverage", namespace = "http://purl.org/dc/elements/1.1/", type = DCCoverage.class,
            required = false),
        @XmlElement(name = "rights", namespace = "http://purl.org/dc/elements/1.1/", type = DCRights.class,
            required = false)
    })
    protected List<DCElement> elements = new Vector<>();

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
    public List<DCElement> getElements() {
        return elements;
    }

    public static Builder builder() {
        return builder(new OaiDc());
    }

    public static Builder builder(OaiDc dc) {
        return new Builder(dc);
    }

    public static class Builder {
        private OaiDc oaiDc;

        protected Builder(OaiDc dc) {
            this.oaiDc = dc;
        }

        public Builder add(DCElement element) {
            oaiDc.getElements().add(element);
            return this;
        }

        public Builder addAll(Collection<DCElement> elements) {
            oaiDc.getElements().addAll(elements);
            return this;
        }

        public OaiDc build() {
            return oaiDc;
        }
    }
}
