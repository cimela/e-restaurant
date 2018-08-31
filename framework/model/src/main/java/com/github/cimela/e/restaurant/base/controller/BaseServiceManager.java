package com.github.cimela.e.restaurant.base.controller;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.cimela.e.restaurant.base.service.ComponentService;

public abstract class BaseServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceManager.class);

    @SuppressWarnings("rawtypes")
    protected Map<String, ComponentService> serviceReg = new TreeMap<>();

    public BaseServiceManager() {
        super();
    }

    public BaseServiceManager(Collection<ComponentService<?, ?>> services) {
        for (ComponentService<?, ?> service : services) {
            LOGGER.info("Register service for {}", service.getTarget());
            serviceReg.put(service.getTarget(), service);
        }
    }

    public void register(ComponentService<?, ?> service) {
        LOGGER.info("Register service for {}", service.getTarget());
        serviceReg.put(service.getTarget(), service);
    }
}
