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
package org.mycore.libmeta.pica.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.pica.model.PicaDatafield;
import org.mycore.libmeta.pica.model.PicaRecord;
import org.mycore.libmeta.pica.model.PicaSubfield;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonWriter;

/**
* Transforms a PicaRecord into a JSON notation
* derived from Ross Singer's MARC-in-JSON proposal:
* https://web.archive.org/web/20151112001548/http://dilettantes.code4lib.org/blog/2010/09/a-proposal-to-serialize-marc-in-json/
* 
* @author Robert Stephan
*/
public class PicaInJSONProcessor {

    private static final PicaInJSONProcessor INSTANCE = new PicaInJSONProcessor();

    //private constructor to avoid client applications to use constructor
    private PicaInJSONProcessor() {
    }

    public static PicaInJSONProcessor getInstance() {
        return INSTANCE;
    }

    public void marshal(PicaRecord pica, Path p) throws LibmetaProcessorException {
        try (BufferedWriter bw = Files.newBufferedWriter(p);
            JsonWriter jw = Json.createWriter(bw)) {
            marshal(pica, jw);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public String marshalToString(PicaRecord pica) throws LibmetaProcessorException {
        StringWriter sw = new StringWriter();
        try (JsonWriter jw = Json.createWriter(sw)) {
            marshal(pica, jw);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
        return sw.toString();
    }

    public PicaRecord unmarshal(String s) throws LibmetaProcessorException {
        try (JsonReader jr = Json.createReader(new StringReader(s))) {
            return unmarshal(jr);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public PicaRecord unmarshal(Path p) throws LibmetaProcessorException {
        try (BufferedReader br = Files.newBufferedReader(p);
            JsonReader jr = Json.createReader(br)) {
            return unmarshal(jr);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public PicaRecord unmarshal(URL url) throws LibmetaProcessorException {
        try (InputStream is = url.openStream();
            JsonReader jr = Json.createReader(is)) {
            return unmarshal(jr);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public void marshal(PicaRecord pica, JsonWriter jw) throws LibmetaProcessorException {
        try {
            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            JsonArrayBuilder fieldsBuilder = Json.createArrayBuilder();
            for (PicaDatafield df : pica.getDatafields()) {
                JsonObjectBuilder fieldBuilder = Json.createObjectBuilder();
                if (df.getOccurrence() != null) {
                    fieldBuilder.add("occurrence", df.getOccurrence());
                }
                JsonArrayBuilder subfieldBuilder = Json.createArrayBuilder();
                for (PicaSubfield sf : df.getSubfields()) {
                    subfieldBuilder.add(Json.createObjectBuilder().add(sf.getCode(), sf.getContent()));
                }
                fieldBuilder.add("subfields", subfieldBuilder);
                fieldsBuilder.add(Json.createObjectBuilder().add(String.valueOf(df.getTag()), fieldBuilder));
            }
            jsonBuilder.add("datafields", fieldsBuilder);

            jw.write(jsonBuilder.build());
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public PicaRecord unmarshal(JsonReader jr) throws LibmetaProcessorException {
        try {
            PicaRecord pica = new PicaRecord();
            JsonObject json = jr.readObject();
            JsonArray jsonFields = json.getJsonArray("datafields");

            for (int i = 0; i < jsonFields.size(); i++) {
                JsonObject jsonField = jsonFields.getJsonObject(i);
                jsonField.forEach((tag, value) -> {
                    PicaDatafield df = PicaDatafield.builder()
                        .tag(tag)
                        .occurrence(value.asJsonObject().containsKey("occurrence")
                            ? value.asJsonObject().getString("occurrence")
                            : null)
                        .build();
                    pica.getDatafields().add(df);
                    value.asJsonObject().getJsonArray("subfields").forEach(sf -> {
                        sf.asJsonObject().forEach((k, v) -> {
                            df.getSubfields().add(
                                PicaSubfield.builder()
                                    .code(k)
                                    .content(((JsonString) v).getString())
                                    .build());
                        });
                    });
                });
            }
            return pica;
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

}
