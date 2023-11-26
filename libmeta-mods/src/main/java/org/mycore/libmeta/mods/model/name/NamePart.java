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
package org.mycore.libmeta.mods.model.name;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAlternativeNameSubelement;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.NamePartType;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;
import org.mycore.libmeta.mods.model.subject.name.ISubjectNameSubelement;

import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Mods Name Subelement {@literal <namePart>}
 * 
 * {@code
 * <xs:complexType name="namePartDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguage">
 *				<xs:attribute name="type">
 *					<xs:simpleType>
 *						<xs:restriction base="xs:string">
 *							<xs:enumeration value="date"/>
 *							<xs:enumeration value="family"/>
 *							<xs:enumeration value="given"/>
 *							<xs:enumeration value="termsOfAddress"/>
 *						</xs:restriction>
 *					</xs:simpleType>
 *				</xs:attribute>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class NamePart extends StringPlusLanguage
    implements INameSubelement, IAlternativeNameSubelement, ISubjectNameSubelement {

    @XmlAttribute(name = "type", required = false)
    protected NamePartType type;

    public NamePartType getType() {
        return type;
    }

    public void setType(NamePartType type) {
        this.type = type;
    }

    public static Builder builder() {
        return builder(new NamePart());
    }

    public static Builder builder(NamePart toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<NamePart, Builder>
        implements IXsStringBuilder<NamePart, Builder>, ILanguageAttributeGroupBuilder<NamePart, Builder> {

        protected Builder(NamePart namePart) {
            super(namePart);
        }

        public Builder type(NamePartType type) {
            _target().setType(type);
            return _self();
        }
    }
}
