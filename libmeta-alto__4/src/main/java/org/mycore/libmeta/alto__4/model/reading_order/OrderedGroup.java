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
package org.mycore.libmeta.alto__4.model.reading_order;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * A group containing ordered elements 
 * (i.e. the sequence of OrderedGroup, UnorderedGroup or ElementRef subelements is ordered).
 * 
 * @author Robert Stephan
 * @version Alto 4.4
  */
@XmlAccessorType(XmlAccessType.NONE)
public class OrderedGroup implements IReadingOrderChild, IGroupChild, IElementRefAttributeGroup {
    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "ID")
    private String ID;

    /**
     *  A link to the referenced element. 
     *  Valid target elements are any block type,
     *  TextLine, String, or Glyph.
     */
    @XmlAttribute(name = "REFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    private String REFS;

    /**
     * Optionally annotates the role of the
     * referenced element in the reading order
     * with one or more tags. Examples could be
     * interlinear additions or marginalia.
     */
    @XmlAttribute(name = "TAGREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    private String TAGREFS;

    @XmlElements(value = {
        @XmlElement(name = "ElementRef",
            namespace = "http://www.loc.gov/standards/alto/ns-v4#",
            required = false,
            type = ElementRef.class),
        @XmlElement(name = "OrderedGroup",
            namespace = "http://www.loc.gov/standards/alto/ns-v4#",
            required = false,
            type = OrderedGroup.class),
        @XmlElement(name = "UnorderedGroup",
            namespace = "http://www.loc.gov/standards/alto/ns-v4#",
            required = false,
            type = UnorderedGroup.class),
    })

    protected List<IGroupChild> contents = new Vector<IGroupChild>();

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getREFS() {
        return REFS;
    }

    public void setREFS(String rEFS) {
        REFS = rEFS;
    }

    public String getTAGREFS() {
        return TAGREFS;
    }

    public void setTAGREFS(String tAGREFS) {
        TAGREFS = tAGREFS;
    }

    public List<IGroupChild> getContents() {
        return contents;
    }

    public void addContent(IGroupChild content) {
        contents.add(content);
    }

    public static Builder builder() {
        return builder(new OrderedGroup());
    }

    public static Builder builder(OrderedGroup orderedGroup) {
        return new Builder(orderedGroup);
    }

    public static class Builder extends BuilderBase<OrderedGroup, Builder>
        implements IElementRefAttributeGroupBuilder<OrderedGroup, Builder> {

        protected Builder(OrderedGroup orderedGroup) {
            super(orderedGroup);
        }

        protected Builder addContent(IGroupChild content) {
            _target().getContents().add(content);
            return _self();
        }
    }

}
