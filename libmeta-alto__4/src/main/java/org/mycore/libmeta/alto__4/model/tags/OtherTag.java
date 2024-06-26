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
package org.mycore.libmeta.alto__4.model.tags;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * OtherTag – criteria about any other characteristic not listed above, 
 * the TYPE attribute is intended to be used for classification within those.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class OtherTag extends Tag {
    public static Builder builder() {
        return builder(new OtherTag());
    }

    public static Builder builder(OtherTag t) {
        return new Builder(t);
    }

    public static class Builder extends BuilderBase<OtherTag, Builder>
        implements ITagBuilder<OtherTag, Builder> {
        protected Builder(OtherTag t) {
            super(t);
        }
    }

}
