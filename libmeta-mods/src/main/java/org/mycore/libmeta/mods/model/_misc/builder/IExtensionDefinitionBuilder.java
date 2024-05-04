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

import java.util.List;

import org.mycore.libmeta.mods.model._misc.definitions.ExtensionDefinition;
import org.w3c.dom.Node;

/**
 * Content: XsString
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public interface IExtensionDefinitionBuilder<T extends ExtensionDefinition, B> extends IIDAttributeGroupBuilder<T, B>{
    public T _target();

    public B _self();

    @SuppressWarnings("unchecked")
    public default B addContent(Node content) {
        _target().getContent().add(content);
        return _self();

    }

    @SuppressWarnings("unchecked")
    public default B addContent(List<Node> content) {
        _target().getContent().addAll(content);
        return _self();
    }

    @SuppressWarnings("unchecked")
    public default B content(String content) {
        _target().getContent().clear();
        _target().getContent().add(content);
        return _self();
    }

    public default B displayLabel(String displayLabel) {
        _target().setDisplayLabel(displayLabel);
        return _self();
    }
    
    public default B type(String type) {
        _target().setType(type);
        return _self();
    }

}
