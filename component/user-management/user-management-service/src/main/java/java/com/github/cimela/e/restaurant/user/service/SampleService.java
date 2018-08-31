package java.com.github.cimela.e.restaurant.user.service;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.service.AbstractComponentService;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.model.UserVO;
import com.github.cimela.e.restaurant.user.service.UserService;

public class UserServiceImpl extends AbstractComponentService<UserRequest, BaseResponse> implements UserService {

    protected static final String MSG_SAMPLE_FAILED  = "sample.failed";
    protected static final String MSG_SAMPLE_SUCCESS = "sample.success";
    
    @Override
    public String getTarget() {
        return TARGET_USER;
    }

    @Override
    public BaseResponse handle(UserRequest request) {
        BaseResponse response = new BaseResponse();
        switch (request.getType()) {
        case CREATE:
            response.setSuccess(true);
            response.setData(new UserVO());
            break;
        case UPDATE:
        default:
            if(request.getUser() != null) {
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
