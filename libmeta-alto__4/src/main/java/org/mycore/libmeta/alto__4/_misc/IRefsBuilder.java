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
package org.mycore.libmeta.alto__4._misc;

public interface IRefsBuilder<T extends IRefsHolder, B> {
    public T _target();

    public B _self();

    public default B STYLEREFS(String styleRefs) {
    	_target().setSTYLEREFS(styleRefs);
        return _self();
    }

    public default B TAGREFS(String tagRefs) {
    	_target().setTAGREFS(tagRefs);
        return _self();
    }

    public default B HPOS(String processingRefs) {
    	_target().setPROCESSINGREFS(processingRefs);
        return _self();
    }
}
