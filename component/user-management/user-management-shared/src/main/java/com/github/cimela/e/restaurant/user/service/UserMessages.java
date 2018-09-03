package com.github.cimela.e.restaurant.user.service;

import com.github.cimela.e.restaurant.base.service.CommonMessages;

public interface UserMessages extends CommonMessages {
    
    static final String ERR_INSERT_FAILED              = "user.insert.failed";
    static final String ERR_INSERT_USERNAME_DUPLICATED = "user.insert.username.duplicated";
    static final String ERR_UPDATE_FAILED              = "user.update.failed";
    static final String ERR_DELETE_FAILED              = "user.delete.failed";
    
    static final String MSG_INSERT_SUCCESS = "user.insert.success";
    static final String MSG_UPDATE_SUCCESS = "user.update.success";
    static final String MSG_DELETE_SUCCESS = "user.delete.success";
}
