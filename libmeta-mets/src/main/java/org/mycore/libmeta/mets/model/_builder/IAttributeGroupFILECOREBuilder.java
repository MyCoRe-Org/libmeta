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
package org.mycore.libmeta.mets.model._builder;

import org.mycore.libmeta.mets.model._enums.CHECKSUMTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupFILECORE;

/**
 * AttributeGroup FILECORE
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
public interface IAttributeGroupFILECOREBuilder<T extends IAttributeGroupFILECORE, B> {

    public T _target();

    public B _self();

    /**
     * {@code
     * <xsd:attribute name="MIMETYPE" type="xsd:string" use="optional">
     * }
     * 
     * MIMETYPE (string/O): The IANA MIME media type for the associated file
     *			or wrapped content. Some values for this attribute can be found on the IANA website.
     *
     * @param mimetype - the mime type
     * @return the builder
     */

    public default B MIMETYPE(String mimetype) {
        _target().setMIMETYPE(mimetype);
        return _self();
    }

    /**
     * {@code
     * <xsd:attribute name="SIZE" type="xsd:long" use="optional">
     * }
     * 
     * SIZE (long/O): Specifies the size in bytes of the associated file or
     * wrapped content.
     * 
     * @param size - the size
     * @return the builder
     */

    public default B SIZE(Long size) {
        _target().setSIZE(size);
        return _self();
    }

    /**
     * {@code
     * <xsd:attribute name="CREATED" type="xsd:dateTime" use="optional">
     * }
     * 
     * CREATED (dateTime/O): Specifies the date and time of creation for the
     * associated file or wrapped content.
     * 
     * @param created - the create date
     * @return the builder
     */
    public default B CREATED(String created) {
        _target().setCREATED(created);
        return _self();
    }

    /**
     * {@code
     * <xsd:attribute name="CHECKSUM" type="xsd:string" use="optional">
     * }
     * 
     * CHECKSUM (string/O): Provides a checksum value for the associated file
     * or wrapped content.
     * 
     * @param checksum - the checksum
     * @return the builder
     */
    public default B CHECKSUM(String checksum) {
        _target().setCHECKSUM(checksum);
        return _self();
    }

    /**
     * {@code
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
     * }
     * 
     * CHECKSUMTYPE (enumerated string/O): Specifies the checksum algorithm
     * used to produce the value contained in the CHECKSUM attribute. CHECKSUMTYPE must contain one of the following
     * values: Adler-32  CRC32  HAVAL  MD5  MNP  SHA-1  SHA-256  SHA-384  SHA-512  TIGER  WHIRLPOOL
     * 
     * @param checksumType - the checksumType
     * @return the builder
     */
    public default B CHECKSUMTYPE(CHECKSUMTYPE checksumType) {
        _target().setCHECKSUMTYPE(checksumType);
        return _self();
    }
}
