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
package org.mycore.libmeta.alto.model.description;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Describes general settings of the alto file like measurement units and
 * metadata
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "measurementUnit", "sourceImageInformation", "ocrProcessing" })
public class Description {

    @XmlElement(name = "MeasurementUnit", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = true)
    protected MeasurementUnit measurementUnit;

    @XmlElement(name = "sourceImageInformation",
        namespace = "http://www.loc.gov/standards/alto/ns-v2#",
        required = false)
    protected SourceImageInformation sourceImageInformation;

    @XmlElement(name = "OCRProcessing", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<OCRProcessing> ocrProcessing = new Vector<OCRProcessing>();

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public SourceImageInformation getSourceImageInformation() {
        return sourceImageInformation;
    }

    public void setSourceImageInformation(SourceImageInformation sourceImageInformation) {
        this.sourceImageInformation = sourceImageInformation;
    }

    public List<OCRProcessing> getOcrProcessing() {
        return ocrProcessing;
    }

    public void setOcrProcessing(List<OCRProcessing> ocrProcessing) {
        this.ocrProcessing = ocrProcessing;
    }

    public static Builder builder() {
        return builder(new Description());
    }

    public static Builder builder(Description description) {
        return new Builder(description);
    }

    public static class Builder extends BuilderBase<Description, Builder> {

        protected Builder(Description description) {
            super(description);
        }

        public Builder MeasurementUnit(MeasurementUnit measurementUnit) {
        	_target().setMeasurementUnit(measurementUnit);
            return _self();
        }

        public Builder sourceImageInformation(SourceImageInformation sourceImageInformation) {
        	_target().setSourceImageInformation(sourceImageInformation);
            return _self();
        }

        public Builder addOCRProcessing(OCRProcessing ocrProcessing) {
        	_target().getOcrProcessing().add(ocrProcessing);
            return _self();
        }
    }

}
