package com.github.cimela.e.restaurant.base.model;

/**
 * Base object used in server-client communication
 * 
 * @author Quyen Phan
 *
 * @param <T> database model
 */
public class GenericModelVO<T extends GenericModel<?>> {

    protected Class<T> modelClzz;

    public GenericModelVO(T model, Class<T> modelClzz, String... excludeAttrs) {
        this(modelClzz);
        ModelUtils.copyProperties(model, this, excludeAttrs);
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
