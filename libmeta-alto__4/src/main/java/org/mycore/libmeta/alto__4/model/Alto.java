package org.mycore.libmeta.alto__4.model;

import org.mycore.libmeta.alto__4.model.description.Description;
import org.mycore.libmeta.alto__4.model.layout.Layout;
import org.mycore.libmeta.alto__4.model.reading_order.ReadingOrder;
import org.mycore.libmeta.alto__4.model.styles.Styles;
import org.mycore.libmeta.alto__4.model.tags.Tags;
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
 * 
 * @author Robert Stephan
 * @version Alto 4.4 

 */

@XmlRootElement(name = "alto", namespace = "http://www.loc.gov/standards/alto/ns-v4#")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "description", "styles", "tags", "readingOrder", "layout" })
public class Alto {

    /**
     * Describes general settings of the alto file like measurement units and metadata
     */
    @XmlElement(name = "Description", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected Description description;

    /**
     * Styles define properties of layout elements. 
     * A style defined in a parent element is used as default style for all related children elements.
     */
    @XmlElement(name = "Styles", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected Styles styles;

    /**
     * Tag define properties of additional characteristic. 
     * The tags are referenced from related content element on Block or String element 
     * by attribute TAGREF via the tag ID.
     * This container element contains the individual elements for 
     * LayoutTags, StructureTags, RoleTags, NamedEntityTags and OtherTags
     */
    @XmlElement(name = "Tags", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected Tags tags;

    /**
     *  Describes alternative hierarchical orderings of the page (i.e. total orders over its segments, for linear text flow),
     *  in addition to the explicit flat reading order defined by @IDNEXT on the block level,
     *  and the implicit flat reading order implied by the segment element ordering.
     */
    @XmlElement(name = "ReadingOrder", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected ReadingOrder readingOrder;

    /**
     * The root layout element.
     */
    @XmlElement(name = "Layout", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = true)
    protected Layout layout;

    /**
     * Schema version of the ALTO file.
     */
    @XmlAttribute(name = "schemaLocation", namespace = "http://www.w3.org/2001/XMLSchema-instance", required = false)
    protected String xsiSchemaLocation;

    @XmlAttribute(name = "SCHEMAVERSION", required = false)
    protected String schemaVersion;

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

    public ReadingOrder getReadingOrder() {
        return readingOrder;
    }

    public void setReadingOrder(ReadingOrder readingOrder) {
        this.readingOrder = readingOrder;
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

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
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

        public Builder ReadingOrder(ReadingOrder ro) {
            _target().setReadingOrder(ro);
            return _self();
        }

        public Builder Layout(Layout layout) {
            _target().setLayout(layout);
            return _self();
        }

        public Builder SCHEMAVERSION(String schemaVersion) {
            _target().setSchemaVersion(schemaVersion);
            return _self();
        }

        public Builder xsiSchemaLocation(String schemaLocation) {
            _target().setXsiSchemaLocation(schemaLocation);
            return _self();
        }
    }
}
