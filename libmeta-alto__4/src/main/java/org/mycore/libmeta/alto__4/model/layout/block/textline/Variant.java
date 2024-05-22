package org.mycore.libmeta.alto__4.model.layout.block.textline;

import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * Alternative (combined) character for the glyph, outlined by OCR engine or similar recognition processes.
 * In case the variant are two (combining) characters, two characters are outlined in one Variant element.
 * E.g. a Glyph element with CONTENT="m" can have a Variant element with the content "rn".
 * Details for different use-cases see on the samples on GitHub.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Variant {

    /**
     * Each Variant represents an option for the glyph that the OCR software detected as possible alternatives.
     * In case the variant are two (combining) characters, two characters are outlined in one Variant element.
     * E.g. a Glyph element with CONTENT="m" can have a Variant element with the content "rn".
     * Details for different use-cases see on the samples on GitHub.
     * 
     * maxLength="3"  / whiteSpace="preserve"
     */
    @XmlAttribute(name = "CONTENT", required = true)
    @XmlSchemaType(name = "CONTENT")
    protected String CONTENT;

    /**
     * This VC attribute records a float value between 0.0 and 1.0 that expresses the level of confidence for the variant where is 1 is certain.
     * This attribute is optional. If it is not available, the default value for the variant is “0”.
     * The VC attribute semantic is the same as the GC attribute on the Glyph element.
     */
    @XmlAttribute(name = "VC", required = false)
    @XmlSchemaType(name = "float")
    protected Float VC;

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String content) {
        CONTENT = content;
    }

    public Float getVC() {
        return VC;
    }

    public void setVC(Float vC) {
        VC = vC;
    }

    public static Builder builder() {
        return builder(new Variant());
    }

    public static Builder builder(Variant v) {
        return new Builder(v);
    }

    public static class Builder extends BuilderBase<Variant, Builder> {

        protected Builder(Variant v) {
            super(v);
        }

        public Builder CONTENT(String content) {
            _target().setCONTENT(content);
            return _self();
        }

        public Builder VC(Float vc) {
            _target().setVC(vc);
            return _self();
        }
    }
}
