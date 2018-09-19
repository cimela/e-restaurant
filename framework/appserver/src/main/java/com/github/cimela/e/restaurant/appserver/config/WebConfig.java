package com.github.cimela.e.restaurant.appserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="web")
public class WebConfig {

    private int  corePoolSize;
    private int  maximumPoolSize;
    private long keepAliveTime;
    public int getCorePoolSize() {
        return corePoolSize;
    }
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }
    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }
    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }
    public long getKeepAliveTime() {
        return keepAliveTime;
    }
    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

}
