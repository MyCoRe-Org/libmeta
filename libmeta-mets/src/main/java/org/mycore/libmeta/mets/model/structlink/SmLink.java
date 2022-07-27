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
import org.mycore.libmeta.xlink.model.XlinkActuate;
import org.mycore.libmeta.xlink.model.XlinkShow;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

/**
 * {@code
 * <xsd:element name="smLink">
 * }
 * 
 * The Structural Map Link element &lt;smLink&gt;
 * identifies a hyperlink between two nodes in the structural map. You would use
 * &lt;smLink&gt;, for instance, to note the existence of hypertext links
 * between web pages, if you wished to record those links within METS. NOTE:
 * &lt;smLink&gt; is an empty element. The location of the &lt;smLink&gt;
 * element to which the &lt;smLink&gt; element is pointing MUST be stored in the
 * xlink:href attribute.
 * 
 * 
 * @author Robert Stephan
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class SmLink extends SmLinkOrSmLinkGrp {
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
     * <xsd:attribute ref="xlink:arcrole" use="optional">
     * }
     * 
     * xlink:arcrole - the role of the link, as per the xlink specification. See
     * http://www.w3.org/TR/xlink/
     */
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkArcrole;

    /**
     * {@code
     * <xsd:attribute ref="xlink:title" use="optional">
     * }
     * 
     * xlink:title - a title for the link (if needed), as per the xlink
     * specification. See http://www.w3.org/TR/xlink/
     */
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected String xlinkTitle;

    /**
     * {@code
     * <xsd:attribute ref="xlink:show" use="optional">
     * }
     * 
     * xlink:show - see the xlink specification at http://www.w3.org/TR/xlink/
     */
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkShow xlinkShow;

    /**
     * {@code
     * <xsd:attribute ref="xlink:actuate" use="optional">
     * }
     * 
     * xlink:actuate - see the xlink specification at
     * http://www.w3.org/TR/xlink/
     */
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink", required = false)
    protected XlinkActuate xlinkActuate;

    /**
     * {@code
     * <xsd:attribute ref="xlink:from" use="required">
     * }
     * 
     * xlink:from - the value of the label for the element in the structMap you
     * are linking from.
     */
    @XmlAttribute(name = "from", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkFrom;

    /**
     * {@code
     * <xsd:attribute ref="xlink:to" use="required">
     * }
     * 
     * xlink:to - the value of the label for the element in the structMap you
     * are linking to.
     */
    @XmlAttribute(name = "to", namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String xlinkTo;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
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

    public String getXlinkFrom() {
        return xlinkFrom;
    }

    public void setXlinkFrom(String xlinkFrom) {
        this.xlinkFrom = xlinkFrom;
    }

    public String getXlinkTo() {
        return xlinkTo;
    }

    public void setXlinkTo(String xlinkTo) {
        this.xlinkTo = xlinkTo;
    }

    public static Builder builder() {
        return builder(new SmLink());
    }

    public static Builder builder(SmLink sl) {
        return new Builder(sl);
    }

    public static class Builder extends BuilderBase<SmLink, Builder> {

        protected Builder(SmLink sl) {
            super(sl);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder xlinkArcrole(String xlinkArcrole) {
            _target().setXlinkArcrole(xlinkArcrole);
            return _self();
        }

        public Builder xlinkTitle(String xlinkTitle) {
            _target().setXlinkTitle(xlinkTitle);
            return _self();
        }

        public Builder xlinkShow(XlinkShow xlinkShow) {
            _target().setXlinkShow(xlinkShow);
            return _self();
        }

        public Builder xlinkActuate(XlinkActuate xlinkActuate) {
            _target().setXlinkActuate(xlinkActuate);
            return _self();
        }

        public Builder xlinkFrom(String xlinkFrom) {
            _target().setXlinkFrom(xlinkFrom);
            return _self();
        }

        public Builder xlinkTo(String xlinkTo) {
            _target().setXlinkTo(xlinkTo);
            return _self();
        }
    }
}
