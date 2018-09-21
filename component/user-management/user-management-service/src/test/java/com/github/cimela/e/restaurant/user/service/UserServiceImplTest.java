package com.github.cimela.e.restaurant.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.dao.DuplicateKeyException;

import com.github.cimela.e.restaurant.base.appserver.BaseResponse;
import com.github.cimela.e.restaurant.base.appserver.ListResponse;
import com.github.cimela.e.restaurant.base.appserver.RequestType;
import com.github.cimela.e.restaurant.base.appserver.ServerException;
import com.github.cimela.e.restaurant.base.model.MessageObject;
import com.github.cimela.e.restaurant.base.model.Status;
import com.github.cimela.e.restaurant.user.appserver.UserRequest;
import com.github.cimela.e.restaurant.user.model.User;
import com.github.cimela.e.restaurant.user.model.UserVO;
import com.github.cimela.e.restaurant.user.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String TARGET = "users";
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Mock
    private UserRepository userRepo;
    
    @InjectMocks
    private UserServiceImpl userService;
    
    private UserRequest request;
    
    @Before
    public void prepareRequest() {
        request = new UserRequest();
        request.setTarget(TARGET);
    }
    
    @Test
    public void testGetTarget() {
        String target = userService.getName();
        assertEquals(target, TARGET);
    }
    
    @Test
    public void testNotSupport() {
        List<RequestType> notSupport = Arrays.asList(RequestType.DOWNLOAD,
                                                     RequestType.UPLOAD,
                                                     RequestType.EXECUTE);
        notSupport.forEach(x -> {
            try {
                request.setType(x);
                userService.handle(request);
                fail("Support " + x + " request");
            } catch (ServerException e) {
                assertEquals(e.getMessage(), UserMessages.ERR_ACTION_NOT_SUPPORT);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testGetAll() {
        List<User> userList = new ArrayList<>();
        
        User user = new User();
        user.setUsername("John");
        userList.add(user);
        
        user = new User();
        user.setUsername("Jimmy");
        userList.add(user);

        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setData(userList);
        
        request.setType(RequestType.GET_ALL);
        
        Mockito.when(userRepo.findAllUsers()).thenReturn(userList);
        
        BaseResponse actualResponse       = userService.handle(request);
        ListResponse<UserVO> listResponse = (ListResponse<UserVO>) actualResponse.getData();
        List<UserVO> actualUserList       = listResponse.getData();
        
        assertEquals(response.isSuccess(), actualResponse.isSuccess());
        assertEquals(userList.size(), actualUserList.size());
        for (int i = 0; i < actualUserList.size(); i++) {
            UserVO actualUsr = actualUserList.get(i);
            User usr = userList.get(i);
            assertEquals(usr.getUsername(), actualUsr.getUsername());
        }
        
        Mockito.verify(userRepo, Mockito.times(1)).findAllUsers();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testGetAll_Empty() {
        List<User> userList = new ArrayList<>();
        
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setData(userList);
        
        request.setType(RequestType.GET_ALL);
        
        Mockito.when(userRepo.findAllUsers()).thenReturn(userList);
        
        BaseResponse actualResponse       = userService.handle(request);
        ListResponse<UserVO> listResponse = (ListResponse<UserVO>) actualResponse.getData();
        List<UserVO> actualUserList       = listResponse.getData();
        
        assertEquals(response.isSuccess(), actualResponse.isSuccess());
        assertEquals(userList.size(), actualUserList.size());
        
        Mockito.verify(userRepo, Mockito.times(1)).findAllUsers();
    }
    
    @Test
    public void testGetUser() {
        String username = "John";
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.GET_ONE);
        request.setUser(userVO);
        
        Mockito.when(userRepo.findByUsername(username)).thenReturn(userVO.toModel());
        
        BaseResponse actualResponse = userService.handle(request);
        UserVO actualUser = (UserVO) actualResponse.getData();
        
        assertTrue(actualResponse.isSuccess());
        assertEquals(username, actualUser.getUsername());
        
        Mockito.verify(userRepo, Mockito.times(1)).findByUsername(username);
    }
    
    @Test
    public void testGetUser_NotFound() {
        String username = "John";
        exceptionRule.expect(ServerException.class);
        exceptionRule.expectMessage(UserMessages.ERR_USERNAME_NOT_FOUND);

        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.GET_ONE);
        request.setUser(userVO);
        
        userService.handle(request);
    }
    
    @Test
    public void testRegister() {
        String username = "John";
        ObjectId id     = new ObjectId();

        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setData(userVO);

        request.setType(RequestType.CREATE);
        request.setUser(userVO);
        
        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                User user = invocation.getArgument(0);
                user.setId(id);
                return null;
            }
        }).when(userRepo).insert(Mockito.any(User.class));
        
        BaseResponse actualResponse = userService.handle(request);
        
        Mockito.verify(userRepo, Mockito.times(1)).insert(argumentCaptor.capture());
        User user = argumentCaptor.getValue();
        assertEquals(username, user.getUsername());
        
        MessageObject data = (MessageObject) actualResponse.getData();
        assertTrue(actualResponse.isSuccess());
        assertEquals(UserMessages.MSG_INSERT_SUCCESS, data.getMessageCode());
        assertEquals(1, data.getParams().length);
        assertEquals(id.toString(), data.getParams()[0]);

    }
    
    @Test
    public void testRegister_Duplicated() {
        String username = "John";
        exceptionRule.expect(ServerException.class);
        exceptionRule.expectMessage(UserMessages.ERR_INSERT_USERNAME_DUPLICATED);
        exceptionRule.expectCause(Matchers.isA(DuplicateKeyException.class));
        
        Mockito.doThrow(DuplicateKeyException.class).when(userRepo).insert(Mockito.any());

        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.CREATE);
        request.setUser(userVO);
        
        userService.handle(request);
    }
    
    @Test
    public void testModified_Missing() {
        String username = "John";
        exceptionRule.expect(ServerException.class);
        exceptionRule.expectMessage(UserMessages.ERR_USER_NOT_FOUND);
        
        Mockito.when(userRepo.update(Mockito.any())).thenReturn(0L);

        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.UPDATE);
        request.setUser(userVO);
        
        userService.handle(request);
    }
    
    @Test
    public void testModified() {
        String username  = "John";
        String firstName = "First";
        String lastName  = "Last";
        ArgumentCaptor<User> argCapture = ArgumentCaptor.forClass(User.class);
        
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        userVO.setFirstName(firstName);
        userVO.setLastName(lastName);
        
        request.setType(RequestType.UPDATE);
        request.setUser(userVO);
        
        Mockito.when(userRepo.update(Mockito.isA(User.class))).thenReturn(1L);
        
        BaseResponse response = userService.handle(request);
        
        Mockito.verify(userRepo, Mockito.times(1)).update(argCapture.capture());
        
        MessageObject message = (MessageObject) response.getData();
        assertTrue(response.isSuccess());
        assertEquals(UserMessages.MSG_UPDATE_SUCCESS, message.getMessageCode());
        
        User value = argCapture.getValue();
        assertEquals(username, value.getUsername());
        assertEquals(firstName, value.getFirstName());
        assertEquals(lastName, value.getLastName());
    }
    
    @Test
    public void testDelete() {
        String username  = "John";
        
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.DELETE);
        request.setUser(userVO);
        
        Mockito.when(userRepo.updateUserStatus(username, Status.DEACTIVE)).thenReturn(1L);
        
        BaseResponse response = userService.handle(request);
        
        Mockito.verify(userRepo, Mockito.times(1)).updateUserStatus(username, Status.DEACTIVE);
        
        MessageObject message = (MessageObject) response.getData();
        assertTrue(response.isSuccess());
        assertEquals(UserMessages.MSG_DELETE_SUCCESS, message.getMessageCode());
    }
    
    @Test
    public void testDelete_Missing() {
        String username  = "John";
        
        exceptionRule.expect(ServerException.class);
        exceptionRule.expectMessage(UserMessages.ERR_USER_NOT_FOUND);
        
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        
        request.setType(RequestType.DELETE);
        request.setUser(userVO);
        
        Mockito.when(userRepo.updateUserStatus(Mockito.anyString(), Mockito.any(Status.class))).thenReturn(1L);
        Mockito.when(userRepo.updateUserStatus(username, Status.DEACTIVE)).thenReturn(0L);
        
        userService.handle(request);
    }
}
