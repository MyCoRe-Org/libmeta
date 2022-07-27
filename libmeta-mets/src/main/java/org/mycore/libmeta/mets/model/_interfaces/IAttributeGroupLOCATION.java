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
package org.mycore.libmeta.mets.model._interfaces;

import org.mycore.libmeta.mets.model._enums.LOCTYPE;

/**
 * AttributeGroup LOCATION
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
public interface IAttributeGroupLOCATION {

	/**
	 * {@code
	 * <xsd:attribute name="LOCTYPE" use="required">
	 *   <xsd:simpleType>
	 *     <xsd:restriction base="xsd:string">
	 *       <xsd:enumeration value="ARK" />
	 *       <xsd:enumeration value="URN" />
	 *       <xsd:enumeration value="URL" />
	 *       <xsd:enumeration value="PURL" />
	 *       <xsd:enumeration value="HANDLE" />
	 *       <xsd:enumeration value="DOI" />
	 *       <xsd:enumeration value="OTHER" />
	 *     </xsd:restriction>
	 *   </xsd:simpleType>
	 * /xsd:attribute>
	 * }
	 * 
	 * LOCTYPE (string/R): Specifies the locator type used in the xlink:href attribute. 
	 * Valid values for LOCTYPE are:
	 *		ARK  URN  URL  PURL  HANDLE DOI OTHER
	 */
	public LOCTYPE getLOCTYPE();

	public void setLOCTYPE(LOCTYPE loctype);

	/**
	 * {@code
	 * <xsd:attribute name="OTHERLOCTYPE" type="xsd:string" use="optional" />
	 * }
	 * 
	 * OTHERLOCTYPE (string/O): Specifies the locator type when the value
	 * OTHER is used in the LOCTYPE attribute. Although optional, it is strongly recommended when OTHER is used.
	 */
	public String getOTHERLOCTYPE();

	public void setOTHERLOCTYPE(String otherLocType);

}
