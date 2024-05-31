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
 * <xsd:complexType name="seqType">
 * }
 * 
 * seqType: Complex Type for Sequences of Files
 * 
 * The seq element should be used to link a div to a set of content files when
 * those files should be played/displayed sequentially to deliver content to a
 * user. Individual &lt;area&gt; subelements within the seq element provide the
 * links to the files or portions thereof.
 * 
 * @author Robert Stephan
 * @version METS 1.11
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Seq extends AreaOrSeqOrPar implements IAttributeGroupORDERLABELS {
    /**
     * {@code
     * <xsd:choice maxOccurs="unbounded">
     * 		<xsd:element name="area" type="areaType" minOccurs="0"/>
     * 		<xsd:element name="par" type="parType" minOccurs="0"/>
     * </xsd:choice>
     * }
     */
    @XmlElements({ @XmlElement(name = "area", namespace = "http://www.loc.gov/METS/", type = Area.class),
        @XmlElement(name = "par", namespace = "http://www.loc.gov/METS/", type = Par.class) })
    protected List<AreaOrSeqOrPar> areaOrPar = new Vector<>();

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

    public List<AreaOrSeqOrPar> getAreaOrPar() {
        return areaOrPar;
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
        return builder(new Seq());
    }

    public static Builder builder(Seq s) {
        return new Builder(s);
    }

    public static class Builder extends BuilderBase<Seq, Builder>
        implements IAttributeGroupORDERLABELSBuilder<Seq, Builder> {

        protected Builder(Seq s) {
            super(s);
        }

        public Builder addArea(Area area) {
            _target().getAreaOrPar().add(area);
            return _self();
        }

        public Builder addPar(Par par) {
            _target().getAreaOrPar().add(par);
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
