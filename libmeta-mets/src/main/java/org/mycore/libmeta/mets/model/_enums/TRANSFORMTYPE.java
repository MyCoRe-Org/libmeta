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
package org.mycore.libmeta.mets.model._enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

/**
 * TRANSFORMTYPE (string/R): Is used to indicate the type of transformation
 * needed to render content of a file accessible. This may include unpacking a
 * file into subsidiary files/streams. The controlled value constraints for this
 * XML string include "decompression" and "decryption". Decompression is defined
 * as the action of reversing data compression, i.e., the process of encoding
 * information using fewer bits than an unencoded representation would use by
 * means of specific encoding schemas. Decryption is defined as the process of
 * restoring data that has been obscured to make it unreadable without special
 * knowledge (encrypted data) to its original form.
 * 
 * @author Robert Stephan
 * 
 */
@XmlEnum
public enum TRANSFORMTYPE {
    @XmlEnumValue("decompression")
    DECOMPRESSION,
    @XmlEnumValue("decryption")
    DECRYPTION;

}
