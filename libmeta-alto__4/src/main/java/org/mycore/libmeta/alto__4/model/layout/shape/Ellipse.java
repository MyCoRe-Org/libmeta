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
package org.mycore.libmeta.alto__4.model.layout.shape;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * An ellipse shape. 
 * HPOS and VPOS describe the center of the ellipse.
 * HLENGTH and VLENGTH are the width and height of the described ellipse.
 * 
 * The attribute ROTATION tells the rotation of the e.g. text or
 * illustration within the block. The value is in degrees counterclockwise.
 *
 * @author Robert Stephan
 * @version Alto 4.4
 */

@XmlAccessorType(XmlAccessType.NONE)
public class Ellipse implements IShapeChild {

    @XmlAttribute(name = "HPOS", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HPOS;

    @XmlAttribute(name = "VPOS", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float VPOS;

    @XmlAttribute(name = "HLENGTH", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float HLENGTH;

    @XmlAttribute(name = "VLENGTH", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float VLENGTH;

    @XmlAttribute(name = "ROTATION", required = true)
    @XmlSchemaType(name = "float")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float ROTATION;

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

    public Float getHLENGTH() {
        return HLENGTH;
    }

    public void setHLENGTH(Float hLENGTH) {
        HLENGTH = hLENGTH;
    }

    public Float getVLENGTH() {
        return VLENGTH;
    }

    public void setVLENGTH(Float vLENGTH) {
        VLENGTH = vLENGTH;
    }
    
    public Float geROTATION() {
        return ROTATION;
    }

    public void setROTATION(Float rOTATION) {
        ROTATION = rOTATION;
    }

    public static Builder builder() {
        return builder(new Ellipse());
    }

    public static Builder builder(Ellipse e) {
        return new Builder(e);
    }

    public static class Builder extends BuilderBase<Ellipse, Builder> {

        protected Builder(Ellipse e) {
            super(e);
        }

        public Builder HPOS(Float hpos) {
            _target().setHPOS(hpos);
            return _self();
        }

        public Builder VPOS(Float vpos) {
            _target().setVPOS(vpos);
            return _self();
        }

        public Builder HLENGTH(Float hlength) {
            _target().setHLENGTH(hlength);
            return _self();
        }

        public Builder VLENGTH(Float vlength) {
            _target().setVLENGTH(vlength);
            return _self();
        }
        
        public Builder ROTATION(Float rotation) {
            _target().setROTATION(rotation);
            return _self();
        }

    }

}
