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
package org.mycore.libmeta.mycoreclass.model;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class Label {
	
	@XmlAttribute(name = "text")
	protected String text;
	
	@XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
	protected String xmlLang;

	@XmlAttribute(name = "description")
	protected String description;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getXmlLang() {
		return xmlLang;
	}

	public void setXmlLang(String xmlLang) {
		this.xmlLang = xmlLang;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	 public static Builder builder() {
	        return builder(new Label());
	    }

	    public static Builder builder(Label label) {
	        return new Builder(label);
	    }

	    public static class Builder extends BuilderBase<Label, Builder> {

	        protected Builder(Label label) {
	            super(label);
	        }
			
			public  Builder text(String text) {
				_target().setText(text);
				return _self();
			}
			
			public  Builder xmlLang(String xmlLang) {
				_target().setXmlLang(xmlLang);
				return _self();
			}
			
			public  Builder description(String description) {
				_target().setDescription(description);
				return _self();
			}
		}
}
