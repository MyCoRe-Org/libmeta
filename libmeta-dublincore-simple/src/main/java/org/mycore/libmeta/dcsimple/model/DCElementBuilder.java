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
package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public abstract class DCElementBuilder<B> {
    protected final ObjectFactory dcObjectFactory;
    protected String language;
    protected String value;

    protected DCElementBuilder() {
        this.dcObjectFactory = new ObjectFactory();
    }

    public B language(String language) {
        this.language = language;
        return _self();
    }

    public B value(String value) {
        this.value = value;
        return _self();
    }

    public abstract JAXBElement<ElementType> build();

    @SuppressWarnings("unchecked")
    public B _self() {
        return (B) this;
    }
}
