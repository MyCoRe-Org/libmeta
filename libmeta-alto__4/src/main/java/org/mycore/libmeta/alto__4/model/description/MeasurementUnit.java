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
package org.mycore.libmeta.alto__4.model.description;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * All measurement values inside the alto file are related to 
 * this unit, except the font size.
 * Coordinates as being used in HPOS and VPOS are absolute coordinates referring to the upper-left corner of a page.
 * The upper left corner of the page is defined as coordinate (0/0). 
 *
 * values meaning:
 * mm10: 1/10th of millimeter
 * inch1200: 1/1200th of inch 
 * pixel: 1 pixel
                    
 * The values for pixel will be related to the resolution of the image based 
 * on which the layout is described. In case the original image is not known
 * the scaling factor can be calculated based on total width and height of 
 * the image and the according information of the PAGE element.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 * 
 */
@XmlEnum
public enum MeasurementUnit {
    @XmlEnumValue("pixel")
    pixel,
    @XmlEnumValue("mm10")
    mm10,
    @XmlEnumValue("inch1200")
    inch1200;
}
