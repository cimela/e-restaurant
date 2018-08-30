package com.github.cimela.e.restaurant.base.appserver;

public class BaseResponse {
    
    private boolean success = true;
    private Object  data;
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
