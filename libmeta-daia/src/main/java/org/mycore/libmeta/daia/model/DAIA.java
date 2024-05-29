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

import java.util.List;
import java.util.Vector;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/*
/<xs:element name="daia" type="daia">
    <xs:annotation>
      <xs:documentation.
      </xs:documentation>
    </xs:annotation>
  </xs:element> 
  <!-- daia type -->
   <xs:complexType name="daia">
      <xs:sequence>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>
        <xs:element maxOccurs="1" minOccurs="0" ref="institution"/>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="document" type="document"/>
      </xs:sequence>
      <xs:attribute name="timestamp" type="xs:dateTime" use="required">
        <xs:annotation>
          <xs:documentation>Date and time of the availability status in this record. The format is a
            subset of ISO 8601 with year, month, day, hour, minute, second, and optionally
            fractional seconds and timezone. It matches the form '-'? yyyy '-' mm '-' dd
            'T' hh ':' mm ':' ss ('.' s+)? ((('+' | '-') hh ':' mm) | 'Z')?.
          </xs:documentation>
        </xs:annotation>
      </xs:attribute>
      <xs:attribute name="version" type="xs:string" use="required"/>
    </xs:complexType>
  <!-- document type -->
  <xs:complexType name="document">
    <xs:annotation><xs:documentation>a group of items that can be refered to with one identifier</xs:documentation></xs:annotation>
      <xs:sequence maxOccurs="unbounded">
        <xs:choice>
          <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>          
          <xs:element maxOccurs="unbounded" minOccurs="0" ref="item"/>
        </xs:choice>
      </xs:sequence>
      <xs:attribute name="id" type="xs:anyURI" use="required">
        <xs:annotation>
          <xs:documentation>Identifier of a document</xs:documentation>
        </xs:annotation>
      </xs:attribute>
      <xs:attribute name="href" type="xs:anyURI" use="optional">
        <xs:annotation>
          <xs:documentation>Hyperlink to information about the document</xs:documentation>
        </xs:annotation>
      </xs:attribute>
    </xs:complexType>
  <!-- item type -->
  <xs:element name="item" type="item">
    <xs:annotation>
      <xs:documentation>An identified information object. This record corresponds to the class Item
        in FRBR. That means multiple copies are encoded with multiple occurrences of this element.
      </xs:documentation>
    </xs:annotation>  
  </xs:element>
  <xs:complexType name="item">
      <xs:sequence>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>
        <xs:element maxOccurs="1" minOccurs="0" ref="label"/>
        <xs:element maxOccurs="1" minOccurs="0" ref="department"/>
        <xs:element maxOccurs="1" minOccurs="0" ref="storage"/>
        <xs:choice minOccurs="0" maxOccurs="unbounded">
          <xs:element name="available">
              <xs:complexType>
                <xs:complexContent>
                  <xs:extension base="availability">
                    <xs:attribute name="delay" use="optional">
                      <xs:simpleType>
                        <xs:union memberTypes="xs:duration">
                          <xs:simpleType>
                            <xs:restriction base="xs:string">
                              <xs:pattern value="unknown"/>
                            </xs:restriction>
                          </xs:simpleType>
                        </xs:union>
                      </xs:simpleType>
                    </xs:attribute>
                  </xs:extension>
                </xs:complexContent>
            </xs:complexType>
          </xs:element>
          <xs:element name="unavailable">
            <xs:complexType>
              <xs:complexContent>
                <xs:extension base="availability">
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
                  <xs:attribute name="queue" type="xs:nonNegativeInteger" use="optional">
                    <xs:annotation>
                      <xs:documentation>Number of pending requests for this item and service (for instance number of reservations).</xs:documentation>
                    </xs:annotation> 
                  </xs:attribute>
                </xs:extension>
              </xs:complexContent>
            </xs:complexType>
          </xs:element>
        </xs:choice>
      </xs:sequence>
      <xs:attribute name="id" type="xs:anyURI" use="optional">
        <xs:annotation>
          <xs:documentation>An item must be identified by an URI. Real URIs of a given schema should
            be used, but you can also use pseudo URIs that only match the lexical form of an
          URI.</xs:documentation>
        </xs:annotation>
      </xs:attribute>
      <xs:attribute name="part" type="partType">
        <xs:annotation>
          <xs:documentation>Indicates that the availability information is only valid for a part if
            the requested item. You should avoid this flag but giving partial information is better
            then giving no information at all.</xs:documentation>
        </xs:annotation>
      </xs:attribute>
      <xs:attribute name="href" type="xs:anyURI">
        <xs:annotation>
          <xs:documentation>Hyperlink to information about the item</xs:documentation>
        </xs:annotation>
      </xs:attribute>
  </xs:complexType>

  <!-- part type -->
  <xs:simpleType name="partType">
    <xs:annotation>
      <xs:documentation>Either 'broader' or 'narrower'</xs:documentation>
    </xs:annotation>
    <xs:restriction base="xs:string">
      <xs:pattern value='^(broader|narrower)$' />
    </xs:restriction>
  </xs:simpleType>

  <!-- avaialability type -->
  <xs:complexType name="availability">
    <xs:annotation>
      <xs:documentation>Availability of an item in a specific service.</xs:documentation>
    </xs:annotation>
    <xs:sequence maxOccurs="unbounded">
      <xs:choice>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>
        <xs:element maxOccurs="unbounded" minOccurs="0" ref="limitation"/>
      </xs:choice>
    </xs:sequence>
    <xs:attribute name="service" type="service" use="optional"/>
    <xs:attribute name="href" type="xs:anyURI" use="optional">
      <xs:annotation>
        <xs:documentation>URL to get or reserve the service</xs:documentation>
      </xs:annotation>
    </xs:attribute>
  </xs:complexType>

  <!-- service type -->
  <xs:simpleType name="service">
    <xs:annotation>
      <xs:documentation>specific service for using the item. This attribute can 
        be mapped to the 'availableFor' field of the ISO 20775 Holdings schema.
      </xs:documentation>
    </xs:annotation>
    <xs:union memberTypes="xs:anyURI">
      <xs:simpleType>
        <xs:restriction base="xs:token">
          <xs:enumeration value="presentation">
            <xs:annotation>
              <xs:documentation>Item can be used inside the institution (in their rooms, in their intranet etc.)</xs:documentation>
            </xs:annotation>
          </xs:enumeration>
          <xs:enumeration value="loan">
            <xs:annotation>
              <xs:documentation>Item can be used outside of the institution (by lending or online access)</xs:documentation>
            </xs:annotation>
          </xs:enumeration>  
          <xs:enumeration value="interloan">
            <xs:annotation>
              <xs:documentation>Item can be used mediated by another institution. That means you do not have to interact with the institution that was queried for this item. This include interlibrary loan as well as public online ressources that are not hosted or made available by the queried institution.</xs:documentation>
            </xs:annotation>
          </xs:enumeration>
          <xs:enumeration value="openaccess">
            <xs:annotation>
              <xs:documentation>Item can be used without any restrictions by the institution. This applies to free online publications or free give-aways.</xs:documentation>
            </xs:annotation>
          </xs:enumeration>      
        </xs:restriction>
      </xs:simpleType>
    </xs:union>
  </xs:simpleType>
  
  <!-- daiatime type -->
  <xs:simpleType name="daiatime">
    <xs:union memberTypes="xs:duration xs:dateTime">
      <xs:simpleType>
        <xs:restriction base="xs:string">
          <xs:pattern value="unknown"/>
        </xs:restriction>
      </xs:simpleType>
    </xs:union>
  </xs:simpleType>
 
  <!-- message type -->
  <xs:complexType mixed="true" name="message">
    <xs:annotation>
      <xs:documentation>
        Textual message of availability information. 
        Must be qualified by an ISO-639 language code (en, fr, de, ...).
        If the 'errno' attribute is set, it is an error message.
      </xs:documentation>
    </xs:annotation>
    <xs:attribute name="lang" type="xs:language" use="required">
      <xs:annotation>
        <xs:documentation>
          ISO-639 language code (en, fr, de, ...) of the message
        </xs:documentation>
      </xs:annotation>
    </xs:attribute>
    <xs:attribute name="errno" type="xs:integer" use="optional">
      <xs:annotation>
        <xs:documentation>
          Error code. Use positive values for core errors and
          negative values for transformation errors.
        </xs:documentation>
      </xs:annotation>
    </xs:attribute>
  </xs:complexType>
  
  <!-- Additional elements -->
  <xs:element name="label">
    <xs:annotation>
      <xs:documentation>Textual label for an item (for instance the call number)</xs:documentation>
    </xs:annotation>
    <xs:complexType mixed="true"/>
  </xs:element>
  
  <xs:element name="department" type="simpleElement">
    <xs:annotation>
      <xs:documentation>an administrative sub-entitity of the institution that is responsible for this item</xs:documentation>
    </xs:annotation>
  </xs:element>
  
  <xs:element name="storage" type="simpleElement">
    <xs:annotation>
      <xs:documentation>a physical location of the item (building, stack, floor etc.)</xs:documentation>
    </xs:annotation>
  </xs:element>  
  
  <xs:element name="institution" type="simpleElement">
    <xs:annotation>
      <xs:documentation>
        Information about the institution that was queried.
      </xs:documentation>
    </xs:annotation>
  </xs:element>
  
  <xs:element name="limitation" type="simpleElement">
    <xs:annotation>
      <xs:documentation>
        Information about a more specific limitation of the availability.
        Semantics of limitations are not part of the core DAIA standard.
        If you use this element, a general client can only see that there is 
        a limitation but not which kind of limitation. You can provide a textual
        description, a link and/or an id.
      </xs:documentation>
    </xs:annotation>
  </xs:element>
    
  <xs:complexType name="simpleElement" mixed="true">
    <xs:annotation>
      <xs:documentation>
        This is an abstract element type that allows the two 
        attributes 'id' and 'href' (both optional) and textual content.
      </xs:documentation>
      </xs:annotation>
      <xs:attribute name="id" type="xs:anyURI" use="optional">
        <xs:annotation>
          <xs:documentation>Identifier of this element</xs:documentation>
        </xs:annotation>
      </xs:attribute>
      <xs:attribute name="href" type="xs:anyURI" use="optional">
        <xs:annotation>
          <xs:documentation>Hyperlink to information about this element</xs:documentation>
        </xs:annotation>
      </xs:attribute>      
  </xs:complexType>
</xs:schema>
*/

/**
Document Availability Information API (DAIA).
Describes the current availability of different services about an information
resource at a given institution. 
Version: 0.54 (2010-05-06) by Jakob Voss

@author Robert Stephan
*/

@XmlRootElement(name = "daia", namespace = "http://ws.gbv.de/daia/")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "message", "institution", "document" })
public class DAIA {
    /*   <xs:sequence>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="message" type="message"/>
        <xs:element maxOccurs="1" minOccurs="0" ref="institution"/>
        <xs:element maxOccurs="unbounded" minOccurs="0" name="document" type="document"/>
      </xs:sequence>
    */
    @XmlElement(name = "message", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Message> message = new Vector<Message>();

    /**
     * Information about the institution that was queried.
     */
    @XmlElement(name = "institution", namespace = "http://ws.gbv.de/daia/", required = false)
    protected SimpleElement institution;

    @XmlElement(name = "document", namespace = "http://ws.gbv.de/daia/", required = false)
    protected List<Document> document = new Vector<Document>();

    /*
    <xs:attribute name="timestamp" type="xs:dateTime" use="required">
    <xs:annotation>
      <xs:documentation>Date and time of the availability status in this record. The format is a
        subset of ISO 8601 with year, month, day, hour, minute, second, and optionally
        fractional seconds and timezone. It matches the form '-'? yyyy '-' mm '-' dd
        'T' hh ':' mm ':' ss ('.' s+)? ((('+' | '-') hh ':' mm) | 'Z')?.
      </xs:documentation>
    </xs:annotation>    
    </xs:attribute>*/
    @XmlAttribute(name = "timestamp", required = true)
    protected String timestamp;

    /*<xs:attribute name="version" type="xs:string" use="required"/>*/
    @XmlAttribute(name = "version", required = true)
    protected String version;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public SimpleElement getInstitution() {
        return institution;
    }

    public void setInstitution(SimpleElement institution) {
        this.institution = institution;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
