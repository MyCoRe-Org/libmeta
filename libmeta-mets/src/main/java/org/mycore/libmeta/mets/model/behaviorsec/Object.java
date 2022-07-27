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
package org.mycore.libmeta.mets.model.behaviorsec;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupLOCATIONBuilder;
import org.mycore.libmeta.mets.model._enums.LOCTYPE;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupLOCATION;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model._builder.IAttributeGroupXlinkSimpleLinkBuilder;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xsd:complexType name="objectType">
 * }
 * 
 * objectType: complexType for interfaceDef and mechanism elements
 * 
 * The mechanism and behavior elements point to external objects--an interface
 * definition object or an executable code object respectively--which together
 * constitute a behavior that can be applied to one or more &lt;div&gt; elements
 * in a &lt;structMap&gt;.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.10
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Object implements IAttributeGroupLOCATION, IAttributeGroupXlinkSimpleLink {
    
    /**
     * {@code
     * <xsd:attribute name="ID" type="xsd:ID" use="optional">
     * }
     * 
     * ID (ID/O): This attribute uniquely identifies the element within the METS
     * document, and would allow the element to be referenced unambiguously from
     * another element or document via an IDREF or an XPTR. For more information
     * on using ID attributes for internal and external linking see Chapter 4 of
     * the METS Primer.
     */
    @XmlAttribute(name = "ID", required = false)
    protected String ID;

    /**
     * {@code
     * <xsd:attribute name="LABEL" type="xsd:string" use="optional">
     * }
     * 
     * LABEL (string/O): A text description of the entity represented.
     */
    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    // attributeGroup LOCATION - begin
    /**
     * {@code
     * <xsd:attribute name="LOCTYPE" use="required">
     * }
     * 
     * LOCTYPE (string/R): Specifies the locator type used in the xlink:href
     * attribute. Valid values for LOCTYPE are:
     */
    @XmlAttribute(name = "LOCTYPE", required = true)
    protected LOCTYPE LOCTYPE;

    /**
     * {@code
     * <xsd:attribute name="OTHERLOCTYPE" type="xsd:string" use="optional">
     * }
     * 
     * OTHERLOCTYPE (string/O): Specifies the locator type when the value OTHER
     * is used in the LOCTYPE attribute. Although optional, it is strongly
     * recommended when OTHER is used.
     */
    @XmlAttribute(name = "OTHERLOCTYPE", required = false)
    protected String OTHERLOCTYPE;

    // attributeGroup LOCATION - end

    // attributeGroup xlink:simpleLink - begin

    /**
     * {@code
     * <attribute name="type" type="string" fixed="simple" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkType;
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

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public String getLABEL() {
		return LABEL;
	}

	public void setLABEL(String label) {
		LABEL = label;
	}

	public LOCTYPE getLOCTYPE() {
		return LOCTYPE;
	}

	public void setLOCTYPE(LOCTYPE locType) {
		LOCTYPE = locType;
	}

	public String getOTHERLOCTYPE() {
		return OTHERLOCTYPE;
	}

	public void setOTHERLOCTYPE(String otherLocType) {
		OTHERLOCTYPE = otherLocType;
	}

	public String getXlinkType() {
		return xlinkType;
	}

	public void setXlinkType(String xlinkType) {
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

    // attributeGroup xlink:simpleLink - end

	 public static Builder builder() {
	        return builder(new Object());
	    }

	    public static Builder builder(Object o) {
	        return new Builder(o);
	    }

	    public static class Builder extends BuilderBase<Object, Builder>  implements IAttributeGroupLOCATIONBuilder<Object, Builder>, IAttributeGroupXlinkSimpleLinkBuilder<Object, Builder>{

	        public Builder(Object o) {
	            super(o);
	        }
		
		public Builder ID(String id) {
			_target().setID(id);
			return _self();
		}
		
		public Builder LABEL(String label) {
			_target().setLABEL(label);
			return _self();
		}
		
		public Builder xlinkType(String xlinkType) {
		    _target().setXlinkType(xlinkType);
			return _self();
		}
	}
}
