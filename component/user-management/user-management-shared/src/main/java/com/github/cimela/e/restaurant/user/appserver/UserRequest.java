package com.github.cimela.e.restaurant.user.appserver;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.user.model.UserVO;

public class UserRequest extends BaseRequest {
    
    private UserVO sample;

    public UserVO getSample() {
        return sample;
    }

    public void setSample(UserVO sample) {
        this.sample = sample;
    }
    
    
}
