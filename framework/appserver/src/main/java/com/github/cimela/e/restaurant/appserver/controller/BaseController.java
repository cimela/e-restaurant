package com.github.cimela.e.restaurant.appserver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.appserver.util.RequestUtils;
import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.RequestType;

public abstract class BaseController {
    
    @Autowired
    protected ServiceManager serviceManager;

    protected <T extends BaseRequest> ResponseEntity<Object> findAllApi(HttpServletRequest request, HttpServletResponse response, Class<T> requestClass)
            throws InstantiationException, IllegalAccessException {
        T serviceRequest = RequestBuilder.request(requestClass)
                                         .requestUri(RequestUtils.getTarget(request.getRequestURI()))
                                         .requestType(RequestType.GET_ALL).build();
        return serviceManager.handle(serviceRequest);
    }

    ResponseEntity<Object> sampleApi(HttpServletRequest request, HttpServletResponse response, @RequestBody Object object)
            throws InstantiationException, IllegalAccessException {
        SampleRequest sampleRequest = RequestBuilder.request(SampleRequest.class)
                                                    .requestUri(RequestUtils.getTarget(request.getRequestURI()))
                                                    .requestType(RequestType.GET_ALL).build();
        sampleRequest.setBody(object);
        return serviceManager.handle(sampleRequest);
    }

    private class SampleRequest extends BaseRequest {

        private Object body;

        @SuppressWarnings("unused")
        public Object getBody() {
            return body;
        }

        public void setBody(Object body) {
            this.body = body;
        }

    }
}
