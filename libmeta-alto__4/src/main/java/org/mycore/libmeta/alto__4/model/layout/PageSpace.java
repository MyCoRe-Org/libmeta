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

import java.util.List;
import java.util.Vector;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxBuilder;
import org.mycore.libmeta.alto__4._misc.IBoundingBoxHolder;
import org.mycore.libmeta.alto__4.model.layout.block.ComposedBlock;
import org.mycore.libmeta.alto__4.model.layout.block.GraphicalElement;
import org.mycore.libmeta.alto__4.model.layout.block.Illustration;
import org.mycore.libmeta.alto__4.model.layout.block.TextBlock;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "shape, block" })
public class PageSpace implements IBoundingBoxHolder {

    /** The area between the top line of print and the upper edge of the leaf. It may contain page number or running title. */
    @XmlElement(name = "Shape", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false)
    protected Shape shape;

    @XmlElements(value = {
        @XmlElement(name = "TextBlock", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = TextBlock.class),
        @XmlElement(name = "Illustration", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = Illustration.class),
        @XmlElement(name = "GraphicalElement", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = GraphicalElement.class),
        @XmlElement(name = "ComposedBlock", namespace = "http://www.loc.gov/standards/alto/ns-v4#", required = false,
            type = ComposedBlock.class) })
    protected List<Block> block = new Vector<Block>();

    @XmlAttribute(name = "ID", required = false)
    @XmlSchemaType(name = "ID")
    protected String ID;

    @XmlAttribute(name = "STYLEREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    protected String STYLEREFS;

    @XmlAttribute(name = "PROCESSINGREFS", required = false)
    @XmlSchemaType(name = "IDREFS")
    protected String PROCESSINGREFS;

    @XmlAttribute(name = "HEIGHT", required = false)
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

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
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

    public String getPROCESSINGREFS() {
        return PROCESSINGREFS;
    }

    public void setPROCESSINGREFS(String pROCESSINGREFS) {
        PROCESSINGREFS = pROCESSINGREFS;
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

    public List<Block> getBlock() {
        return block;
    }

    public static Builder builder() {
        return builder(new PageSpace());
    }

    public static Builder builder(PageSpace pageSpace) {
        return new Builder(pageSpace);
    }

    public static class Builder extends BuilderBase<PageSpace, Builder>
        implements IBoundingBoxBuilder<PageSpace, Builder> {

        protected Builder(PageSpace pageSpace) {
            super(pageSpace);
        }

        public Builder shape(Shape s) {
            _target().setShape(s);
            return _self();
        }

        public Builder addBlock(Block block) {
            _target().getBlock().add(block);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder STYLEREFS(String styleRefs) {
            _target().setSTYLEREFS(styleRefs);
            return _self();
        }

        public Builder PROCESSINGREFS(String processingRefs) {
            _target().setPROCESSINGREFS(processingRefs);
            return _self();
        }

        protected Float HEIGHT;

        public Builder HEIGHT(Float height) {
            _target().setHEIGHT(height);
            return _self();
        }

        protected Float WIDTH;

        public Builder WIDTH(Float width) {
            _target().setWIDTH(width);
            return _self();
        }

        protected Float HPOS;

        public Builder HPOS(Float hpos) {
            _target().setHPOS(hpos);
            return _self();
        }

        public Builder VPOS(Float vpos) {
            _target().setVPOS(vpos);
            return _self();
        }
    }
}
