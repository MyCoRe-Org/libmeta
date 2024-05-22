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
package org.mycore.libmeta.alto__4.model.styles;

import java.util.EnumSet;

public interface IFormattingAttributeGroupBuilder<T extends IFormattingAttributeGroup, B> {
    public T _target();

    public B _self();

    public default B FONTFAMILY(String fontFamily) {
        _target().setFONTFAMILY(fontFamily);
        return _self();
    }

    public default B FONTTYPE(FontType fontType) {
        _target().setFONTTYPE(fontType);
        return _self();
    }

    public default B FONTWIDTH(FontWidth fontWidth) {
        _target().setFONTWIDTH(fontWidth);
        return _self();
    }

    public default B FONTSIZE(Float fontSize) {
        _target().setFONTSIZE(fontSize);
        return _self();
    }

    public default B FONTCOLOR(String fontColor) {
        _target().setFONTCOLOR(fontColor);
        return _self();
    }

    public default B FONTStyle(EnumSet<FontStyle> fontStyle) {
        _target().setFONTSTYLE(fontStyle);
        return _self();
    }
}
