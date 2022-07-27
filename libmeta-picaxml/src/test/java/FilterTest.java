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

import org.mycore.libmeta.picaxml.FilterPicaXMLFromSRUReaderDelegate;
import org.mycore.libmeta.picaxml.PicaXMLProcessor;
import org.mycore.libmeta.picaxml.model.PicaObject;

public class FilterTest {
    //public static String SRU_URL = "http://sru.gbv.de/gvk?version=1.1&operation=searchRetrieve&maximumRecords=1&recordSchema=picaxml&query=pica.ppn%3D340126604";
    public static String SRU_URL = "http://sru.gbv.de/opac-de-28?version=1.1&operation=searchRetrieve&maximumRecords=10&recordSchema=picaxml&query=pica.url%3Dpurl.uni-rostock.de*&startRecord=31";

    public static void main(String[] args) throws Exception {
        Path outFile = Files.createTempFile("test_filter_pica", ".xml");
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        URL url = new URL(SRU_URL);
        URLConnection urlConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(inputFactory.createXMLEventReader(br));

        XMLEventWriter xmlEventWriter = outputFactory.createXMLEventWriter(System.out);

        while (xmlEventReader.hasNext()) {
            xmlEventWriter.add(xmlEventReader.nextEvent());
        }
        xmlEventReader.close();
        xmlEventWriter.close();

        try {
            PicaXMLProcessor xmlProcessor = PicaXMLProcessor.getInstance();
            PicaObject pica2 = xmlProcessor.unmarshalFromSRU(new URL(SRU_URL));
            xmlProcessor.marshal(pica2, outFile);
            System.out.println();
            System.out.println("The result can be found here:" + outFile.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
