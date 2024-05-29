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
package org.mycore.libmeta.alto.model;

import org.mycore.libmeta.alto.model.description.Description;
import org.mycore.libmeta.alto.model.layout.Layout;
import org.mycore.libmeta.alto.model.styles.Styles;
import org.mycore.libmeta.alto.model.tags.Tags;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This class implements a Java model for Alto XML 
 * 
 * ALTO (analyzed layout and text object) stores layout information and 
 * OCR recognized text of pages of any kind of printed documents like books, journals and newspapers.
 * ALTO is a standardized XML format to store layout and content information.
 * It is designed to be used as an extension schema to METS (Metadata Encoding and Transmission Standard),
 * where METS provides metadata and structural information while ALTO contains content and physical information.
 * 
 * @author Robert Stephan
 * @version Alto 2.1 

 */

@XmlRootElement(name = "alto", namespace = "http://www.loc.gov/standards/alto/ns-v2#")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "description", "styles", "tags", "layout" })
public class Alto {
    //<xsd:sequence>

    @XmlElement(name = "Description", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected Description description;

    @XmlElement(name = "Styles", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected Styles styles;

    @XmlElement(name = "Tags", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected Tags tags;

    @XmlElement(name = "Layout", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = true)
    protected Layout layout;

    @XmlAttribute(name = "schemaLocation", namespace = "http://www.w3.org/2001/XMLSchema-instance", required = false)
    protected String xsiSchemaLocation;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Styles getStyles() {
        return styles;
    }

    public void setStyles(Styles styles) {
        this.styles = styles;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }

    public void setXsiSchemaLocation(String xsiSchemaLocation) {
        this.xsiSchemaLocation = xsiSchemaLocation;
    }

    public static Builder builder() {
        return builder(new Alto());
    }

    public static Builder builder(Alto alto) {
        return new Builder(alto);
    }

    public static class Builder extends BuilderBase<Alto, Builder> {

        protected Builder(Alto alto) {
            super(alto);
        }

        public Builder Description(Description description) {
            _target().setDescription(description);
            return _self();
        }

        public Builder Styles(Styles styles) {
            _target().setStyles(styles);
            return _self();
        }

        public Builder Tags(Tags tags) {
            _target().setTags(tags);
            return _self();
        }

        public Builder Layout(Layout layout) {
            _target().setLayout(layout);
            return _self();
        }

        public Builder xsiSchemaLocation(String schemaLocation) {
            _target().setXsiSchemaLocation(schemaLocation);
            return _self();
        }
    }
}
