package com.github.cimela.e.restaurant.i18n.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.github.cimela.e.restaurant.appserver.controller.BaseController;
import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.base.appserver.RequestType;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.i18n.appserver.SampleRequest;
import com.github.cimela.e.restaurant.i18n.model.SampleVO;
import com.github.cimela.e.restaurant.i18n.service.SampleService;

@RestController
@RequestMapping(BaseController.PREFIX_API + SampleService.TARGET_SAMPLE)
public class SampleController extends BaseController {

    @GetMapping(path="/{name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public SampleVO findSample(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        SampleRequest sampleReq = RequestBuilder.request(SampleRequest.class)
                                                .requestType(RequestType.GET_ONE)
                                                .requestUri(request.getServletPath())
                                                .build();
        return serviceManager.handle(sampleReq);
    }
    
    @PostMapping(path="/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public WebAsyncTask<MessageObject> asyncRequest(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        SampleRequest sampleReq = RequestBuilder.request(SampleRequest.class)
                                                .requestType(RequestType.UPDATE)
                                                .requestUri(request.getServletPath())
                                                .build();
        return serviceManager.asyncHandle(sampleReq);
    }
}
