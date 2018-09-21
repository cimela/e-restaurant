package com.github.cimela.e.restaurant.i18n.translation;

public class DummyTranslator implements Translator<Object> {

    @Override
    public Object translate(Object object) {
        return object;
    }

    @Override
    public String getName() {
        return null;
    }

}
