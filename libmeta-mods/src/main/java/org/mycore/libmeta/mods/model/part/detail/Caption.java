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
 * {@code
 *  <xs:element name="caption" type="stringPlusLanguage"/>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 */
public class Caption extends StringPlusLanguage implements IPartDetailSubelement{

    public static Builder builder() {
        return builder(new Caption());
    }
    
    public static Builder builder(Caption cap) {
        return new Builder(cap);
    }
    
    public static class Builder extends BuilderBase<Caption, Builder> implements IXsStringBuilder<Caption, Builder>, ILanguageAttributeGroupBuilder<Caption, Builder> {
        protected Builder(Caption cap) {
            super(cap);
        }
     }
}