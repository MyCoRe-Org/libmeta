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

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * {@code
 * <xsd:complexType name="behaviorType">
 * }
 * 
 * behaviorType: Complex Type for Behaviors
 * 
 * A behavior can be used to associate executable behaviors with content in the
 * METS object. A behavior element has an interface definition element that
 * represents an abstract definition of the set of behaviors represented by a
 * particular behavior. A behavior element also has an behavior mechanism which
 * is a module of executable code that implements and runs the behavior defined
 * abstractly by the interface definition.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "interfaceDef", "mechanism" })
public class Behavior {
    // <xsd:sequence>
    /**
     * {@code
     * <xsd:element name="interfaceDef" type="objectType" minOccurs="0">
     * }
     * 
     * The interface definition &lt;interfaceDef&gt; element contains a pointer
     * to an abstract definition of a single behavior or a set of related
     * behaviors that are associated with the content of a METS object. The
     * interface definition object to which the &lt;interfaceDef&gt; element
     * points using xlink:href could be another digital object, or some other
     * entity, such as a text file which describes the interface or a Web
     * Services Description Language (WSDL) file. Ideally, an interface
     * definition object contains metadata that describes a set of behaviors or
     * methods. It may also contain files that describe the intended usage of
     * the behaviors, and possibly files that represent different expressions of
     * the interface definition.
     */
    @XmlElement(name = "interfaceDef", namespace = "http://www.loc.gov/METS/", required = false)
    protected Object interfaceDef;

    /**
     * {@code
     * <xsd:element name="mechanism" type="objectType">
     * }
     * 
     * A mechanism element &lt;mechanism&gt; contains a pointer to an executable
     * code module that implements a set of behaviors defined by an interface
     * definition. The &lt;mechanism&gt; element will be a pointer to another
     * object (a mechanism object). A mechanism object could be another METS
     * object, or some other entity (e.g., a WSDL file). A mechanism object
     * should contain executable code, pointers to executable code, or
     * specifications for binding to network services (e.g., web services).
     */
    @XmlElement(name = "mechanism", namespace = "http://www.loc.gov/METS/", required = true)
    protected Object mechanism;

    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
     * }
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. In the case of a
     * &lt;behavior&gt; element that applies to a &lt;transformFile&gt; element,
     * the ID value must be present and would be referenced from the
     * transformFile/@TRANSFORMBEHAVIOR attribute. For more information on using
     * ID attributes for internal and external linking see Chapter 4 of the METS
     * Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    /**
     * {@code
     * <xsd:attribute name="STRUCTID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * STRUCTID (IDREFS/O): An XML IDREFS attribute used to link a
     * &lt;behavior&gt; to one or more &lt;div&gt; elements within a
     * &lt;structMap&gt; in the METS document. The content to which the STRUCTID
     * points is considered input to the executable behavior mechanism defined
     * for the behavior. If the &lt;behavior&gt; applies to one or more
     * &lt;div&gt; elements, then the STRUCTID attribute must be present.
     */
    @XmlAttribute(name = "STRUCTID", required = false)
    protected String STRUCTID;

    /**
     * {@code
     * <xsd:attribute name="BTYPE" type="xsd:string" use="optional">
     * }
     * 
     * BTYPE (string/O): The behavior type provides a means of categorizing the
     * related behavior.
     */
    @XmlAttribute(name = "BTYPE", required = false)
    protected String BTYPE;

    /**
     * {@code
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATED (dateTime/O): The dateTime of creation for the behavior.
     */
    @XmlAttribute(name = "CREATED", required = false)
    protected String CREATED;

    /**
     * {@code
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * }
     * 
     * LABEL (string/O): A text description of the behavior.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    /**
     * {@code
     * <xsd:attribute name="GROUPID" type="xsd:string" use="optional">
     * }
     * 
     * GROUPID (string/O): An identifier that establishes a correspondence
     * between the given behavior and other behaviors, typically used to
     * facilitate versions of behaviors.
     */
    @XmlAttribute(name = "GROUPID", required = false)
    protected String GROUPID;

    /**
     * {@code
     * <xsd:attribute name="ADMID" type="xsd:IDREFS" use="optional">
     * }
     * 
     * ADMID (IDREFS/O): An optional attribute listing the XML ID values of
     * administrative metadata sections within the METS document pertaining to
     * this behavior.
     */
    @XmlAttribute(name = "ADMID", required = false)
    protected String ADMID;

    public Object getInterfaceDef() {
        return interfaceDef;
    }

    public void setInterfaceDef(Object interfaceDef) {
        this.interfaceDef = interfaceDef;
    }

    public Object getMechanism() {
        return mechanism;
    }

    public void setMechanism(Object mechanism) {
        this.mechanism = mechanism;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getSTRUCTID() {
        return STRUCTID;
    }

    public void setSTRUCTID(String structId) {
        STRUCTID = structId;
    }

    public String getBTYPE() {
        return BTYPE;
    }

    public void setBTYPE(String bType) {
        BTYPE = bType;
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

    public String getGROUPID() {
        return GROUPID;
    }

    public void setGROUPID(String groupId) {
        GROUPID = groupId;
    }

    public String getADMID() {
        return ADMID;
    }

    public void setADMID(String admId) {
        ADMID = admId;
    }

    public static Builder builder() {
        return builder(new Behavior());
    }

    public static Builder builder(Behavior b) {
        return new Builder(b);
    }

    public static class Builder extends BuilderBase<Behavior, Builder> {

        protected Builder(Behavior b) {
            super(b);
        }

        public Builder interfaceDef(Object interfaceDef) {
            _target().setInterfaceDef(interfaceDef);
            return _self();
        }

        public Builder mechanism(Object mechanism) {
            _target().setMechanism(mechanism);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder STRUCTID(String structID) {
            _target().setSTRUCTID(structID);
            return _self();
        }

        public Builder BTYPE(String bType) {
            _target().setBTYPE(bType);
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

        public Builder GROUPID(String groupID) {
            _target().setGROUPID(groupID);
            return _self();
        }

        public Builder ADMID(String admID) {
            _target().setADMID(admID);
            return _self();
        }
    }
}
