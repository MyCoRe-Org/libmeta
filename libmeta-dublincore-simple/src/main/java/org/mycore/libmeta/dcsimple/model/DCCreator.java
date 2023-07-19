package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCCreator {

    public static DCCreatorBuilder builder() {
        return new DCCreatorBuilder();
    }

    public static class DCCreatorBuilder extends DCElementBuilder<DCCreatorBuilder> {
        protected DCCreatorBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createCreator(ElementType.builder().language(language).value(value).build());
        }
    }
}
