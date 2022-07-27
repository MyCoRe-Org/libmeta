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

import org.mycore.libmeta.mets.model.Mets;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model.filesec.File;
import org.mycore.libmeta.mets.model.filesec.FileGrp;
import org.mycore.libmeta.mets.model.filesec.FileSec;
import org.mycore.libmeta.mets.model.filesec.file.FLocat;
import org.mycore.libmeta.mets.model.mdsec.MdSec;
import org.mycore.libmeta.mets.model.structmap.Div;
import org.mycore.libmeta.mets.model.structmap.StructMap;

public class METSQuery {
    public static StructMap findStructMap(Mets mets, String type) {
        for (StructMap s : mets.getStructMap()) {
            if(type!=null && s.getTYPE()!=null && type.equals(s.getTYPE())) {
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
                if (id!=null && id.equals(fg.getID())) {
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
            if(mets.getFileSec()==null) {
                mets.setFileSec(new FileSec());
            }
            mets.getFileSec().getFileGrp().add(fg);
        }
        return fg;
    }
    
    public static FileGrp findFileGrpOfUse(Mets mets, String use) {
        if (mets.getFileSec() != null) {
            for (FileGrp fg : mets.getFileSec().getFileGrp()) {
                if (use!=null && use.equals(fg.getUSE())) {
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

    /**
     * {@code
     * <mets:fileSec ID="fileSec_rosdok_document_000000000029">
     *	<mets:fileGrp USE="MIN">
     * 		<mets:file MIMETYPE="image/jpeg" ID="etwas_1737_i0001_MIN">
     *  		<mets:FLocat LOCTYPE="URL" xlink:href="http://rosdok.uni-rostock.de/data/etwas/etwas1737/MIN/intro/etwas_1737_i0001.jpg"/>
     *		</mets:file>
     *	}
     * @return
     */
    
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
        if (id!=null && id.equals(parent.getID())) {
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
        if(id==null || mets == null) {
            return null;
        }
        for(MdSec dmd: mets.getDmdSec()) {
            if(id.equals(dmd.getID())) {
                return dmd;
            }
        }
        return null;
    }
}
