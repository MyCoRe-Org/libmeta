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
package org.mycore.libmeta.alto__4.model.description;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * A unique identifier for the document.
 * 
 * This identifier must be unique within the local system.
 * To facilitate file sharing or interoperability with other systems, 
 * documentIdentifierLocation may be added to designate the system or application
 * where the identifier is unique.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class DocumentIdentifier {

    @XmlValue
    protected String value;

    /** A location qualifier, i.e., a namespace. */
    @XmlAttribute(name = "documentIdentifierLocation", required = false)
    protected String documentIdentifierLocation;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDocumentIdentifierLocation() {
        return documentIdentifierLocation;
    }

    public void setDocumentIdentifierLocation(String documentIdentifierLocation) {
        this.documentIdentifierLocation = documentIdentifierLocation;
    }

    public static Builder builder() {
        return builder(new DocumentIdentifier());
    }

    public static Builder builder(DocumentIdentifier documentIdentifier) {
        return new Builder(documentIdentifier);
    }

    public static class Builder extends BuilderBase<DocumentIdentifier, Builder> {

        protected Builder(DocumentIdentifier documentIdentifier) {
            super(documentIdentifier);
        }

        public Builder value(String value) {
            _target().setValue(value);
            return _self();
        }

        public Builder documentIdentifierLocation(String documentIdentifierLocation) {
            _target().setDocumentIdentifierLocation(documentIdentifierLocation);
            return _self();
        }
    }
}
