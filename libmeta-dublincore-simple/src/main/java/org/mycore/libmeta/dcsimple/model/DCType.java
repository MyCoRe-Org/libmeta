package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCType {

    public static DCTypeBuilder builder() {
        return new DCTypeBuilder();
    }

    public static class DCTypeBuilder extends DCElementBuilder<DCTypeBuilder> {
        protected DCTypeBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createType(ElementType.builder().language(language).value(value).build());
        }
    }
}
