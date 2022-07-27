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
package org.mycore.libmeta.mods.model.location;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IXsAnyURIBuilder;
import org.mycore.libmeta.mods.model._misc.types.XsAnyURI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class Url extends XsAnyURI implements ILocationSublement{
    @XmlAttribute(name = "dateLastAccessed", required = false)
    protected String dateLastAccessed;
    
    @XmlAttribute(name = "displayLabel", required = false)
    protected String displayLabel;
    
    @XmlAttribute(name = "note", required = false)
    protected String note;
    
    @XmlAttribute(name = "access", required = false)
    protected UrlAccess access;
    
    @XmlAttribute(name = "usage", required = false)
    protected UrlUsage usage;
    
    public String getDateLastAccessed() {
        return dateLastAccessed;
    }

    public void setDateLastAccessed(String dateLastAccessed) {
        this.dateLastAccessed = dateLastAccessed;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UrlAccess getAccess() {
        return access;
    }

    public void setAccess(UrlAccess access) {
        this.access = access;
    }

    public UrlUsage getUsage() {
        return usage;
    }

    public void setUsage(UrlUsage usage) {
        this.usage = usage;
    }
    
    public static Builder builderForUrl() {
        return builder(new Url());
    }
    public static Builder builder(Url url) {
        return new Builder(url);
    }
    
    public static class Builder extends BuilderBase<Url, Builder> implements IXsAnyURIBuilder<Url, Builder>{
        protected Builder(Url url) {
            super(url);
        }
        
        public Builder dateLastAccessed(String d) {
            _target().setDateLastAccessed(d);
            return _self();
        }
        
        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }
        
        public Builder note(String note) {
            _target().setNote(note);
            return _self();
        }
        
        public Builder access(UrlAccess access) {
            _target().setAccess(access);
            return _self();
        }
        
        public Builder usage(UrlUsage usage) {
            _target().setUsage(usage);
            return _self();
        }
    }
}
