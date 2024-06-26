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
package org.mycore.libmeta.alto.model.layout;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.alto._misc.FloatAdapter;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The root layout element.
 * 
 * @author Robert Stephan
 * @version Alto 2.1
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "TopMargin", "LeftMargin", "RightMargin", "BottomMargin", "PrintSpace" })
public class Page {

    /** The area between the top line of print and the upper edge of the leaf. It may contain page number or running title. */
    @XmlElement(name = "TopMargin", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<PageSpace> TopMargin = new Vector<PageSpace>();

    /** The area between the printspace and the left border of a page. May contain margin notes. */
    @XmlElement(name = "LeftMargin", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<PageSpace> LeftMargin = new Vector<PageSpace>();

    /** The area between the printspace and the right border of a page. May contain margin notes. */
    @XmlElement(name = "RightMargin", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<PageSpace> RightMargin = new Vector<PageSpace>();

    /** The area between the bottom line of letterpress or writing and the bottom edge of the leaf. It may contain a page number, a signature number or a catch word.*/
    @XmlElement(name = "BottomMargin", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<PageSpace> BottomMargin = new Vector<PageSpace>();

    /** Rectangle covering the printed area of a page. Page number and running title are not part of the print space. */
    @XmlElement(name = "PrintSpace", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false)
    protected List<PageSpace> PrintSpace = new Vector<PageSpace>();

    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "ID")
    protected String ID;

    /** Any user-defined class like title page. */
    @XmlAttribute(name = "PAGECLASS", required = false)
    @XmlSchemaType(name = "string")
    protected String PAGECLASS;

    @XmlAttribute(name = "STYLEREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    protected String STYLEREFS;

    @XmlAttribute(name = "HEIGHT", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HEIGHT;

    @XmlAttribute(name = "WIDTH", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float WIDTH;

    /** The number of the page within the document. */
    @XmlAttribute(name = "PHYSICAL_IMG_NR", required = true)
    @XmlSchemaType(name = "float")
    protected Integer PHYSICAL_IMG_NR;

    /** The page number that is printed on the page. */
    @XmlAttribute(name = "PRINTED_IMG_NR", required = false)
    @XmlSchemaType(name = "string")
    protected String PRINTED_IMG_NR;

    /** Gives brief information about original page quality. */
    @XmlAttribute(name = "QUALITY", required = false)
    protected PageQuality QUALITY;

    /** Gives more details about the original page quality, since QUALITY attribute gives only brief and restrictive information. */
    @XmlAttribute(name = "QUALITY_DETAIL", required = false)
    @XmlSchemaType(name = "string")
    protected String QUALITY_DETAIL;

    /** Position of the page. Could be lefthanded, righthanded, cover, foldout or single if it has no special position. */
    @XmlAttribute(name = "POSITION", required = false)
    protected PagePosition POSITION;

    /** A link to the processing description that has been used for this page. */
    @XmlAttribute(name = "PROCESSING", required = false)
    @XmlSchemaType(name = "IDREF")
    protected String PROCESSING;

    /** Estimated percentage of OCR Accuracy in range from 0 to 100 */
    @XmlAttribute(name = "ACCURACY", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float ACCURACY;

    /** Page Confidence: Confidence level of the ocr for this page. 
     * A value between 0 (unsure) and 1 (sure). */
    @XmlAttribute(name = "PC", required = false)
    @XmlSchemaType(name = "float")
    protected Float PC;

    public List<PageSpace> getTopMargin() {
        return TopMargin;
    }

    public List<PageSpace> getLeftMargin() {
        return LeftMargin;
    }

    public List<PageSpace> getRightMargin() {
        return RightMargin;
    }

    public List<PageSpace> getBottomMargin() {
        return BottomMargin;
    }

    public List<PageSpace> getPrintSpace() {
        return PrintSpace;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getPAGECLASS() {
        return PAGECLASS;
    }

    public void setPAGECLASS(String pAGECLASS) {
        PAGECLASS = pAGECLASS;
    }

    public String getSTYLEREFS() {
        return STYLEREFS;
    }

    public void setSTYLEREFS(String sTYLEREFS) {
        STYLEREFS = sTYLEREFS;
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

    public Integer getPHYSICAL_IMG_NR() {
        return PHYSICAL_IMG_NR;
    }

    public void setPHYSICAL_IMG_NR(Integer pHYSICAL_IMG_NR) {
        PHYSICAL_IMG_NR = pHYSICAL_IMG_NR;
    }

    public String getPRINTED_IMG_NR() {
        return PRINTED_IMG_NR;
    }

    public void setPRINTED_IMG_NR(String pRINTED_IMG_NR) {
        PRINTED_IMG_NR = pRINTED_IMG_NR;
    }

    public PageQuality getQUALITY() {
        return QUALITY;
    }

    public void setQUALITY(PageQuality qUALITY) {
        QUALITY = qUALITY;
    }

    public String getQUALITY_DETAIL() {
        return QUALITY_DETAIL;
    }

    public void setQUALITY_DETAIL(String qUALITY_DETAIL) {
        QUALITY_DETAIL = qUALITY_DETAIL;
    }

    public PagePosition getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(PagePosition pOSITION) {
        POSITION = pOSITION;
    }

    public String getPROCESSING() {
        return PROCESSING;
    }

    public void setPROCESSING(String pROCESSING) {
        PROCESSING = pROCESSING;
    }

    public Float getACCURACY() {
        return ACCURACY;
    }

    public void setACCURACY(Float aCCURACY) {
        ACCURACY = aCCURACY;
    }

    public Float getPC() {
        return PC;
    }

    public void setPC(Float pC) {
        PC = pC;
    }

    public static Builder builder() {
        return builder(new Page());
    }

    public static Builder builder(Page layout) {
        return new Builder(layout);
    }

    public static class Builder extends BuilderBase<Page, Builder> {

        protected Builder(Page layout) {
            super(layout);
        }

        public Builder addTopMargin(PageSpace t) {
            _target().getTopMargin().add(t);
            return _self();
        }

        public Builder addLeftMargin(PageSpace l) {
            _target().getLeftMargin().add(l);
            return _self();
        }

        public Builder addRightMargin(PageSpace r) {
            _target().getRightMargin().add(r);
            return _self();
        }

        public Builder addBottomMargin(PageSpace b) {
            _target().getBottomMargin().add(b);
            return _self();
        }

        public Builder addPrintSpace(PageSpace ps) {
            _target().getPrintSpace().add(ps);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder PAGECLASS(String pageClass) {
            _target().setPAGECLASS(pageClass);
            return _self();
        }

        public Builder STYLEREFS(String stylerefs) {
            _target().setSTYLEREFS(stylerefs);
            return _self();
        }

        public Builder HEIGHT(Float height) {
            _target().setHEIGHT(height);
            return _self();
        }

        public Builder WIDTH(Float width) {
            _target().setWIDTH(width);
            return _self();
        }

        public Builder PHYSICAL_IMG_NR(Integer nr) {
            _target().setPHYSICAL_IMG_NR(nr);
            return _self();
        }

        public Builder PRINTED_IMG_NR(String nr) {
            _target().setPRINTED_IMG_NR(nr);
            return _self();
        }

        public Builder QUALITY(PageQuality quality) {
            _target().setQUALITY(quality);
            return _self();
        }

        public Builder QUALITY_DETAIL(String qualityDetail) {
            _target().setQUALITY_DETAIL(qualityDetail);
            return _self();
        }

        public Builder POSITION(PagePosition position) {
            _target().setPOSITION(position);
            return _self();
        }

        public Builder PROCESSING(String idref) {
            _target().setPROCESSING(idref);
            return _self();
        }

        public Builder ACCURACY(Float accuracy) {
            _target().setACCURACY(accuracy);
            return _self();
        }

        public Builder PC(Float pc) {
            _target().setPC(pc);
            return _self();
        }
    }

}
