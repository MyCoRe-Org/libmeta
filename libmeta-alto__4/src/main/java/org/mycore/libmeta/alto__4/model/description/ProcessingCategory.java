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
 * Classification of the category of operation, how the file was created, 
 * including generation, modification, preprocessing, postprocessing or any other steps.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 * 
 */
@XmlEnum
public enum ProcessingCategory {
    @XmlEnumValue("contentGeneration")
    CONTENT_GENERATION,
    @XmlEnumValue("contentModification")
    CONTENT_MODIFICATION,
    @XmlEnumValue("preOperation")
    PRE_OPERATION,
    @XmlEnumValue("postOperation")
    POST_OPERATION,
    @XmlEnumValue("other")
    OTHER;

}
