package com.github.cimela.e.restaurant.user.appserver;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.user.model.UserVO;

public class UserRequest extends BaseRequest<ObjectId> {
    
    private UserVO user;
    private String password;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
