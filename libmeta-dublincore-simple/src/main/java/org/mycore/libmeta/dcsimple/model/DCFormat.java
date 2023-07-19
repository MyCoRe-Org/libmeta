package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCFormat {

    public static DCFormatBuilder builder() {
        return new DCFormatBuilder();
    }

    public static class DCFormatBuilder extends DCElementBuilder<DCFormatBuilder> {
        protected DCFormatBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createFormat(ElementType.builder().language(language).value(value).build());
        }
    }
}
