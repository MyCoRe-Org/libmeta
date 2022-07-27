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
package org.mycore.libmeta.alto._misc;

public interface IBoundingBoxBuilder<T extends IBoundingBoxHolder, B> {
    public T _target();

    public B _self();

    public default B HEIGHT(Float height) {
    	_target().setHEIGHT(height);
        return _self();
    }

    public default B WIDTH(Float width) {
    	_target().setWIDTH(width);
        return _self();
    }

    public default B HPOS(Float hpos) {
    	_target().setHPOS(hpos);
        return _self();
    }

    public default B VPOS(Float vpos) {
    	_target().setVPOS(vpos);
        return _self();
    }
}
