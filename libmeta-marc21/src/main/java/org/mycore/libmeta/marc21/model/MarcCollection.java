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

/**
 * MARC21 collection is a top level container element for 0 or many records
 * 
 * <xsd:complexType name="collectionType" id="collection.ct">
 * <xsd:sequence minOccurs="0" maxOccurs="unbounded">
 * <xsd:element ref="record"/> </xsd:sequence>
 * <xsd:attribute name="id" type="idDataType" use="optional"/>
 * </xsd:complexType>
 * 
 * @author Robert Stephan
 * @version MARC21 1.2
 * 
 */

@XmlRootElement(name = "collection", namespace = "http://www.loc.gov/MARC21/slim")
@XmlAccessorType(XmlAccessType.NONE)
public class MarcCollection extends MarcObject {
	/**
	 * 
	 */
	@XmlElement(name = "record", namespace = "http://www.loc.gov/MARC21/slim", required = false)
	protected List<MarcRecord> records = new Vector<MarcRecord>();

	@XmlAttribute(name = "id", required = false)
	protected String id;

	public List<MarcRecord> getRecords() {
		return records;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static Builder builder() {
		return builder(new MarcCollection());
	}

	public static Builder builder(MarcCollection coll) {
		return new Builder(coll);
	}

	public static class Builder extends BuilderBase<MarcCollection, Builder> {

		protected Builder(MarcCollection col) {
			super(col);
		}

		public Builder id(String id) {
			_target().setId(id);
			return _self();
		}

		public Builder addRecord(MarcRecord record) {
			_target().getRecords().add(record);
			return _self();
		}
	}
}
