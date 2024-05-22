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
package org.mycore.libmeta.alto__4.model.layout;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * A list of coordinate-pairs that are absolute to the upper-left corner of a page.
 * The upper left corner of the page is defined as x=0 and y=0
 * Currently there are no rules to enforce a particular format for a points list but in future versions is planned to restrict it to following options:
 *     x1,y1 x2,y2 ... xn,yn" - highly recommended as widely used and easy to read by both human and machine
 *     x1 y1 x2 y2 ... xn yn" - kept for back compatibility, since currently there are tools using this format
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Points {

    @XmlValue
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Builder builder() {
        return builder(new Points());
    }

    public static Builder builder(Points points) {
        return new Builder(points);
    }

    public static class Builder extends BuilderBase<Points, Builder> {

        protected Builder(Points points) {
            super(points);
        }

        public Builder value(String value) {
            _target().setValue(value);
            return _self();
        }
    }
}
