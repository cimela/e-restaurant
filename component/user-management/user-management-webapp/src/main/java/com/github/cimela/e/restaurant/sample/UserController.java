package com.github.cimela.e.restaurant.sample;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cimela.e.restaurant.appserver.controller.BaseController;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.service.UserService;

@RestController
@RequestMapping(BaseController.PREFIX_API + UserService.TARGET_USER)
public class UserController extends BaseController {

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse findSample(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        return findAllApi(request, UserRequest.class);
    }
    
}
