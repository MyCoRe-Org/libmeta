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
package org.mycore.libmeta.mix.model.image_assessment_metadata;

import org.mycore.libmeta.mix.model.util.Rational;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * NDD id="9.1"
 * 
 * @author Robert Stephan
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "samplingFrequencyPlane", "samplingFrequencyUnit", "xSamplingFrequency", "ySamplingFrequency" })
public class SpatialMetrics {

	// sequence

	// NDD id="9.1.1"
	@XmlElement(name = "samplingFrequencyPlane", namespace = "http://www.loc.gov/mix/v20", required = false)
	protected SamplingFrequencyPlane samplingFrequencyPlane;

	// NDD id="9.1.2"
	@XmlElement(name = "samplingFrequencyUnit", namespace = "http://www.loc.gov/mix/v20", required = false)
	protected SamplingFrequencyUnit samplingFrequencyUnit;

	// >NDD id="9.1.2.1
	@XmlElement(name = "xSamplingFrequency", namespace = "http://www.loc.gov/mix/v20", required = false)
	protected Rational xSamplingFrequency;

	// NDD id="9.1.2.2
	@XmlElement(name = "ySamplingFrequency", namespace = "http://www.loc.gov/mix/v20", required = false)
	protected Rational ySamplingFrequency;

	public SpatialMetrics(){
		
	}
	
	public SpatialMetrics(SamplingFrequencyPlane samplingFrequencyPlane, SamplingFrequencyUnit samplingFrequencyUnit, 
			Rational xSamplingFrequency, Rational ySamplingFrequency) {
		this.samplingFrequencyPlane = samplingFrequencyPlane;
		this.samplingFrequencyUnit = samplingFrequencyUnit;
		this.xSamplingFrequency = xSamplingFrequency;
		this.ySamplingFrequency = ySamplingFrequency;
	}

	public SamplingFrequencyPlane getSamplingFrequencyPlane() {
		return samplingFrequencyPlane;
	}

	public void setSamplingFrequencyPlane(SamplingFrequencyPlane samplingFrequencyPlane) {
		this.samplingFrequencyPlane = samplingFrequencyPlane;
	}

	public SamplingFrequencyUnit getSamplingFrequencyUnit() {
		return samplingFrequencyUnit;
	}

	public void setSamplingFrequencyUnit(SamplingFrequencyUnit samplingFrequencyUnit) {
		this.samplingFrequencyUnit = samplingFrequencyUnit;
	}

	public Rational getxSamplingFrequency() {
		return xSamplingFrequency;
	}

	public void setxSamplingFrequency(Rational xSamplingFrequency) {
		this.xSamplingFrequency = xSamplingFrequency;
	}

	public Rational getySamplingFrequency() {
		return ySamplingFrequency;
	}

	public void setySamplingFrequency(Rational ySamplingFrequency) {
		this.ySamplingFrequency = ySamplingFrequency;
	}

}
