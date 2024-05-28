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
package org.mycore.libmeta.marc21;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.marc21.model.MarcDatafield;
import org.mycore.libmeta.marc21.model.MarcRecord;
import org.mycore.libmeta.marc21.model.MarcSubfield;

public class MarcQuery {
    public static List<MarcDatafield> findDatafields(MarcRecord r, String tag) {
        Vector<MarcDatafield> v = new Vector<MarcDatafield>();
        for (MarcDatafield d : r.getDatafields()) {
            if (d.getTag().equals(tag)) {
                v.add(d);
            }
        }
        return v;
    }

    public static List<MarcSubfield> findSubfields(MarcDatafield d, String code) {
        Vector<MarcSubfield> v = new Vector<MarcSubfield>();
        for (MarcSubfield s : d.getSubfields()) {
            if (s.getCode().equals(code)) {
                v.add(s);
            }
        }
        return v;
    }

    public static List<MarcSubfield> findSubfields(MarcRecord r, String datafieldTag, String subfieldCode) {
        Vector<MarcSubfield> v = new Vector<MarcSubfield>();
        for (MarcDatafield d : r.getDatafields()) {
            if (d.getTag().equals(datafieldTag)) {
                for (MarcSubfield s : d.getSubfields()) {
                    if (s.getCode().equals(subfieldCode)) {
                        v.add(s);
                    }
                }
            }
        }
        return v;
    }

    public static MarcDatafield findFirstDatafield(MarcRecord r, String tag) {
        for (MarcDatafield d : r.getDatafields()) {
            if (d.getTag().equals(tag)) {
                return d;
            }
        }
        return null;
    }

    public static MarcSubfield findFirstSubfield(MarcDatafield d, String code) {
        for (MarcSubfield s : d.getSubfields()) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    public static MarcSubfield findFirstSubfield(MarcRecord r, String datafieldTag, String subfieldCode) {
        for (MarcDatafield d : r.getDatafields()) {
            if (d.getTag().equals(datafieldTag)) {
                for (MarcSubfield s : d.getSubfields()) {
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
    public static String findFirstContent(MarcRecord parent, String tag, String code) {
        MarcSubfield subfield = findFirstSubfield(parent, tag, code);
        return subfield != null ? subfield.getContent() : null;
    }

    /**
     * Returns the string content of the first subfield of the specified datafield with the specified attribute code.
     * @param field Datafield.
     * @param code Subfield code.
     * @return Subfield's string content or <code>null</code> if subfield is null or doesn't exist.
     */
    public static String findFirstContent(MarcDatafield field, String code) {
        MarcSubfield subfield = findFirstSubfield(field, code);
        return subfield != null ? subfield.getContent() : null;
    }

    /**
     * Returns the string content of all subfields with the specified datafield
     * tag and subfields code.
     * 
     * @param parent
     *            Record.
     * @param tag
     *            MarcDatafield tag.
     * @param code
     *            Subfield code. 
     * @param separator - a String, that will be
     *            used to separate multiple values - if
     *            <code>null</code> the parameter will be ignored
     * @return Datafield's subfield's string content or <code>null</code> if
     *         datafield or subfield is null or doesn't exist.
     */
    public static String findContents(MarcRecord parent, String tag, String code, String separator) {
        StringBuffer sb = new StringBuffer();
        for (MarcSubfield s : findSubfields(parent, tag, code)) {
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
    public static String findContents(MarcDatafield field, String code, String separator) {
        StringBuffer sb = new StringBuffer();
        for (MarcSubfield s : findSubfields(field, code)) {
            if (separator != null && sb.length() > 0) {
                sb.append(separator);
            }
            sb.append(s.getContent());
        }
        return sb.length() == 0 ? null : sb.toString();
    }
}
