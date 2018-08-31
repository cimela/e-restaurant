package com.github.cimela.e.restaurant.base.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * This object represent the message
 * 
 * @author Quyen Phan
 *
 */
public class MessageObject {

    private String messageCode;
    private List<Object> params;

    public MessageObject(String messageCode, Object... params) {
        this.messageCode = messageCode;
        this.params = ArrayUtils.isEmpty(params) ? new LinkedList<>() : Arrays.asList(params);
    }

    public String getMessageCode() {
        return messageCode;
    }

    public Object[] getParams() {
        return params.toArray();
    }

    public MessageObject addParam(Object param) {
        params.add(param);
        return this;
    }
    
}
