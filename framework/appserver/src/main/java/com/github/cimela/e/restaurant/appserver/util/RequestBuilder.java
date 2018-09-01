package com.github.cimela.e.restaurant.appserver.util;

import java.net.URI;

import org.springframework.data.domain.PageRequest;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.RequestType;
import com.github.cimela.e.restaurant.base.model.UserRole;

public class RequestBuilder<T extends BaseRequest<?>> {

    private T request;

    public RequestBuilder(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        request = clazz.newInstance();
    }

    public static <T extends BaseRequest<?>> RequestBuilder<T> request(Class<T> clazz)
            throws InstantiationException, IllegalAccessException {
        return new RequestBuilder<T>(clazz);
    }

    public RequestBuilder<T> requestUri(String uri) {
        request.setTarget(RequestUtils.getTarget(uri));
        return this;
    }
    
    public RequestBuilder<T> requestUri(URI uri) {
        request.setTarget(RequestUtils.getTarget(uri.getPath()));
        return this;
    }

    public RequestBuilder<T> requestType(RequestType requestType) {
        request.setType(requestType);
        return this;
    }

    public RequestBuilder<T> userRole(UserRole userRole) {
        request.setUserRole(userRole);
        return this;
    }

    public RequestBuilder<T> pageRequest(PageRequest pageRequest) {
        request.setPageRequest(pageRequest);
        return this;
    }

    public T build() {
        return request;
    }
}