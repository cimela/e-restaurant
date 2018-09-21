package com.github.cimela.e.restaurant.i18n.appserver;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.appserver.BaseRequest;
import com.github.cimela.e.restaurant.i18n.model.SampleVO;

public class SampleRequest extends BaseRequest<ObjectId> {
    
    private SampleVO sample;

    public SampleVO getSample() {
        return sample;
    }

    public void setSample(SampleVO sample) {
        this.sample = sample;
    }
    
    
}
