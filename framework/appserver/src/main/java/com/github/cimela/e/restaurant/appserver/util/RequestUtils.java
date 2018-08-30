package com.github.cimela.e.restaurant.appserver.util;

import org.apache.commons.lang3.StringUtils;

public class RequestUtils {
    private static final String SERVER_API_PREFIX = "api";
    private static final String SERVER_PUBLIC_API_PREFIX = "public";
    
    /**
     * Get the service name from the uri
     * The pattern must be api/{service}/...
     * 
     * @param uri
     * @return
     */
    public static String getTarget(String uri) {
        if(StringUtils.isNotBlank(uri)) {
            String[] parts = uri.split("/");
            for (int i = 0; i < parts.length; i++) {
                // the part after 'api' is the service name
                if(SERVER_API_PREFIX.equals(parts[i]) && (++i) < parts.length) {
                    if(SERVER_PUBLIC_API_PREFIX.equals(parts[i])) {
                        return parts[i + 1];
                    } else {
                        return parts[i];
                    }
                }
            }
        }
        throw new RuntimeException("Invalid URL: " + uri);
    }
    
}
