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
package org.mycore.libmeta.mods.model.physicaldescription;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * MODS PhysicalDescription Subelement: Form
 * 
 * <xs:element ref="form"/>
 *   <!-- same definition as is used in copyInformation -->
 *
 *    
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Form extends org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.Form implements IPhysicalDescriptionSubelement {

    public static Builder builder() {
        return builder(new Form());
    }

    public static Builder builder(Form f) {
        return new Builder(f);
    }

    public static class Builder extends org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.Form.Builder {
        protected Builder(Form f) {
            super(f);
        }
    }
}
