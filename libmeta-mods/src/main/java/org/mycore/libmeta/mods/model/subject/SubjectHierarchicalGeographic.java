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
package org.mycore.libmeta.mods.model.subject;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAuthorityAttributeGroup;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Area;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.City;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.CitySection;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Continent;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Country;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.County;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.ExtraTerrestrialArea;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.IHierarchicalGeographicSubelement;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Island;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Province;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Region;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.State;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Territory;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * MODS SubjectSubelement <hierarchicalGeographic>
 * 
 * <xs:complexType name="hierarchicalGeographicDefinition">
 *		<xs:choice maxOccurs="unbounded">
 *			<xs:element ref="extraTerrestrialArea"/>
 *			<xs:element ref="continent"/>
 *			<xs:element ref="country"/>
 *			<xs:element ref="province"/>
 *			<!-- province is deprecated in version 3.6.  Use <state> instead.  -->
 *			<xs:element ref="region"/>
 *			<xs:element ref="state"/>
 *			<!-- <state> definition broadened in 3.6.  Use <state> for all first order political divisions, e.g. province. -->
 *			<xs:element ref="territory"/>
 *			<xs:element ref="county"/>
 *			<xs:element ref="city"/>
 *			<xs:element ref="citySection"/>
 *			<xs:element ref="island"/>
 *			<xs:element ref="area"/>
 *		</xs:choice>
 *		<xs:attributeGroup ref="authorityAttributeGroup"/>
 *	</xs:complexType>
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SubjectHierarchicalGeographic implements ISubjectSubelement, IAuthorityAttributeGroup {
    @XmlElements({
            @XmlElement(name = "extraterrestrialArea", namespace = "http://www.loc.gov/mods/v3", type = ExtraTerrestrialArea.class),
            @XmlElement(name = "continent", namespace = "http://www.loc.gov/mods/v3", type = Continent.class),
            @XmlElement(name = "country", namespace = "http://www.loc.gov/mods/v3", type = Country.class),
            @XmlElement(name = "province", namespace = "http://www.loc.gov/mods/v3", type = Province.class),
            @XmlElement(name = "region", namespace = "http://www.loc.gov/mods/v3", type = Region.class),
            @XmlElement(name = "state", namespace = "http://www.loc.gov/mods/v3", type = State.class),
            @XmlElement(name = "territory", namespace = "http://www.loc.gov/mods/v3", type = Territory.class),
            @XmlElement(name = "county", namespace = "http://www.loc.gov/mods/v3", type = County.class),
            @XmlElement(name = "city", namespace = "http://www.loc.gov/mods/v3", type = City.class),
            @XmlElement(name = "citySection", namespace = "http://www.loc.gov/mods/v3", type = CitySection.class),
            @XmlElement(name = "island", namespace = "http://www.loc.gov/mods/v3", type = Island.class),
            @XmlElement(name = "area", namespace = "http://www.loc.gov/mods/v3", type = Area.class) })
    protected List<IHierarchicalGeographicSubelement> content = new Vector<>();

    // --- <xs:attributeGroup name="authorityAttributeGroup"> - begin
    /**
     * <xs:attribute name="authority" type="xs:string"/>
     */
    @XmlAttribute(name = "authority")
    protected String authority;

    /**
     * <xs:attribute name="authorityURI" type="xs:anyURI"/>
     */
    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    /**
     * <xs:attribute name="valueURI" type="xs:anyURI"/>
     */
    @XmlAttribute(name = "valueURI")
    protected String valueURI;
    // --- <xs:attributeGroup name="authorityAttributeGroup"> - end    

    public List<IHierarchicalGeographicSubelement> getContent() {
        return content;
    }

    public void setContent(List<IHierarchicalGeographicSubelement> content) {
        this.content = content;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityURI() {
        return authorityURI;
    }

    public void setAuthorityURI(String authorityURI) {
        this.authorityURI = authorityURI;
    }

    public String getValueURI() {
        return valueURI;
    }

    public void setValueURI(String valueURI) {
        this.valueURI = valueURI;
    }

    public static Builder builder() {
        return new Builder(new SubjectHierarchicalGeographic());
    }

    public static Builder builder(SubjectHierarchicalGeographic toc) {
        return new Builder(toc);
    }

    public static class Builder extends BuilderBase<SubjectHierarchicalGeographic, Builder>{

        protected Builder(SubjectHierarchicalGeographic toc) {
            super(toc);
        }

        public Builder addContent(IHierarchicalGeographicSubelement content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder authority(String authority) {
            _target().setAuthority(authority);
            return _self();
        }

        public Builder authorityURI(String authorityURI) {
            _target().setAuthorityURI(authorityURI);
            return _self();
        }

        public Builder valueURI(String valueURI) {
            _target().setValueURI(valueURI);
            return _self();
        }
    }
}
