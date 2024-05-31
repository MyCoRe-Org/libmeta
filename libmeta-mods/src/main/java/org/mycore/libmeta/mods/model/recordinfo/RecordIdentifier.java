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
package org.mycore.libmeta.mods.model.recordinfo;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xs:complexType name="recordIdentifierDefinition">
 *       <xs:simpleContent>
 *            <xs:extension base="stringPlusLanguage">
 *                <xs:attribute name="source" type="xs:string"/>
 *            </xs:extension>
 *        </xs:simpleContent>
 *    </xs:complexType>
 * }
 *
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class RecordIdentifier extends StringPlusLanguage implements IRecordInfoSubelement {

    @XmlAttribute(name = "source", required = false)
    protected String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static Builder builder() {
        return builder(new RecordIdentifier());
    }

    public static Builder builder(RecordIdentifier ri) {
        return new Builder(ri);
    }

    public static class Builder extends BuilderBase<RecordIdentifier, Builder> implements
        IXsStringBuilder<RecordIdentifier, Builder>, ILanguageAttributeGroupBuilder<RecordIdentifier, Builder> {
        protected Builder(RecordIdentifier r) {
            super(r);
        }

        public Builder source(String source) {
            _target().setSource(source);
            return _self();
        }
    }

}
