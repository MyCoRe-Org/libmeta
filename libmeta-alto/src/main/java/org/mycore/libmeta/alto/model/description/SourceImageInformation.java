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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Information to identify the image file from which the OCR text was created.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "fileName", "fileIdentifier" })
public class SourceImageInformation {

    @XmlElement(name = "fileName", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected String fileName;

    @XmlElement(name = "fileIdentifier", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<FileIdentifier> fileIdentifier = new Vector<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<FileIdentifier> getFileIdentifier() {
        return fileIdentifier;
    }

    public static Builder builder() {
        return builder(new SourceImageInformation());
    }

    public static Builder builder(SourceImageInformation sourceImageInformation) {
        return new Builder(sourceImageInformation);
    }

    public static class Builder extends BuilderBase<SourceImageInformation, Builder> {

        protected Builder(SourceImageInformation sourceImageInformation) {
            super(sourceImageInformation);
        }

        public Builder fileName(String fileName) {
            _target().setFileName(fileName);
            return _self();
        }

        public Builder addFileIdentifier(FileIdentifier fileIdentifier) {
            _target().getFileIdentifier().add(fileIdentifier);
            return _self();
        }
    }
}
