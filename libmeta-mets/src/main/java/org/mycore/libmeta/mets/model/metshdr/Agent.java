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
package org.mycore.libmeta.mets.model.metshdr;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._enums.AgentROLE;
import org.mycore.libmeta.mets.model._enums.AgentTYPE;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * The agent element &lt;agent&gt; provides for various parties and their roles with respect to the METS 
 * record to be documented.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "name", "note" })
public class Agent {
    // sequence

    /**
     * {@code
     * <xsd:element name="name" type="xsd:string">
     * }
     * 
     * The element &lt;name&gt; can be used to record the full name of the
     * document agent.
     */
    @XmlElement(name = "name", namespace = "http://www.loc.gov/METS/", required = true)
    protected String name;

    /**
     * {@code
     * <xsd:element name="altRecordID" minOccurs="0" maxOccurs="unbounded">
     * }
     * 
     * The &lt;note&gt; element can be used to record any additional information
     * regarding the agent's activities with respect to the METS document.
     */
    @XmlElement(name = "note", namespace = "http://www.loc.gov/METS/", required = false)
    protected List<AgentNote> note = new Vector<AgentNote>();

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
     * <xsd:attribute name="ROLE" use="required"> 
     * }
     * ROLE (string/R): Specifies the function of the agent with respect to the METS record. 
     * The allowed values are:
     *    CREATOR: The person(s) or institution(s) responsible for the METS document.
     *    EDITOR: The person(s) or institution(s) that prepares the metadata for encoding.
     *    ARCHIVIST: The person(s) or institution(s) responsible for the document/collection.
     *    PRESERVATION: The person(s) or institution(s) responsible for preservation functions.
     *    DISSEMINATOR: The person(s) or institution(s) responsible for dissemination functions.
     *    CUSTODIAN: The person(s) or institution(s) charged with the oversight of a document/collection.
     *    IPOWNER: Intellectual Property Owner: The person(s) or institution holding copyright, trade or service marks or other
     *             intellectual property rights for the object.
     *     OTHER: Use OTHER if none of the preceding values pertains and clarify the type and location specifier being used in
     *		      the OTHERROLE attribute (see below).
     *
     */

    @XmlAttribute(name = "ROLE", required = true)
    protected AgentROLE ROLE;

    /**
     * {@code
     * <xsd:attribute name="OTHERROLE" type="xsd:string" use="optional">
     * }
     * 
     * OTHERROLE (string/O): Denotes a role not contained in the allowed values
     * set if OTHER is indicated in the ROLE attribute.
     */
    @XmlAttribute(name = "OTHERROLE", required = false)
    protected String OTHERROLE;

    /**
     * {@code
     * <xsd:attribute name="TYPE" use="optional" />
     * }
     * TYPE (string/O): is used to specify the type of AGENT. 
     * It must be one of the following values:
     *   INDIVIDUAL: Use if an individual has served as the agent.
     *   ORGANIZATION: Use if an institution, corporate body, association, non-profit enterprise, government, religious body, etc.
     *      			has served as the agent.
     *   OTHER: Use OTHER if none of the preceding values pertain and clarify the type of agent specifier being used in the
     *	 OTHERTYPE attribute
     */
    @XmlAttribute(name = "TYPE", required = false)
    protected AgentTYPE TYPE;

    /**
     * {@code
     * <xsd:attribute name="OTHERTYPE" type="xsd:string" use="optional">
     * }
     * 
     * OTHERTYPE (string/O): Specifies the type of agent when the value OTHER is
     * indicated in the TYPE attribute.
     */
    @XmlAttribute(name = "OTHERTYPE", required = false)
    protected String OTHERTYPE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AgentNote> getNote() {
        return note;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public AgentROLE getROLE() {
        return ROLE;
    }

    public void setROLE(AgentROLE rOLE) {
        ROLE = rOLE;
    }

    public String getOTHERROLE() {
        return OTHERROLE;
    }

    public void setOTHERROLE(String oTHERROLE) {
        OTHERROLE = oTHERROLE;
    }

    public AgentTYPE getTYPE() {
        return TYPE;
    }

    public void setTYPE(AgentTYPE tYPE) {
        TYPE = tYPE;
    }

    public String getOTHERTYPE() {
        return OTHERTYPE;
    }

    public void setOTHERTYPE(String oTHERTYPE) {
        OTHERTYPE = oTHERTYPE;
    }

    public static Builder builder() {
        return builder(new Agent());
    }

    public static Builder builder(Agent a) {
        return new Builder(a);
    }

    public static class Builder extends BuilderBase<Agent, Builder> {

        protected Builder(Agent a) {
            super(a);
        }

        public Builder name(String name) {
            _target().setName(name);
            return _self();
        }

        public Builder addNote(AgentNote note) {
            _target().getNote().add(note);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder ROLE(AgentROLE role) {
            _target().setROLE(role);
            return _self();
        }

        public Builder OTHERROLE(String otherRole) {
            _target().setOTHERROLE(otherRole);
            return _self();
        }

        public Builder TYPE(AgentTYPE type) {
            _target().setTYPE(type);
            return _self();
        }

        public Builder OTHERTYPE(String otherType) {
            _target().setOTHERTYPE(otherType);
            return _self();
        }
    }
}
