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
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguage;

import jakarta.xml.bind.annotation.XmlAttribute;

/**
 *  Top Level Element {@literal <identifier>}
 *  
 *  {@code
 *  <xs:complexType name="identifierDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguage">
 *				<xs:attribute name="displayLabel" type="xs:string"/>
 *				<xs:attribute name="type" type="xs:string"/>
 *				<xs:attribute name="typeURI" type="xs:anyURI"/>
 *				<xs:attribute name="invalid" type="yes"/>
 *				<xs:attribute name="altRepGroup" type="xs:string"/>
 *			</xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Identifier extends StringPlusLanguage implements ITopLevelElement, IIDAttributeGroup {

    @XmlAttribute(name = "ID")
    protected String ID;

    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "type")
    protected String type;

    @XmlAttribute(name = "typeURI")
    protected String typeURI;

    @XmlAttribute(name = "invalid")
    protected Yes invalid;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getIDREF() {
        return IDREF;
    }

    public void setIDREF(String iDREF) {
        IDREF = iDREF;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeURI() {
        return typeURI;
    }

    public void setTypeURI(String typeURI) {
        this.typeURI = typeURI;
    }

    public Yes getInvalid() {
        return invalid;
    }

    public void setInvalid(Yes invalid) {
        this.invalid = invalid;
    }

    public String getAltRepGroup() {
        return altRepGroup;
    }

    public void setAltRepGroup(String altRepGroup) {
        this.altRepGroup = altRepGroup;
    }

    public static Builder builderForIdentifier() {
        return builder(new Identifier());
    }

    public static Builder builder(Identifier toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<Identifier, Builder>
        implements IXsStringBuilder<Identifier, Builder>, IIDAttributeGroupBuilder<Identifier, Builder>,
        ILanguageAttributeGroupBuilder<Identifier, Builder> {
        protected Builder(Identifier spl) {
            super(spl);
        }

        public Builder displayLabel(String displayLabel) {
            _target().setDisplayLabel(displayLabel);
            return _self();
        }

        public Builder type(String type) {
            _target().setType(type);
            return _self();
        }

        public Builder typeURI(String typeURI) {
            _target().setTypeURI(typeURI);
            return _self();
        }

        public Builder invalid(Yes invalid) {
            _target().setInvalid(invalid);
            return _self();
        }

        public Builder altRepGroup(String altRepGroup) {
            _target().setAltRepGroup(altRepGroup);
            return _self();
        }
    }

}
