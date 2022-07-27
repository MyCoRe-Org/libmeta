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
package org.mycore.libmeta.alto.model.tags;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.w3c.dom.Node;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlMixed;



@XmlAccessorType(XmlAccessType.NONE)
public class XmlData {
   
    @SuppressWarnings("rawtypes")
	@XmlAnyElement(lax = true)
    @XmlMixed
    private List content = new Vector();
    
     @SuppressWarnings("rawtypes")
	public List getContent() {
        return content;
    }

    public void setContent(List<Node> nodes) {
        this.content = nodes;
    }

    
	public static Builder builder() {
		return builder(new XmlData());
	}
	
	public static Builder builder(XmlData xml) {
		return new Builder(xml);
	}
	
	public static class Builder extends BuilderBase<XmlData, Builder> {

	    protected Builder(XmlData xml) {
			super(xml);
		}
	}
}