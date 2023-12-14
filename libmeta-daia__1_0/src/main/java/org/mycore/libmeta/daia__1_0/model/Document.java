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
import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * a group of items that can be refered to with one identifier
 * 
 * @author Robert Stephan
 *
 */

public class Document {
    //JSON Schema excerpt:
    //    "document": {
    //        "additionalProperties": false,
    //        "properties": {
    //          "about": {
    //            "type": "string"
    //          },
    //          "href": {
    //            "$ref": "#/types/URL"
    //          },
    //          "id": {
    //            "$ref": "#/types/URI"
    //          },
    //          "item": {
    //            "items": {
    //              "$ref": "#/types/item"
    //            },
    //            "type": "array"
    //          },
    //          "requested": {
    //            "type": "string"
    //          }
    //        },
    //        "required": [
    //          "id"
    //        ],
    //        "type": "object"
    //      },

    private String about;

    private URL href;

    private URI id;

    @JsonbProperty("item")
    private List<Item> items;

    private String requested;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
