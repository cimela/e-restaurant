package com.github.cimela.e.restaurant.base.controller;

import java.util.Collection;

import com.github.cimela.e.restaurant.base.common.AbstractRegistry;
import com.github.cimela.e.restaurant.base.service.ComponentService;

@SuppressWarnings("rawtypes")
public abstract class BaseServiceManager extends AbstractRegistry<ComponentService>{

    public BaseServiceManager() {
        super();
    }

    public BaseServiceManager(Collection<ComponentService> services) {
        super(services);
    }

}
