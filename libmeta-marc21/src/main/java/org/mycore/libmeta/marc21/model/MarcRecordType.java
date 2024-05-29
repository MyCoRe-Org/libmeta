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
package org.mycore.libmeta.marc21.model;

/**
 * &lt;xsd:simpleType name="recordTypeType" id="type.st"&gt;
 *   &lt;xsd:restriction base="xsd:NMTOKEN"&gt;
 *     &lt;xsd:enumeration value="Bibliographic"/&gt;
 *     &lt;xsd:enumeration value="Authority"/&gt;
 *     &lt;xsd:enumeration value="Holdings"/&gt;
 *     &lt;xsd:enumeration value="Classification"/&gt;
 *     &lt;xsd:enumeration value="Community"/&gt;
 *   &lt;/xsd:restriction&gt;
 * &lt;/xsd:simpleType&gt;
 * 
 * @author Robert Stephan
 * @version MARC21 1.2
 *
 */

public enum MarcRecordType {
    BIBLIOGRAPHIC("Bibliographic"),
    AUTHORITY("Authority"),
    HOLDINGS("Holdings"),
    CLASSIFICATION("Classification"),
    COMMUNITY("Community");

    private String value;

    private MarcRecordType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
