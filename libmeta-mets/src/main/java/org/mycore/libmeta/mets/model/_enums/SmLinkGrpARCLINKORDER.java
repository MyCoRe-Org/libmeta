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
 * ARCLINKORDER (enumerated string/O): ARCLINKORDER is used to indicate whether
 * the order of the smArcLink elements aggregated by the smLinkGrp element is
 * significant. If the order is significant, then a value of &quot;ordered&quot;
 * should be supplied. Value defaults to &quot;unordered&quot; Note that the
 * ARLINKORDER attribute has no xlink specified meaning.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlEnum
public enum SmLinkGrpARCLINKORDER {
	@XmlEnumValue("ordered") ORDERED, 
	@XmlEnumValue("unordered") UNORDERED;
}
