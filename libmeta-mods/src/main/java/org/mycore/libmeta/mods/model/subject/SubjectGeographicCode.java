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

import org.mycore.libmeta.mods.model._misc.types.StringPlusLanguagePlusAuthority;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 *  MODS Subject Subelement {@literal <geographicCode>}
 *  
 *  {@code
 *  <xs:complexType name="geographicCodeDefinition">
 *		<xs:simpleContent>
 *			<xs:extension base="stringPlusLanguagePlusAuthority">
 *              <xs:attribute name="type" type="codeOrText"/>
 *          </xs:extension>
 *		</xs:simpleContent>
 *	</xs:complexType>
 *  }
 * 
 * @author Robert Stephan
 * @version MODS 3.6 / modified in MODS 3.8
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SubjectGeographicCode extends StringPlusLanguagePlusAuthority {

    public static final String AUTHORITY__MARCGAC = "marcgac";

    public static final String AUTHORITY__MARCCOUNTRY = "marccountry";

    public static final String AUTHORITY__ISO3166 = "iso3166";

    public static Builder builder() {
        return new Builder(new SubjectGeographicCode());
    }

    public static Builder builder(SubjectGeographicCode sgc) {
        return new Builder(sgc);
    }

    public static class Builder extends StringPlusLanguagePlusAuthority.Builder<SubjectGeographicCode> {
        protected Builder(SubjectGeographicCode sgc) {
            super(sgc);
        }
    }
}
