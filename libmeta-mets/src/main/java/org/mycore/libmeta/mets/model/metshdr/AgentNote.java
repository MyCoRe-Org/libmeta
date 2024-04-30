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
package org.mycore.libmeta.mets.model.metshdr;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * The &lt;note&gt; element can be used to record any additional information regarding the agent's activities with respect to the METS document.
											
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class AgentNote {

    @XmlValue
    protected String content;

    /**
     * {@code
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String getOtherAttribute(QName qname) {
        return otherAttributes.get(qname);
    }

    public static Builder builder() {
        return builder(new AgentNote());
    }

    public static Builder builder(AgentNote note) {
        return new Builder(note);
    }

    public static class Builder extends BuilderBase<AgentNote, Builder> {

        protected Builder(AgentNote id) {
            super(id);
        }

        public Builder content(String content) {
            _target().setContent(content);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
