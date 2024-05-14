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
package org.mycore.libmeta.pica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import org.mycore.libmeta.common.DefaultXMLProcessor;
import org.mycore.libmeta.pica.model.PicaCollection;
import org.mycore.libmeta.pica.xml.FilterPicaXMLFromSRUReaderDelegate;
import org.mycore.libmeta.pica.xml.FilterPicaXMLFromSRUReaderDelegate.RootElement;

public class PicaCollectionXMLProcessor extends DefaultXMLProcessor<PicaCollection> {

    private static final PicaCollectionXMLProcessor INSTANCE = new PicaCollectionXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private PicaCollectionXMLProcessor() {
        super(PicaCollection.class);
    }

    public static PicaCollectionXMLProcessor getInstance() {
        return INSTANCE;
    }

    public PicaCollection unmarshalFromSRU(URL url) throws Exception {
        URLConnection urlConnection = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(
            inputFactory.createXMLEventReader(br), RootElement.COLLECTION);

        return (PicaCollection) createJAXBContext().createUnmarshaller().unmarshal(xmlEventReader);
    }

}
