//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v3.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2023.06.23 um 12:38:43 PM CEST 
//

package org.mycore.libmeta.dfgviewer.model;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für anonymous complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ownerLogo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ownerSiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ownerContact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="aggregator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aggregatorLogo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aggregatorSiteURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sponsor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sponsorLogo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sponsorSiteURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="license" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "owner", "ownerLogo", "ownerSiteURL", "ownerContact", "aggregator", "aggregatorLogo",
    "aggregatorSiteURL", "sponsor", "sponsorLogo", "sponsorSiteURL", "license" })
@XmlRootElement(name = "rights")
public class Rights {

    @XmlElement(required = true)
    protected String owner;
    @XmlElement(required = true)
    protected String ownerLogo;
    @XmlElement(required = true)
    protected String ownerSiteURL;
    @XmlElement(required = true)
    protected String ownerContact;
    protected String aggregator;
    protected String aggregatorLogo;
    protected String aggregatorSiteURL;
    protected String sponsor;
    protected String sponsorLogo;
    protected String sponsorSiteURL;
    protected String license;

    /**
     * Ruft den Wert der owner-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Legt den Wert der owner-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Ruft den Wert der ownerLogo-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOwnerLogo() {
        return ownerLogo;
    }

    /**
     * Legt den Wert der ownerLogo-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOwnerLogo(String value) {
        this.ownerLogo = value;
    }

    /**
     * Ruft den Wert der ownerSiteURL-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOwnerSiteURL() {
        return ownerSiteURL;
    }

    /**
     * Legt den Wert der ownerSiteURL-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOwnerSiteURL(String value) {
        this.ownerSiteURL = value;
    }

    /**
     * Ruft den Wert der ownerContact-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getOwnerContact() {
        return ownerContact;
    }

    /**
     * Legt den Wert der ownerContact-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setOwnerContact(String value) {
        this.ownerContact = value;
    }

    /**
     * Ruft den Wert der aggregator-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAggregator() {
        return aggregator;
    }

    /**
     * Legt den Wert der aggregator-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setAggregator(String value) {
        this.aggregator = value;
    }

    /**
     * Ruft den Wert der aggregatorLogo-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAggregatorLogo() {
        return aggregatorLogo;
    }

    /**
     * Legt den Wert der aggregatorLogo-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setAggregatorLogo(String value) {
        this.aggregatorLogo = value;
    }

    /**
     * Ruft den Wert der aggregatorSiteURL-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getAggregatorSiteURL() {
        return aggregatorSiteURL;
    }

    /**
     * Legt den Wert der aggregatorSiteURL-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setAggregatorSiteURL(String value) {
        this.aggregatorSiteURL = value;
    }

    /**
     * Ruft den Wert der sponsor-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * Legt den Wert der sponsor-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSponsor(String value) {
        this.sponsor = value;
    }

    /**
     * Ruft den Wert der sponsorLogo-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSponsorLogo() {
        return sponsorLogo;
    }

    /**
     * Legt den Wert der sponsorLogo-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSponsorLogo(String value) {
        this.sponsorLogo = value;
    }

    /**
     * Ruft den Wert der sponsorSiteURL-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSponsorSiteURL() {
        return sponsorSiteURL;
    }

    /**
     * Legt den Wert der sponsorSiteURL-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSponsorSiteURL(String value) {
        this.sponsorSiteURL = value;
    }

    /**
     * Ruft den Wert der license-Eigenschaft ab.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getLicense() {
        return license;
    }

    /**
     * Legt den Wert der license-Eigenschaft fest.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setLicense(String value) {
        this.license = value;
    }

    public static Builder builder() {
        return builder(new Rights());
    }

    public static Builder builder(Rights rights) {
        return new Builder(rights);
    }

    public static class Builder extends BuilderBase<Rights, Builder> {
        protected Builder(Rights r) {
            super(r);
        }

        public Builder owner(String owner) {
            _target().setOwner(owner);
            return _self();
        }

        public Builder ownerContact(String ownerContact) {
            _target().setOwnerContact(ownerContact);
            return _self();
        }

        public Builder ownerLogo(String ownerLogo) {
            _target().setOwnerLogo(ownerLogo);
            return _self();
        }

        public Builder ownerSiteUrl(String ownerSiteUrl) {
            _target().setOwnerSiteURL(ownerSiteUrl);
            return _self();
        }
    }
}
