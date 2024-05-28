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
package org.mycore.libmeta.pica;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.pica.model.HasPicaDatafields;
import org.mycore.libmeta.pica.model.PicaDatafield;
import org.mycore.libmeta.pica.model.PicaSubfield;

public class PicaQuery {
    public static List<PicaDatafield> findDatafields(HasPicaDatafields r, String tag) {
        Vector<PicaDatafield> v = new Vector<PicaDatafield>();
        for (PicaDatafield d : r.getDatafields()) {
            if (d.getTag().equals(tag)) {
                v.add(d);
            }
        }
        return v;
    }

    public static List<PicaSubfield> findSubfields(PicaDatafield d, String code) {
        Vector<PicaSubfield> v = new Vector<PicaSubfield>();
        for (PicaSubfield s : d.getSubfields()) {
            if (s.getCode().equals(code)) {
                v.add(s);
            }
        }
        return v;
    }

    public static List<PicaSubfield> findSubfields(HasPicaDatafields r, String datafieldTag, String subfieldCode) {
        Vector<PicaSubfield> v = new Vector<PicaSubfield>();
        for (PicaDatafield d : r.getDatafields()) {
            if (d.getTag().equals(datafieldTag)) {
                for (PicaSubfield s : d.getSubfields()) {
                    if (s.getCode().equals(subfieldCode)) {
                        v.add(s);
                    }
                }
            }
        }
        return v;
    }

    public static PicaDatafield findFirstDatafield(HasPicaDatafields r, String tag) {
        for (PicaDatafield d : r.getDatafields()) {
            if (d.getTag().equals(tag)) {
                return d;
            }
        }
        return null;
    }

    public static PicaSubfield findFirstSubfield(PicaDatafield d, String code) {
        for (PicaSubfield s : d.getSubfields()) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    public static PicaSubfield findFirstSubfield(HasPicaDatafields r, String datafieldTag, String subfieldCode) {
        for (PicaDatafield d : r.getDatafields()) {
            if (d.getTag().equals(datafieldTag)) {
                for (PicaSubfield s : d.getSubfields()) {
                    if (s.getCode().equals(subfieldCode)) {
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the string content of the specified first field's first subfield with the specified datafield tag and subfields code.
     * @param parent Record.
     * @param tag Datafield tag.
     * @param code Subfield code.
     * @return Datafield's subfield's string content or <code>null</code> if datafield or subfield is null or doesn't exist.
     */
    public static String findFirstContent(HasPicaDatafields parent, String tag, String code) {
        PicaSubfield subfield = findFirstSubfield(parent, tag, code);
        return subfield != null ? subfield.getContent() : null;
    }

    /**
     * Returns the string content of the first subfield of the specified datafield with the specified attribute code.
     * @param field Datafield.
     * @param code Subfield code.
     * @return Subfield's string content or <code>null</code> if subfield is null or doesn't exist.
     */
    public static String findFirstContent(PicaDatafield field, String code) {
        PicaSubfield subfield = findFirstSubfield(field, code);
        return subfield != null ? subfield.getContent() : null;
    }

    /**
     * Returns the string content of all subfields with the specified datafield
     * tag and subfields code.
     * 
     * @param parent
     *            Record.
     * @param tag
     *            Datafield tag.
     * @param code
     *            Subfield code.
     * @param separator - a String, that will be
     *            used to separate multiple values - if
     *            <code>null</code> the parameter will be ignored
     * @return Datafield's subfield's string content or <code>null</code> if
     *         datafield or subfield is null or doesn't exist.
     */
    public static String findContents(HasPicaDatafields parent, String tag, String code, String separator) {
        StringBuffer sb = new StringBuffer();
        for (PicaSubfield s : findSubfields(parent, tag, code)) {
            if (separator != null && sb.length() > 0) {
                sb.append(separator);
            }
            sb.append(s.getContent());
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    /**
     * Returns the string content of all subfields of the specified datafield
     * with the specified attribute code.
     * 
     * @param field
     *            Datafield.
     * @param code
     *            Subfield code.
     * @param separator
     *            - a String, that will be used to separate multiple values
     *            - if <code>null</code> the parameter will be ignored
     * @return Subfield's string content or <code>null</code> if subfield is
     *         null or doesn't exist.
     */
    public static String findContents(PicaDatafield field, String code, String separator) {
        StringBuffer sb = new StringBuffer();
        for (PicaSubfield s : findSubfields(field, code)) {
            if (separator != null && sb.length() > 0) {
                sb.append(separator);
            }
            sb.append(s.getContent());
        }
        return sb.length() == 0 ? null : sb.toString();
    }
}
