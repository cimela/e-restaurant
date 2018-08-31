package com.github.cimela.e.restaurant.base.service;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;

public interface ComponentService<T extends BaseRequest, R extends BaseResponse> {
    
    String getTarget();
    R handle(T request);
    
}
