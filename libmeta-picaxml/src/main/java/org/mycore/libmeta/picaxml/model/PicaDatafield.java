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
package org.mycore.libmeta.picaxml.model;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * This class implements a PicaXML datafield
 * 
 * a datafield cotains subfields
 * 
 * @see <a href="http://www.loc.gov/standards/sru/resources/pica-xml-v1-0.xsd">PicaXML XML Schema</a>
 * 
 * @author Robert Stephan
 * 
 */

@XmlRootElement(name = "datafield", namespace = "info:srw/schema/5/picaXML-v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class PicaDatafield implements PicaObject {
    /**
     * 
     */
    @XmlElement(name = "subfield", namespace = "info:srw/schema/5/picaXML-v1.0", required = true)
    protected List<PicaSubfield> subfields = new Vector<PicaSubfield>();
    
    /**
     * &lt;xs:attribute name="tag" use="required"&gt;
     *   &lt;xs:simpleType&gt;
     *     &lt;xs:restriction base="xs:string"&gt;
     *       &lt;xs:pattern value="[0-9][0-9][0-9][A-Z@]"/&gt;
     *     &lt;/xs:restriction&gt;
     *   &lt;/xs:simpleType&gt;    
     * &lt;/xs:attribute&gt;
     */
    @XmlAttribute(name = "tag", required = true)
    protected String tag;
    
    /**
     * &lt;xs:attribute name="occurrence" use="optional"&gt;
     *   &lt;xs:simpleType&gt;
     *     &lt;xs:restriction base="xs:string"&gt;
     *       &lt;xs:pattern value="[0-9][0-9]"/&gt;
     *     &lt;/xs:restriction&gt;
     *   &lt;/xs:simpleType&gt;    
     * &lt;/xs:attribute&gt;     
     */
    @XmlAttribute(name = "occurrence", required = false)
    protected String occurrence;

    public List<PicaSubfield> getSubfields() {
        return subfields;
    }

    public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}
    
	public static Builder builder() {
        return builder(new PicaDatafield());
    }

    public static Builder builder(PicaDatafield datafield) {
        return new Builder(datafield);
    }

    public static class Builder extends BuilderBase<PicaDatafield, Builder> {

        protected Builder(PicaDatafield datafield) {
            super(datafield);
        }
		
		public Builder addSubfield(PicaSubfield subfield) {
			_target().getSubfields().add(subfield);
			return _self();
		}
		
		public Builder addSubfield(String code, String content) {
			PicaSubfield sf = new PicaSubfield();
			sf.setCode(code);
			sf.setContent(content);
			return addSubfield(sf);
		}
		
		public Builder tag(String tag) {
			_target().setTag(tag);
			return _self();
		}
		
		public Builder occurrence(String occurrence) {
			_target().setOccurrence(occurrence);
			return _self();
		}		
	}
}
