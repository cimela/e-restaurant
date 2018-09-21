package com.github.cimela.e.restaurant.i18n.service;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.service.ComponentService;
import com.github.cimela.e.restaurant.i18n.appserver.SampleRequest;

public interface SampleService extends ComponentService<SampleRequest, BaseResponse> {
    static final String TARGET_SAMPLE = "sample";
}
