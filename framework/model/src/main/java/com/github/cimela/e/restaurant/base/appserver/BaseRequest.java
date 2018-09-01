package com.github.cimela.e.restaurant.base.appserver;

import java.io.Serializable;

import org.springframework.data.domain.PageRequest;

import com.github.cimela.e.restaurant.base.model.UserRole;

public class BaseRequest<T extends Serializable> {

    private String target;
    private RequestType type;
    private UserRole userRole;
    private PageRequest pageRequest;
    private T currentUserId;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public T getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(T currentUserId) {
        this.currentUserId = currentUserId;
    }
    

}
