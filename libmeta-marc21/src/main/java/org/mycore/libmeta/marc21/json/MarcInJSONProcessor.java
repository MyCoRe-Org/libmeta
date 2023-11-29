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
package org.mycore.libmeta.marc21.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.mycore.libmeta.marc21.model.MarcControlfield;
import org.mycore.libmeta.marc21.model.MarcDatafield;
import org.mycore.libmeta.marc21.model.MarcLeader;
import org.mycore.libmeta.marc21.model.MarcRecord;
import org.mycore.libmeta.marc21.model.MarcSubfield;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonWriter;

/**
* Transform MARC-in-JSON from and to MARCRecord object
* 
* based on Ross Singers MARC-in-JSON proposal:
* https://web.archive.org/web/20151112001548/http://dilettantes.code4lib.org/blog/2010/09/a-proposal-to-serialize-marc-in-json/
* 
* @author Robert Stephan
*/
public class MarcInJSONProcessor {

    private static final MarcInJSONProcessor INSTANCE = new MarcInJSONProcessor();

    //private constructor to avoid client applications to use constructor
    private MarcInJSONProcessor() {
    }

    public static MarcInJSONProcessor getInstance() {
        return INSTANCE;
    }

    public void marshal(MarcRecord marc, Path p) throws Exception {
        try (BufferedWriter bw = Files.newBufferedWriter(p);
            JsonWriter jw = Json.createWriter(bw)) {
            marshal(marc, jw);
        }
    }

    public String marshalToString(MarcRecord marc) throws Exception {
        StringWriter sw = new StringWriter();
        try (JsonWriter jw = Json.createWriter(sw)) {
            marshal(marc, jw);
        }
        return sw.toString();
    }

    public MarcRecord unmarshal(String s) throws Exception {
        try (JsonReader jr = Json.createReader(new StringReader(s))) {
            return unmarshal(jr);
        }

    }

    public MarcRecord unmarshal(Path p) throws Exception {
        try (BufferedReader br = Files.newBufferedReader(p);
            JsonReader jr = Json.createReader(br)) {
            return unmarshal(jr);
        }
    }

    public MarcRecord unmarshal(URL url) throws Exception {
        try (InputStream is = url.openStream();
            JsonReader jr = Json.createReader(is)) {
            return unmarshal(jr);
        }
    }

    public void marshal(MarcRecord marc, JsonWriter jw) {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        if (marc.getLeader() != null) {
            jsonBuilder.add("leader", Json.createValue(marc.getLeader().getContent()));
        }

        JsonArrayBuilder fieldsBuilder = Json.createArrayBuilder();
        for (MarcControlfield cf : marc.getControlfields()) {
            fieldsBuilder
                .add(Json.createObjectBuilder()
                    .add(cf.getTag(), cf.getContent()));
        }
        for (MarcDatafield df : marc.getDatafields()) {
            JsonObjectBuilder fieldBuilder = Json.createObjectBuilder();
            fieldBuilder.add("ind1", df.getInd1());
            fieldBuilder.add("ind2", df.getInd2());
            JsonArrayBuilder subfieldBuilder = Json.createArrayBuilder();
            for (MarcSubfield sf : df.getSubfields()) {
                subfieldBuilder.add(Json.createObjectBuilder().add(sf.getCode(), sf.getContent()));
            }
            fieldBuilder.add("subfields", subfieldBuilder);
            fieldsBuilder.add(Json.createObjectBuilder().add(String.valueOf(df.getTag()), fieldBuilder));
        }
        jsonBuilder.add("fields", fieldsBuilder);

        jw.write(jsonBuilder.build());
    }

    public MarcRecord unmarshal(JsonReader jr) {
        MarcRecord marc = new MarcRecord();
        JsonObject json = jr.readObject();
        if (json.containsKey("leader")) {
            marc.setLeader(MarcLeader.builder().content(json.getString("leader")).build());
        }
        JsonArray jsonFields = json.getJsonArray("fields");

        for (int i = 0; i < jsonFields.size(); i++) {
            JsonObject jsonField = jsonFields.getJsonObject(i);
            jsonField.forEach((tag, value) -> {
                if (value instanceof JsonString) {
                    marc.getControlfields().add(
                        MarcControlfield.builder()
                            .tag(tag)
                            .content(((JsonString) value).getString())
                            .build());
                } else {
                    MarcDatafield df = MarcDatafield.builder()
                        .tag(tag)
                        .ind1(value.asJsonObject().getString("ind1"))
                        .ind2(value.asJsonObject().getString("ind2"))
                        .build();
                    marc.getDatafields().add(df);
                    value.asJsonObject().getJsonArray("subfields").forEach(sf -> {
                        sf.asJsonObject().forEach((k, v) -> {
                            df.getSubfields().add(
                                MarcSubfield.builder()
                                    .code(k)
                                    .content(v.toString())
                                    .build());
                        });
                    });
                }
            });
        }
        return marc;
    }

}
