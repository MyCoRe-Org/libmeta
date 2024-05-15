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
package org.mycore.libmeta.alto__4.model.layout;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxHolder;
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;
import org.mycore.libmeta.xlink.model.XlinkTypeSimple;
import org.mycore.libmeta.xlink.model._interfaces.IAttributeGroupXlinkSimpleLink;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.NONE)
public class Block implements IAttributeGroupXlinkSimpleLink, IBoundingBoxHolder {
	
	@XmlElement(name = "Shape", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
	protected Shape Shape;
	
	@XmlAttribute(name = "ID", required = true)
	@XmlSchemaType(name = "ID")
	protected String ID;

	@XmlAttribute(name = "STYLEREFS", required = false)
	@XmlSchemaType(name = "IDREFS")
	protected String STYLEREFS;
	
	@XmlAttribute(name = "TAGREFS", required = false)
	@XmlSchemaType(name = "IDREFS")
	protected String TAGREFS;
		
	@XmlAttribute(name = "HEIGHT", required = true)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float HEIGHT;

	@XmlAttribute(name = "WIDTH", required = true)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float WIDTH;

	@XmlAttribute(name = "HPOS", required = true)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float HPOS;

	@XmlAttribute(name = "VPOS", required = true)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float VPOS;
	
	/**
	 * Tells the rotation of the block e.g. text or illustration. The value is in degree counterclockwise.
	 */
	@XmlAttribute(name = "ROTATION", required = false)
	@XmlSchemaType(name = "float")
	@XmlJavaTypeAdapter(FloatAdapter .class)
	protected Float ROTATAION;
	
	/**The next block in reading sequence on the page.*/
	@XmlAttribute(name = "IDNEXT", required = false)
	@XmlSchemaType(name = "IDREF")
	protected String IDNEXT;
	
	/** Correction Status. Indicates whether manual correction has been done or not. The correction status should be recorded at the highest level possible (Block, TextLine, String). */
	@XmlAttribute(name = "CS", required = false)
	@XmlSchemaType(name = "boolean")
	protected String CS;
	
    // attributeGroup xlink:simpleLink - begin

    /**
     * {@code
     * <attribute name="type" type="string" fixed="simple" form="qualified"/>
     * }
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected XlinkTypeSimple xlinkType;

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
    
	public Shape getShape() {
		return Shape;
	}

	public void setShape(Shape shape) {
		Shape = shape;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSTYLEREFS() {
		return STYLEREFS;
	}

	public void setSTYLEREFS(String sTYLEREFS) {
		STYLEREFS = sTYLEREFS;
	}

	public String getTAGREFS() {
		return TAGREFS;
	}

	public void setTAGREFS(String tAGREFS) {
		TAGREFS = tAGREFS;
	}

	public Float getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(Float hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public Float getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(Float wIDTH) {
		WIDTH = wIDTH;
	}

	public Float getHPOS() {
		return HPOS;
	}

	public void setHPOS(Float hPOS) {
		HPOS = hPOS;
	}

	public Float getVPOS() {
		return VPOS;
	}

	public void setVPOS(Float vPOS) {
		VPOS = vPOS;
	}

	public Float getROTATAION() {
		return ROTATAION;
	}

	public void setROTATAION(Float rOTATAION) {
		ROTATAION = rOTATAION;
	}

	public String getIDNEXT() {
		return IDNEXT;
	}

	public void setIDNEXT(String iDNEXT) {
		IDNEXT = iDNEXT;
	}

	public String getCS() {
		return CS;
	}

	public void setCS(String cS) {
		CS = cS;
	}

	public XlinkTypeSimple getXlinkType() {
		return xlinkType;
	}

	public void setXlinkType(XlinkTypeSimple xlinkType) {
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



    // 

}
