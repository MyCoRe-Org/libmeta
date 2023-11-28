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
package org.mycore.libmeta.daia__1_0.model;

import java.net.URI;
import java.net.URL;
import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;

/**
 * An identified information object. This record corresponds to the class Item
   in FRBR. That means multiple copies are encoded with multiple occurrences of this element.
   
 * @author Robert Stephan
 *
 */

@JsonbPropertyOrder({ "about", "available", "chronology", "department", "href", "id", "label", "part", "storage",
    "unavailable" })
public class Item {

    public enum Part {
        broader, narrower;
    }

    private String about;

    @JsonbProperty("available")
    private List<Available> availables;

    private Chronology chronology;

    private Department department;

    private URL href;

    private URI id;

    private String label;

    private Part part;

    private Storage storage;

    @JsonbProperty("unavailable")
    private List<Unavailable> unavailables;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Available> getAvailables() {
        return availables;
    }

    public void setAvailables(List<Available> availables) {
        this.availables = availables;
    }

    public Chronology getChronology() {
        return chronology;
    }

    public void setChronology(Chronology chronology) {
        this.chronology = chronology;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public URL getHref() {
        return href;
    }

    public void setHref(URL href) {
        this.href = href;
    }

    public URI getId() {
        return id;
    }

    public void setId(URI id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<Unavailable> getUnavailables() {
        return unavailables;
    }

    public void setUnavailables(List<Unavailable> unavailables) {
        this.unavailables = unavailables;
    }

}
