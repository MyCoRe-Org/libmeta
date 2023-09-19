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
import org.mycore.libmeta.marc21.xml.MarcXMLProcessor;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import jakarta.json.stream.JsonGenerator;

/**
* Transform MARCJSON from and to MARCRecord object
* 
* based on: http://format.gbv.de/marc/json
* 
* @author Robert Stephan
*/
public class MarcJSONProcessor {

    private static final MarcJSONProcessor INSTANCE = new MarcJSONProcessor();

    //private constructor to avoid client applications to use constructor
    private MarcJSONProcessor() {
    }

    public static MarcJSONProcessor getInstance() {
        return INSTANCE;
    }

    public void marshal(MarcRecord marc, Path p) throws Exception {
        try (BufferedWriter bw = Files.newBufferedWriter(p);
            JsonGenerator jg = Json.createGenerator(bw)) {
            marshal(marc, jg);
        }
    }

    public String marshalToString(MarcRecord marc) throws Exception {
        StringWriter sw = new StringWriter();
        try (JsonGenerator jg = Json.createGenerator(sw)) {
            marshal(marc, jg);
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

    public void marshal(MarcRecord marc, JsonGenerator jGen) {
        jGen.writeStartArray();
        if (marc.getLeader() != null) {
            jGen.writeStartArray();
            jGen.write("LDR");
            jGen.writeNull();
            jGen.writeNull();
            jGen.write("_");
            jGen.write(marc.getLeader().getContent());
            jGen.writeEnd();
        }
        if (marc.getControlfields().size() > 0 || marc.getDatafields().size() > 0) {
            for (MarcControlfield cf : marc.getControlfields()) {
                jGen.writeStartArray();
                jGen.write(cf.getTag());
                jGen.writeNull();
                jGen.writeNull();
                jGen.write("_");
                jGen.write(cf.getContent());
                jGen.writeEnd();
            }
            for (MarcDatafield df : marc.getDatafields()) {
                jGen.writeStartArray();
                jGen.write(df.getTag());
                jGen.write(df.getInd1());
                jGen.write(df.getInd2());
                for (MarcSubfield sf : df.getSubfields()) {
                    jGen.write(sf.getCode());
                    jGen.write(sf.getContent());
                }
                jGen.writeEnd();
            }

        }
        jGen.writeEnd();
    }

    public MarcRecord unmarshal(JsonReader jr) {
        MarcRecord mr = new MarcRecord();
        JsonArray a = jr.readArray();
        for (int i = 0; i < a.size(); i++) {
            JsonArray field = a.getJsonArray(i);
            if ("LDR".equals(field.getString(0))) {
                mr.setLeader(
                    MarcLeader.builder()
                        .content(field.getString(4))
                        .build());
            } else if (field.getString(0).startsWith("00")) {
                mr.getControlfields().add(
                    MarcControlfield.builder()
                        .tag(field.getString(0))
                        .content(field.getString(4))
                        .build());
            } else {
                MarcDatafield df = MarcDatafield.builder()
                    .tag(field.getString(0))
                    .ind1(field.getString(1))
                    .ind2(field.getString(2))
                    .build();
                mr.getDatafields().add(df);
                for (int j = 3; j < field.size(); j = j + 2) {
                    df.getSubfields().add(
                        MarcSubfield.builder()
                            .code(field.getString(j))
                            .content(field.getString(j + 1))
                            .build());
                }
            }
        }
        return mr;
    }

    public static void main(String[] args) {
        try {
            //URL url = new URL("https://unapi.k10plus.de/?&format=marcxml&id=k10plus:ppn:1667675745");
            URL url = new URL("https://lccn.loc.gov/09028059/marcxml");
            MarcRecord mr = (MarcRecord) MarcXMLProcessor.getInstance().unmarshal(url);
            System.out.println(MarcJSONProcessor.getInstance().marshalToString(mr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
