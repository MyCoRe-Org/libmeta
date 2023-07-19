package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCRelation {

    public static DCRelationBuilder builder() {
        return new DCRelationBuilder();
    }

    public static class DCRelationBuilder extends DCElementBuilder<DCRelationBuilder> {
        protected DCRelationBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createRelation(ElementType.builder().language(language).value(value).build());
        }
    }
}
