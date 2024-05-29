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
 * CHECKSUMTYPE (enumerated string/O): Specifies the checksum algorithm used to produce 
 * the value contained in the CHECKSUM attribute.  CHECKSUMTYPE must contain one of the following values:
 * 	Adler-32
 * 	CRC32
 * 	HAVAL
 * 	MD5
 * 	MNP
 * 	SHA-1
 * 	SHA-256
 * 	SHA-384
 * 	SHA-512
 * 	TIGER
 * 	WHIRLPOOL
 *	
 * @author Robert Stephan
 * @version METS 1.10
  */

@XmlEnum
public enum CHECKSUMTYPE {
    @XmlEnumValue("Adler-32")
    ADLER_32,
    @XmlEnumValue("CRC32")
    CRC32,
    @XmlEnumValue("HAVAL")
    HAVAL,
    @XmlEnumValue("MD5")
    MD5,
    @XmlEnumValue("MNP")
    MNP,
    @XmlEnumValue("SHA-1")
    SHA_1,
    @XmlEnumValue("SHA-256")
    SHA_256,
    @XmlEnumValue("SHA-384")
    SHA_384,
    @XmlEnumValue("SHA-512")
    SHA_512,
    @XmlEnumValue("TIGER")
    TIGER,
    @XmlEnumValue("WHIRLPOOL")
    WHIRLPOOL;
}
