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
package org.mycore.libmeta.alto__4.model.layout.shape;

import org.mycore.libmeta.alto__4.model.layout.Points;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * A polygon shape.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Polygon implements IShapeChild {

    @XmlAttribute(name = "POINTS", required = true)
    protected Points POINTS;

    public Points getPOINTS() {
        return POINTS;
    }

    public void setPOINTS(Points points) {
        POINTS = points;
    }

    public static Builder builder() {
        return builder(new Polygon());
    }

    public static Builder builder(Polygon p) {
        return new Builder(p);
    }

    public static class Builder extends BuilderBase<Polygon, Builder> {

        protected Builder(Polygon p) {
            super(p);
        }

        public Builder POINTS(Points points) {
            _target().setPOINTS(points);
            return _self();
        }

    }
}
