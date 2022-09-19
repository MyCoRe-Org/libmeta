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
package org.mycore.libmeta.mycoreclass;

import java.util.HashMap;
import java.util.Map;

import org.mycore.libmeta.mycoreclass.model.Category;
import org.mycore.libmeta.mycoreclass.model.Label;
import org.mycore.libmeta.mycoreclass.model.Mycoreclass;

public class MycoreclassQuery {
	public static Map<String, Label> findLabels(Mycoreclass m, String categoryID) {
		Map<String, Label> labels = new HashMap<>();
		for (Category cc : m.getCategories()) {
			findLabels(cc, categoryID, labels);
		}
		return labels;
	}
	
	private static void findLabels(Category c, String categoryID, Map<String, Label> labels) {
		if (c.getID().equals(categoryID)) {
			for (Label l : c.getLabels()) {
				labels.put(l.getXmlLang(), l);
			}
		} else {
			for (Category cc : c.getCategories()) {
				findLabels(cc, categoryID, labels);
			}	
		}
	}
	public static String findLabelText(Mycoreclass m, String categoryID, String xmlLang) {
		for (Category cc : m.getCategories()) {
			String t = findLabelText(cc, categoryID, xmlLang);
			if(t != null) {
				return t;
			}
		}
		return null;
	}
	
	private static String findLabelText(Category c, String categoryID, String xmlLang) {
		if (c.getID().equals(categoryID)) {
			for (Label l : c.getLabels()) {
				if(l.getXmlLang().equals(xmlLang)) {
					return l.getText();
				}
			}
		} else {
			for (Category cc : c.getCategories()) {
			    String t = findLabelText(cc, categoryID, xmlLang);
	            if(t != null) {
	                return t;
	            }
			}	
		}
		return null;
	}
}
