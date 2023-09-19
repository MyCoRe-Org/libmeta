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
package org.mycore.libmeta.mycoreclass.model;

import java.util.ArrayList;
import java.util.List;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "mycoreclass")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "id", "labels", "categories" })
public class Mycoreclass {

    @XmlAttribute(name = "ID")
    protected String id;

    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "category")
    protected List<Category> categories = new ArrayList<>();

    @XmlElement(name = "label")
    protected List<Label> labels = new ArrayList<>();

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public static Builder builder() {
        return builder(new Mycoreclass());
    }

    public static Builder builder(Mycoreclass mycoreclass) {
        return new Builder(mycoreclass);
    }

    public static class Builder extends BuilderBase<Mycoreclass, Builder> {

        protected Builder(Mycoreclass mycoreclass) {
            super(mycoreclass);
        }

        public Builder addCategory(Category category) {
            _target().getCategories().add(category);
            return _self();
        }

        public Builder addLabel(Label label) {
            _target().getLabels().add(label);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }
    }

}
