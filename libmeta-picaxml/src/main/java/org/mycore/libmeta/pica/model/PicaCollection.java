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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * This class implements a PicaXML collection
 * 
 * a collection contains records
 * 
 * @see <a href="http://www.loc.gov/standards/sru/resources/pica-xml-v1-0.xsd">PicaXML XML Schema</a>
 * 
 * @author Robert Stephan
 * 
 */

@XmlRootElement(name = "collection", namespace = "info:srw/schema/5/picaXML-v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class PicaCollection implements PicaObject {
    /**
     * 
     */
    @XmlElement(name = "record", namespace = "info:srw/schema/5/picaXML-v1.0", required = true)
    protected List<PicaRecord> records = new Vector<PicaRecord>();

    public List<PicaRecord> getRecords() {
        return records;
    }

    public static Builder builder() {
        return builder(new PicaCollection());
    }

    public static Builder builder(PicaCollection col) {
        return new Builder(col);
    }

    public static class Builder extends BuilderBase<PicaCollection, Builder> {

        protected Builder(PicaCollection col) {
            super(col);
        }

        public Builder addRecord(PicaRecord record) {
            _target().getRecords().add(record);
            return _self();
        }
    }
}
