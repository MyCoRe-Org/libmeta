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
package org.mycore.libmeta.mods.model.part.extend;

import org.mycore.libmeta.mods.model._misc.types.XsPositiveInteger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


/**
 * {@code
 *  <xs:element name="total" type="xs:positiveInteger"/>
 * }
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Total extends XsPositiveInteger implements IPartExtendSubelement {
    public static Builder builder() {
        return builder(new Total());
    }
    
    public static Builder builder(Total t) {
        return new Builder(t);
    }
    
    public static class Builder extends XsPositiveInteger.Builder<Total>{
         protected Builder(Total t) {
            super(t);
        }
    }
}
