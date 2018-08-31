package com.github.cimela.e.restaurant.base.model;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Base object used in server-client communication
 * 
 * @author Quyen Phan
 *
 * @param <T> database model
 */
public class GenericModelVO<T extends GenericModel<?>> {

    protected Class<T> modelClzz;
    protected String   id;

    public GenericModelVO(T model, Class<T> modelClzz, String... excludeAttrs) {
        this(modelClzz);
        if(!ArrayUtils.contains(excludeAttrs, GenericModel.ATTR_ID_VALUE)) {
            excludeAttrs = (String[]) ArrayUtils.add(excludeAttrs, new String[] {GenericModel.ATTR_ID_VALUE});
            ModelUtils.copyProperties(model, this, excludeAttrs);
            
            this.id = String.valueOf(model.getId());
        } else {
            ModelUtils.copyProperties(model, this, excludeAttrs);
        }
    }

    protected GenericModelVO(Class<T> modelClzz) {
        this.modelClzz = modelClzz;
    }

    public T toModel() {
        return ModelUtils.getInstance(this, modelClzz);
    }

    protected T toModel(String... exclude) {
        return ModelUtils.getInstance(this, modelClzz, exclude);
    }
}
