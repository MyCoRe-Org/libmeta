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

import java.net.URL;
import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

public class Unavailable {
// JSON schema excerpt:
//    "unavailable": {
//        "additionalProperties": false,
//        "properties": {
//          "expected": {
//            "$ref": "#/types/anydate"
//          },
//          "href": {
//            "$ref": "#/types/URL"
//          },
//          "limitation": {
//            "items": {
//              "$ref": "#/types/entity"
//            },
//            "type": "array"
//          },
//          "queue": {
//            "$ref": "#/types/count"
//          },
//          "service": {
//            "$ref": "#/types/service"
//          },
//          "title": {
//            "type": "string"
//          }
//        },
//        "required": [
//          "service"
//        ],
//        "type": "object"
//      }
    
    private AnyDate expected;
    private URL href;
    
    @JsonbProperty("limitation")
    private List<Limitation> limitiations;
    
    private Integer queue;
    
    private Service service;
    
    private String title;

    public AnyDate getExpected() {
        return expected;
    }

    public void setExpected(AnyDate expected) {
        this.expected = expected;
    }

    public URL getHref() {
        return href;
    }

    public void setHref(URL href) {
        this.href = href;
    }

    public List<Limitation> getLimitiations() {
        return limitiations;
    }

    public void setLimitiations(List<Limitation> limitiations) {
        this.limitiations = limitiations;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        if(queue<1) {
           throw new NumberFormatException("the queue value must be greater than 0");
        }
        this.queue = queue;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
