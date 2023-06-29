package org.mycore.libmeta.dfgviewer.model.links;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * <p>This class implements a Java model for a DFGViewer reference object.
 * <p>It is a subelement of <pre>links</pre>.
 * 
 * <p>The following schema describes the expected content:
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="linktext" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "", propOrder = {"value"})
public class Reference {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "linktext")
    protected String linktext;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der linktext-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinktext() {
        return linktext;
    }

    /**
     * Legt den Wert der linktext-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinktext(String value) {
        this.linktext = value;
    }

    public static ReferenceBuilder builder() {
        return builder(new Reference());
    }

    public static ReferenceBuilder builder(Reference reference) {
        return new ReferenceBuilder(reference);
    }

    public static class ReferenceBuilder extends BuilderBase<Reference, ReferenceBuilder> {
        protected ReferenceBuilder(Reference r) {
            super(r);
        }

        public ReferenceBuilder linktext(String linktext) {
            _target().setLinktext(linktext);
            return _self();
        }

        public ReferenceBuilder value(String value) {
            _target().setValue(value);
            return _self();
        }
    }
}