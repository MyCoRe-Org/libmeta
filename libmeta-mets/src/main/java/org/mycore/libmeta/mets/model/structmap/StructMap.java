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
package org.mycore.libmeta.mets.model.structmap;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <xsd:complexType name="structMapType">
 * 
 * structMapType: Complex Type for Structural Maps
 * 
 * The structural map (structMap) outlines a hierarchical structure for the
 * original object being encoded, using a series of nested div elements.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "div" })
public class StructMap {
    // <xsd:sequence>

    /**
     * <xsd:element name="div" type="divType">
     * 
     * The structural divisions of the hierarchical organization provided by a
     * &lt;structMap&gt; are represented by division &lt;div&gt; elements, which
     * can be nested to any depth. Each &lt;div&gt; element can represent either
     * an intellectual (logical) division or a physical division. Every
     * &lt;div&gt; node in the structural map hierarchy may be connected (via
     * subsidiary &lt;mptr&gt; or &lt;fptr&gt; elements) to content files which
     * represent that div's portion of the whole document.
     */
    @XmlElement(name = "div", namespace = "http://www.loc.gov/METS/", required = true)
    protected Div div;

    /**
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. For more information
     * on using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    /**
     * <xsd:attribute name="TYPE" type="xsd:string" use="optional">
     * 
     * TYPE (string/O): Identifies the type of structure represented by the
     * &lt;structMap&gt;. For example, a &lt;structMap&gt; that represented a
     * purely logical or intellectual structure could be assigned a TYPE value
     * of "logical" whereas a &lt;structMap&gt; that represented a purely
     * physical structure could be assigned a TYPE value of "physical". However,
     * the METS schema neither defines nor requires a common vocabulary for this
     * attribute. A METS profile, however, may well constrain the values for the
     * &lt;structMap&gt; TYPE.
     */
    @XmlAttribute(name = "TYPE", required = false)
    protected String TYPE;

    /**
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * 
     * LABEL (string/O): Describes the &lt;structMap&gt; to viewers of the METS
     * document. This would be useful primarily where more than one
     * &lt;structMap&gt; is provided for a single object. A descriptive LABEL
     * value, in that case, could clarify to users the purpose of each of the
     * available structMaps.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    /**
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public Div getDiv() {
        return div;
    }

    public void setDiv(Div div) {
        this.div = div;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String type) {
        TYPE = type;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String label) {
        LABEL = label;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new StructMap());
    }

    public static Builder builder(StructMap sm) {
        return new Builder(sm);
    }

    public static class Builder extends BuilderBase<StructMap, Builder> {

        protected Builder(StructMap sm) {
            super(sm);
        }

        public Builder div(Div div) {
            _target().setDiv(div);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder TYPE(String type) {
            _target().setTYPE(type);
            return _self();
        }

        public Builder LABEL(String label) {
            _target().setLABEL(label);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
