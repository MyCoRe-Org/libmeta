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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * Defines one or more reading orders within the
 * page. Groups may be either unordered or ordered and can
 * contain other groups, e.g. a page containing
 * unrelated texts that are ordered individually
 * would be encoded as an UnorderedGroup containing
 * multiple OrderedGroups. The granularity of
 * elements can vary inside groups.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ReadingOrder {

    @XmlElements(value = {
        @XmlElement(name = "OrderedGroup",
            namespace = "http://www.loc.gov/standards/alto/ns-v4#",
            required = false,
            type = OrderedGroup.class),
        @XmlElement(name = "UnorderedGroup",
            namespace = "http://www.loc.gov/standards/alto/ns-v4#",
            required = false,
            type = UnorderedGroup.class),
    })
    protected List<IReadingOrderChild> contents = new Vector<IReadingOrderChild>();

    public List<IReadingOrderChild> getContents() {
        return contents;
    }

    public void addContent(IReadingOrderChild content) {
        contents.add(content);
    }

    public static Builder builder() {
        return builder(new ReadingOrder());
    }

    public static Builder builder(ReadingOrder r) {
        return new Builder(r);
    }

    public static class Builder extends BuilderBase<ReadingOrder, Builder> {
        protected Builder(ReadingOrder r) {
            super(r);
        }

        protected Builder addContent(IReadingOrderChild content) {
            _target().getContents().add(content);
            return _self();
        }
    }
}
