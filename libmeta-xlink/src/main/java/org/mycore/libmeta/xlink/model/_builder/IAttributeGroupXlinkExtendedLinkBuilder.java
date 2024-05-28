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
package org.mycore.libmeta.xlink.model._builder;

import org.mycore.libmeta.xlink.model.XlinkTypeExtended;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkExtendedLink;

/**
 * Builder for XlinkExtendedLink attributes
 * 
 * @author Robert Stephan
 *
 * @param <T> object that implements the XLinkExtendedLink interface
 * @param <B> the builder that should be enhanced by this interface
 */
public interface IAttributeGroupXlinkExtendedLinkBuilder<T extends IAttributeGroupXlinkExtendedLink, B> {

    T _target();

    public B _self();

    public default B xlinkType(XlinkTypeExtended xlinkType) {
        _target().setXlinkType(xlinkType);
        return _self();
    }

    public default B xlinkRole(String xlinkRole) {
        _target().setXlinkRole(xlinkRole);
        return _self();
    }

    public default B xlinkTitle(String xlinkTitle) {
        _target().setXlinkTitle(xlinkTitle);
        return _self();
    }

}
