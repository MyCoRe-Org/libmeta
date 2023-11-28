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

import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;

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
public interface ILanguageAttributeGroupBuilder<T extends ILanguageAttributeGroup, B> {
    public T _target();

    public B _self();

    public default B lang(String lang) {
        _target().setLang(lang);
        return _self();
    }

    public default B xmlLang(String xmlLang) {
        _target().setXmlLang(xmlLang);
        return _self();
    }

    public default B script(String script) {
        _target().setScript(script);
        return _self();
    }

    public default B transliteration(String transliteration) {
        _target().setTransliteration(transliteration);
        return _self();
    }
}
