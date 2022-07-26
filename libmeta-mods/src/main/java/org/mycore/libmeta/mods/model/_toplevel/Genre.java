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
package org.mycore.libmeta.mods.model._toplevel;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Top Level Element <genre>
 * 
 *  <xs:complexType name="genreDefinition"> 
 *    <xs:simpleContent>
 *      <xs:extension base="stringPlusLanguagePlusAuthority">
 *        <xs:attribute name="type" type="xs:string"/>
 *        <xs:attribute name="displayLabel" type="xs:string"/>
 *        <xs:attribute name="altRepGroup" type="xs:string"/>
 *        <xs:attribute name="usage" fixed="primary"/>
 *      </xs:extension>
 *   </xs:simpleContent>
 * </xs:complexType>
 *
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Genre extends StringPlusLanguagePlusAuthority implements ITopLevelElement {

    @XmlAttribute(name = "type")
    protected String type;

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGoup")
    protected String altRepGroup;

    @XmlAttribute(name = "usage")
    protected Usage usage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getAltRepGroup() {
        return altRepGroup;
    }

    public void setAltRepGroup(String altRepGroup) {
        this.altRepGroup = altRepGroup;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public static Builder builderForGenre() {
        return builder(new Genre());
    }

    public static Builder builder(Genre genre) {
        return new Builder(genre);
    }

    public static class Builder extends BuilderBase<Genre, Builder> implements IXsStringBuilder<Genre, Builder>,  ILanguageAttributeGroupBuilder<Genre, Builder>, IAuthorityAttributeGroupBuilder<Genre, Builder> {
        protected Builder(Genre genre) {
            super(genre);
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder altRepGroup(String altRepGroup) {
            _target().setAltRepGroup(altRepGroup);
            return _self();
        }

        public Builder usage(Usage usage) {
            _target().setUsage(usage);
            return _self();
        }
    }
}
