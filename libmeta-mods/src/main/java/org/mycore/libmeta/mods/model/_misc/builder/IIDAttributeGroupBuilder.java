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

import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;

/**
 * {@code
 * <xs:attributeGroup name="IDAttributeGroup">
 *   <xs:attribute name="ID" type="xs:ID"/>
 *   <xs:attribute name="IDREF" type="xs:IDREF"/>
 * </xs:attributeGroup>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.8
 *
 */
public interface IIDAttributeGroupBuilder<T extends IIDAttributeGroup, B>{
    public T _target();
    public B _self();
    
	public default B ID(String iD){
		_target().setID(iD);
		return _self();
	}
	public default B IDREF(String iDREF){
		_target().setIDREF(iDREF);
		return _self();
	}
}
