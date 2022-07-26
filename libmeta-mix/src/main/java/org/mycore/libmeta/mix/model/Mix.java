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
package org.mycore.libmeta.mix.model;

import org.mycore.libmeta.mix.model.basic_image_information.BasicImageInformation;
import org.mycore.libmeta.mix.model.image_assessment_metadata.ImageAssessmentMetadata;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This class implements a Mix record 
 * Mix = NISO metadata for Images in XML Schema 
 * Namespace maintained by Library of Congress
 * based upon NISO Standard Z39.87 - Data Dictionary - Technical Metadata for Digital Still Images
 * 
 * only a minimal subset is currently supported image width, image height and
 * sampling frequency
 * 
 * @see http://www.loc.gov/mix/v20
 * @see http://www.loc.gov/standards/mix/
 * @see http://www.niso.org/kst/reports/standards?step=2&gid=None&project_key=b897b0cf3e2ee526252d9f830207b3cc9f3b6c2c
 * 
 * @author Robert Stephan
 * 
 */

@XmlRootElement(name = "mix", namespace = "http://www.loc.gov/mix/v20")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "basicImageInformation", "imageAssessmentMetadata" })
public class Mix {

	@XmlElement(name = "BasicImageInformation", namespace = "http://www.loc.gov/mix/v20", required = true)
	protected BasicImageInformation basicImageInformation;

	@XmlElement(name = "ImageAssessmentMetadata", namespace = "http://www.loc.gov/mix/v20", required = true)
	protected ImageAssessmentMetadata imageAssessmentMetadata;

	public Mix(){
		
	}
	
	public Mix(BasicImageInformation basicImageInformation, ImageAssessmentMetadata imageAssessmentMetadata) {
		this.basicImageInformation = basicImageInformation;
		this.imageAssessmentMetadata = imageAssessmentMetadata;
	}
	
	

	public BasicImageInformation getBasicImageInformation() {
		return basicImageInformation;
	}

	public void setBasicImageInformation(BasicImageInformation basicImageInformation) {
		this.basicImageInformation = basicImageInformation;
	}

	public ImageAssessmentMetadata getImageAssessmentMetadata() {
		return imageAssessmentMetadata;
	}

	public void setImageAssessmentMetadata(ImageAssessmentMetadata imageAssessmentMetadata) {
		this.imageAssessmentMetadata = imageAssessmentMetadata;
	}
}
