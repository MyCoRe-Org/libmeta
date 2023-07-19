package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCDescription {

    public static DCDescriptionBuilder builder() {
        return new DCDescriptionBuilder();
    }

    public static class DCDescriptionBuilder extends DCElementBuilder<DCDescriptionBuilder> {
        protected DCDescriptionBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createDescription(ElementType.builder().language(language).value(value).build());
        }
    }
}
