package com.github.cimela.e.restaurant.base.service;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.common.Item;

public interface ComponentService<T extends BaseRequest<?>, R extends BaseResponse> extends Item {
    
    R handle(T request);
    
}
