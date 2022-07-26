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
package org.mycore.libmeta.mods.model;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *  Definition of a MODS collection   
 *  
 * @author Robert Stephan
 *
 */
@XmlRootElement(name = "modsCollection", namespace = "http://www.loc.gov/mods/v3")
@XmlAccessorType(XmlAccessType.NONE)
public class ModsCollection {
    //sequence
    @XmlElement(name = "mods", namespace = "http://www.loc.gov/mods/v3", required = true)
    protected List<Mods> mods = new Vector<>();

    public List<Mods> getContent() {
        return mods;
    }

    public static Builder builder() {
        return new Builder(new ModsCollection());
    }

    public static Builder builder(ModsCollection col) {
        return new Builder(col);
    }

    public static class Builder extends BuilderBase<ModsCollection, Builder> {

        protected Builder(ModsCollection c) {
            super(c);
        }

        public Builder addContent(Mods mods) {
            _target().getContent().add(mods);
            return _self();
        }
    }
}
