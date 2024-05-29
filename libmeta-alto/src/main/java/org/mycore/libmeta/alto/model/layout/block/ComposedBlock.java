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

import org.mycore.libmeta.alto.model.layout.Block;
import org.mycore.libmeta.alto.model.layout.IBlockBuilder;
import org.mycore.libmeta.common.BuilderBase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlSchemaType;

/**
 * A block that consists of other blocks
 * 
 * @author Robert Stephan
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ComposedBlock extends Block {

    @XmlElements(value = {
        @XmlElement(name = "TextBlock", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = TextBlock.class),
        @XmlElement(name = "Illustration", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = Illustration.class),
        @XmlElement(name = "GraphicalElement", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = GraphicalElement.class),
        @XmlElement(name = "ComposedBlock", namespace = "http://www.loc.gov/standards/alto/ns-v2#", required = false,
            type = ComposedBlock.class) })
    protected List<Block> block = new Vector<Block>();

    @XmlAttribute(name = "TYPE", required = false)
    @XmlSchemaType(name = "string")
    protected String TYPE;

    @XmlAttribute(name = "FILEID", required = false)
    @XmlSchemaType(name = "string")
    protected String FILEID;

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }

    public String getFILEID() {
        return FILEID;
    }

    public void setFILEID(String fILEID) {
        FILEID = fILEID;
    }

    public List<Block> getBlock() {
        return block;
    }

    public static Builder builder() {
        return builder(new ComposedBlock());
    }

    public static Builder builder(ComposedBlock composedBlock) {
        return new Builder(composedBlock);
    }

    public static class Builder extends BuilderBase<ComposedBlock, Builder> implements
        IBlockBuilder<ComposedBlock, Builder> {

        protected Builder(ComposedBlock composedBlock) {
            super(composedBlock);
        }

        public Builder addBlock(Block block) {
            _target().getBlock().add(block);
            return _self();
        }

        public Builder TYPE(String type) {
            _target().setTYPE(type);
            return _self();
        }

        public Builder FILEID(String styleRefs) {
            _target().setSTYLEREFS(styleRefs);
            return _self();
        }
    }

}
