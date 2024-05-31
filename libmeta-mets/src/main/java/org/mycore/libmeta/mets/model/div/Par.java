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
package org.mycore.libmeta.mets.model.div;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.mycore.libmeta.common.BuilderBase;
import org.mycore.libmeta.mets.model._builder.IAttributeGroupORDERLABELSBuilder;
import org.mycore.libmeta.mets.model._interfaces.IAttributeGroupORDERLABELS;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

/**
 * {@code
 * <xsd:complexType name="parType">
 * }
 * 
 * parType: Complex Type for Parallel Files
 * 
 * The &lt;par&gt; or parallel files element aggregates pointers to files, parts
 * of files, and/or sequences of files or parts of files that must be played or
 * displayed simultaneously to manifest a block of digital content represented
 * by an &lt;fptr&gt; element.
 * 
 * 
 * @author Robert Stephan
 * @version METS 1.11
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Par extends AreaOrSeqOrPar implements IAttributeGroupORDERLABELS {
    // <xsd:choice maxOccurs="unbounded">

    /**
     * {@code
     * <xsd:choice maxOccurs="unbounded">
     * 
     * 		<xsd:element name="area" type="areaType" minOccurs="0"/>
     * 
     * 		<xsd:element name="seq" type="seqType" minOccurs="0"/>
     * 
     * </xsd:choice>
     * }
     */
    @XmlElements({ @XmlElement(name = "area", namespace = "http://www.loc.gov/METS/", type = Area.class),
        @XmlElement(name = "seq", namespace = "http://www.loc.gov/METS/", type = Seq.class) })
    protected List<AreaOrSeqOrPar> areaOrSeq = new Vector<>();

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

    //AttributeGroup ORDERLABELS - begin

    @XmlAttribute(name = "ORDER", required = false)
    protected Integer ORDER;

    @XmlAttribute(name = "ORDERLABEL", required = false)
    protected String ORDERLABEL;

    @XmlAttribute(name = "LABEL", required = false)
    protected String LABEL;

    //AttributeGroup ORDERLABES - end

    /**
     * {@code
     * 	<xsd:anyAttribute namespace="##other" processContents="lax" />
     * }
     */
    @XmlAnyAttribute
    protected Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<AreaOrSeqOrPar> getAreaOrSeq() {
        return areaOrSeq;
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public Integer getORDER() {
        return ORDER;
    }

    public void setORDER(Integer order) {
        ORDER = order;
    }

    public String getORDERLABEL() {
        return ORDERLABEL;
    }

    public void setORDERLABEL(String orderLabel) {
        ORDERLABEL = orderLabel;
    }

    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(String label) {
        LABEL = label;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public String getOtherAttribute(QName qname) {
        return otherAttributes.get(qname);
    }

    public static Builder builder() {
        return builder(new Par());
    }

    public static Builder builder(Par p) {
        return new Builder(p);
    }

    public static class Builder extends BuilderBase<Par, Builder>
        implements IAttributeGroupORDERLABELSBuilder<Par, Builder> {

        protected Builder(Par p) {
            super(p);
        }

        public Builder addArea(Area area) {
            _target().getAreaOrSeq().add(area);
            return _self();
        }

        public Builder addSeq(Seq seq) {
            _target().getAreaOrSeq().add(seq);
            return _self();
        }

        public Builder ID(String id) {
            _target().setID(id);
            return _self();
        }

        public Builder addOtherAttribute(QName name, String value) {
            _target().getOtherAttributes().put(name, value);
            return _self();
        }
    }
}
