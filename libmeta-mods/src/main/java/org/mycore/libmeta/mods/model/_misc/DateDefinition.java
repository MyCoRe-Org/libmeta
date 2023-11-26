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
package org.mycore.libmeta.mods.model._misc;

import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 *    <xs:complexType name="dateDefinition">
 *        <xs:simpleContent>
 *            <xs:extension base="stringPlusLanguage">
 *                <xs:attribute name="encoding">
 *                    <xs:simpleType>
 *                        <xs:restriction base="xs:string">
 *                            <xs:enumeration value="w3cdtf"/>
 *                            <xs:enumeration value="iso8601"/>
 *                            <xs:enumeration value="marc"/>
 *                            <xs:enumeration value="temper"/>
 *                            <xs:enumeration value="edtf"/>
 *                        </xs:restriction>
 *                    </xs:simpleType>
 *                </xs:attribute>
 *                <xs:attribute name="qualifier">
 *                    <xs:simpleType>
 *                        <xs:restriction base="xs:string">
 *                            <xs:enumeration value="approximate"/>
 *                            <xs:enumeration value="inferred"/>
 *                            <xs:enumeration value="questionable"/>
 *                        </xs:restriction>
 *                    </xs:simpleType>
 *                </xs:attribute>
 *                <xs:attribute name="point">
 *                    <xs:simpleType>
 *                        <xs:restriction base="xs:string">
 *                            <xs:enumeration value="start"/>
 *                            <xs:enumeration value="end"/>
 *                        </xs:restriction>
 *                    </xs:simpleType>
 *                </xs:attribute>
 *                <xs:attribute name="keyDate" fixed="yes"/>
 *            </xs:extension>
 *        </xs:simpleContent>
 *    </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * @version MODS 3.7 (calendar attribute added)
 *
 */
public class DateDefinition extends StringPlusLanguage{

    /**
     * {@code
     * <xs:attribute name="encoding" type="dateEncodingAttributeDefinition"/>
     * }
     */
    @XmlAttribute(name = "encoding")
    protected DateEncoding encoding;
    
    /**
     * {@code
     * <xs:attribute name="qualifier" type="dateQualifierAttributeDefinition"/>
     * }
     */
    @XmlAttribute(name = "qualifier")
    protected DateQualifier qualifier;
    
    /**
     * {@code
     * <xs:attribute name="point" type="datePointAttributeDefinition"/>
     * }
     */
    @XmlAttribute(name = "point")
    protected DatePoint point;
    
    @XmlAttribute(name="keyDate")
    protected Yes keyDate;
    
    @XmlAttribute(name = "calendar")
    protected String calendar;
    

    public DateEncoding getEncoding() {
        return encoding;
    }

    public void setEncoding(DateEncoding encoding) {
        this.encoding = encoding;
    }

    public DateQualifier getQualifier() {
        return qualifier;
    }

    public void setQualifier(DateQualifier qualifier) {
        this.qualifier = qualifier;
    }

    public DatePoint getPoint() {
        return point;
    }

    public void setPoint(DatePoint point) {
        this.point = point;
    }

    public Yes getKeyDate() {
        return keyDate;
    }

    public void setKeyDate(Yes keyDate) {
        this.keyDate = keyDate;
    }
    
    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }
}
