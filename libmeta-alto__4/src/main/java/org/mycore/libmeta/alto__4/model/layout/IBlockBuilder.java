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
package org.mycore.libmeta.alto__4.model.layout;

import org.mycore.libmeta.alto__4._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto__4._misc.IRefsBuilder;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;

public interface IBlockBuilder<T extends Block, B>
    extends IBoundingBoxBuilder<T, B>, IAttributeGroupXlinkSimpleLinkBuilder<T, B>, IRefsBuilder<T, B> {

    public T _target();

    public B _self();

    public default B ID(String id) {
        _target().setID(id);
        return _self();
    }

    public default B Shape(Shape shape) {
        _target().setShape(shape);
        return _self();
    }

    public default B ROTATION(Float rOTATION) {
        _target().setROTATION(rOTATION);
        return _self();
    }

    public default B IDNEXT(String iDNEXT) {
        _target().setIDNEXT(iDNEXT);
        return _self();
    }

    public default B CS(Boolean cS) {
        _target().setCS(cS);
        return _self();
    }

}
