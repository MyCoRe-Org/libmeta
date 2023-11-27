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
package org.mycore.libmeta.mods.model._misc;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.mods.model._misc.enums.NameType;
import org.mycore.libmeta.mods.model._misc.enums.Usage;
import org.mycore.libmeta.mods.model._misc.enums.Yes;
import org.mycore.libmeta.mods.model.name.Affiliation;
import org.mycore.libmeta.mods.model.name.AlternativeName;
import org.mycore.libmeta.mods.model.name.Description;
import org.mycore.libmeta.mods.model.name.DisplayForm;
import org.mycore.libmeta.mods.model.name.Etal;
import org.mycore.libmeta.mods.model.name.NameIdentifier;
import org.mycore.libmeta.mods.model.name.NamePart;
import org.mycore.libmeta.mods.model.name.Role;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 *   Top Level Element {@literal {@literal <name>}}
 *   {@code 
 *   	<xs:complexType name="nameDefinition">
 *		<xs:choice>
 *			
 *			<!-- this choice give two ways to do this.  
 *				The second way allows the element <etal>,  to express "et. al."
 *		Choice one. WITHOUT <etal>. -->
 *			<xs:choice minOccurs="0" maxOccurs="unbounded">
 *				<xs:element ref="namePart"/>
 *				<xs:element ref="displayForm"/>
 *				<xs:element ref="affiliation"/>
 *				<xs:element ref="role"/>
 *				<xs:element ref="description"/>
 *			<!-- 
 *				the following element, <nameIdentifier>, is introduced in version 3.6,
 *				to allow the inclusion of an identifier for the object named by this <name>.
 *				It is typed as "indentifierDefinition", the same definition that 
 *				top-level element <identifier> uses. 
 *				-->
 *				<xs:element ref="nameIdentifier"/>
 *		<!--   -->		
 *		</xs:choice>
 *			<!-- 
 *       Choice two.	With <etal>.
 *               The presence of <etal> indicates that there are names that cannot 
 *              be explicitily included. It may be empty, or it may have simple content
 *               - e.g. <etal>et al.</etal>.  In the latter case the content is what is 
 *              suggested for display. 
 *               When <etal> occurs:
 *                 - <namePart>, <displayForm>, and <identifier> MAY NOT occur;
 *                  - <affiliation>, <role>, <description>   MAY occur (but are NOT repeatable).
 *              <etal> is not repeatable within a given <name>, however there may be 
 *              mutilple <etal> elements, each within in a separate <name> element.
 * -->
 *			<xs:sequence>
 *				<!--   
 *            <etal> is mandatory, nonrepeatable, and must occur first. 
 *            After that <affiliation>, <role>, and <description> may occur, in any order or number. 
 *            <nameIdentifier> is not used with <etal>
 * -->
 *				<xs:element ref="etal"/>
 *				<xs:choice minOccurs="0" maxOccurs="unbounded">
 *					<xs:element ref="affiliation"/>
 *					<xs:element ref="role"/>
 *					<xs:element ref="description"/>
 *				</xs:choice>
 *			</xs:sequence>
 *			<!-- -->
 *		</xs:choice>
 *		<xs:attribute name="ID" type="xs:ID"/>
 *		<xs:attributeGroup ref="authorityAttributeGroup"/>
 *		<xs:attributeGroup ref="xlink:simpleLink"/>
 *		<xs:attributeGroup ref="languageAttributeGroup"/>
 *		<xs:attribute name="displayLabel" type="xs:string"/>
 *		<xs:attribute name="altRepGroup" type="xs:string"/>
 *		<xs:attribute name="nameTitleGroup" type="xs:string"/>
 *		<xs:attribute name="usage" fixed="primary"/>
 *		<xs:attribute name="type">
 *			<xs:simpleType>
 *				<xs:restriction base="xs:string">
 *					<xs:enumeration value="personal"/>
 *					<xs:enumeration value="corporate"/>
 *					<xs:enumeration value="conference"/>
 *					<xs:enumeration value="family"/>
 *				</xs:restriction>
 *			</xs:simpleType>
 *		</xs:attribute>
 *	</xs:complexType>
 *}
 *   
 * @author Robert Stephan
 * @version MODS 3.6
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public abstract class NameDefinition<S extends INameDefinitionSubelement>
    implements IIDAttributeGroup, IAuthorityAttributeGroup, IAttributeGroupXlinkSimpleLink, ILanguageAttributeGroup {

    @XmlElements({ @XmlElement(name = "namePart", namespace = "http://www.loc.gov/mods/v3", type = NamePart.class),
        @XmlElement(name = "displayForm", namespace = "http://www.loc.gov/mods/v3", type = DisplayForm.class),
        @XmlElement(name = "affiliation", namespace = "http://www.loc.gov/mods/v3", type = Affiliation.class),
        @XmlElement(name = "role", namespace = "http://www.loc.gov/mods/v3", type = Role.class),
        @XmlElement(name = "description", namespace = "http://www.loc.gov/mods/v3", type = Description.class),
        @XmlElement(name = "nameIdentifier", namespace = "http://www.loc.gov/mods/v3", type = NameIdentifier.class),
        @XmlElement(name = "etal", namespace = "http://www.loc.gov/mods/v3", type = Etal.class),
        
        /** @version MODS 3.7 */
         @XmlElement(name = "alternativeName", namespace = "http://www.loc.gov/mods/v3", type = AlternativeName.class) })
    protected List<S> content = new Vector<>();

    @XmlAttribute(name = "ID")
    protected String ID;
    
    @XmlAttribute(name = "IDREF")
    protected String IDREF;

    // IAuthorityAttributeGroup - begin

    @XmlAttribute(name = "authority")
    protected String authority;

    @XmlAttribute(name = "authorityURI")
    protected String authorityURI;

    @XmlAttribute(name = "valueURI")
    protected String valueURI;

    //IAuthorityAttributeGroup - end

    //IXlinkSimpleLinkAttributeGroup - begin

    /**
     * {@code 
     * <attribute ref="xlink:href" use="optional"/>
     * }
     */
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkHref;

    /**
     * {@code 
     * <attribute ref="xlink:role" use="optional"/>
     * }
     */
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkRole;

    /**
     * {@code 
     * <attribute ref="xlink:arcrole" use="optional"/>
     * }
     */
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkArcrole;

    /**
     * {@code 
     * <attribute ref="xlink:title" use="optional"/>
     * }
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * {@code 
     * <attribute ref="xlink:show" use="optional"/>
     * }
     */
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkShow xlinkShow;

    /**
     * {@code 
     * <attribute ref="xlink:actuate" use="optional"/>
     * }
     */
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkActuate xlinkActuate;

    //IXlinkSimpleLinkAttributeGroup - end

    //ILanguageAttributeGroup - begin

    @XmlAttribute(name = "lang")
    protected String lang;

    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = false)
    protected String xmlLang;

    @XmlAttribute(name = "script")
    protected String script;

    @XmlAttribute(name = "transliteration")
    protected String transliteration;

    //ILanguageAttributeGroup - end

    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;

    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;

    @XmlAttribute(name = "nameTitleGroup")
    protected String nameTitleGroup;

    @XmlAttribute(name = "usage")
    protected Usage usage;

    @XmlAttribute(name = "type")
    protected NameType type;
    
    @XmlAttribute(name = "supplied")
    protected Yes supplied;

    public List<S> getContent() {
        return content;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }
    
    public String getIDREF() {
        return IDREF;
    }

    public void setIDREF(String iDREF) {
        IDREF = iDREF;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityURI() {
        return authorityURI;
    }

    public void setAuthorityURI(String authorityURI) {
        this.authorityURI = authorityURI;
    }

    public String getValueURI() {
        return valueURI;
    }

    public void setValueURI(String valueURI) {
        this.valueURI = valueURI;
    }

    public String getXlinkHref() {
        return xlinkHref;
    }

    public void setXlinkHref(String xlinkHref) {
        this.xlinkHref = xlinkHref;
    }

    public String getXlinkRole() {
        return xlinkRole;
    }

    public void setXlinkRole(String xlinkRole) {
        this.xlinkRole = xlinkRole;
    }

    public String getXlinkArcrole() {
        return xlinkArcrole;
    }

    public void setXlinkArcrole(String xlinkArcrole) {
        this.xlinkArcrole = xlinkArcrole;
    }

    public String getXlinkTitle() {
        return xlinkTitle;
    }

    public void setXlinkTitle(String xlinkTitle) {
        this.xlinkTitle = xlinkTitle;
    }

    public XlinkShow getXlinkShow() {
        return xlinkShow;
    }

    public void setXlinkShow(XlinkShow xlinkShow) {
        this.xlinkShow = xlinkShow;
    }

    public XlinkActuate getXlinkActuate() {
        return xlinkActuate;
    }

    public void setXlinkActuate(XlinkActuate xlinkActuate) {
        this.xlinkActuate = xlinkActuate;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public void setXmlLang(String xmlLang) {
        this.xmlLang = xmlLang;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getAltRepGroup() {
        return altRepGroup;
    }

    public void setAltRepGroup(String altRepGroup) {
        this.altRepGroup = altRepGroup;
    }

    public String getNameTitleGroup() {
        return nameTitleGroup;
    }

    public void setNameTitleGroup(String nameTitleGroup) {
        this.nameTitleGroup = nameTitleGroup;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public NameType getType() {
        return type;
    }

    public void setType(NameType type) {
        this.type = type;
    }
    
    public Yes getSupplied() {
        return supplied;
    }

    public void setSupplied(Yes supplied) {
        this.supplied = supplied;
    }
}
