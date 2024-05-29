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
import org.mycore.libmeta.xlink.model.XlinkTypeArc;

/**
 * Interface for elements that should contain XlinkArcLink attributes
 * 
 * @author Robert Stephan
 */
public interface IAttributeGroupXlinkArcLink {
    public XlinkTypeArc getXlinkType();

    public String getXlinkArcrole();

    public String getXlinkTitle();

    public XlinkShow getXlinkShow();

    public XlinkActuate getXlinkActuate();

    public String getXlinkFrom();

    public String getXlinkTo();

    public void setXlinkType(XlinkTypeArc xlinkType);

    public void setXlinkArcrole(String xlinkArcrole);

    public void setXlinkTitle(String xlinkTitle);

    public void setXlinkShow(XlinkShow xlinkShow);

    public void setXlinkActuate(XlinkActuate xlinkActuate);

    public void setXlinkFrom(String xlinkFrom);

    public void setXlinkTo(String xlinkTo);
}
