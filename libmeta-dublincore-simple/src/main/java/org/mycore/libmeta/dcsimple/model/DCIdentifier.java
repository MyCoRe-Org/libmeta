package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCIdentifier {

    public static DCIdentifierBuilder builder() {
        return new DCIdentifierBuilder();
    }

    public static class DCIdentifierBuilder extends DCElementBuilder<DCIdentifierBuilder> {
        protected DCIdentifierBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createIdentifier(ElementType.builder().language(language).value(value).build());
        }
    }
}
