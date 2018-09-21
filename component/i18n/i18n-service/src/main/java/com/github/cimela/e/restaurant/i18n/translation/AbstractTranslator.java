package com.github.cimela.e.restaurant.i18n.translation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.cimela.e.restaurant.i18n.registry.TranslatorFactory;

public abstract class AbstractTranslator<T> implements Translator<T> {

    @Autowired
    protected TranslatorFactory translatorFactory;
    
    @PostConstruct
    public void init() {
        translatorFactory.register(this);
    }
    
}
