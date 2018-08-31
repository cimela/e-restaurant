package com.github.cimela.e.restaurant.sample.service;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.service.ComponentService;
import com.github.cimela.e.restaurant.sample.appserver.SampleRequest;

public interface SampleService extends ComponentService<SampleRequest, BaseResponse> {
    static final String TARGET_SAMPLE = "sample";
}
