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

import org.mycore.libmeta.xlink.model.XlinkTypeLocator;

/**
 * Interface for elements that should contain XlinkLocatorLink attributes
 * 
 * @author Robert Stephan
 */
public interface IAttributeGroupXlinkLocatorLink {
    public XlinkTypeLocator getXlinkType();

    public String getXlinkHref();

    public String getXlinkRole();

    public String getXlinkTitle();

    public String getXlinkLabel();

    public void setXlinkType(XlinkTypeLocator xlinkType);

    public void setXlinkHref(String xlinkHref);

    public void setXlinkRole(String xlinkRole);

    public void setXlinkTitle(String xlinkTitle);

    public void setXlinkLabel(String xlinkLabel);
}
