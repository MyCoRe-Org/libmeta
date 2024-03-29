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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.IAgentSubelement;
import org.mycore.libmeta.mods.model._misc.IAlternativeNameSubelement;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model.subject.name.ISubjectNameSubelement;

import jakarta.xml.bind.annotation.XmlElement;

/**
 * MODS Name Subelement {@literal <role>}
 * 
 * {@code
 * 	<xs:complexType name="roleDefinition">
 *		<xs:sequence maxOccurs="unbounded">
 *			<xs:element ref="roleTerm"/>
 *		</xs:sequence>
 *	</xs:complexType>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
public class Role implements INameSubelement, IAlternativeNameSubelement, ISubjectNameSubelement, IAgentSubelement {

    @XmlElement(name = "roleTerm", namespace = "http://www.loc.gov/mods/v3")
    protected List<RoleTerm> roleTerm = new Vector<>();

    public List<RoleTerm> getRoleTerm() {
        return roleTerm;
    }

    public static Builder builder() {
        return builder(new Role());
    }

    public static Builder builder(Role role) {
        return new Builder(role);
    }

    public static class Builder extends BuilderBase<Role, Builder> {
        protected Builder(Role role) {
            super(role);
        }

        public Builder addRoleTerm(RoleTerm roleTerm) {
            _target().getRoleTerm().add(roleTerm);
            return _self();
        }
    }
}
