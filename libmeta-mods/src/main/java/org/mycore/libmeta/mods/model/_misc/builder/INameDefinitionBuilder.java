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

import org.mycore.libmeta.mods.model._misc.INameDefinitionSubelement;
import org.mycore.libmeta.mods.model._misc.definitions.NameDefinition;
import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;

/**
 * Content: XsString
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public interface INameDefinitionBuilder<S extends INameDefinitionSubelement, T extends NameDefinition<S>, B>
    extends IIDAttributeGroupBuilder<T, B>,
    IAuthorityAttributeGroupBuilder<T, B>,
    IAttributeGroupXlinkSimpleLinkBuilder<T, B>,
    ILanguageAttributeGroupBuilder<T, B> {

    public T _target();

    public B _self();

    public default B addContent(S content) {
        _target().getContent().add(content);
        return _self();
    }

    public default B displayLabel(String displayLabel) {
        _target().setDisplayLabel(displayLabel);
        return _self();
    }

    public default B altRepGroup(String s) {
        _target().setAltRepGroup(s);
        return _self();
    }

    public default B nameTitleGroup(String s) {
        _target().setNameTitleGroup(s);
        return _self();
    }

    public default B usage(Usage usage) {
        _target().setUsage(usage);
        return _self();
    }

    public default B type(NameType type) {
        _target().setType(type);
        return _self();
    }

    public default B supplied(Yes supplied) {
        _target().setSupplied(supplied);
        return _self();
    }

}
