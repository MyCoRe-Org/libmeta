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
package org.mycore.libmeta.alto.model.tags;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * There are following variation of tag types available:
 *   LayoutTag – criteria about arrangement or graphical appearance
 *   StructureTag – criteria about grouping or formation
 *   RoleTag – criteria about function or mission
 *   NamedEntityTag – criteria about assignment of terms to their relationship / meaning (NER)
 *   OtherTag – criteria about any other characteristic not listed above, 
 *              the TYPE attribute is intended to be used for classification within those.
 *
 * The xml data wrapper element XmlData is used to contain XML encoded metadata.
 * The content of an XmlData element can be in any namespace or in no namespace.
 * As permitted by the XML Schema Standard, the processContents attribute value for the
 * metadata in an XmlData is set to “lax”. Therefore, if the source schema and its location are
 * identified by means of an XML schemaLocation attribute, then an XML processor will validate
 * the elements for which it can find declarations. If a source schema is not identified, or cannot be
 * found at the specified schemaLocation, then an XML validator will check for well-formedness,
 * but otherwise skip over the elements appearing in the XmlData element.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Tag {

    @XmlElement(name = "XmlData", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    XmlData xmlData;

    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "ID")
    protected String ID;

    @XmlAttribute(name = "TYPE", required = false)
    protected String TYPE;

    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    @XmlAttribute(name = "DESCRIPTION", required = false)
    protected String DESCRIPTION;

    @XmlAttribute(name = "URI", required = false)
    @XmlSchemaType(name = "anyURI")
    protected String URI;

    public XmlData getXmlData() {
        return xmlData;
    }

    public void setXmlData(XmlData xml) {
        this.xmlData = xml;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String lABEL) {
        LABEL = lABEL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        DESCRIPTION = dESCRIPTION;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String uRI) {
        URI = uRI;
    }

}
