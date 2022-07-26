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

//does not work under Java 6

@XmlSchema(namespace = "http://www.loc.gov/mix/v20",  
        xmlns = {   
            @XmlNs(namespaceURI = "http://www.loc.gov/mix/v20", prefix = "mix"),  
            @XmlNs(namespaceURI = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")
        },
        location = "http://www.loc.gov/mix/v20 http://www.loc.gov/standards/mix/mix20/mix20.xsd",
        elementFormDefault = jakarta.xml.bind.annotation.XmlNsForm.QUALIFIED)  
package org.mycore.libmeta.mix.model;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlSchema;
