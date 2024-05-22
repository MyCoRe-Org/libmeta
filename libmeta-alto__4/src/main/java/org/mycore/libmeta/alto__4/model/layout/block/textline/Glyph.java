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
package org.mycore.libmeta.alto__4.model.layout.block.textline;

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxHolder;
import org.mycore.libmeta.alto__4.model.layout.Shape;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A hyphenation char. Can appear only at the end of a line.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Glyph implements IBoundingBoxHolder {

    /** The area between the top line of print and the upper edge of the leaf. It may contain page number or running title. */
    @XmlElement(name = "Shape", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected Shape shape;

    @XmlElement(name = "Variant", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected List<Variant> variant = new Vector<Variant>();

    @XmlAttribute(name = "ID", required = false)
    @XmlSchemaType(name = "ID")
    protected String ID;

    /**
     * CONTENT contains the precomposed representation (combining character) of the character from the parent String element.
     * The sequence position of the Glyph element matches the position of the character in the String.
     */
    @XmlAttribute(name = "CONTENT", required = true)
    @XmlSchemaType(name = "CONTENT")
    protected String CONTENT;

    /**
     * This GC attribute records a float value between 0.0 and 1.0 that expresses the level of confidence for the glyph where 1 is certain.
     * This attribute is optional. If it is not available, the default value for the glyph is “0”.
     * The GC attribute semantic is the same as the WC attribute on the String element and VC on Variant element.
     */
    @XmlAttribute(name = "GC", required = false)
    @XmlSchemaType(name = "float")
    protected Float GC;

    @XmlAttribute(name = "HEIGHT", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HEIGHT;

    @XmlAttribute(name = "WIDTH", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float WIDTH;

    @XmlAttribute(name = "HPOS", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HPOS;

    @XmlAttribute(name = "VPOS", required = false)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float VPOS;

    public List<Variant> getVariant() {
        return variant;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String content) {
        CONTENT = content;
    }

    public Float getGC() {
        return GC;
    }

    public void setGC(Float gC) {
        GC = gC;
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

    public static Builder builder() {
        return builder(new Glyph());
    }

    public static Builder builder(Glyph hyp) {
        return new Builder(hyp);
    }

    public static class Builder extends BuilderBase<Glyph, Builder> implements
        IBoundingBoxBuilder<Glyph, Builder> {

        protected Builder(Glyph hyp) {
            super(hyp);
        }

        public Builder addVariant(Variant variant) {
            _target().getVariant().add(variant);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder CONTENT(String content) {
            _target().setCONTENT(content);
            return _self();
        }

        public Builder GC(Float gc) {
            _target().setGC(gc);
            return _self();
        }
    }
}
