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
package org.mycore.libmeta.mets.model._interfaces;

/**
 * AttributeGroup ORDERLABELS
 * 
 * @author Robert Stephan
 * @version METS 1.10
 *
 */
public interface IAttributeGroupORDERLABELS {
	
	/**
	 * <xsd:attribute name="ORDER" type="xsd:integer" use="optional" /> 
	 * ORDER (integer/O): A representation of the element's order among its
	 * siblings (e.g., its absolute, numeric sequence). For an example, and clarification of the distinction 
	 * between ORDER and ORDERLABEL, see the description of the ORDERLABEL attribute.
	 */
	public Integer getORDER();
	public void setORDER(Integer order);
	
	/**
	 * <xsd:attribute name="ORDERLABEL" type="xsd:string" use="optional" />
	 * ORDERLABEL (string/O): A representation of the element's order among
	 * its siblings (e.g., “xii”), or of any non-integer native numbering system. It is presumed that this value will
	 * still be machine actionable (e.g., it would support ‘go to page ___’ function), and it should not be used as a
	 * replacement/substitute for the LABEL attribute. To understand the differences between ORDER, ORDERLABEL and LABEL,
	 * imagine a text with 10 roman numbered pages followed by 10 arabic numbered pages. Page iii would have an ORDER of
	 * “3”, an ORDERLABEL of “iii” and a LABEL of “Page iii”, while page 3 would have an ORDER of “13”, an ORDERLABEL of
	 * “3” and a LABEL of “Page 3”.
	 */
	public String getORDERLABEL();
	public void setORDERLABEL(String orderlabel);
	
	/**
	 * <xsd:attribute name="LABEL" type="xsd:string" use="optional" />
	 * LABEL (string/O): An attribute used, for example, to identify a
	 * &lt;div&gt; to an end user viewing the document. Thus a hierarchical arrangement of the &lt;div&gt; LABEL values
	 * could provide a table of contents to the digital content represented by a METS document and facilitate the users’
	 * navigation of the digital object. Note that a &lt;div&gt; LABEL should be specific to its level in the structural
	 * map. In the case of a book with chapters, the book &lt;div&gt; LABEL should have the book title and the chapter
	 * &lt;div&gt;; LABELs should have the individual chapter titles, rather than having the chapter &lt;div&gt; LABELs
	 * combine both book title and chapter title . For further of the distinction between LABEL and ORDERLABEL see the
	 */
	public String getLABEL();
	public void setLABEL(String label);
}
