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
package org.mycore.libmeta.alto__4.model.tags;

public interface ITagBuilder<T extends Tag, B> {
    public T _target();

    public B _self();

    public default B XmlData(XmlData xml) {
        _target().setXmlData(xml);
        return _self();
    }

    public default B ID(String id) {
        _target().setID(id);
        return _self();
    }

    public default B TYPE(String type) {
        _target().setTYPE(type);
        return _self();
    }

    public default B LABEL(String label) {
        _target().setLABEL(label);
        return _self();
    }

    public default B DESCRIPTION(String description) {
        _target().setDESCRIPTION(description);
        return _self();
    }

    public default B URI(String uri) {
        _target().setURI(uri);
        return _self();
    }
}
