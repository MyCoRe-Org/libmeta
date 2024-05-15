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
package org.mycore.libmeta.alto__4.model.description;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A processing step.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "processingCategory", "processingDateTime", "processingAgency", "processingStepDescription",
    "processingStepSettings", "processingSoftware" })
public class ProcessingStep {

    /**
     * Classification of the category of operation, how the file was created, 
     * including generation, modification, preprocessing, postprocessing or any other steps.
     */
    @XmlElement(name = "processingCategory", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected ProcessingCategory processingCategory;

    /**
     * Date or DateTime the image was processed.
     */
    // @TODO support Java DateTime objects
    //       (supported schema types: {@code <xsd:union memberTypes="xsd:date xsd:dateTime xsd:gYear xsd:gYearMonth"/>})

    @XmlElement(name = "processingDateTime", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected String processingDateTime;

    /**
     * Identifies the organizationlevel producer(s) of the processed image.
     */
    @XmlElement(name = "processingAgency", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected String processingAgency;

    /**
     * An ordinal listing of the image processing steps performed. For example,
     * "image despeckling".
     */
    @XmlElement(name = "processingStepDescription", namespace = "http://www.loc.gov/standards/alto/ns-v4#",
        required = false)
    protected List<String> processingStepDescription = new Vector<>();

    /**
     * A description of any setting of the processing application. For example, for
     * a multi-engine OCR application this might include the engines which were
     * used. Ideally, this description should be adequate so that someone else using
     * the same application can produce identical results.
     */
    @XmlElement(name = "processingStepSettings", namespace = "http://www.loc.gov/standards/alto/ns-v4#",
        required = false)
    protected String processingStepSettings;

    /**
     * Information about a software application. Where applicable, the preferred
     * method for determining this information is by selecting Help -- About.
     */
    @XmlElement(name = "processingSoftware", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected ProcessingSoftware processingSoftware;

    public ProcessingCategory getProcessingCategory() {
        return processingCategory;
    }

    public void setProcessingCategory(ProcessingCategory processingCategory) {
        this.processingCategory = processingCategory;
    }

    public String getProcessingDateTime() {
        return processingDateTime;
    }

    public void setProcessingDateTime(String processingDateTime) {
        this.processingDateTime = processingDateTime;
    }

    public String getProcessingAgency() {
        return processingAgency;
    }

    public void setProcessingAgency(String processingAgency) {
        this.processingAgency = processingAgency;
    }

    public String getProcessingStepSettings() {
        return processingStepSettings;
    }

    public void setProcessingStepSettings(String processingStepSettings) {
        this.processingStepSettings = processingStepSettings;
    }

    public ProcessingSoftware getProcessingSoftware() {
        return processingSoftware;
    }

    public void setProcessingSoftware(ProcessingSoftware processingSoftware) {
        this.processingSoftware = processingSoftware;
    }

    public List<String> getProcessingStepDescription() {
        return processingStepDescription;
    }

    public static Builder builder() {
        return builder(new ProcessingStep());
    }

    public static Builder builder(ProcessingStep processingStep) {
        return new Builder(processingStep);
    }

    public static class Builder extends BuilderBase<ProcessingStep, Builder> {

        protected Builder(ProcessingStep processingStep) {
            super(processingStep);
        }
        
        public Builder processingCategory(ProcessingCategory processingCategory) {
            _target().setProcessingCategory(processingCategory);
            return _self();
        }

        public Builder processingDateTime(String processingDateTime) {
            _target().setProcessingDateTime(processingDateTime);
            return _self();
        }

        public Builder processingAgency(String processingAgency) {
            _target().setProcessingAgency(processingAgency);
            return _self();
        }

        public Builder addProcessingStepDescription(String processingStepDescription) {
            _target().getProcessingStepDescription().add(processingStepDescription);
            return _self();
        }

        public Builder processingStepSettings(String processingStepSettings) {
            _target().setProcessingStepSettings(processingStepSettings);
            return _self();
        }

        public Builder processingSoftware(ProcessingSoftware processingSoftware) {
            _target().setProcessingSoftware(processingSoftware);
            return _self();
        }
    }

}
