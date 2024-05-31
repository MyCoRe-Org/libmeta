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
package org.mycore.libmeta.alto__4.model.layout.block;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * Describes the inline base direction and line orientation of a line or of all lines inside a text block.
 * The meaning of these terms is defined by the W3C writing modes document: 
 * https://www.w3.org/TR/css-writing-modes-3/#writing-mode
 * 
 * These values should correspond to the base direction set in the BiDi algorithm to the respective elements 
 * during Unicode encoding. A value of "ttb" (top-to-bottom) implies a base direction of left-to-right,
 * a value of "btt" (bottom-to-top) a base direction of right-to-left.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 */
@XmlEnum
public enum InlineDir {
    @XmlEnumValue("ltr")
    ltr,
    @XmlEnumValue("rtl")
    rtl,
    @XmlEnumValue("ttb")
    ttb,
    @XmlEnumValue("btt")
    btt;
}
