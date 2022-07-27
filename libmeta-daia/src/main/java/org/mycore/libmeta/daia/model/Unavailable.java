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
package org.mycore.libmeta.daia.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Unavailable extends Availability {

    /*
     <xs:attribute name="expected" use="optional">
       <xs:simpleType>
         <xs:union memberTypes="xs:date xs:dateTime">
           <xs:simpleType>
             <xs:restriction base="xs:string">
               <xs:pattern value="unknown"/>
             </xs:restriction>
           </xs:simpleType>
         </xs:union>
       </xs:simpleType>
     </xs:attribute> 
     */
    @XmlAttribute(name = "expected", required = false)
    protected String expected;

    /**
     * Number of pending requests for this item and service (for instance number of reservations).
     */
    // <xs:attribute name="queue" type="xs:nonNegativeInteger" use="optional">
    @XmlAttribute(name = "queue", required = false)
    protected Integer queue;

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }
}
