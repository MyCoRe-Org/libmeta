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
 * {@code
 *	<xs:attributeGroup name="languageAttributeGroup">
 *		<xs:attribute name="lang" type="xs:string"/>
 *		<xs:attribute ref="xml:lang"/>
 *		<xs:attribute name="script" type="xs:string"/>
 *		<xs:attribute name="transliteration" type="xs:string"/>
 *	</xs:attributeGroup>
 *	}
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public interface ILanguageAttributeGroup {
	public String getLang();
	public String getXmlLang();
	public String getScript();
	public String getTransliteration();
	
	public void setLang(String lang);
	public void setXmlLang(String xmlLang);
	public void setScript(String script);
	public void setTransliteration(String transliteration);
}
