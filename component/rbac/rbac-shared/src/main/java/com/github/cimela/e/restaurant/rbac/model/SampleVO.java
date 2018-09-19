package com.github.cimela.e.restaurant.rbac.model;

import com.github.cimela.e.restaurant.base.model.GenericModelVO;

public class SampleVO extends GenericModelVO<Sample> {

    public SampleVO() {
        super(Sample.class);
    }
    
    public SampleVO(Sample sample, String...excludeAttrs) {
        super(sample, Sample.class, excludeAttrs);
    }
    
}
