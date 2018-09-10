package com.github.cimela.e.restaurant.user.service;

import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.model.Status;
import com.github.cimela.e.restaurant.base.service.AbstractComponentService;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.model.User;
import com.github.cimela.e.restaurant.user.model.UserVO;
import com.github.cimela.e.restaurant.user.repository.UserRepository;

@Service
public class UserServiceImpl extends AbstractComponentService<UserRequest, BaseResponse> implements UserService, UserMessages {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public String getTarget() {
        return TARGET_USER;
    }

    @Override
    public BaseResponse handle(UserRequest request) {
        
        LOGGER.info("Receive {} request for user", request.getTarget());
        switch (request.getType()) {
        case GET_ALL:
            return findAllUsers(request);
        case GET_ONE:
            return findUser(request);
        case CREATE:
            return registerUser(request);
        case UPDATE:
            return updateUserInfo(request);
        case DELETE:
            return deactiveUser(request);
        default:
            break;
        }
        throw new ServerException(new MessageObject(ERR_ACTION_NOT_SUPPORT));
    }

    private BaseResponse findAllUsers(UserRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(userRepo.findAllUsers().stream()
                                                .map(user -> new UserVO(user))
                                                .collect(Collectors.toList()));
        return response;
    }

    private BaseResponse findUser(UserRequest request) {
        BaseResponse response = new BaseResponse();
        User user = userRepo.findByUsername(request.getUser().getUsername());
        if(user != null) {
            response.setData(new UserVO(user));
        } else {
            throw new ServerException(new MessageObject(ERR_USERNAME_NOT_FOUND, request.getUser().getUsername()));
        }
        return response;
    }

    private BaseResponse deactiveUser(UserRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(new MessageObject(MSG_UPDATE_SUCCESS));
        
        try {
            String username = request.getUser().getUsername();
            if(userRepo.updateUserStatus(username, Status.DEACTIVE) < 1) {
                throw new ServerException(new MessageObject(ERR_USER_NOT_FOUND));
            }
        } catch(Exception e) {
            throw new ServerException(new MessageObject(ERR_DELETE_FAILED), e);
        }
        
        return response;
    }

    private BaseResponse updateUserInfo(UserRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(new MessageObject(MSG_UPDATE_SUCCESS));
        
        try {
            User model = request.getUser().toModel();
            model.setUpdateDate(new Date());
            
            if(userRepo.update(model) < 1) {
                throw new ServerException(new MessageObject(ERR_USER_NOT_FOUND));
            }
            
        } catch (ServerException e) {
            throw e;
        } catch(Exception e) {
            throw new ServerException(new MessageObject(ERR_UPDATE_FAILED), e);
        }
        
        return response;
    }

    private BaseResponse registerUser(UserRequest request) {
        BaseResponse response = new BaseResponse();
        
        try {
            User model = request.getUser().toModel();
            model.setCreateDate(new Date());
            
            userRepo.insert(model);
            response.setData(new MessageObject(MSG_INSERT_SUCCESS, model.getId()));
        } catch(DuplicateKeyException e) {
            throw new ServerException(new MessageObject(ERR_INSERT_USERNAME_DUPLICATED), e);
        } catch(Exception e) {
            throw new ServerException(new MessageObject(ERR_INSERT_FAILED), e);
        }
        
        return response;
    }

}
