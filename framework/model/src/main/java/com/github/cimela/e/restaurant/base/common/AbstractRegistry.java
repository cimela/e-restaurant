package com.github.cimela.e.restaurant.base.common;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractRegistry<T extends Item> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRegistry.class);
    
    protected Map<String, T> registry = new TreeMap<>();
    
    public AbstractRegistry() {
    }
    
    public AbstractRegistry(Collection<T> items) {
        for (T item : items) {
            LOGGER.info("Register {} at {}", item.getName(), this.getClass().getSimpleName());
            registry.put(item.getName(), item);
        }
    }
    
    public void register(T item) {
        LOGGER.info("Register {} at {}", item.getName(), this.getClass().getSimpleName());
        registry.put(item.getName(), item);
    }
}
