package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCSource {

    public static DCSourceBuilder builder() {
        return new DCSourceBuilder();
    }

    public static class DCSourceBuilder extends DCElementBuilder<DCSourceBuilder> {
        protected DCSourceBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createSource(ElementType.builder().language(language).value(value).build());
        }
    }
}
