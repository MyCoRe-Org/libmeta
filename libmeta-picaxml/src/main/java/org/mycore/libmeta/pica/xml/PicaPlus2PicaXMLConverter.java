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
package org.mycore.libmeta.pica.xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * This tool converts a Pica+ Download file into a PicaXML file
 * The download has to be UTF-8 encoded.
 * 
 * Information about the PicaXML Format can be found at:
 * http://www.gbv.de/wikis/cls/PICA_XML_Version_1.0
 * 
 * 
 * @author Robert Stephan
 *
 */
public class PicaPlus2PicaXMLConverter {
    String lastTag = null;

    String ppn = null;

    /**
     * parses the input file and creates the output file
     * @param fIn - the input file
     * @param fOut - the output file
     */

    public void processFile(Path fIn, Path fOut) {
        try (InputStream isIn = Files.newInputStream(fIn);
            OutputStream isOut = Files.newOutputStream(fOut)) {
            processStreams(isIn, isOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processStreams(InputStream inS, OutputStream outS) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlWriter = factory.createXMLStreamWriter(outS, "UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(inS, "UTF-8"));
            process(br, xmlWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(BufferedReader br, XMLStreamWriter writer) {
        try {

            // create XML header
            writer.writeStartDocument("UTF-8", "1.0");

            // create root element:
            // <collection xmlns="info:srw/schema/5/picaXML-v1.0"
            //             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            //             xsi:schemaLocation="info:srw/schema/5/picaXML-v1.0
            //                       http://www.loc.gov/standards/sru/resources/pica-xml-v1-0.xsd">
            writer.writeCharacters("\n");
            writer.writeStartElement("collection");
            writer.writeDefaultNamespace("info:srw/schema/5/picaXML-v1.0");
            writer.writeNamespace("xsi",
                "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute(
                "http://www.w3.org/2001/XMLSchema-instance",
                "schemaLocation",
                "info:srw/schema/5/picaXML-v1.0 http://www.loc.gov/standards/sru/resources/pica-xml-v1-0.xsd");

            boolean record_open = false;
            String s;
            while ((s = br.readLine()) != null) {
                if (s.length() == 0) {
                    continue;
                }
                if (s.contains("PPN:")) {
                    //a new record begins
                    if (record_open) {
                        writer.writeCharacters("\n\t");
                        writer.writeEndElement(); // </record>
                    }
                    record_open = true;
                    lastTag = "";
                    ppn = s.substring(s.indexOf("PPN:") + 5, s.indexOf("PPN:") + 5 + 9);
                    writer.writeCharacters("\n\t");
                    writer.writeStartElement("record");
                    continue;
                }
                if (s.startsWith("[")) {
                    writer.writeCharacters("\n\t");
                    writer.writeComment(s);
                    continue;
                }

                writeFields(s, writer);

            }
            br.close();
            writer.writeCharacters("\n\t");
            writer.writeEndElement(); // </record>

            writer.writeCharacters("\n");
            writer.writeEndElement(); // </collection>

            writer.writeEndDocument();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * outputs a data field at the subfields belonging to it.
     */
    private void writeFields(String line, XMLStreamWriter writer) throws XMLStreamException {
        // get Field
        int pos = line.indexOf(" ");
        String[] data = line.substring(0, pos).split("/");
        String tag = data[0];
        if (lastTag.compareTo("003@") < 0 && tag.compareTo("003@") > 0) {
            //write the PPN at the proper position, if not present in record
            writeFields("003@ ƒ0" + ppn, writer);
        }
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("datafield");
        writer.writeAttribute("tag", tag);
        if (data.length > 1) {
            writer.writeAttribute("occurrence", data[1]);
        }

        // get Subfields
        String[] subfields = line.substring(pos + 1).split("ƒ");
        for (String sub : subfields) {
            if (sub.length() > 1) {
                writer.writeCharacters("\n\t\t\t");
                writer.writeStartElement("subfield");
                writer.writeAttribute("code", sub.substring(0, 1));
                writer.writeCharacters(sub.substring(1));
                writer.writeEndElement(); // </subfield>
            }
        }
        writer.writeCharacters("\n\t\t");
        writer.writeEndElement(); // </ datafield>
        lastTag = tag;
    }

    public static void main(String[] args) {
        Path fOut, fIn;
        if (args.length == 2) {
            fIn = Paths.get(args[0]);
            fOut = Paths.get(args[1]);
            PicaPlus2PicaXMLConverter converter = new PicaPlus2PicaXMLConverter();
            converter.processFile(fIn, fOut);
        } else {
            System.out.println("PicaPlusXML Creator");
            System.out.println("=====================");
            System.out.println("This tool parses an HTML directory listing for Pica+ files.");
            System.out.println("It opens these files, parses them for PND numbers and stores");
            System.out.println("the PND numbers with their count of occurence in a PND Beacon file.\n");
            System.out.println("It expects 2 parameters:");
            System.out.println("{1} absolute path to input file (Pica+, UTF-8 encoded)");
            System.out.println("{2} absolute path to output file (XML, UTF-8 encoded)");
            System.out.println("\nHave fun!");
        }
    }
}
