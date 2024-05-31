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
package org.mycore.libmeta.daia__1_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.daia__1_0.model.DAIA;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

/**
 * @author Robert Stephan
 */
public class DAIAJSONProcessor {

    private static final DAIAJSONProcessor INSTANCE = new DAIAJSONProcessor();

    private JsonbConfig cfg = new JsonbConfig().withFormatting(true);

    //private constructor to avoid client applications to use constructor
    private DAIAJSONProcessor() {
    }

    public static DAIAJSONProcessor getInstance() {
        return INSTANCE;
    }

    public void marshal(DAIA daia, Path p) throws LibmetaProcessorException {
        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            Jsonb jsonb = JsonbBuilder.create(cfg);
            jsonb.toJson(daia, bw);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public String marshalToString(DAIA daia) throws LibmetaProcessorException {
        StringWriter sw = new StringWriter();
        try {
            Jsonb jsonb = JsonbBuilder.create(cfg);
            jsonb.toJson(daia, sw);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
        return sw.toString();
    }

    public DAIA unmarshal(String s) throws LibmetaProcessorException {
        try {
            Jsonb jsonb = JsonbBuilder.create(cfg);
            return jsonb.fromJson(new StringReader(s), DAIA.class);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public DAIA unmarshal(Path p) throws LibmetaProcessorException {
        try (BufferedReader br = Files.newBufferedReader(p)) {
            Jsonb jsonb = JsonbBuilder.create(cfg);
            return jsonb.fromJson(br, DAIA.class);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }

    public DAIA unmarshal(URL url) throws LibmetaProcessorException {
        try (InputStream is = url.openStream()) {
            Jsonb jsonb = JsonbBuilder.create(cfg);
            return jsonb.fromJson(is, DAIA.class);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }
    }
}
