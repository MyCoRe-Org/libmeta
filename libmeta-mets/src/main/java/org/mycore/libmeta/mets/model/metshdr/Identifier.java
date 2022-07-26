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

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * A general METS ID based on String Content with an ID Attribute and and a TYPE
 * attribute
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Identifier {

    @XmlValue
    protected String content;

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
     * TYPE (string/O): A description of the identifier type.
     */
    @XmlAttribute(name = "TYPE", required = false)
    protected String TYPE;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public static Builder builder() {
        return builder(new Identifier());
    }

    public static Builder builder(Identifier id) {
        return new Builder(id);
    }

    public static class Builder extends BuilderBase<Identifier, Builder> {

        protected Builder(Identifier id) {
            super(id);
        }

        public Builder content(String content) {
            _target().setContent(content);
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
    }
}
