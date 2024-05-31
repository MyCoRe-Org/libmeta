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
 * RoleTag – criteria about function or mission
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class RoleTag extends Tag {
    public static Builder builder() {
        return builder(new RoleTag());
    }

    public static Builder builder(RoleTag t) {
        return new Builder(t);
    }

    public static class Builder extends BuilderBase<RoleTag, Builder>
        implements ITagBuilder<RoleTag, Builder> {
        protected Builder(RoleTag t) {
            super(t);
        }
    }

}
