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
package org.mycore.libmeta.mix.model.basic_image_information;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "basicImageCharacteristics" })
public class BasicImageInformation {

    // sequence

    // NDD id="7"
    @XmlElement(name = "BasicImageCharacteristics", namespace = "http://www.loc.gov/mix/v20", required = false)
    protected BasicImageCharacteristics basicImageCharacteristics;

    public BasicImageInformation() {

    }

    public BasicImageInformation(BasicImageCharacteristics basicImageCharacteristics) {
        this.basicImageCharacteristics = basicImageCharacteristics;
    }

    public BasicImageCharacteristics getBasicImageCharacteristics() {
        return basicImageCharacteristics;
    }

    public void setBasicImageCharacteristics(BasicImageCharacteristics basicImageCharacteristics) {
        this.basicImageCharacteristics = basicImageCharacteristics;
    }
}
