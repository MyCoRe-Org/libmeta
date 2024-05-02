/* 
 * This file is part of *** MyCoRe LibMeta ***
 * See https://github.com/MyCoRe-Org/libmeta/ for details.
 * 
 * MyCoRe LibMeta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General public static License as published 
 * by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * MyCoRe LibMeta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General public static License for more details.
 *
 * You should have received a copy of the GNU Lesser General public static License
 * along with MyCoRe LibMeta.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mycore.libmeta.mods;

import java.util.List;
import java.util.stream.Stream;

import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._misc.IAgentSubelement;
import org.mycore.libmeta.mods.model._misc.IAlternativeNameSubelement;
import org.mycore.libmeta.mods.model._misc.INameSubelement;
import org.mycore.libmeta.mods.model._toplevel.ITopLevelElement;
import org.mycore.libmeta.mods.model._toplevel.Name;
import org.mycore.libmeta.mods.model._toplevel.RecordInfo;
import org.mycore.libmeta.mods.model.name.AlternativeName;
import org.mycore.libmeta.mods.model.origininfo.Agent;
import org.mycore.libmeta.mods.model.recordinfo.IRecordInfoSubelement;

public class MODSQuery {
    /**
     * returns a filtered stream of MODS top level elements
     * @param <T> the type of the toplevelElement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS top level elements
     */
    public static <T extends ITopLevelElement> Stream<T> streamFilteredContent(Mods mods, Class<T> type) {
        return mods.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered list of MODS top level elements
     * @param <T> the type of the toplevelElement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS top level elements
     */
    public static <T extends ITopLevelElement> List<T> listFilteredContent(Mods mods, Class<T> type) {
        return streamFilteredContent(mods, type).toList();
    }

    /**
     * returns a filtered List of RecordInfoSubelements
     * @param <T> the type of the RecordInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS record info subelements
     */
    public static <T extends IRecordInfoSubelement> Stream<T> streamFilteredContent(RecordInfo recordInfo,
        Class<T> type) {
        return recordInfo.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of RecordInfoSubelements
     * @param <T> the type of the RecordInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS record info subelements
     */
    public static <T extends IRecordInfoSubelement> List<T> listFilteredContent(RecordInfo recordInfo, Class<T> type) {
        return streamFilteredContent(recordInfo, type).toList();
    }

    /**
     * returns a filtered List of NameSubelements
     * @param <T> the type of the NameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS name subelements
     */
    public static <T extends INameSubelement> Stream<T> streamFilteredContent(Name name, Class<T> type) {
        return name.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of NameSubelements
     * @param <T> the type of the NameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS name subelements
     */
    public static <T extends INameSubelement> List<T> listFilteredContent(Name name, Class<T> type) {
        return streamFilteredContent(name, type).toList();
    }

    /**
     * returns a filtered List of AlternativeNameSubelements
     * @param <T> the type of the AlternativeNameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS alternativeName subelements
     */
    public static <T extends IAlternativeNameSubelement> Stream<T> streamFilteredContent(AlternativeName altName,
        Class<T> type) {
        return altName.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of AlternativeNameSubelements
     * @param <T> the type of the AlternativeNameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS alternative name subelements
     */
    public static <T extends IAlternativeNameSubelement> List<T> listFilteredContent(AlternativeName altName,
        Class<T> type) {
        return streamFilteredContent(altName, type).toList();
    }

    /**
     * returns a filtered List of AgentSubelements
     * @param <T> the type of the AgentSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS originInfo agent subelements
     */
    public static <T extends IAgentSubelement> Stream<T> streamFilteredContent(Agent agent, Class<T> type) {
        return agent.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of AgentSubelements
     * @param <T> the type of the AgentSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS originInfo agent subelements
     */
    public static <T extends IAgentSubelement> List<T> listFilteredContent(Agent agent, Class<T> type) {
        return streamFilteredContent(agent, type).toList();
    }
}
