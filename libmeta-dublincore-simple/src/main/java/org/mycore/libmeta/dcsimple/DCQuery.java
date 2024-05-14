/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General public static License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General public static License for more details.
 *
 * You should have received a copy of the GNU Lesser General public static License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mycore.libmeta.dcsimple;

import java.util.List;
import java.util.stream.Stream;

import org.mycore.libmeta.dcsimple.model.DCElement;
import org.mycore.libmeta.dcsimple.model.DCElementRoot;

public class DCQuery {

    /**
     * returns a filtered stream of DCElements
     * @param <T> the type of the DCElement
     * @param type the class to filter and cast elements for
     * @return an object stream of DCElements
     */
    public static <T extends DCElement> Stream<T> streamFilteredContent(DCElementRoot dcElementRoot, Class<T> type) {
        return dcElementRoot.getElements().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered list of DCElements
     * @param <T> the type of the DCElement
     * @param type the class to filter and cast elements for
     * @return an object stream of DCElements
     */
    public static <T extends DCElement> List<T> listFilteredContent(DCElementRoot dcElementRoot, Class<T> type) {
        return streamFilteredContent(dcElementRoot, type).toList();
    }

}
