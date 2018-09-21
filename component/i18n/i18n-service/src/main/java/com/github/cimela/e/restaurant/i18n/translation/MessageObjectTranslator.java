package com.github.cimela.e.restaurant.i18n.translation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.cimela.e.restaurant.base.model.MessageObject;

@Component
public class MessageObjectTranslator extends AbstractTranslator<MessageObject> {

    public static final String NAME = "Bean";
    
    @Override
    public Map<String, Object> translate(MessageObject object) {
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
