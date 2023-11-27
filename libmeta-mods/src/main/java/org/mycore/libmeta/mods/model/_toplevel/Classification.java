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
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.ILanguageAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IAuthorityAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.ILanguageAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._misc.builder.IXsStringBuilder;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * Top Level Element &lt;classification&gt;
 * 
 * {@code
 * <xs:complexType name="classificationDefinition">
 *        <xs:simpleContent>
 *           <xs:extension base="stringPlusLanguagePlusAuthority">
 *                <xs:attribute name="edition" type="xs:string"/>
 *               <xs:attribute name="displayLabel" type="xs:string"/>
 *                <xs:attribute name="altRepGroup" type="xs:string"/>
 *                <xs:attribute name="usage" fixed="primary"/>
 *                <xs:attribute name="generator" type="xs:string"/>
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
public class Classification extends StringPlusLanguagePlusAuthority implements ITopLevelElement, IIDAttributeGroup, ILanguageAttributeGroup, IAuthorityAttributeGroup {
    
    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    @XmlAttribute(name = "edition")
    protected String edition;

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGoup")
    protected String altRepGroup;

    @XmlAttribute(name = "usage")
    protected Usage usage;

    /**
     * {@code
     * <xs:attribute name="generator" type="xs:string"/>
     * }
     * 
     * The following attribute, generator, is new in version 3.5
     * {@literal @generator} may be used to indicate that the classification is automatically generated,
     * and its value may indicate the nature of the generation, for example "lcc to ddc" 
     */
    @XmlAttribute(name = "generator")
    protected String generator;
    
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
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

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public static Builder builderForClassification() {
        return builder(new Classification());
    }

    public static Builder builder(Classification div) {
        return new Builder(div);
    }

    public static class Builder extends BuilderBase<Classification, Builder> implements IXsStringBuilder<Classification, Builder>,  IIDAttributeGroupBuilder<Classification, Builder>, ILanguageAttributeGroupBuilder<Classification, Builder>, IAuthorityAttributeGroupBuilder<Classification, Builder> {
        protected Builder(Classification spl) {
            super(spl);
        }

        public Builder edition(String edition) {
            _target().setEdition(edition);
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

        public Builder generator(String generator) {
            _target().setGenerator(generator);
            return _self();
        }
    }
}
