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
package org.mycore.libmeta.mods.model.origininfo;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mods.model._misc.builder.IDateDefinitionBuilder;
import org.mycore.libmeta.mods.model._misc.definitions.DateDefinition;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * MODS OriginInfo Subelement: DateIssued
 * 
 * {@code
 * <xs:element name="dateIssued" type="dateDefinition"/>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class DateIssued extends DateDefinition implements IOriginInfoSubelement {

    public static Builder builder() {
        return builder(new DateIssued());
    }

    public static Builder builder(DateIssued d) {
        return new Builder(d);
    }

    public static class Builder extends BuilderBase<DateIssued, Builder>
        implements IDateDefinitionBuilder<DateIssued, Builder> {
        protected Builder(DateIssued d) {
            super(d);
        }
    }
}
