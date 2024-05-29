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
package org.mycore.libmeta.mets.model._misc;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Implementation of Attribute Type URI
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlJavaTypeAdapter(URIs.JAXBAdapter.class)
public class URIs extends Vector<URI> implements List<URI> {

    private static final long serialVersionUID = 1L;

    public static class JAXBAdapter extends XmlAdapter<String, URIs> {

        public URIs unmarshal(String value) {
            URIs uris = new URIs();
            if (value != null) {
                for (String s : value.trim().split("\\s+")) {
                    try {
                        uris.add(new URI(s));
                    } catch (URISyntaxException e) {
                        // ignore URI
                    }
                }
            }
            return uris;
        }

        public String marshal(URIs value) {
            if (value == null || value.size() == 0) {
                return null;
            }
            StringBuffer sb = new StringBuffer();
            for (URI u : value) {
                sb.append(" ");
                sb.append(u.toString());
            }
            return sb.toString().trim();
        }
    }
}
