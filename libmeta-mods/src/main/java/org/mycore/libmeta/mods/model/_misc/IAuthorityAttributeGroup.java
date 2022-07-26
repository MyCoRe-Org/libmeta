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
package org.mycore.libmeta.mods.model._misc;

/**
 * 
 *	<xs:attributeGroup name="authorityAttributeGroup">
 *		<!-- new in 3.4 -->
 *		<xs:attribute name="authority" type="xs:string"/>
 *		<xs:attribute name="authorityURI" type="xs:anyURI"/>
 *		<xs:attribute name="valueURI" type="xs:anyURI"/>
 *	</xs:attributeGroup>
 *	
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public interface IAuthorityAttributeGroup {
	public String getAuthority();
	public String getAuthorityURI();
	public String getValueURI();
	public void setAuthority(String authority);
	public void setAuthorityURI(String authorityURI);
	public void setValueURI(String valueURI);
}
