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

import org.mycore.libmeta.mets.model._enums.CHECKSUMTYPE;

/**
 * AttributeGroup FILECORE
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
public interface IAttributeGroupFILECORE {

	/**
	 * <xsd:attribute name="MIMETYPE" type="xsd:string" use="optional">
	 * MIMETYPE (string/O): The IANA MIME media type for the associated file
	 *			or wrapped content. Some values for this attribute can be found on the IANA website.
	 */
	public String getMIMETYPE();

	public void setMIMETYPE(String s);

	/**
	 * <xsd:attribute name="SIZE" type="xsd:long" use="optional">
	 * SIZE (long/O): Specifies the size in bytes of the associated file or
	 * wrapped content.
	 */
	public Long getSIZE();

	public void setSIZE(Long size);

	/**
	 * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
	 * CREATED (dateTime/O): Specifies the date and time of creation for the
	 * associated file or wrapped content.
	 */
	public String getCREATED();

	public void setCREATED(String created);

	/**
	 * <xsd:attribute name="CHECKSUM" type="xsd:string" use="optional">
	 * CHECKSUM (string/O): Provides a checksum value for the associated file
	 * or wrapped content.
	 */
	public String getCHECKSUM();

	public void setCHECKSUM(String checksum);

	/**
	 * <xsd:attribute name="CHECKSUMTYPE" use="optional">
	 *   </xsd:annotation>
	 *     <xsd:simpleType>
	 *       <xsd:restriction base="xsd:string">
	 *         <xsd:enumeration value="Adler-32" />
	 *         <xsd:enumeration value="CRC32" />
	 *         <xsd:enumeration value="HAVAL" />
	 *         <xsd:enumeration value="MD5" />
	 *         <xsd:enumeration value="MNP" />
	 *         <xsd:enumeration value="SHA-1" />
	 *         <xsd:enumeration value="SHA-256" />
	 *         <xsd:enumeration value="SHA-384" />
	 *         <xsd:enumeration value="SHA-512" />
	 *         <xsd:enumeration value="TIGER" />
	 *         <xsd:enumeration value="WHIRLPOOL" />
	 *       </xsd:restriction>
	 *     </xsd:simpleType>
	 *   </xsd:attribute>
	 * </xsd:attributeGroup>
	 * CHECKSUMTYPE (enumerated string/O): Specifies the checksum algorithm
	 * used to produce the value contained in the CHECKSUM attribute. CHECKSUMTYPE must contain one of the following
	 * values: Adler-32  CRC32  HAVAL  MD5  MNP  SHA-1  SHA-256  SHA-384  SHA-512  TIGER  WHIRLPOOL
	 */
	public CHECKSUMTYPE getCHECKSUMTYPE();

	public void setCHECKSUMTYPE(CHECKSUMTYPE checksumType);
}
