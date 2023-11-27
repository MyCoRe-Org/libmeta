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
package org.mycore.libmeta.mods.model;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IIDAttributeGroup;
import org.mycore.libmeta.mods.model._misc.builder.IIDAttributeGroupBuilder;
import org.mycore.libmeta.mods.model._toplevel.Abstract;
import org.mycore.libmeta.mods.model._toplevel.AccessCondition;
import org.mycore.libmeta.mods.model._toplevel.Classification;
import org.mycore.libmeta.mods.model._toplevel.Extension;
import org.mycore.libmeta.mods.model._toplevel.Genre;
import org.mycore.libmeta.mods.model._toplevel.ITopLevelElement;
import org.mycore.libmeta.mods.model._toplevel.Identifier;
import org.mycore.libmeta.mods.model._toplevel.Language;
import org.mycore.libmeta.mods.model._toplevel.Location;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model._toplevel.Note;
import org.mycore.libmeta.mods.model._toplevel.OriginInfo;
import org.mycore.libmeta.mods.model._toplevel.Part;
import org.mycore.libmeta.mods.model._toplevel.PhysicalDescription;
import org.mycore.libmeta.mods.model._toplevel.RecordInfo;
import org.mycore.libmeta.mods.model._toplevel.RelatedItem;
import org.mycore.libmeta.mods.model._toplevel.Subject;
import org.mycore.libmeta.mods.model._toplevel.TableOfContents;
import org.mycore.libmeta.mods.model._toplevel.TargetAudience;
import org.mycore.libmeta.mods.model._toplevel.TitleInfo;
import org.mycore.libmeta.mods.model._toplevel.TypeOfResource;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * {@code
 *	<xs:choice maxOccurs="unbounded">
 * 			<xs:element ref="abstract"/>
 *			<xs:element ref="accessCondition"/>
 *			<xs:element ref="classification"/>
 *			<xs:element ref="extension"/>
 *			<xs:element ref="genre"/>
 *			<xs:element ref="identifier"/>
 *			<xs:element ref="language"/>
 *			<xs:element ref="location"/>
 *			<xs:element ref="name"/>
 *			<xs:element ref="note"/>
 *			<xs:element ref="originInfo"/>
 *			<xs:element ref="part"/>
 *			<xs:element ref="physicalDescription"/>
 *			<xs:element ref="recordInfo"/>
 *			<xs:element ref="relatedItem"/>
 *			<xs:element ref="subject"/>
 *			<xs:element ref="tableOfContents"/>
 *			<xs:element ref="targetAudience"/>
 *			<xs:element ref="titleInfo"/>
 *			<xs:element ref="typeOfResource"/>
 *	</xs:choice>
 *	}
 */
@XmlRootElement(name = "mods", namespace = "http://www.loc.gov/mods/v3")
@XmlAccessorType(XmlAccessType.NONE)
public class Mods implements IIDAttributeGroup {
    @XmlElements({
        @XmlElement(name = "abstract", namespace = "http://www.loc.gov/mods/v3", type = Abstract.class),
        @XmlElement(name = "accessCondition", namespace = "http://www.loc.gov/mods/v3", type = AccessCondition.class),
        @XmlElement(name = "classification", namespace = "http://www.loc.gov/mods/v3", type = Classification.class),
        @XmlElement(name = "extension", namespace = "http://www.loc.gov/mods/v3", type = Extension.class),
        @XmlElement(name = "genre", namespace = "http://www.loc.gov/mods/v3", type = Genre.class),
        @XmlElement(name = "identifier", namespace = "http://www.loc.gov/mods/v3", type = Identifier.class),
        @XmlElement(name = "language", namespace = "http://www.loc.gov/mods/v3", type = Language.class),
        @XmlElement(name = "location", namespace = "http://www.loc.gov/mods/v3", type = Location.class),
        @XmlElement(name = "name", namespace = "http://www.loc.gov/mods/v3", type = Name.class),
        @XmlElement(name = "note", namespace = "http://www.loc.gov/mods/v3", type = Note.class),
        @XmlElement(name = "originInfo", namespace = "http://www.loc.gov/mods/v3", type = OriginInfo.class),
        @XmlElement(name = "part", namespace = "http://www.loc.gov/mods/v3", type = Part.class),
        @XmlElement(name = "physicalDescription", namespace = "http://www.loc.gov/mods/v3", type = PhysicalDescription.class),
        @XmlElement(name = "recordInfo", namespace = "http://www.loc.gov/mods/v3", type = RecordInfo.class),
        @XmlElement(name = "relatedItem", namespace = "http://www.loc.gov/mods/v3", type = RelatedItem.class),
        @XmlElement(name = "subject", namespace = "http://www.loc.gov/mods/v3", type = Subject.class),
        @XmlElement(name = "tableOfContents", namespace = "http://www.loc.gov/mods/v3", type = TableOfContents.class),
        @XmlElement(name = "targetAudience", namespace = "http://www.loc.gov/mods/v3", type = TargetAudience.class),
        @XmlElement(name = "titleInfo", namespace = "http://www.loc.gov/mods/v3", type = TitleInfo.class),
        @XmlElement(name = "typeOfResource", namespace = "http://www.loc.gov/mods/v3", type = TypeOfResource.class) })

    protected List<ITopLevelElement> toplevel = new Vector<>();

    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    @XmlAttribute(name = "version")
    protected ModsVersion version;

    public List<ITopLevelElement> getContent() {
        return toplevel;
    }

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
    
    public ModsVersion getVersion() {
        return version;
    }

    public void setVersion(ModsVersion version) {
        this.version = version;
    }

    public static Builder builder() {
        return builder(new Mods());
    }

    public static Builder builder(Mods spl) {
        return new Builder(spl);
    }

    public static class Builder extends BuilderBase<Mods, Builder>
     implements IIDAttributeGroupBuilder<Mods, Builder>{

        protected Builder(Mods m) {
            super(m);
        }

        public Builder addContent(ITopLevelElement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder version(ModsVersion version) {
            _target().setVersion(version);
            return _self();
        }

    }

    public static void main(String... args) {
      //  Mods.builder()
      //      .addContent(Name.builder().addContent(NamePart.builder().content("Robert Stephan").build()).build());
    }
}
