package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCPublisher {

    public static DCPublisherBuilder builder() {
        return new DCPublisherBuilder();
    }

    public static class DCPublisherBuilder extends DCElementBuilder<DCPublisherBuilder> {
        protected DCPublisherBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createPublisher(ElementType.builder().language(language).value(value).build());
        }
    }
}
