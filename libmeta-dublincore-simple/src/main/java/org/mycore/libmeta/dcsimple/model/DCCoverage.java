package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCCoverage {

    public static DCCoverageBuilder builder() {
        return new DCCoverageBuilder();
    }

    public static class DCCoverageBuilder extends DCElementBuilder<DCCoverageBuilder> {
        protected DCCoverageBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createCoverage(ElementType.builder().language(language).value(value).build());
        }
    }
}
