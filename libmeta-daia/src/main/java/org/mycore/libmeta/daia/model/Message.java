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
package org.mycore.libmeta.daia.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * Textual message of availability information. 
 * Must be qualified by an ISO-639 language code (en, fr, de, ...).
 * If the 'errno' attribute is set, it is an error message.
 *
 * @author Robert Stephan
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Message {

    /**
     * ISO-639 language code (en, fr, de, ...) of the messageIdentifier of this element
     *
     * &lt;xs:attribute name="lang" type="xs:language" use="required"&gt;
     * 
     */
    @XmlAttribute(name = "lang", required = true)
    protected String lang;

    /**
     * Error code. Use positive values for core errors and
     * negative values for transformation errors.
     * 
     *  &lt;xs:attribute name="errno" type="xs:integer" use="optional"&gt;
     */
    @XmlAttribute(name = "errno", required = false)
    protected Integer errno;

    @XmlValue
    protected String content;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
