package com.github.cimela.e.restaurant.i18n.translation;

import java.util.Map;

import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class MapTranslator extends AbstractTranslator<Map> {

    public static final String NAME = "Map";
    
    @Override
    public Map<String, Object> translate(Map object) {
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
