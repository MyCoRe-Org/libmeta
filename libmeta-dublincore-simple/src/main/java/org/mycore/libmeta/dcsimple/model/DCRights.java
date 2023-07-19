package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCRights {

    public static DCRightsBuilder builder() {
        return new DCRightsBuilder();
    }

    public static class DCRightsBuilder extends DCElementBuilder<DCRightsBuilder> {
        protected DCRightsBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createRights(ElementType.builder().language(language).value(value).build());
        }
    }
}
