package com.github.cimela.e.restaurant.sample.appserver;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.sample.model.SampleVO;

public class SampleRequest extends BaseRequest {
    
    private SampleVO sample;

    public SampleVO getSample() {
        return sample;
    }

    public void setSample(SampleVO sample) {
        this.sample = sample;
    }
    
    
}
