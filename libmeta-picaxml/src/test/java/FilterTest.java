
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
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

import org.junit.Test;
import org.mycore.libmeta.pica.PicaCollectionXMLProcessor;
import org.mycore.libmeta.pica.PicaXMLProcessor;
import org.mycore.libmeta.pica.model.PicaCollection;
import org.mycore.libmeta.pica.model.PicaRecord;
import org.mycore.libmeta.pica.xml.FilterPicaXMLFromSRUReaderDelegate;

public class FilterTest {
    public static String SRU_URL_RECORD
        = "https://sru.k10plus.de/gvk?version=1.1&operation=searchRetrieve&maximumRecords=1&recordSchema=picaxml&query=pica.ppn%3D340126604";
    public static String SRU_URL_COLLECTION
        = "https://sru.k10plus.de/opac-de-28?version=1.1&operation=searchRetrieve&maximumRecords=10&recordSchema=picaxml&query=pica.url%3Dpurl.uni-rostock.de*&startRecord=31";

    @Test
    public void testRecord() {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            URL url = new URL(SRU_URL_RECORD);
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(
                inputFactory.createXMLEventReader(br));

            XMLEventWriter xmlEventWriter = outputFactory.createXMLEventWriter(System.out);

            while (xmlEventReader.hasNext()) {
                xmlEventWriter.add(xmlEventReader.nextEvent());
            }
            xmlEventReader.close();
            xmlEventWriter.close();

            Path outFile = Files.createTempFile("test_filter_pica", ".xml");
            PicaXMLProcessor xmlProcessor = PicaXMLProcessor.getInstance();
            PicaRecord pica = xmlProcessor.unmarshalFromSRU(new URL(SRU_URL_RECORD));
            xmlProcessor.marshal(pica, outFile);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    @Test
    public void testCollection() {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            URL url = new URL(SRU_URL_COLLECTION);
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(
                inputFactory.createXMLEventReader(br));

            XMLEventWriter xmlEventWriter = outputFactory.createXMLEventWriter(System.out);

            while (xmlEventReader.hasNext()) {
                xmlEventWriter.add(xmlEventReader.nextEvent());
            }
            xmlEventReader.close();
            xmlEventWriter.close();

            Path outFile = Files.createTempFile("test_filter_pica", ".xml");
            PicaCollectionXMLProcessor xmlProcessor = PicaCollectionXMLProcessor.getInstance();
            PicaCollection picaColl = xmlProcessor.unmarshalFromSRU(new URL(SRU_URL_COLLECTION));
            xmlProcessor.marshal(picaColl, outFile);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }
}
