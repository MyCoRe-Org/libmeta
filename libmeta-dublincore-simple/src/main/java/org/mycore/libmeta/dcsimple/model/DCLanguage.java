package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public class DCLanguage {

    public static DCLanguageBuilder builder() {
        return new DCLanguageBuilder();
    }

    public static class DCLanguageBuilder extends DCElementBuilder<DCLanguageBuilder> {
        protected DCLanguageBuilder() {
            super();
        }

        public JAXBElement<ElementType> build() {
            return dcObjectFactory.createLanguage(ElementType.builder().language(language).value(value).build());
        }
    }
}
