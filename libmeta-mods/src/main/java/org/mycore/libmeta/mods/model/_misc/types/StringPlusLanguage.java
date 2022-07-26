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
package org.mycore.libmeta.mods.model._misc.types;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public class StringPlusLanguage extends XsString implements ILanguageAttributeGroup {

    @XmlAttribute(name = "lang", namespace = "http://www.loc.gov/mods/v3", required = false)
    String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    String xmlLang;

    @XmlAttribute(name = "script", namespace = "http://www.loc.gov/mods/v3", required = false)
    String script;

    @XmlAttribute(name = "transliteration", namespace = "http://www.loc.gov/mods/v3", required = false)
    String transliteration;

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public String getXmlLang() {
        return xmlLang;
    }

    @Override
    public String getScript() {
        return script;
    }

    @Override
    public String getTransliteration() {
        return transliteration;
    }

    @Override
    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public void setXmlLang(String xmlLang) {
        this.xmlLang = xmlLang;
    }

    @Override
    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

   public static class Builder extends BuilderBase<StringPlusLanguage, Builder> implements ILanguageAttributeGroupBuilder<StringPlusLanguage, Builder>, IXsStringBuilder<StringPlusLanguage, Builder> {
        protected Builder(StringPlusLanguage spl) {
            super(spl);
        }
    }
}
