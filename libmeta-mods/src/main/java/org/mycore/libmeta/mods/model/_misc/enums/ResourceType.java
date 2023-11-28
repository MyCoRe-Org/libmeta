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
package org.mycore.libmeta.mods.model._misc.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * resourceTypeDefinition
 * 	referenced by {@literal <typeOfResourceDefinition>}
 * 
 * @author Robert Stephan
 *@version MODS 3.6 (deprecated in MODS 3.7)
 */
@XmlEnum
public enum ResourceType {
    @XmlEnumValue("text")
    TEXT,
    @XmlEnumValue("cartographic")
    CARTOGRAPHIC,
    @XmlEnumValue("notated music")
    NOTATED_MUSIC,
    @XmlEnumValue("sound recording-musical")
    SOUND_RECORDING_MUSICAL,
    @XmlEnumValue("sound recording-nonmusical")
    SOUND_RECORDING_NONMUSICAL,
    @XmlEnumValue("sound recording")
    SOUND_RECORDING,
    @XmlEnumValue("still image")
    STILL_IMAGE,
    @XmlEnumValue("moving image")
    MOVING_IMAGE,
    @XmlEnumValue("three dimensional object")
    THREE_DIMENSIONAL_OBJECT,
    @XmlEnumValue("software, multimedia")
    SOFTWARE_MULTIMEDIA,
    @XmlEnumValue("mixed material")
    MIXED_MATERIAL,
    @XmlEnumValue("")
    UNDEFINIED;

}
