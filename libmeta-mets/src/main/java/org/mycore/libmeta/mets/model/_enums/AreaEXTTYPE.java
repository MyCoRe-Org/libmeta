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

/**
 * EXTTYPE (string/O): An attribute that specifies the kind of EXTENT values that are being used. For example if BYTE
 * is specified then EXTENT would represent a byte count. If TIME is specified the EXTENT would represent a duration
 * of time. EXTTYPE must be one of the following values:
 * 	BYTE
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
 *	
 * @author Robert Stephan
 *
 */
public enum AreaEXTTYPE {
    BYTE("BYTE"),
    SMIL("SMIL"),
    MIDI("MIDI"),
    SMPTE_25("SMPTE-25"),
    SMPTE_24("SMPTE-24"),
    SMPTE_DF30("SMPTE-DF30"),
    SMPTE_NDF30("SMPTE-NDF30"),
    SMPTE_DF29_97("SMPTE-DF29.97"),
    SMPTE_NDF29_97("SMPTE-NDF29.97"),
    TIME("TIME"),
    TCF("TCF");

    private String value;

    private AreaEXTTYPE(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
