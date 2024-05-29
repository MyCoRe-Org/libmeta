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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * NDD id="9"
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "spatialMetrics" })
public class ImageAssessmentMetadata {

    //sequence

    //NDD id="9.1"
    @XmlElement(name = "SpatialMetrics", namespace = "http://www.loc.gov/mix/v20", required = false)
    protected SpatialMetrics spatialMetrics;

    public ImageAssessmentMetadata() {

    }

    public ImageAssessmentMetadata(SpatialMetrics spatialMetrics) {
        this.spatialMetrics = spatialMetrics;
    }

    public SpatialMetrics getSpatialMetrics() {
        return spatialMetrics;
    }

    public void setSpatialMetrics(SpatialMetrics spatialMetrics) {
        this.spatialMetrics = spatialMetrics;
    }
}
