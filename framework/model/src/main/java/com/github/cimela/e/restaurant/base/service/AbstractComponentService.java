package com.github.cimela.e.restaurant.base.service;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.controller.BaseServiceManager;

public abstract class AbstractComponentService<T extends BaseRequest, R extends BaseResponse> implements ComponentService<T, R> {
    
    public static final int      DEFAULT_POOL_SIZE  = 5;
    public static final int      DEFAULT_QUEUE_SIZE = 300;
    public static final long     DEFAULT_TIME_ALIVE = 15L;
    public static final TimeUnit DEFAULT_TIME_ALIVE_UNIT = TimeUnit.MINUTES;
    
    protected Executor executor;
    
    @Autowired
    private BaseServiceManager serviceManager;
    
    @PostConstruct
    public void init() {
        serviceManager.register(this);
        executor = new ThreadPoolExecutor(DEFAULT_POOL_SIZE, DEFAULT_QUEUE_SIZE, DEFAULT_TIME_ALIVE, DEFAULT_TIME_ALIVE_UNIT, new LinkedBlockingQueue<Runnable>(DEFAULT_QUEUE_SIZE)); 
    }
    
}
