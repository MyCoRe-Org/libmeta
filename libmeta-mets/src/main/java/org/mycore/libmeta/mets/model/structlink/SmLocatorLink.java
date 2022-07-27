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
package org.mycore.libmeta.mets.model.structlink;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.xlink.model.XlinkTypeLocator;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkLocatorLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkLocatorLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xsd:element name="smLocatorLink" minOccurs="2" maxOccurs="unbounded" >
 * }
 * 
 * The structMap locator link element &lt;smLocatorLink&gt; is of xlink:type
 * &quot;locator&quot;. It provides a means of identifying a &lt;div&gt; element
 * that will participate in one or more of the links specified by means of
 * &lt;smArcLink&gt; elements within the same &lt;smLinkGrp&gt;. The
 * participating &lt;div&gt; element that is represented by the
 * &lt;smLocatorLink&gt; is identified by means of a URI in the associate
 * xlink:href attribute. The lowest level of this xlink:href URI value should be
 * a fragment identifier that references the ID value that identifies the
 * relevant &lt;div&gt; element. For example,
 * &quot;xlink:href='#div20'&quot; where &quot;div20&quot; is the ID
 * value that identifies the pertinent &lt;div&gt; in the current METS document.
 * Although not required by the xlink specification, an &lt;smLocatorLink&gt;
 * element will typically include an xlink:label attribute in this context, as
 * the &lt;smArcLink&gt; elements will reference these labels to establish the
 * from and to sides of each arc link.
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SmLocatorLink implements IAttributeGroupXlinkLocatorLink {
    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID">
     * }
     * //TODO-CHECK required=true
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. For more information
     * on using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ID", required = true)
    protected String ID;

    // attributeGroup xlink:locatorLink - begin
    /**
     * {@code
     * <attribute name="type" type="string" fixed="locator" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected XlinkTypeLocator xlinkType = XlinkTypeLocator.LOCATOR;

    /**
     * {@code
     * <attribute ref="xlink:href" use="required"/>
     * }
     */
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink", required = true)
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
     * <attribute ref="xlink:title" use="optional"/>
     * }
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * {@code
     * <attribute ref="xlink:label" use="optional"/>
     * }
     */
    @XmlAttribute(name = "label", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkLabel;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public XlinkTypeLocator getXlinkType() {
        return xlinkType;
    }

    public void setXlinkType(XlinkTypeLocator xlinkType) {
        this.xlinkType = xlinkType;
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

    public String getXlinkTitle() {
        return xlinkTitle;
    }

    public void setXlinkTitle(String xlinkTitle) {
        this.xlinkTitle = xlinkTitle;
    }

    public String getXlinkLabel() {
        return xlinkLabel;
    }

    public void setXlinkLabel(String xlinkLabel) {
        this.xlinkLabel = xlinkLabel;
    }

    public static Builder builder() {
        return builder(new SmLocatorLink());
    }

    public static Builder builder(SmLocatorLink sll) {
        return new Builder(sll);
    }

    public static class Builder extends BuilderBase<SmLocatorLink, Builder> implements IAttributeGroupXlinkLocatorLinkBuilder<SmLocatorLink, Builder> {

        protected Builder(SmLocatorLink sll) {
            super(sll);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }
    }
}
