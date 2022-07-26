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
package org.mycore.libmeta.mods.model.part.detail;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

/**
 * <xs:element name="number" type="stringPlusLanguage"/>
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Number extends StringPlusLanguage implements IPartDetailSubelement{

    public static Builder builder() {
        return builder(new Number());
    }
    
    public static Builder builder(Number num) {
        return new Builder(num);
    }
    
    public static class Builder extends BuilderBase<Number, Builder> implements IXsStringBuilder<Number, Builder>, ILanguageAttributeGroupBuilder<Number, Builder> {
        protected Builder(Number num) {
            super(num);
        }
    }
}