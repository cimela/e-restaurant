package com.github.cimela.e.restaurant.i18n.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="i18n")
public class I18nConfig {
    
    private Map<String, String> translatorMappings;

    public Map<String, String> getTranslatorMappings() {
        return translatorMappings;
    }

    public void setTranslatorMappings(Map<String, String> translatorMappings) {
        this.translatorMappings = translatorMappings;
    }
}
