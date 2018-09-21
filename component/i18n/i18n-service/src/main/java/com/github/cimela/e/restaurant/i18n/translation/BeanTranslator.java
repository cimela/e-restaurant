package com.github.cimela.e.restaurant.i18n.translation;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BeanTranslator extends AbstractTranslator<Object> {

    public static final String NAME = "Bean";
    
    @Override
    public Map<String, Object> translate(Object object) {
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
