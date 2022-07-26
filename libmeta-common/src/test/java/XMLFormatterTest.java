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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mycore.libmeta.common.XMLFormatter;
import org.w3c.dom.Document;

class XMLFormatterTest{
	public static void main(String[] args) throws IOException{
		Document doc = XMLFormatter.parseFromResource("/deeply_nested.xml");
		Path pOut = Paths.get("C:\\workspaces\\goobi2mycore\\git\\metadata\\libmeta-common\\target\\output\\deeply_nested_formated.xml");
		Files.createDirectories(pOut.getParent());
		XMLFormatter.cleanEmptyTextNodes(doc);
		XMLFormatter.prettyPrintXML(doc, pOut);
	}
}