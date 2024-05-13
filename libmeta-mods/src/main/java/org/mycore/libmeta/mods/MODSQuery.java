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
import org.mycore.libmeta.mods.model._toplevel.OriginInfo;
import org.mycore.libmeta.mods.model._toplevel.Part;
import org.mycore.libmeta.mods.model._toplevel.PhysicalDescription;
import org.mycore.libmeta.mods.model._toplevel.RecordInfo;
import org.mycore.libmeta.mods.model._toplevel.Subject;
import org.mycore.libmeta.mods.model._toplevel.TitleInfo;
import org.mycore.libmeta.mods.model.name.AlternativeName;
import org.mycore.libmeta.mods.model.origininfo.Agent;
import org.mycore.libmeta.mods.model.origininfo.IOriginInfoSubelement;
import org.mycore.libmeta.mods.model.origininfo.Place;
import org.mycore.libmeta.mods.model.part.Detail;
import org.mycore.libmeta.mods.model.part.IPartSubelement;
import org.mycore.libmeta.mods.model.physicaldescription.IPhysicalDescriptionSubelement;
import org.mycore.libmeta.mods.model.recordinfo.IRecordInfoSubelement;
import org.mycore.libmeta.mods.model.subject.ISubjectSubelement;
import org.mycore.libmeta.mods.model.subject.SubjectHierarchicalGeographic;
import org.mycore.libmeta.mods.model.subject.SubjectName;
import org.mycore.libmeta.mods.model.subject.SubjectTitleInfo;
import org.mycore.libmeta.mods.model.titleInfo.ITitleInfoSubelement;

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
    
    /**
     * returns a filtered List of OriginInfoSubelement
     * @param <T> the type of the OriginInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS originmInfo subelements
     */
    public static <T extends IOriginInfoSubelement> Stream<T> streamFilteredContent(OriginInfo originInfo, Class<T> type) {
        return originInfo.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of OriginInfoSubelement
     * @param <T> the type of the OriginInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS origin Info subelements
     */
    public static <T extends IOriginInfoSubelement> List<T> listFilteredContent(OriginInfo originInfo, Class<T> type) {
        return streamFilteredContent(originInfo, type).toList();
    }
    
    /**
     * returns a filtered List of PartSubelement
     * @param <T> the type of the PartSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS part subelements
     */
    public static <T extends IPartSubelement> Stream<T> streamFilteredContent(Part part, Class<T> type) {
        return part.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of PartSubelement
     * @param <T> the type of the PartSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS part Info subelements
     */
    public static <T extends IPartSubelement> List<T> listFilteredContent(Part part, Class<T> type) {
        return streamFilteredContent(part, type).toList();
    }
    
    /**
     * returns a filtered List of PhysicalDescriptionSubelement
     * @param <T> the type of the PhysicalDescriptionSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS physical description subelements
     */
    public static <T extends IPhysicalDescriptionSubelement> Stream<T> streamFilteredContent(PhysicalDescription physicalDescription, Class<T> type) {
        return physicalDescription.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of PhysicalDescriptionSubelement
     * @param <T> the type of the PhysicalDescriptionSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS physical description subelements
     */
    public static <T extends IPhysicalDescriptionSubelement> List<T> listFilteredContent(PhysicalDescription physicalDescription, Class<T> type) {
        return streamFilteredContent(physicalDescription, type).toList();
    }
    
    /**
     * returns a filtered List of SubjectSubelement
     * @param <T> the type of the SubjectSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject subelements
     */
    public static <T extends ISubjectSubelement> Stream<T> streamFilteredContent(Subject subject, Class<T> type) {
        return subject.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of SubjectSubelement
     * @param <T> the type of the SubjectSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject subelements
     */
    public static <T extends ISubjectSubelement> List<T> listFilteredContent(Subject subject, Class<T> type) {
        return streamFilteredContent(subject, type).toList();
    }

    /**
     * returns a filtered List of TitleInfoSubelement
     * @param <T> the type of the TitleInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS title info subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(TitleInfo titleInfo, Class<T> type) {
        return titleInfo.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of TitleInfoSubelement
     * @param <T> the type of the TitleInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS title info subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(TitleInfo titleInfo, Class<T> type) {
        return streamFilteredContent(titleInfo, type).toList();
    }
    
    /**
     * returns a filtered List of PlaceSubelement
     * @param <T> the type of the PlaceSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS place subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(Place place, Class<T> type) {
        return place.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of PlaceSubelement
     * @param <T> the type of the PlaceSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS place subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(Place place, Class<T> type) {
        return streamFilteredContent(place, type).toList();
    }
    
    /**
     * returns a filtered List of PartDetailSubelement
     * @param <T> the type of the PartDetailSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS part detail subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(Detail detail, Class<T> type) {
        return detail.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of PartDetailSubelement
     * @param <T> the type of the PartDetailSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS part detail subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(Detail detail, Class<T> type) {
        return streamFilteredContent(detail, type).toList();
    }
    
    /**
     * returns a filtered List of HierarchicalGeographicSubelement
     * @param <T> the type of the HierarchicalGeographicSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS hierarchical geographic subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(SubjectHierarchicalGeographic subjectHierarchicalGeographic, Class<T> type) {
        return subjectHierarchicalGeographic.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of HierarchicalGeographicSubelement
     * @param <T> the type of the HierarchicalGeographicSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS hierarchical geographic subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(SubjectHierarchicalGeographic subjectHierarchicalGeographic, Class<T> type) {
        return streamFilteredContent(subjectHierarchicalGeographic, type).toList();
    }
    
    /**
     * returns a filtered List of SubjectNameSubelement
     * @param <T> the type of the SubjectNameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject name subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(SubjectName subjectName, Class<T> type) {
        return subjectName.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of SubjectNameSubelement
     * @param <T> the type of the SubjectNameSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject name subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(SubjectName subjectName, Class<T> type) {
        return streamFilteredContent(subjectName, type).toList();
    }
    
    /**
     * returns a filtered List of SubjectTitleInfoSubelement
     * @param <T> the type of the SubjectTitleInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject title info subelements
     */
    public static <T extends ITitleInfoSubelement> Stream<T> streamFilteredContent(SubjectTitleInfo subjectTitleInfo, Class<T> type) {
        return subjectTitleInfo.getContent().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered List of SubjectTitleInfoSubelement
     * @param <T> the type of the SubjectTitleInfoSubelement
     * @param type the class to filter and cast elements for
     * @return an object stream of MODS subject name subelements
     */
    public static <T extends ITitleInfoSubelement> List<T> listFilteredContent(SubjectTitleInfo subjectTitleInfo, Class<T> type) {
        return streamFilteredContent(subjectTitleInfo, type).toList();
    }
    
}
