package com.github.cimela.e.restaurant.appserver.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.cimela.e.restaurant.base.model.MessageObject;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DetailedExceptionAdvice {
    
    @ExceptionHandler(DetailedException.class)
    public ResponseEntity<MessageObject> defaultHandler(DetailedException exception) {
        return new ResponseEntity<MessageObject>(exception.getMessageObject(), exception.getStatus());
    }
}
