package com.github.cimela.e.restaurant.i18n.translation;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CollectionTranslator extends AbstractTranslator<Collection<?>> {

    public static final String NAME = "Collection";
    
    @Override
    public Map<String, Object> translate(Collection<?> object) {
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
