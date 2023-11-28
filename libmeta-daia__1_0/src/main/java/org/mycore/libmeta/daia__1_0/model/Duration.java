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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;

@JsonbTypeAdapter(Duration.DurationJsonbAdapter.class)
public class Duration {
    // JSON schema exerpt;
    // "duration": {
    //  "anyOf": [
    //    {
    //      "pattern": "^-?P([0-9]+Y)?([0-9]+M)?([0-9]+D)?T?([0-9]+H)?([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?$",
    //      "type": "string"
    //    },
    //    {
    //      "enum": [
    //        "unknown"
    //      ]
    //    }
    //  ]
    //},

    private String value;

    public Duration(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class DurationJsonbAdapter implements JsonbAdapter<Duration, JsonString> {

        @Override
        public JsonString adaptToJson(Duration d) throws Exception {
            return Json.createValue(d.getValue());
        }

        @Override
        public Duration adaptFromJson(JsonString s) throws Exception {
            return new Duration(s.getString());
        }
    }
}
