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
package org.mycore.libmeta.dcsimple.xml;

import org.mycore.libmeta.common.DefaultXMLProcessor;
import org.mycore.libmeta.dcsimple.model.DCElement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

/**
 * JAXB Marshaller allows only indentation up to 8th level and starts then on the first column again
 * bug report: https://java.net/jira/browse/JAXB-970
 * 
 * therefore we use the XSLT-Transformer for output
 */
public class DCSimpleXMLProcessor extends DefaultXMLProcessor<DCElement> {

    private static final DCSimpleXMLProcessor INSTANCE = new DCSimpleXMLProcessor();

    //private constructor to avoid client applications to use constructor
    private DCSimpleXMLProcessor() {
        super(DCElement.class);
    }

    public static DCSimpleXMLProcessor getInstance() {
        return INSTANCE;
    }

    @Override
    public JAXBContext createJAXBContext() throws JAXBException{
        return JAXBContext.newInstance("org.mycore.libmeta.dcsimple.model");
    }

}
