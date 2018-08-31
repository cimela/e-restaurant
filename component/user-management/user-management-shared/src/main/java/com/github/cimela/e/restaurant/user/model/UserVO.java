package com.github.cimela.e.restaurant.user.model;

import com.github.cimela.e.restaurant.base.model.GenericModelVO;

public class UserVO extends GenericModelVO<User> {

    private String username;
    
    public UserVO() {
        super(User.class);
    }
    
    public UserVO(User sample, String...excludeAttrs) {
        super(sample, User.class, excludeAttrs);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
