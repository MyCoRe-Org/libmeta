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
import java.nio.charset.StandardCharsets;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

import org.mycore.libmeta.common.DefaultXMLProcessor;
import org.mycore.libmeta.common.LibmetaProcessorException;
import org.mycore.libmeta.pica.model.PicaRecord;
import org.mycore.libmeta.pica.xml.FilterPicaXMLFromSRUReaderDelegate;
import org.mycore.libmeta.pica.xml.FilterPicaXMLFromSRUReaderDelegate.RootElement;

public class PicaXMLProcessor extends DefaultXMLProcessor<PicaRecord> {

    private static final PicaXMLProcessor INSTANCE = new PicaXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private PicaXMLProcessor() {
        super(PicaRecord.class);
    }

    public static PicaXMLProcessor getInstance() {
        return INSTANCE;
    }

    public PicaRecord unmarshalFromSRU(URL url) throws LibmetaProcessorException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = new FilterPicaXMLFromSRUReaderDelegate(
                inputFactory.createXMLEventReader(br), RootElement.RECORD);
            return (PicaRecord) createJAXBContext().createUnmarshaller().unmarshal(xmlEventReader);
        } catch (Exception e) {
            throw new LibmetaProcessorException(e);
        }

    }

}
