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
package org.mycore.libmeta.pica.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.stream.XMLStreamException;

import org.mycore.libmeta.pica.model.PicaCollection;
import org.mycore.libmeta.pica.model.PicaDatafield;
import org.mycore.libmeta.pica.model.PicaRecord;
import org.mycore.libmeta.pica.model.PicaSubfield;

public class PicaPlusProcessor {
private static final PicaPlusProcessor INSTANCE = new PicaPlusProcessor();
    
    //private constructor to avoid client applications to use constructor
    private PicaPlusProcessor() {}
    
    public static PicaPlusProcessor getInstance() {
        return INSTANCE;
    }
    
	/**
	 * outputs a data field at the subfields belonging to it from a given text line.
	 */
	private void createFields(String line, PicaRecord record) throws XMLStreamException {
		int pos = line.indexOf(" ");
		String[] data = line.substring(0, pos).split("/");
		String tag = data[0];

		PicaDatafield dataField = new PicaDatafield();
		record.getDatafields().add(dataField);
		dataField.setTag(tag);
		if (data.length > 1) {
			dataField.setOccurrence(data[1]);
		}

		// get Subfields
		String[] subfields = line.substring(pos + 1).split("ƒ");
		for (String sub : subfields) {
			if (sub.length() > 1) {
				PicaSubfield subfield = new PicaSubfield();
				dataField.getSubfields().add(subfield);
				subfield.setCode(sub.substring(0, 1));
				subfield.setContent(sub.substring(1));
			}
		}
	}

	public PicaCollection unmarshalFromWinIBWDownlad(Path p) {
		PicaCollection col = new PicaCollection();
		try(BufferedReader br = Files.newBufferedReader(p)) {
			PicaRecord record = null;
			String s;
			while ((s = br.readLine()) != null) {
				if (s.length() == 0) {
					continue;
				}
				if (s.contains("PPN:")) {
					// a new record begins
					record = new PicaRecord();
					col.getRecords().add(record);
					// ppn = s.substring(s.indexOf("PPN:") + 5, s.indexOf("PPN:") + 5 + 12).trim();
					continue;
				}
				if (s.startsWith("[")) {
					// [0028 ] ub rostock <28>
					// we produce some new fields here - USE WITH CARE AS THEY ARE NOT STANDARDIZED
					// WITH GBV !!!
					// 100@ ƒa0028ƒbub rostock <28>
					String[] data = s.substring(1).split("]");
					createFields("100@ ƒa" + data[0].trim() + "ƒb" + data[1].trim(), record);
					// comments are currently not supported
					continue;
				}

				createFields(s, record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}
	
	public String marshalToString(PicaRecord pica) throws Exception {
        StringWriter sw = new StringWriter();
	    marshal(pica, sw);
	    return sw.toString();
    }
	
	public void marshal(PicaRecord pica, Path p) throws Exception {
	    try(BufferedWriter bw = Files.newBufferedWriter(p)){
         marshal(pica, bw);
	    }
    }
	
	private void marshal(PicaRecord record, Writer w) throws IOException {
	    for(PicaDatafield df : record.getDatafields()) {
	        w.append(df.getTag());
	        if(df.getOccurrence() != null) {
	            w.append("/").append(df.getOccurrence());
	        }
	        w.append(" ");
	        for(PicaSubfield sf : df.getSubfields()) {
	            w.append("ƒ").append(sf.getCode()).append(sf.getContent());
	        }
	        w.append("\n");
	    }
	}
	
}
