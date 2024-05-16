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
package org.mycore.libmeta.alto__4.model.layout.block;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxHolder;
import org.mycore.libmeta.alto__4.model.layout.Shape;
import org.mycore.libmeta.alto__4.model.layout.block.textline.HYP;
import org.mycore.libmeta.alto__4.model.layout.block.textline.ITextlineContent;
import org.mycore.libmeta.alto__4.model.layout.block.textline.SP;
import org.mycore.libmeta.alto__4.model.layout.block.textline.TextlineString;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A single line of text.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Textline implements IBoundingBoxHolder {
    @XmlElements(value = {
        @XmlElement(name = "Shape", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = Shape.class),
        @XmlElement(name = "String", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = TextlineString.class),
        @XmlElement(name = "SP", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = SP.class),
        @XmlElement(name = "HYP", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = HYP.class) })
    protected List<ITextlineContent> content = new Vector<ITextlineContent>();

    @XmlAttribute(name = "ID", required = false)
    @XmlSchemaType(name = "ID")
    protected TextlineString ID;

    @XmlAttribute(name = "STYLEREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    protected TextlineString STYLEREFS;

    @XmlAttribute(name = "TAGREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    protected TextlineString TAGREFS;

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
    protected TextlineString LANG;

    /**
     * Correction Status. Indicates whether manual correction has been done or not.
     * The correction status should be recorded at the highest level possible
     * (Block, TextLine, String).
     */
    @XmlAttribute(name = "CS", required = false)
    @XmlSchemaType(name = "boolean")
    protected Boolean CS;

    public TextlineString getID() {
        return ID;
    }

    public void setID(TextlineString iD) {
        ID = iD;
    }

    public TextlineString getSTYLEREFS() {
        return STYLEREFS;
    }

    public void setSTYLEREFS(TextlineString sTYLEREFS) {
        STYLEREFS = sTYLEREFS;
    }

    public TextlineString getTAGREFS() {
        return TAGREFS;
    }

    public void setTAGREFS(TextlineString tAGREFS) {
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

    public TextlineString getLANG() {
        return LANG;
    }

    public void setLANG(TextlineString lANG) {
        LANG = lANG;
    }

    public Boolean getCS() {
        return CS;
    }

    public void setCS(Boolean cS) {
        CS = cS;
    }

    //
    public List<ITextlineContent> getContent() {
        repairContent();
        return content;
    }

    private void repairContent() {
        List<ITextlineContent> repaired = new Vector<ITextlineContent>();
        //das zuletzt hinzugefügte Shape-Element
        Optional<ITextlineContent> first = content.stream().filter(x -> Shape.class.isInstance(x)).reduce((a, b) -> b);
        // alternativ das erste Elemente
        //Optional<ITextlineContent> first = content.stream().filter(x -> Shape.class.isInstance(x)).findFirst();
        first.ifPresent(x -> repaired.add(x));
        repaired.addAll(
            content.stream().filter(x -> TextlineString.class.isInstance(x) || SP.class.isInstance(x)).toList());
        Optional<ITextlineContent> last = content.stream().filter(x -> HYP.class.isInstance(x)).reduce((a, b) -> b);
        last.ifPresent(x -> repaired.add(x));
        content = repaired;
    }

    public void addContent(ITextlineContent c) {
        if (c instanceof Shape) {
            content.removeIf(x -> x instanceof Shape);
            content.add(0, c);
        } else if (c instanceof HYP) {
            content.removeIf(x -> x instanceof HYP);
            content.add(c);
        } else {
            if (content.get(content.size() - 1) instanceof HYP) {
                content.add(content.size() - 1, c);
            } else {
                content.add(c);
            }
        }
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
            _target().addContent(content);
            return _self();
        }

        public Builder ID(TextlineString id) {
            _target().setID(id);
            return _self();
        }

        public Builder STYLEREFS(TextlineString stylerefs) {
            _target().setSTYLEREFS(stylerefs);
            return _self();
        }

        public Builder TAGREFS(TextlineString tagrefs) {
            _target().setTAGREFS(tagrefs);
            return _self();
        }

        public Builder BASELINE(Float baseline) {
            _target().setBASELINE(baseline);
            return _self();
        }

        public Builder LANG(TextlineString lang) {
            _target().setLANG(lang);
            return _self();
        }

        public Builder CS(Boolean cs) {
            _target().setCS(cs);
            return _self();
        }
    }

}
