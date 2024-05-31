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
package org.mycore.libmeta.alto.model.layout.block.textline;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * Any alternative for the word.
 * Alternative can outline a variant of writing by new typing / spelling rules, typically manually done or by dictionary replacements.
 * The above sample is an old composed character "Æ" of ancient time, which is replaced now by "Ä".
 * As variant are meant alternatives of the real printed content which are options outlined by the text recognition process.
 * Similar sample: "Straße" vs. "Strasse". Such alternatives are not coming from text recognition.
 *  
 * @author Robert Stephan
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
public class TextlineStringALTERNATIVE {

    @XmlValue
    protected String value;

    /** Identifies the purpose of the alternative. */
    @XmlAttribute(name = "PURPOSE", required = false)
    @XmlSchemaType(name = "string")
    protected String PURPOSE;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPURPOSE() {
        return PURPOSE;
    }

    public void setPURPOSE(String pURPOSE) {
        PURPOSE = pURPOSE;
    }

    public static Builder builder() {
        return builder(new TextlineStringALTERNATIVE());
    }

    public static Builder builder(TextlineStringALTERNATIVE alternative) {
        return new Builder(alternative);
    }

    public static class Builder extends BuilderBase<TextlineStringALTERNATIVE, Builder> {

        protected Builder(TextlineStringALTERNATIVE alternative) {
            super(alternative);
        }

        public Builder value(String value) {
            _target().setValue(value);
            return _self();
        }

        public Builder PURPOSE(String purpose) {
            _target().setPURPOSE(purpose);
            return _self();
        }
    }
}
