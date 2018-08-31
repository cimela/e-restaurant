package com.github.cimela.e.restaurant.user.appserver;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.user.model.UserVO;

public class UserRequest extends BaseRequest {
    
    private UserVO user;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

}
