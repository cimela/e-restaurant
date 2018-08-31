package com.github.cimela.e.restaurant.appserver.exception;

import org.springframework.http.HttpStatus;

import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.model.MessageObject;

public class DetailedException extends ServerException {

    /**
     * 
     */
    private static final long serialVersionUID = -4145359734961199954L;
    
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public DetailedException(MessageObject messageObject, HttpStatus status) {
        super(messageObject);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
