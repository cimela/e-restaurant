package com.github.cimela.e.restaurant.base.appserver;

import com.github.cimela.e.restaurant.base.model.MessageObject;

public class ServerException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -3839182745235174827L;

    private MessageObject messageObject;
    
    public ServerException(MessageObject messageObject) {
        super(messageObject.getMessageCode());
        this.messageObject = messageObject;
    }
    
    public ServerException(MessageObject messageObject, Exception rootCause) {
        super(messageObject.getMessageCode(), rootCause);
        this.messageObject = messageObject;
    }

    public MessageObject getMessageObject() {
        return messageObject;
    }
    
}
