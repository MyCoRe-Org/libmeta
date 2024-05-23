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

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Information on how the text was created, including preprocessing, OCR processing, and postprocessing steps.
 * Where possible, this draws from MIX's change history.
 * 
 * @author Robert Stephan
 * @version Alto 4.4
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
public class Processing extends AbstractProcessingStep {

    /**
     *  required if direct child of description !!!
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }
    
    public static Builder builder() {
        return builder(new Processing());
    }

    public static Builder builder(Processing processing) {
        return new Builder(processing);
    }

    public static class Builder extends BuilderBase<Processing, Builder>
        implements IProcessingStepBuilder<Processing, Builder> {

        protected Builder(Processing ocrProcessing) {
            super(ocrProcessing);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }
    }
}
