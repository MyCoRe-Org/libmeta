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
package org.mycore.libmeta.alto.model.layout;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * The root layout element.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Layout {

    @XmlAttribute(name = "StyleRefs", required = true)
    @XmlSchemaType(name = "IDREFS")
    protected String STYLEREFS;

    @XmlElement(name = "Page", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = true)
    protected List<Page> page = new Vector<Page>();

    public String getSTYLEREFS() {
        return STYLEREFS;
    }

    public void setSTYLEREFS(String STYLEREFS) {
        this.STYLEREFS = STYLEREFS;
    }

    public List<Page> getPage() {
        return page;
    }

    public static Builder builder() {
        return builder(new Layout());
    }

    public static Builder builder(Layout l) {
        return new Builder(l);
    }

    public static class Builder extends BuilderBase<Layout, Builder> {
        protected Builder(Layout l) {
            super(l);
        }

        public Builder STYLEREFs(String stylerefs) {
            _target().setSTYLEREFS(stylerefs);
            return _self();
        }

        public Builder addPage(Page p) {
            _target().getPage().add(p);
            return _self();
        }

    }
}
