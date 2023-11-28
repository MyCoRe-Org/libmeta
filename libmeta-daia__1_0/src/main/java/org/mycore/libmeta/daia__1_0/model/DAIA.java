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
import java.time.ZonedDateTime;
import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;

/**
Document Availability Information API (DAIA).
Describes the current availability of different services about an information
resource at a given institution. 
Version: 1.0.0 (2017-06-23) by Jakob Voss
Specification: http://gbv.github.io/daia/daia.html
JSON schema: https://github.com/gbv/daia/blob/master/daia-schema/daia.schema.json

@author Robert Stephan
*/
public class DAIA {
    // JSON Schema excerpt:
    //"properties": {
    //    "$schema": {
    //      "$ref": "#/types/URL"
    //    },
    //    "@context": {
    //      "$ref": "#/types/URL"
    //    },
    //    "document": {
    //      "items": {
    //        "$ref": "#/types/document"
    //      },
    //      "type": "array"
    //    },
    //    "institution": {
    //      "$ref": "#/types/entity"
    //    },
    //    "timestamp": {
    //      "$ref": "#/types/datetime"
    //    }
    //  },
    //  "required": [
    //    "document"
    //  ],
    //  
    @JsonbProperty("$schema")
    private URL schema;

    @JsonbProperty("@context")
    private URL context;

    @JsonbProperty("document")
    private List<Document> documents;

    private Institution institution;

    private ZonedDateTime timestamp;

    public URL getSchema() {
        return schema;
    }

    public void setSchema(URL schema) {
        this.schema = schema;
    }

    public URL getContext() {
        return context;
    }

    public void setContext(URL context) {
        this.context = context;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
