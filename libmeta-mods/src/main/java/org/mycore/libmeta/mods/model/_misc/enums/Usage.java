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
 *  Usage 
 *  
 *  This definition is for the usage attribute as used by{@literal <url>} (subelement of {@literal <location>})
 *  
 *  In earlier versions the usage attribute applied to element {@literal <url>} (of {@literal <location>}) only, and defined the single value "primary display".
 *  In this version, 3.4, the usage attribute applies additionally to elements {@literal <classification>}, {@literal <genre>}, {@literal <language>}, {@literal <subject>}, {@literal <name>},{@literal <titleInfo>},
 *  and {@literal <typeOfResource>}.
 *  However the value "primary display" is generalized to "primary", for these latter elements.
 *  {@literal <url>} retains the value "primary display" (for compatibility with earlier versions) although its use is depricated. So it has both values, "primary" and "primary display". For the other elements, only the value "primary" is valid.
 *  Therefore, two definitions are needed for the usage attribute, one for {@literal <url>} ("urlUsageAttributeDefinition") and one for the other elements ("usageAttributeDefinition")
*  
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */
@XmlEnum
public enum Usage {
	@XmlEnumValue("primary") PRIMARY;
}
