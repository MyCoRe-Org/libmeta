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
package org.mycore.libmeta.alto.model.description;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * A unique identifier for the image file. This is drawn from MIX.
 * 
 * This identifier must be unique within the local system. To facilitate file
 * sharing or interoperability with other systems, fileIdentifierLocation may be
 * added to designate the system or application where the identifier is unique.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class FileIdentifier {

    @XmlValue
    protected String value;

    /** A location qualifier, i.e., a namespace. */
    @XmlAttribute(name = "fileIdentifierLocation", required = false)
    protected String fileIdentifierLocation;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFileIdentifierLocation() {
        return fileIdentifierLocation;
    }

    public void setFileIdentifierLocation(String fileIdentifierLocation) {
        this.fileIdentifierLocation = fileIdentifierLocation;
    }

    public static Builder builder() {
        return builder(new FileIdentifier());
    }

    public static Builder builder(FileIdentifier fileIdentifier) {
        return new Builder(fileIdentifier);
    }

    public static class Builder extends BuilderBase<FileIdentifier, Builder> {

        protected Builder(FileIdentifier fileIdentifier) {
            super(fileIdentifier);
        }

        public Builder value(String value) {
            _target().setValue(value);
            return _self();
        }

        public Builder fileIdentifierLocation(String fileIdentifierLocation) {
            _target().setFileIdentifierLocation(fileIdentifierLocation);
            return _self();
        }
    }
}
