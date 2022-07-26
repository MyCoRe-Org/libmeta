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
 * BETYPE: Begin/End Type.
 * BETYPE (string/O): An attribute that specifies the kind of BEGIN and/or END values that are being used. For example, if BYTE is specified, then the BEGIN and END point values represent the byte offsets into a file. If IDREF is specified, then the BEGIN element specifies the ID value that identifies the element in a structured text file where the relevant section of the file begins; and the END value (if present) would specify the ID value that identifies the element with which the relevant section of the file ends. Must be one of the following values:
 * 	BYTE
 * 	IDREF
 * 	SMIL
 * 	MIDI	
 * 	SMPTE-25
 * 	SMPTE-24
 * 	SMPTE-DF30
 * 	SMPTE-NDF30
 * 	SMPTE-DF29.97
 * 	SMPTE-NDF29.97
 * 	TIME
 * 	TCF
 * 	XPTR
 *	
 * @author Robert Stephan
 *
 */
@XmlEnum
public enum AreaBETYPE {
	@XmlEnumValue("BYTE") BYTE, 
	@XmlEnumValue("IDREF") IDREF, 
	@XmlEnumValue("SMIL") SMIL, 
	@XmlEnumValue("MIDI") MIDI, 
	@XmlEnumValue("SMPTE-25") SMPTE_25, 
	@XmlEnumValue("SMPTE-24") SMPTE_24, 
	@XmlEnumValue("SMPTE-DF30") SMPTE_DF30, 
	@XmlEnumValue("SMPTE-NDF30") SMPTE_NDF30, 
	@XmlEnumValue("SMPTE-DF29.97") SMPTE_DF29_97, 
	@XmlEnumValue("SMPTE-NDF29.97") SMPTE_NDF29_97, 
	@XmlEnumValue("TIME") TIME, 
	@XmlEnumValue("TCF") TCF, 
	@XmlEnumValue("XPTR") XPTR;
	
}
