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
package org.mycore.libmeta.alto.model.layout.block;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.alto._misc.FloatAdapter;
import org.mycore.libmeta.alto._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto._misc.IBoundingBoxHolder;
import org.mycore.libmeta.alto.model.layout.block.textline.ITextlineContent;
import org.mycore.libmeta.alto.model.layout.block.textline.TextlineHYP;
import org.mycore.libmeta.alto.model.layout.block.textline.TextlineSP;
import org.mycore.libmeta.alto.model.layout.block.textline.TextlineString;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.NONE)
public class Textline implements IBoundingBoxHolder {
    @XmlElements(value = {
        @XmlElement(name = "String", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = TextlineString.class),
        @XmlElement(name = "SP", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = TextlineSP.class),
        @XmlElement(name = "HYP", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = TextlineHYP.class) })
    protected List<ITextlineContent> content = new Vector<ITextlineContent>();

    @XmlAttribute(name = "ID", required = false)
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
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HEIGHT;

    @XmlAttribute(name = "WIDTH", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float WIDTH;

    @XmlAttribute(name = "HPOS", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HPOS;

    @XmlAttribute(name = "VPOS", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float VPOS;

    @XmlAttribute(name = "BASELINE", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float BASELINE;

    /** Attribute to record language of the textline. */
    @XmlAttribute(name = "LANG", required = false)
    @XmlSchemaType(name = "language")
    protected String LANG;

    /**
     * Correction Status. Indicates whether manual correction has been done or not.
     * The correction status should be recorded at the highest level possible
     * (Block, TextLine, String).
     */
    @XmlAttribute(name = "CS", required = false)
    @XmlSchemaType(name = "boolean")
    protected Boolean CS;

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

    public Float getBASELINE() {
        return BASELINE;
    }

    public void setBASELINE(Float bASELINE) {
        BASELINE = bASELINE;
    }

    public String getLANG() {
        return LANG;
    }

    public void setLANG(String lANG) {
        LANG = lANG;
    }

    public Boolean getCS() {
        return CS;
    }

    public void setCS(Boolean cS) {
        CS = cS;
    }

    public List<ITextlineContent> getContent() {
        return content;
    }

    public static Builder builder() {
        return builder(new Textline());
    }

    public static Builder builder(Textline textline) {
        return new Builder(textline);
    }

    public static class Builder extends BuilderBase<Textline, Builder>
        implements IBoundingBoxBuilder<Textline, Builder> {

        protected Builder(Textline textline) {
            super(textline);
        }

        public Builder addContent(ITextlineContent content) {
            _target().getContent().add(content);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder STYLEREFS(String stylerefs) {
            _target().setSTYLEREFS(stylerefs);
            return _self();
        }

        public Builder TAGREFS(String tagrefs) {
            _target().setTAGREFS(tagrefs);
            return _self();
        }

        public Builder BASELINE(Float baseline) {
            _target().setBASELINE(baseline);
            return _self();
        }

        public Builder LANG(String lang) {
            _target().setLANG(lang);
            return _self();
        }

        public Builder CS(Boolean cs) {
            _target().setCS(cs);
            return _self();
        }
    }

}
