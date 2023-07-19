package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCDate {

    public static DCDateBuilder builder() {
        return new DCDateBuilder();
    }

    public static class DCDateBuilder extends DCElementBuilder<DCDateBuilder> {
        protected DCDateBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createDate(ElementType.builder().language(language).value(value).build());
        }
    }
}
