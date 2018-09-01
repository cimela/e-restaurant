package com.github.cimela.e.restaurant.sample.appserver;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.sample.model.SampleVO;

public class SampleRequest extends BaseRequest<ObjectId> {
    
    private SampleVO sample;

    public SampleVO getSample() {
        return sample;
    }

    public void setSample(SampleVO sample) {
        this.sample = sample;
    }
    
    
}
