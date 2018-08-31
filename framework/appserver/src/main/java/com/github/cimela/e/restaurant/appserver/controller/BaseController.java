package com.github.cimela.e.restaurant.appserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.RequestType;

public abstract class BaseController {
    
    @Autowired
    protected ServiceManager serviceManager;

    protected <T extends BaseRequest> BaseResponse findAllApi(HttpRequest request, Class<T> requestClass)
            throws InstantiationException, IllegalAccessException {
        T serviceRequest = RequestBuilder.request(requestClass)
                                         .requestUri(request.getURI())
                                         .requestType(RequestType.GET_ALL).build();
        return serviceManager.handle(serviceRequest);
    }

}
