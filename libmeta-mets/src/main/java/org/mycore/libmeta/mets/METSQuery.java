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
package org.mycore.libmeta.mets;

import java.util.List;
import java.util.stream.Stream;

import org.mycore.libmeta.mets.model.Mets;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model.div.AreaOrSeqOrPar;
import org.mycore.libmeta.mets.model.div.Par;
import org.mycore.libmeta.mets.model.div.Seq;
import org.mycore.libmeta.mets.model.filesec.File;
import org.mycore.libmeta.mets.model.filesec.FileGrp;
import org.mycore.libmeta.mets.model.filesec.FileSec;
import org.mycore.libmeta.mets.model.filesec.file.FLocat;
import org.mycore.libmeta.mets.model.mdsec.MdSec;
import org.mycore.libmeta.mets.model.structlink.SmLinkOrSmLinkGrp;
import org.mycore.libmeta.mets.model.structlink.StructLink;
import org.mycore.libmeta.mets.model.structmap.Div;
import org.mycore.libmeta.mets.model.structmap.StructMap;

public class METSQuery {
    public static StructMap findStructMap(Mets mets, String type) {
        for (StructMap s : mets.getStructMap()) {
            if (type != null && s.getTYPE() != null && type.equals(s.getTYPE())) {
                return s;
            }
        }
        return null;
    }

    public static StructMap findOrCreateStructMap(Mets mets, String type) {
        StructMap sm = findStructMap(mets, type);
        if (sm == null) {
            sm = new StructMap();
            sm.setTYPE(type);
            mets.getStructMap().add(sm);
        }
        return sm;
    }

    public static FileGrp findFileGrpOfID(Mets mets, String id) {
        if (mets.getFileSec() != null) {
            for (FileGrp fg : mets.getFileSec().getFileGrp()) {
                if (id != null && id.equals(fg.getID())) {
                    return fg;
                }
            }
        }
        return null;
    }

    public static FileGrp findOrCreateFileGrpOfID(Mets mets, String id) {
        FileGrp fg = findFileGrpOfID(mets, id);
        if (fg == null) {
            fg = new FileGrp();
            fg.setID(id);
            if (mets.getFileSec() == null) {
                mets.setFileSec(new FileSec());
            }
            mets.getFileSec().getFileGrp().add(fg);
        }
        return fg;
    }

    public static FileGrp findFileGrpOfUse(Mets mets, String use) {
        if (mets.getFileSec() != null) {
            for (FileGrp fg : mets.getFileSec().getFileGrp()) {
                if (use != null && use.equals(fg.getUSE())) {
                    return fg;
                }
            }
        }
        return null;
    }

    public static FileGrp findOrCreateFileGrpOfUse(Mets mets, String use) {
        FileGrp fg = findFileGrpOfUse(mets, use);
        if (fg == null) {
            fg = new FileGrp();
            fg.setUSE(use);
            mets.getFileSec().getFileGrp().add(fg);
        }
        return fg;
    }

    public static FLocat findFLocat(Mets mets, String fileGrpUSE, String fileID, LOCTYPE locType) {
        for (FileGrp fg : mets.getFileSec().getFileGrp()) {
            if (fg.getUSE().equals(fileGrpUSE)) {
                for (File f : fg.getFile()) {
                    if (f.getID().equals(fileID)) {
                        for (FLocat fl : f.getFLocat()) {
                            if (fl.getLOCTYPE().equals(locType)) {
                                return fl;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Div findDivOfType(Div parent, String type) {
        if (type.equals(parent.getTYPE())) {
            return parent;
        } else {
            if (parent.getDiv() != null) {
                for (Div d : parent.getDiv()) {
                    Div d2 = findDivOfType(d, type);
                    if (d2 != null)
                        return d2;
                }
            }
        }
        return null;
    }

    public static Div findDivOfID(Div parent, String id) {
        if (id != null && id.equals(parent.getID())) {
            return parent;
        } else {
            if (parent.getDiv() != null) {
                for (Div d : parent.getDiv()) {
                    Div d2 = findDivOfID(d, id);
                    if (d2 != null)
                        return d2;
                }
            }
        }
        return null;
    }

    public static MdSec findDmdSecOfID(Mets mets, String id) {
        if (id == null || mets == null) {
            return null;
        }
        for (MdSec dmd : mets.getDmdSec()) {
            if (id.equals(dmd.getID())) {
                return dmd;
            }
        }
        return null;
    }

    /**
     * This method create a stream of divs of a hierarchical structure of div elements in a structMap.
     * (The traversal order is depth first search.)
     * 
     * @param div - the root div element
     * @return a stream of child div elements
     */
    public static Stream<Div> treeTraversalStreamOfDivs(Div div) {
        return Stream.concat(Stream.of(div), div.getDiv().stream().flatMap(x -> treeTraversalStreamOfDivs(x)));
    }

    /**
     * returns a filtered stream of SmLinkOrSmLinkGrp
     * @param <T> the type of the SmLinkOrSmLinkGrp
     * @param structLink parent of SmLinkOrSmLinkGrp
     * @param type the class to filter and cast elements for
     * @return an object stream of SmLinkOrSmLinkGrp
     */
    public static <T extends SmLinkOrSmLinkGrp> Stream<T> streamFilteredContent(StructLink structLink, Class<T> type) {
        return structLink.getSmLinkOrSmLinkGrp().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered list of SmLinkOrSmLinkGrps
     * @param <T> the type of the SmLinkOrSmLinkGrp
     * @param structLink parent of SmLinkOrSmLinkGrp
     * @param type the class to filter and cast elements for
     * @return an object stream of SmLinkOrSmLinkGrp
     */
    public static <T extends SmLinkOrSmLinkGrp> List<T> listFilteredContent(StructLink structLink, Class<T> type) {
        return streamFilteredContent(structLink, type).toList();
    }

    /**
     * returns a filtered stream of AreaOrSeqOrPar
     * @param <T> the type of the AreaOrSeqOrPar
     * @param par parent of AreaOrSeqOrPar
     * @param type the class to filter and cast elements for
     * @return an object stream of AreaOrSeqOrPar
     */
    public static <T extends AreaOrSeqOrPar> Stream<T> streamFilteredContent(Par par, Class<T> type) {
        return par.getAreaOrSeq().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered list of AreaOrSeqOrPar
     * @param <T> the type of the AreaOrSeqOrPar
     * @param par parent of AreaOrSeqOrPar
     * @param type the class to filter and cast elements for
     * @return an object stream of AreaOrSeqOrPar
     */
    public static <T extends AreaOrSeqOrPar> List<T> listFilteredContent(Par par, Class<T> type) {
        return streamFilteredContent(par, type).toList();
    }

    /**
     * returns a filtered stream of AreaOrSeqOrPar
     * @param <T> the type of the AreaOrSeqOrPar
     * @param seq parent of AreaOrSeqOrPar
     * @param type the class to filter and cast elements for
     * @return an object stream of AreaOrSeqOrPar
     */
    public static <T extends AreaOrSeqOrPar> Stream<T> streamFilteredContent(Seq seq, Class<T> type) {
        return seq.getAreaOrPar().stream().filter(type::isInstance).map(type::cast);
    }

    /**
     * returns a filtered list of AreaOrSeqOrPar
     * @param <T> the type of the AreaOrSeqOrPar
     * @param seq parent of AreaOrSeqOrPar
     * @param type the class to filter and cast elements for
     * @return an object stream of AreaOrSeqOrPar
     */
    public static <T extends AreaOrSeqOrPar> List<T> listFilteredContent(Seq seq, Class<T> type) {
        return streamFilteredContent(seq, type).toList();
    }

}
