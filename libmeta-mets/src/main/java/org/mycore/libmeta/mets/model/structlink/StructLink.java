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
package org.mycore.libmeta.mets.model.structlink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * {@code
 * <xsd:complexType name="structLinkType">
 * }
 * 
 * structLinkType: Complex Type for Structural Map Linking
 * 
 * The Structural Map Linking section allows for the specification of hyperlinks
 * between different components of a METS structure delineated in a structural
 * map. structLink contains a single, repeatable element, smLink. Each smLink
 * element indicates a hyperlink between two nodes in the structMap. The
 * structMap nodes recorded in smLink are identified using their XML ID
 * attribute values.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class StructLink {
    // <xsd:choice maxOccurs="unbounded">
    // <xsd:element name="smLink" />
    // <xsd:element name="smLinkGrp" />
    // </xsd:choice>
    @XmlElements({
        @XmlElement(name = "smLink", namespace = "http://www.loc.gov/METS/", type = SmLink.class),
        @XmlElement(name = "smLinkGrp", namespace = "http://www.loc.gov/METS/", type = SmLinkGrp.class) })
    protected List<SmLinkOrSmLinkGrp> smLinkOrsmLinkGrp = new Vector<>();

    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
     * }
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
     * {@code
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<SmLinkOrSmLinkGrp> getSmLinkOrSmLinkGrp() {
        return smLinkOrsmLinkGrp;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public static Builder builder() {
        return builder(new StructLink());
    }

    public static Builder builder(StructLink sl) {
        return new Builder(sl);
    }

    public static class Builder extends BuilderBase<StructLink, Builder> {

        protected Builder(StructLink sl) {
            super(sl);
        }

        public Builder addSmLink(SmLink smLink) {
            _target().getSmLinkOrSmLinkGrp().add(smLink);
            return _self();
        }

        public Builder addSmLinkGrp(SmLinkGrp smLinkGrp) {
            _target().getSmLinkOrSmLinkGrp().add(smLinkGrp);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
