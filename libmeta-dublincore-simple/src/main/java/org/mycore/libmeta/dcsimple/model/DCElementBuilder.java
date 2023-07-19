package org.mycore.libmeta.dcsimple.model;

import jakarta.xml.bind.JAXBElement;

public abstract class DCElementBuilder<B> {
    protected final ObjectFactory dcObjectFactory;
    protected String language;
    protected String value;

    protected DCElementBuilder() {
        this.dcObjectFactory = new ObjectFactory();
    }

    public B language(String language) {
        this.language = language;
        return _self();
    }

    public B value(String value) {
        this.value = value;
        return _self();
    }

    public abstract JAXBElement<ElementType> build();

    @SuppressWarnings("unchecked")
    public B _self() {
        return (B) this;
    }
}
