package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCContributor {

    public static DCContributorBuilder builder() {
        return new DCContributorBuilder();
    }

    public static class DCContributorBuilder extends DCElementBuilder<DCContributorBuilder> {
        protected DCContributorBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createContributor(ElementType.builder().language(language).value(value).build());
        }
    }
}
