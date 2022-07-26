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
@XmlType(propOrder = { "imageWidth", "imageHeight" })
public class BasicImageCharacteristics {
    
    //sequence
	
	// NDD id="7.1.1"
    @XmlElement(name = "imageWidth", namespace = "http://www.loc.gov/mix/v20", required = false)    
    protected Integer imageWidth;
    
    // NDD id="7.1.2"
    @XmlElement(name = "imageHeight", namespace = "http://www.loc.gov/mix/v20", required = false)    
    protected Integer imageHeight;
    
    public BasicImageCharacteristics(){
    	
    }
    
    public BasicImageCharacteristics(Integer imageWidth, Integer imageHeight){
    	this.imageWidth = imageWidth;
    	this.imageHeight = imageHeight;
    }

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
    
    }
