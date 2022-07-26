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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MARC21 record is a top level container element for all of the field elements which compose the record
 * 
 * &lt;xsd:complexType name="recordType" id="record.ct"&gt;
 *   &lt;xsd:sequence minOccurs="0"&gt;
 *     &lt;xsd:element name="leader" type="leaderFieldType"/&gt;
 *     &lt;xsd:element name="controlfield" type="controlFieldType" minOccurs="0" maxOccurs="unbounded"/&gt;
 *     &lt;xsd:element name="datafield" type="dataFieldType" minOccurs="0" maxOccurs="unbounded"/&gt;
 *   &lt;/xsd:sequence&gt;
 *   &lt;xsd:attribute name="type" type="recordTypeType" use="optional"/&gt;
 *   &lt;xsd:attribute name="id" type="idDataType" use="optional"/&gt;
 * &lt;/xsd:complexType&gt;
 * 
 * @author Robert Stephan
 * @version MARC21 1.2
 * 
 */

@XmlRootElement(name = "record", namespace = "http://www.loc.gov/MARC21/slim")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "leader", "controlfied", "datafield" })
public class MarcRecord extends MarcObject {

    @XmlElement(name = "leader", namespace = "http://www.loc.gov/MARC21/slim")
    protected MarcLeader leader = null;

    @XmlElement(name = "controlfied", namespace = "http://www.loc.gov/MARC21/slim")
    protected List<MarcControlfield> controlfields = new Vector<MarcControlfield>();

    @XmlElement(name = "datafield", namespace = "http://www.loc.gov/MARC21/slim")
    protected List<MarcDatafield> datafields = new Vector<MarcDatafield>();

    @XmlAttribute(name = "id", required = false)
    protected String id;

    @XmlAttribute(name = "type", required = false)
    protected MarcRecordType type;

    public MarcLeader getLeader() {
        return leader;
    }

    public void setLeader(MarcLeader leader) {
        this.leader = leader;
    }

    public List<MarcControlfield> getControlfields() {
        return controlfields;
    }

    public void setControlfields(List<MarcControlfield> controlfields) {
        this.controlfields = controlfields;
    }

    public List<MarcDatafield> getDatafields() {
        return datafields;
    }

    public void setDatafields(List<MarcDatafield> datafields) {
        this.datafields = datafields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MarcRecordType getType() {
        return type;
    }

    public void setType(MarcRecordType type) {
        this.type = type;
    }

    public static Builder builder() {
        return builder(new MarcRecord());
    }

    public static Builder builder(MarcRecord record) {
        return new Builder(record);
    }

    public static class Builder extends BuilderBase<MarcRecord, Builder> {

        protected Builder(MarcRecord record) {
            super(record);
        }

        public Builder leader(MarcLeader leader) {
            _target().setLeader(leader);
            return _self();
        }

        public Builder leader(String leader) {
            MarcLeader ml = new MarcLeader();
            ml.setContent(leader);
            return leader(ml);
        }

        public Builder addControlfield(MarcControlfield cf) {
            _target().getControlfields().add(cf);
            return _self();
        }

        public Builder addDatafield(MarcDatafield df) {
            _target().getDatafields().add(df);
            return _self();
        }

        public Builder id(String id) {
            _target().setId(id);
            return _self();
        }

        public Builder type(MarcRecordType type) {
            _target().setType(type);
            return _self();
        }
    }
}
