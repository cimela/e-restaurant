package java.com.github.cimela.e.restaurant.user.service;

import java.com.github.cimela.e.restaurant.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.service.AbstractComponentService;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.model.User;
import com.github.cimela.e.restaurant.user.service.UserService;

//@Service
public class UserServiceImpl extends AbstractComponentService<UserRequest, BaseResponse> implements UserService {

    protected static final String MSG_SAMPLE_FAILED  = "sample.failed";
    protected static final String MSG_SAMPLE_SUCCESS = "sample.success";
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public String getTarget() {
        return TARGET_USER;
    }

    @Override
    public BaseResponse handle(UserRequest request) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        
        switch (request.getType()) {
        case GET_ALL:
            response.setData(userRepo.findAll());
            break;
        case CREATE:
            registerUser(request);
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

    private void registerUser(UserRequest request) {
        User model = request.getUser().toModel();
        model.setPassword(request.getPassword());
        
        userRepo.insert(request.getUser().toModel());
    }

}
