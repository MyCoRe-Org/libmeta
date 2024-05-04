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
package org.mycore.libmeta.xlink.model._interfaces;

import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeSimple;

/**
 * Interface for elements that should contain XlinkSimpleLink attributes
 * 
 * @author Robert Stephan
 */
public interface IAttributeGroupXlinkSimpleLink {
    
    public XlinkTypeSimple getXlinkType();
    
    public void setXlinkType(XlinkTypeSimple xlinkType);

	public String getXlinkHref();

	public void setXlinkHref(String xlinkHref);

	public String getXlinkRole();

	public void setXlinkRole(String xlinkRole);

	public String getXlinkArcrole();

	public void setXlinkArcrole(String xlinkArcrole);

	public String getXlinkTitle();

	public void setXlinkTitle(String xlinkTitle);

	public XlinkShow getXlinkShow();

	public void setXlinkShow(XlinkShow xlinkShow);

	public XlinkActuate getXlinkActuate();

	public void setXlinkActuate(XlinkActuate xlinkActuate);

}