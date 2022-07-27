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
package org.mycore.libmeta.mods.model._misc.types;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * generic XMLSchema type xs:positiveInteger
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public class XsPositiveInteger{
    @XmlValue
    protected Integer content;

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }
    
	 public static class Builder<T extends XsPositiveInteger> extends BuilderBase<T, Builder<T>> {

	        protected Builder(T object) {
	            super(object);
	        }

	        public Builder<T> content(Integer content) {
	            _target().setContent(content);
	            return _self();
	        }
	    }
}
