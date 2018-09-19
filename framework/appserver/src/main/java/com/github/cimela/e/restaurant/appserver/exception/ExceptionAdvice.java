package com.github.cimela.e.restaurant.appserver.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.model.MessageObject;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionAdvice {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);
    
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<MessageObject> defaultHandler(ServerException exception) {
        LOGGER.error("Error occurs", exception);
        return new ResponseEntity<MessageObject>(exception.getMessageObject(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
