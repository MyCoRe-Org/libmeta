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
import org.mycore.libmeta.mods.model._misc.DateDefinition;
import org.mycore.libmeta.mods.model._misc.builder.IDateDefinitionBuilder;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * MODS OriginInfo Subelement: DateCaptured
 * 
 * {@code
 * <xs:element name="dateCaptured" type="dateDefinition"/>
 * }
 * 
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class DateCaptured extends DateDefinition implements IOriginInfoSubelement {

    public static Builder builder() {
        return builder(new DateCaptured());
    }

    public static Builder builder(DateCaptured d) {
        return new Builder(d);
    }

    public static class Builder extends BuilderBase<DateCaptured, Builder>
        implements IDateDefinitionBuilder<DateCaptured, Builder> {
        protected Builder(DateCaptured d) {
            super(d);
        }
    }
}
