package com.github.cimela.e.restaurant.base.controller;

import java.util.Arrays;
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
            LOGGER.info("Register target for {}", String.valueOf(service.getTargets()));
            Arrays.stream(service.getTargets()).forEach(target -> serviceReg.put(target, service));
        }
    }

    public void register(ComponentService<?, ?> service) {
        LOGGER.info("Register {} services", service.getTargets().length);
        Arrays.stream(service.getTargets()).forEach(target -> serviceReg.put(target, service));
    }
}
