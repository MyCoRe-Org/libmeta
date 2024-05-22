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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Information on how the text was created, including preprocessing, OCR processing, and postprocessing steps.
 * Where possible, this draws from MIX's change history.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "preProcessingStep", "ocrProcessingStep", "postProcessingStep" })
public class Processing {

    /**
     *  required if direct child of description !!!
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    @XmlElement(name = "preProcessingStep", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected List<ProcessingStep> preProcessingStep = new Vector<ProcessingStep>();

    @XmlElement(name = "ocrProcessingStep", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = true)
    protected ProcessingStep ocrProcessingStep;

    @XmlElement(name = "postProcessingStep", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected List<ProcessingStep> postProcessingStep = new Vector<ProcessingStep>();

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public List<ProcessingStep> getPreProcessingStep() {
        return preProcessingStep;
    }

    public ProcessingStep getOcrProcessingStep() {
        return ocrProcessingStep;
    }

    public void setOcrProcessing(ProcessingStep ocrProcessingStep) {
        this.ocrProcessingStep = ocrProcessingStep;
    }

    public List<ProcessingStep> getPostProcessingStep() {
        return postProcessingStep;
    }

    public static Builder builder() {
        return builder(new Processing());
    }

    public static Builder builder(Processing ocrProcessing) {
        return new Builder(ocrProcessing);
    }

    public static class Builder extends BuilderBase<Processing, Builder> {

        protected Builder(Processing ocrProcessing) {
            super(ocrProcessing);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder addPreProcessingStep(ProcessingStep preProcessingStep) {
            _target().getPreProcessingStep().add(preProcessingStep);
            return _self();
        }

        public Builder ocrProcessingStep(ProcessingStep ocrProcessingStep) {
            _target().setOcrProcessing(ocrProcessingStep);
            return _self();
        }

        public Builder addPostProcessing(ProcessingStep postProcessingStep) {
            _target().getPostProcessingStep().add(postProcessingStep);
            return _self();
        }
    }
}
