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
package org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS CopyLocation Subelement: ShelfLocator
 * 
 * {@code
 * <xs:element name="note" minOccurs="0" maxOccurs="unbounded">
 *   <xs:complexType>
 *     <xs:simpleContent>
 *       <xs:extension base="stringPlusLanguage">
 *         <xs:attribute name="displayLabel" type="xs:string"/>
 *         <xs:attribute name="type" type="xs:string"/>
 *         <xs:attributeGroup ref="xlink:simpleLink"/>
 *         <xs:attribute name="ID" type="xs:ID"/>
 *       </xs:extension>
 *     </xs:simpleContent>
 *   </xs:complexType>
 * </xs:element>
 * }
 *
 *   @author Robert Stephan
 *   @version MODS 3.6
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "copyinformation_shelflocator")
public class ShelfLocator extends org.mycore.libmeta.mods.model.location.ShelfLocator
    implements ICopyInformationSubelement {

    public static Builder builder() {
        return builder(new ShelfLocator());
    }

    public static Builder builder(ShelfLocator sl) {
        return new Builder(sl);
    }

    public static class Builder extends org.mycore.libmeta.mods.model.location.ShelfLocator.Builder {
        protected Builder(ShelfLocator sl) {
            super(sl);
        }
    }
}
