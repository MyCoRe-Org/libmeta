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
package org.mycore.libmeta.mods.model._misc.builder;

import org.mycore.libmeta.mods.model._misc.IOtherTypeAttributeGroup;

/**
 * {@code
 * <xs:attribute name="otherType"/>
 * <xs:attribute name="otherTypeAuth" type="xs:string"/>
 * <xs:attribute name="otherTypeAuthURI" type="xs:anyURI"/>
 * <xs:attribute name="otherTypeURI" type="xs:anyURI"/>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.8
 *
 */
public interface IOtherTypeAttributeGroupBuilder<T extends IOtherTypeAttributeGroup, B> {
    public T _target();

    public B _self();

    public default B otherType(String otherType) {
        _target().setOtherType(otherType);
        return _self();
    }

    public default B otherTypeURI(String otherTypeURI) {
        _target().setOtherTypeURI(otherTypeURI);
        return _self();
    }

    public default B otherTypeAuth(String otherTypeAuth) {
        _target().setOtherTypeAuth(otherTypeAuth);
        return _self();
    }

    public default B otherTypeAuthURI(String otherTypeAuthURI) {
        _target().setOtherTypeAuthURI(otherTypeAuthURI);
        return _self();
    }
}
