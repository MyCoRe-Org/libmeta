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

public interface IProcessingStepBuilder<T extends AbstractProcessingStep, B> {
    public T _target();

    public B _self();

    public default B processingCategory(ProcessingCategory processingCategory) {
        _target().setProcessingCategory(processingCategory);
        return _self();
    }

    public default B processingDateTime(String processingDateTime) {
        _target().setProcessingDateTime(processingDateTime);
        return _self();
    }

    public default B processingAgency(String processingAgency) {
        _target().setProcessingAgency(processingAgency);
        return _self();
    }

    public default B addProcessingStepDescription(String processingStepDescription) {
        _target().getProcessingStepDescription().add(processingStepDescription);
        return _self();
    }

    public default B processingStepSettings(String processingStepSettings) {
        _target().setProcessingStepSettings(processingStepSettings);
        return _self();
    }

    public default B processingSoftware(ProcessingSoftware processingSoftware) {
        _target().setProcessingSoftware(processingSoftware);
        return _self();
    }
}
