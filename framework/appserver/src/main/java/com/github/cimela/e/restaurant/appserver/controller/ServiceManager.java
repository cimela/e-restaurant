package com.github.cimela.e.restaurant.appserver.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.controller.BaseServiceManager;
import com.github.cimela.e.restaurant.base.service.ComponentService;

@Service
public class ServiceManager extends BaseServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
    
    public ServiceManager() {
        super();
    }

    public ServiceManager(Collection<ComponentService<?, ?>> services) {
        super(services);
    }

    public <T extends BaseRequest> ResponseEntity<Object> handle(T request) {
        if (request != null) {
            @SuppressWarnings("unchecked")
            ComponentService<T, BaseResponse> service = serviceReg.get(request.getTarget());
            if (service != null) {
                LOGGER.debug("Perform {} request for {}", request.getType(), request.getTarget());
                BaseResponse response = service.handle(request);
                return new ResponseEntity<Object>(response, response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
            }
            LOGGER.error("Cannot find service for {}", request.getTarget());
        }
        
        return new ResponseEntity<Object>("Service not found", HttpStatus.BAD_REQUEST);
    }
}
