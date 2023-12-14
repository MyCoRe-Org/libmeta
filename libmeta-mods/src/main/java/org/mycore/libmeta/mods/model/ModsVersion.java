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
package org.mycore.libmeta.mods.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * modsVersionAttributeDefinition
 * 
 * "version" attribute of {@literal <mods>}
 * 
 * The version attribute, now, in 3.4, enumerates all 3.x versions. In earlier
 * versions only the current (latest) version was allowed. E.g. in version 3.3,
 * the only allowable value for the version attribute was "3.3". Henceforth for
 * any version x.y, all values x.z where z is less than or equal to y will be
 * enumerated.
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlEnum
public enum ModsVersion {
    @XmlEnumValue("3.8")
    VERSION_3_8,
    @XmlEnumValue("3.7")
    VERSION_3_7,
    @XmlEnumValue("3.6")
    VERSION_3_6,
    @XmlEnumValue("3.5")
    VERSION_3_5,
    @XmlEnumValue("3.4")
    VERSION_3_4,
    @XmlEnumValue("3.3")
    VERSION_3_3,
    @XmlEnumValue("3.2")
    VERSION_3_2,
    @XmlEnumValue("3.1")
    VERSION_3_1,
    @XmlEnumValue("3.0")
    VERSION_3_0;
}
