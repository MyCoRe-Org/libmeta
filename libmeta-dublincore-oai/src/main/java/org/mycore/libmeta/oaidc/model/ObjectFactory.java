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
package org.mycore.libmeta.oaidc.model;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.mycore.libmeta.oaidc.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory extends org.mycore.libmeta.dcsimple.model.ObjectFactory {

    private final static QName _Dc_QNAME = new QName("http://www.openarchives.org/OAI/2.0/oai_dc/", "dc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.mycore.libmeta.oaidc.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OaiDc }
     * 
     */
    public OaiDc createOaiDcType() {
        return new OaiDc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OaiDc }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OaiDc }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.openarchives.org/OAI/2.0/oai_dc/", name = "dc")
    public JAXBElement<OaiDc> createDc(OaiDc value) {
        return new JAXBElement<OaiDc>(_Dc_QNAME, OaiDc.class, null, value);
    }

}
