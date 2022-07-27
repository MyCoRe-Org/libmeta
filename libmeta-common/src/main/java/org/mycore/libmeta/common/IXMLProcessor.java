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
package org.mycore.libmeta.common;

import java.net.URL;
import java.nio.file.Path;

import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface IXMLProcessor<T> {
    
    public String marshalToString(T t) throws Exception;
    public String marshalToString(T t, String schemaLocations) throws Exception;
    public Document marshalToDOM(T t) throws Exception;
    public Document marshalToDOM(T t, String schemaLocations) throws Exception;
    public void marshal(T t, Path p) throws Exception;
    public void marshal(T t, Path p, String schemaLocations) throws Exception;
    public void marshal(T t, StreamResult streamResult, String schemaLocations) throws Exception;
    
    public T unmarshal(Node xml) throws Exception;
    public T unmarshal(String xml) throws Exception;
    public T unmarshal(Path p) throws Exception;
    public T unmarshal(URL url) throws Exception;
}
