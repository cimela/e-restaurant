package com.github.cimela.e.restaurant.appserver.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.controller.BaseServiceManager;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.service.ComponentService;

@Service
public class ServiceManager extends BaseServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
    
    public  static final String ERR_SERVICE_NOT_FOUND = "err.service.not.found";
    
    public ServiceManager() {
        super();
    }

    public ServiceManager(Collection<ComponentService<?, ?>> services) {
        super(services);
    }

    public <T extends BaseRequest<?>> BaseResponse handle(T request) {
        if (request != null) {
            @SuppressWarnings("unchecked")
            ComponentService<T, BaseResponse> service = serviceReg.get(request.getTarget());
            if (service != null) {
                LOGGER.debug("Perform {} request for {}", request.getType(), request.getTarget());
                BaseResponse response = service.handle(request);
                if(response.isSuccess()) {
                    return response;
                } else {
                    throw new ServerException((MessageObject) response.getData());
                }
            }
            LOGGER.error("Cannot find service for {}", request.getTarget());
        }
        
        throw new ServerException(new MessageObject(ERR_SERVICE_NOT_FOUND));
    }
}
