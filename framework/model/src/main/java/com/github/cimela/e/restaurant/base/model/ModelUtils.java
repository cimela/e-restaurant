package com.github.cimela.e.restaurant.base.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 * Convert objects with similar properties
 * 
 * @author Quyen Phan
 *
 */
public class ModelUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelUtils.class);
	
	public static final <T, R> R getInstance(T input, Class<R> output, String... excludeAttrs) {

        try {
            R toObj = output.newInstance();

            BeanUtils.copyProperties(input, toObj, excludeAttrs);

            return toObj;
        } catch (IllegalAccessException | InstantiationException | BeansException e) {
            LOGGER.error("Cannot clone the object", e);
        }
        return null;
    }
    
    public static final <T,R> void copyProperties(T source, R target, String... excludeAttrs) {
        BeanUtils.copyProperties(source, target, excludeAttrs);
    }
}
