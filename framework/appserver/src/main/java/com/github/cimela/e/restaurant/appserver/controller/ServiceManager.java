package com.github.cimela.e.restaurant.appserver.controller;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.github.cimela.e.restaurant.appserver.config.WebConfig;
import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.controller.BaseServiceManager;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.service.CommonMessages;
import com.github.cimela.e.restaurant.base.service.ComponentService;

@Service
public class ServiceManager extends BaseServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
    
    @Autowired
    private WebConfig webConfig;
    
    @SuppressWarnings("unused")
    private ExecutorService SERVICE_THREAD_POOL;
    
    public ServiceManager() {
        super();
    }

    public ServiceManager(Collection<ComponentService<?, ?>> services) {
        super(services);
    }

    @PostConstruct
    public void init() {
        SERVICE_THREAD_POOL = new ThreadPoolExecutor(webConfig.getCorePoolSize(), webConfig.getMaximumPoolSize(), webConfig.getKeepAliveTime(), TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseRequest<?>, R> R handle(T request) {
        if (request != null) {
            ComponentService<T, BaseResponse> service = serviceReg.get(request.getTarget());
            if (service != null) {
                LOGGER.debug("Perform {} request for {}", request.getType(), request.getTarget());
                BaseResponse response = service.handle(request);
                if (response.isSuccess()) {
                    return (R) response.getData();
                } else {
                    throw new ServerException((MessageObject) response.getData());
                }
                
            }
            LOGGER.error("Cannot find service for {}", request.getTarget());
        }
        
        throw new ServerException(new MessageObject(CommonMessages.ERR_SERVICE_NOT_FOUND));
    }
    
    @SuppressWarnings("unchecked")
    public <T extends BaseRequest<?>, R> WebAsyncTask<R> asyncHandle(T request) {
        if (request != null) {
            ComponentService<T, BaseResponse> service = serviceReg.get(request.getTarget());
            if (service != null) {
                LOGGER.debug("Perform {} request for {}", request.getType(), request.getTarget());
                return new WebAsyncTask<R>(webConfig.getKeepAliveTime() * 60 * 1000, new ServiceCallable<T, R>(service, request));
            }
            LOGGER.error("Cannot find service for {}", request.getTarget());
        }
        
        throw new ServerException(new MessageObject(CommonMessages.ERR_SERVICE_NOT_FOUND));
    }
    
    private class ServiceCallable<T extends BaseRequest<?>, R> implements Callable<R> {

        private ComponentService<T, BaseResponse> service;
        private T request;
        
        public ServiceCallable(ComponentService<T, BaseResponse> service, T request) {
            super();
            this.service = service;
            this.request = request;
        }

        @SuppressWarnings("unchecked")
        @Override
        public R call() throws Exception {
            BaseResponse response = service.handle(request);
            if (response.isSuccess()) {
                return (R) response.getData();
            } else {
                throw new ServerException((MessageObject) response.getData());
            }
        }
        
    }
}
