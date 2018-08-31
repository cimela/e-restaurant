package com.github.cimela.e.restaurant.sample.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cimela.e.restaurant.appserver.controller.BaseController;
import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.RequestType;
import com.github.cimela.e.restaurant.sample.appserver.SampleRequest;
import com.github.cimela.e.restaurant.sample.service.SampleService;

@RestController
@RequestMapping(SampleService.TARGET_SAMPLE)
public class SampleController extends BaseController {

    @GetMapping(path="/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse findSample(HttpRequest request) throws InstantiationException, IllegalAccessException {
        SampleRequest sampleReq = RequestBuilder.request(SampleRequest.class)
                                              .requestType(RequestType.GET_ONE)
                                              .requestUri(request.getURI())
                                              .build();
        return serviceManager.handle(sampleReq);
    }
    
}
