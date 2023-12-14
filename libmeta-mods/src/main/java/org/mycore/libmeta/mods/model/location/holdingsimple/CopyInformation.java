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
package org.mycore.libmeta.mods.model.location.holdingsimple;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.ElectronicLocator;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.EnumerationAndChronology;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.Form;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.ItemIdentifier;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.Note;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.ShelfLocator;
import org.mycore.libmeta.mods.model.location.holdingsimple.copyinformation.SubLocation;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * MODS Location Subelement CopyInformation
 * 
 * {@code
 * <xs:complexType name="copyInformationDefinition">
 *   <xs:sequence>
 *     <xs:element ref="form" minOccurs="0"/>
 *     <xs:element ref="subLocation" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element ref="shelfLocator" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element ref="electronicLocator" minOccurs="0" maxOccurs="unbounded"/>
 *     <xs:element name="note" minOccurs="0" maxOccurs="unbounded">
 *       <xs:complexType>
 *         <!-- .... -->
 *       </xs:complexType>
 *     </xs:element>
 *     <xs:element ref="enumerationAndChronology" minOccurs="0" maxOccurs="unbounded"/>
 *     <!-- ******************the following element <itemIdentifer> added in 3.6   -->
 *     <xs:element ref="itemIdentifier" minOccurs="0" maxOccurs="unbounded"/>
 *       </xs:sequence>
 *   </xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 * 
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "form", "subLocation", "shelfLocator", "electronicLocator", "note", "enumerationAndChronology",
    "itemIdentifier" })
public class CopyInformation {
    // <xs:sequence>

    /**
     * {@code
     * <xs:element ref="form" minOccurs="0"/>
     * }
     */
    @XmlElement(name = "form", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected Form form;

    /**
     * {@code
     * <xs:element ref="subLocation" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "subLocation", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<SubLocation> subLocation = new Vector<>();

    /**
     * {@code
     * <xs:element ref="shelfLocator" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "shelfLocator", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<ShelfLocator> shelfLocator = new Vector<>();

    /**
     * {@code
     * <xs:element ref="electronicLocator" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "electronicLocator", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<ElectronicLocator> electronicLocator = new Vector<>();

    /**
     * {@code
     * <xs:element name="note" minOccurs="0" maxOccurs="unbounded">
     * }
     */
    @XmlElement(name = "note", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<Note> note = new Vector<>();

    /**
     * {@code
     * <xs:element ref="enumerationAndChronology" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "enumerationAndChronology", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<EnumerationAndChronology> enumerationAndChronology = new Vector<>();

    /**
     * {@code
     * <xs:element ref="itemIdentifier" minOccurs="0" maxOccurs="unbounded"/>
     * }
     */
    @XmlElement(name = "itemIdentifier", namespace = "http://www.loc.gov/mods/v3", required = false)
    protected List<ItemIdentifier> itemIdentifier = new Vector<>();

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<SubLocation> getSubLocation() {
        return subLocation;
    }

    public List<ShelfLocator> getShelfLocator() {
        return shelfLocator;
    }

    public List<ElectronicLocator> getElectronicLocator() {
        return electronicLocator;
    }

    public List<Note> getNote() {
        return note;
    }

    public List<EnumerationAndChronology> getEnumerationAndChronology() {
        return enumerationAndChronology;
    }

    public List<ItemIdentifier> getItemIdentifier() {
        return itemIdentifier;
    }

    public static Builder builderForCopyInformation() {
        return builder(new CopyInformation());
    }

    public static Builder builder(CopyInformation ci) {
        return new Builder(ci);
    }

    public static class Builder extends BuilderBase<CopyInformation, Builder> {

        protected Builder(CopyInformation ci) {
            super(ci);
        }

        public Builder form(Form form) {
            _target().setForm(form);
            return _self();
        }

        public Builder addSubLocation(SubLocation subLocation) {
            _target().getSubLocation().add(subLocation);
            return _self();
        }

        public Builder shelfLocator(ShelfLocator shelfLocator) {
            _target().getShelfLocator().add(shelfLocator);
            return _self();
        }

        public Builder addElectronicLocator(ElectronicLocator electronicLocator) {
            _target().getElectronicLocator().add(electronicLocator);
            return _self();
        }

        public Builder addNote(Note note) {
            _target().getNote().add(note);
            return _self();
        }

        public Builder addEnumerationAndChronology(EnumerationAndChronology enumerationAndChronology) {
            _target().getEnumerationAndChronology().add(enumerationAndChronology);
            return _self();
        }

        public Builder addItemIdentifier(ItemIdentifier itemIdentifier) {
            _target().getItemIdentifier().add(itemIdentifier);
            return _self();
        }
    }
}
