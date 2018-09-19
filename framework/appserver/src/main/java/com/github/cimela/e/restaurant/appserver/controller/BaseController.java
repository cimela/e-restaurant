package com.github.cimela.e.restaurant.appserver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.ListResponse;
import com.github.cimela.e.restaurant.base.appserver.RequestType;

public abstract class BaseController {
    
    public static final String PREFIX_API = "api/";
    
    @Autowired
    protected ServiceManager serviceManager;

    protected <T extends BaseRequest<?>, R extends ListResponse<?>> R findAllApi(HttpServletRequest request, Class<T> requestClass)
            throws InstantiationException, IllegalAccessException {
        T serviceRequest = RequestBuilder.request(requestClass)
                                         .requestUri(request.getServletPath())
                                         .requestType(RequestType.GET_ALL).build();
        return serviceManager.handle(serviceRequest);
    }

}
