package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCTitle {

    public static DCTitleBuilder builder() {
        return new DCTitleBuilder();
    }

    public static class DCTitleBuilder extends DCElementBuilder<DCTitleBuilder> {
        protected DCTitleBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createTitle(ElementType.builder().language(language).value(value).build());
        }
    }
}
