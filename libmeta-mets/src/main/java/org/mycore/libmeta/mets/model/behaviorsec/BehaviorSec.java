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
package org.mycore.libmeta.mets.model.behaviorsec;

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
import jakarta.xml.bind.annotation.XmlType;

/**
 * {@code
 * <xsd:complexType name="behaviorSecType">
 * }
 * behaviorSecType: Complex Type for Behavior Sections
 * 
 * Behaviors are executable code which can be associated with parts of a METS
 * object. The behaviorSec element is used to group individual behaviors within
 * a hierarchical structure. Such grouping can be useful to organize families of
 * behaviors together or to indicate other relationships between particular
 * behaviors.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "behaviorSec", "behavior" })
public class BehaviorSec {
    // <xsd:sequence>
    /**
     * {@code
     * <xsd:element name="behaviorSec" type="behaviorSecType" minOccurs="0"
     * maxOccurs="unbounded"/>
     * }
     * 
     * Behaviors are executable code which can be associated with parts of a
     * METS object. The behaviorSec element is used to group individual
     * behaviors within a hierarchical structure. Such grouping can be useful to
     * organize families of behaviors together or to indicate other
     * relationships between particular behaviors.
     */
    @XmlElement(name = "behaviorSec", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<BehaviorSec> behaviorSec = new Vector<>();

    /**
     * {@code
     * <xsd:element name="behavior" type="behaviorType" minOccurs="0"
     * maxOccurs="unbounded">
     * }
     * 
     * A behavior element &lt;behavior&gt; can be used to associate executable
     * behaviors with content in the METS document. This element has an
     * interface definition &lt;interfaceDef&gt; element that represents an
     * abstract definition of a set of behaviors represented by a particular
     * behavior. A &lt;behavior&gt; element also has a behavior mechanism
     * &lt;mechanism&gt; element, a module of executable code that implements
     * and runs the behavior defined abstractly by the interface definition.
     */
    @XmlElement(name = "behavior", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<Behavior> behavior = new Vector<>();

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
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATED (dateTime/O): Specifies the date and time of creation for the
     * &lt;behaviorSec&gt;
     */
    @XmlAttribute(name = "CREATED", required = false)
    protected String CREATED;

    /**
     * {@code
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * }
     * 
     * LABEL (string/O): A text description of the behavior section.
     */
    @XmlAttribute(name = "LABEl", required = false)
    protected String LABEL;

    /**
     * {@code
     * <xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<BehaviorSec> getBehaviorSec() {
        return behaviorSec;
    }

    public List<Behavior> getBehavior() {
        return behavior;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getCREATED() {
        return CREATED;
    }

    public void setCREATED(String created) {
        CREATED = created;
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

    public String getOtherAttribute(QName qname) {
        return otherAttributes.get(qname);
    }

    public static Builder builder() {
        return builder(new BehaviorSec());
    }

    public static Builder builder(BehaviorSec b) {
        return new Builder(b);
    }

    public static class Builder extends BuilderBase<BehaviorSec, Builder> {

        protected Builder(BehaviorSec bs) {
            super(bs);
        }

        public Builder addBehaviorSec(BehaviorSec behaviorSec) {
            _target().getBehaviorSec().add(behaviorSec);
            return _self();
        }

        public Builder addBehavior(Behavior behavior) {
            _target().getBehavior().add(behavior);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder CREATED(String created) {
            _target().setCREATED(created);
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
