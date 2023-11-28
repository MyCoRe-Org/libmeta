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
package org.mycore.libmeta.daia__1_0.model;

import java.net.URI;
import java.net.URL;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

/**
 * 
 * @author Robert Stephan
 * 
 */
@JsonbPropertyOrder({"id", "content", "href"})
public abstract class Entity {
    // JSON schema excerpt:
    //  "entity": {
    //    "additionalProperties": false,
    //    "properties": {
    //      "content": {
    //        "type": "string"
    //      },
    //      "href": {
    //        "$ref": "#/types/URL"
    //      },
    //      "id": {
    //        "$ref": "#/types/URI"
    //      }
    //     },
    //     "type": "object"
    //  }

    private String content;
    private URL href;
    private URI id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public URL getHref() {
        return href;
    }

    public void setHref(URL href) {
        this.href = href;
    }

    public URI getId() {
        return id;
    }

    public void setId(URI id) {
        this.id = id;
    }

}
