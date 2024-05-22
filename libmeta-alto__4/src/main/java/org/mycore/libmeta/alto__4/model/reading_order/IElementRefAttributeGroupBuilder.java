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
package org.mycore.libmeta.alto__4.model.reading_order;

/**
    * Build for Attributes of ElementRef
    * 
    * @author Robert Stephan
    * @version Alto 4.4
    *
    */
public interface IElementRefAttributeGroupBuilder<T extends IElementRefAttributeGroup, B> {
    public T _target();

    public B _self();

    public default B ID(String id) {
        _target().setID(id);
        return _self();
    }

    public default B REF(String refs) {
        _target().setREF(refs);
        return _self();
    }

    public default B TAGREFS(String tagrefs) {
        _target().setTAGREFS(tagrefs);
        return _self();
    }
}
