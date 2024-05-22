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
package org.mycore.libmeta.alto__4.model.styles;

import java.util.EnumSet;

import org.mycore.libmeta.alto__4._misc.FloatAdapter;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A text style defines font properties of text.
 * 
 * Formatting attributes. Note that these attributes are assumed to be inherited
 * from ancestor elements of the document hierarchy.
 * 
 * @author Robert Stephan
 * @version 4.4
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
public class TextStyle implements IFormattingAttributeGroup {

    @XmlAttribute(name = "ID", required = true)
    @XmlSchemaType(name = "ID")
    protected String ID;

    /** The font name. */
    @XmlAttribute(name = "FONTFAMILY", required = false)
    protected String FONTFAMILY;

    @XmlAttribute(name = "FONTTYPE", required = false)
    protected FontType FONTTYPE;

    @XmlAttribute(name = "FONTWIDTH", required = false)
    protected FontWidth FONTWIDTH;

    /** The font size, in points (1/72 of an inch). */
    @XmlAttribute(name = "FONTSIZE", required = true)
    @XmlJavaTypeAdapter(FloatAdapter.class)
    protected Float FONTSIZE;

    /**
     * Font color as RGB value
     */
    @XmlAttribute(name = "FONTCOLOR", required = false)
    @XmlSchemaType(name = "hexBinary")
    protected String FONTCOLOR;

    @XmlAttribute(name = "FONTSTYLE", required = false)
    protected EnumSet<FontStyle> FONTSTYLE;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getFONTFAMILY() {
        return FONTFAMILY;
    }

    public void setFONTFAMILY(String fONTFAMILY) {
        FONTFAMILY = fONTFAMILY;
    }

    public FontType getFONTTYPE() {
        return FONTTYPE;
    }

    public void setFONTTYPE(FontType fONTTYPE) {
        FONTTYPE = fONTTYPE;
    }

    public FontWidth getFONTWIDTH() {
        return FONTWIDTH;
    }

    public void setFONTWIDTH(FontWidth fONTWIDTH) {
        FONTWIDTH = fONTWIDTH;
    }

    public Float getFONTSIZE() {
        return FONTSIZE;
    }

    public void setFONTSIZE(Float fONTSIZE) {
        FONTSIZE = fONTSIZE;
    }

    public String getFONTCOLOR() {
        return FONTCOLOR;
    }

    public void setFONTCOLOR(String fONTCOLOR) {
        FONTCOLOR = fONTCOLOR;
    }

    public EnumSet<FontStyle> getFONTSTYLE() {
        return FONTSTYLE;
    }

    public void setFONTSTYLE(EnumSet<FontStyle> fontstyles) {
        FONTSTYLE = fontstyles;
    }

    public static Builder builder() {
        return builder(new TextStyle());
    }

    public static Builder builder(TextStyle textStyle) {
        return new Builder(textStyle);
    }

    public static class Builder extends BuilderBase<TextStyle, Builder>
        implements IFormattingAttributeGroupBuilder<IFormattingAttributeGroup, Builder> {

        protected Builder(TextStyle textStyle) {
            super(textStyle);
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

    }

}
