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

import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeArc;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkArcLink;

/**
 * Builder for XlinkArcLink attributes
 * 
 * @author Robert Stephan
 *
 * @param <T> object that implements the XLinkArcLink interface
 * @param <B> the builder that should be enhanced by this interface
 */
public interface IAttributeGroupXlinkArcLinkBuilder<T extends IAttributeGroupXlinkArcLink, B> {
	public T _target();

	public B _self();

	public default B xlinkType(XlinkTypeArc xlinkType) {
		_target().setXlinkType(xlinkType);
		return _self();
	}

	public default B xlinkArcrole(String xlinkArcrole) {
		_target().setXlinkArcrole(xlinkArcrole);
		return _self();
	}

	public default B xlinkTitle(String xlinkTitle) {
		_target().setXlinkTitle(xlinkTitle);
		return _self();
	}

	public default B xlinkShow(XlinkShow xlinkShow) {
		_target().setXlinkShow(xlinkShow);
		return _self();
	}

	public default B xlinkActuate(XlinkActuate xlinkActuate) {
		_target().setXlinkActuate(xlinkActuate);
		return _self();
	}

	public default B xlinkFrom(String xlinkFrom) {
		_target().setXlinkFrom(xlinkFrom);
		return _self();
	}

	public default B xlinkTo(String xlinkTo) {
		_target().setXlinkTo(xlinkTo);
		return _self();
	}

}
