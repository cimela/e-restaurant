package com.github.cimela.e.restaurant.user.model;

import com.github.cimela.e.restaurant.base.model.GenericModelVO;

public class UserVO extends GenericModelVO<User> {

    public UserVO() {
        super(User.class);
    }
    
    public UserVO(User sample, String...excludeAttrs) {
        super(sample, User.class, excludeAttrs);
    }
    
}
