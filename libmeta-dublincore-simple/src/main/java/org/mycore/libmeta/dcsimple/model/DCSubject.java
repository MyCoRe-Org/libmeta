package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCSubject {

    public static DCSubjectBuilder builder() {
        return new DCSubjectBuilder();
    }

    public static class DCSubjectBuilder extends DCElementBuilder<DCSubjectBuilder> {
        protected DCSubjectBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createSubject(ElementType.builder().language(language).value(value).build());
        }
    }
}
