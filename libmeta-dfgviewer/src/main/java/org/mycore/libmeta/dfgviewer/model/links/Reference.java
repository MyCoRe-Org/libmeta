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
@XmlType(name = "", propOrder = { "content" })
public class Reference {

    @XmlValue
    protected String content;

    @XmlAttribute(name = "linktext")
    protected String linktext;

    /**
     * Ruft den Wert der content-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Legt den Wert der content-Eigenschaft fest.
     * 
     * @param content
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String content) {
        this.content = content;
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

        public ReferenceBuilder content(String content) {
            _target().setContent(content);
            return _self();
        }
    }
}
