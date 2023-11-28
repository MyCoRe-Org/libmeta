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

import java.time.ZonedDateTime;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbTypeAdapter;

@JsonbTypeAdapter(AnyDate.AnyDateJsonbAdapter.class)
public class AnyDate {
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

    private ZonedDateTime date;

    private Unknown unknown;

    public enum Unknown {
        unknown;
    }

    public AnyDate(ZonedDateTime date) {
        this.date = date;
        unknown = null;
    }

    public AnyDate(Unknown unknown) {
        this.unknown = unknown;
        if (unknown == null) {
            date = ZonedDateTime.now();
        }
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Unknown getUnknown() {
        return unknown;
    }

    public static class AnyDateJsonbAdapter implements JsonbAdapter<AnyDate, JsonString> {

        @Override
        public JsonString adaptToJson(AnyDate d) throws Exception {
            if (d == null) {
                return null;
            }
            if (d.getUnknown() != null) {
                return Json.createValue("unknown");
            }
            return Json.createValue(d.getDate().toString());
        }

        @Override
        public AnyDate adaptFromJson(JsonString s) throws Exception {
            if (s == null) {
                return null;
            }
            if (s.getString().equals("unknown")) {
                return new AnyDate(Unknown.unknown);
            }
            return new AnyDate(ZonedDateTime.parse(s.getString()));
        }
    }
}
