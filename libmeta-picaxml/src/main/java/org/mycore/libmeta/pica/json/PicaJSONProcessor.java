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
import jakarta.json.JsonReader;
import jakarta.json.stream.JsonGenerator;

/**
* Transform PicaJSON from and to PicaRecord object
* 
* based on: http://format.gbv.de/pica/json
* 
* @author Robert Stephan
*/
public class PicaJSONProcessor {

    private static final PicaJSONProcessor INSTANCE = new PicaJSONProcessor();

    //private constructor to avoid client applications to use constructor
    private PicaJSONProcessor() {
    }

    public static PicaJSONProcessor getInstance() {
        return INSTANCE;
    }

    public void marshal(PicaRecord marc, Path p) throws LibmetaProcessorException {
        try (BufferedWriter bw = Files.newBufferedWriter(p);
            JsonGenerator jg = Json.createGenerator(bw)) {
            marshal(marc, jg);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public String marshalToString(PicaRecord marc) throws LibmetaProcessorException {
        StringWriter sw = new StringWriter();
        try (JsonGenerator jg = Json.createGenerator(sw)) {
            marshal(marc, jg);
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

    public void marshal(PicaRecord pica, JsonGenerator jGen) throws LibmetaProcessorException {
        try {
            jGen.writeStartArray();
            for (PicaDatafield df : pica.getDatafields()) {
                jGen.writeStartArray();
                jGen.write(df.getTag());
                if (df.getOccurrence() == null) {
                    jGen.writeNull();
                } else {
                    jGen.write(df.getOccurrence());
                }

                for (PicaSubfield sf : df.getSubfields()) {
                    jGen.write(sf.getCode());
                    jGen.write(sf.getContent());
                }
                jGen.writeEnd();
            }

            jGen.writeEnd();
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public PicaRecord unmarshal(JsonReader jr) throws LibmetaProcessorException {
        try {
            PicaRecord pr = new PicaRecord();
            JsonArray a = jr.readArray();
            for (int i = 0; i < a.size(); i++) {
                JsonArray field = a.getJsonArray(i);

                PicaDatafield df = PicaDatafield.builder()
                    .tag(field.getString(0))
                    .build();
                pr.getDatafields().add(df);
                if (!field.isNull(1)) {
                    df.setOccurrence(field.getString(1));
                }
                for (int j = 3; j < field.size(); j = j + 2) {
                    df.getSubfields().add(
                        PicaSubfield.builder()
                            .code(field.getString(j))
                            .content(field.getString(j + 1))
                            .build());
                }
            }
            return pr;
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

}
