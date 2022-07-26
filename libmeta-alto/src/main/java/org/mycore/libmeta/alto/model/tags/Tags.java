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
package org.mycore.libmeta.alto.model.tags;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * Tag define properties of additional characteristic. The tags are referenced
 * from related content element on Block or String element by attribute TAGREF
 * via the tag ID. This container element contains the individual elements for
 * LayoutTags, StructureTags, RoleTags, NamedEntityTags and OtherTags
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Tags {
    @XmlElements(value = {
        @XmlElement(name = "LayoutTag",
            namespace = "http://www.loc.gov/standards/alto/ns-v2#",
            required = false,
            type = LayoutTag.class),
        @XmlElement(name = "StructureTag",
            namespace = "http://www.loc.gov/standards/alto/ns-v2#",
            required = false,
            type = StructureTag.class),
        @XmlElement(name = "RoleTag",
            namespace = "http://www.loc.gov/standards/alto/ns-v2#",
            required = false,
            type = RoleTag.class),
        @XmlElement(name = "NamedEntityTag",
            namespace = "http://www.loc.gov/standards/alto/ns-v2#",
            required = false,
            type = NamedEntityTag.class),
        @XmlElement(name = "OtherTag",
            namespace = "http://www.loc.gov/standards/alto/ns-v2#",
            required = false,
            type = OtherTag.class)
    })
    private List<Tag> tags = new Vector<Tag>();

    
    public List<Tag> getTags() {
        return tags;
    }

    public static Builder builder() {
        return builder(new Tags());
    }

    public static Builder builder(Tags tags) {
        return new Builder(tags);
    }

    public static class Builder extends BuilderBase<Tags, Builder> {

        protected Builder(Tags tags) {
            super(tags);
        }

        public Builder addTag(Tag tag) {
            _target().getTags().add(tag);
            return _self();
        }
    }
}
