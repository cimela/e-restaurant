package com.github.cimela.e.restaurant.sample;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cimela.e.restaurant.appserver.controller.BaseController;
import com.github.cimela.e.restaurant.appserver.util.RequestBuilder;
import com.github.cimela.e.restaurant.base.appserver.ListResponse;
import com.github.cimela.e.restaurant.base.appserver.RequestType;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.model.UserVO;
import com.github.cimela.e.restaurant.user.service.UserService;

@RestController
@RequestMapping(BaseController.PREFIX_API + UserService.TARGET_USER)
public class UserController extends BaseController {

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ListResponse<UserVO> findUsers(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        return findAllApi(request, UserRequest.class);
    }
    
    @GetMapping(path="/{username}", produces= MediaType.APPLICATION_JSON_VALUE)
    public UserVO findUser(HttpServletRequest request, @PathVariable String username) throws InstantiationException, IllegalAccessException {
        UserRequest usrReq = RequestBuilder.request(UserRequest.class)
                                           .requestUri(request.getServletPath())
                                           .requestType(RequestType.GET_ONE)
                                           .build();
        UserVO user = new UserVO();
        user.setUsername(username);
        usrReq.setUser(user);
        
        return serviceManager.handle(usrReq);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public MessageObject registerUser(HttpServletRequest request, @RequestBody UserVO user) throws InstantiationException, IllegalAccessException {
        UserRequest usrReq = RequestBuilder.request(UserRequest.class)
                                           .requestUri(request.getServletPath())
                                           .requestType(RequestType.CREATE)
                                           .build();
        usrReq.setUser(user);
        
        return serviceManager.handle(usrReq);
    }
    
    @PutMapping(path="/{username}", consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public MessageObject updateUserInfo(HttpServletRequest request, @PathVariable String username, @RequestBody UserVO user) throws InstantiationException, IllegalAccessException {

        user.setUsername(username);
        
        UserRequest usrReq = RequestBuilder.request(UserRequest.class)
                                           .requestUri(request.getServletPath())
                                           .requestType(RequestType.UPDATE)
                                           .build();
        usrReq.setUser(user);
        
        return serviceManager.handle(usrReq);
    }
    
    @DeleteMapping(path="/{username}", consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public MessageObject deactiveUser(HttpServletRequest request, @PathVariable String username, @RequestBody UserVO user) throws InstantiationException, IllegalAccessException {
        
        user.setUsername(username);
        
        UserRequest usrReq = RequestBuilder.request(UserRequest.class)
                                           .requestUri(request.getServletPath())
                                           .requestType(RequestType.DELETE)
                                           .build();
        usrReq.setUser(user);
        
        return serviceManager.handle(usrReq);
    }
}
