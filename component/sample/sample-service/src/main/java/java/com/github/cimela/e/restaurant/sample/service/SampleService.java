package java.com.github.cimela.e.restaurant.sample.service;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.service.AbstractComponentService;
import com.github.cimela.e.restaurant.sample.appserver.SampleRequest;
import com.github.cimela.e.restaurant.sample.model.SampleVO;

public class SampleService extends AbstractComponentService<SampleRequest, BaseResponse> {

    protected static final String TARGET_SAMPLE = "sample";
    protected static final String MSG_SAMPLE_FAILED  = "sample.failed";
    protected static final String MSG_SAMPLE_SUCCESS = "sample.success";
    
    @Override
    public String getTarget() {
        return TARGET_SAMPLE;
    }

    @Override
    public BaseResponse handle(SampleRequest request) {
        BaseResponse response = new BaseResponse();
        switch (request.getType()) {
        case CREATE:
            response.setSuccess(true);
            response.setData(new SampleVO());
            break;
        case UPDATE:
        default:
            if(request.getSample() != null) {
                response.setSuccess(true);
                response.setData(new MessageObject(MSG_SAMPLE_SUCCESS));
            } else {
                response.setSuccess(false);
                response.setData(new MessageObject(MSG_SAMPLE_FAILED));
            }
            break;

        }
        return response;
    }

}
