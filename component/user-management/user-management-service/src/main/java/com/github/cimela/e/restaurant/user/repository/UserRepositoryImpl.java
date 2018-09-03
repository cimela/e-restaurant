package com.github.cimela.e.restaurant.user.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.github.cimela.e.restaurant.base.model.Status;
import com.github.cimela.e.restaurant.base.repository.BaseRepositoryImpl;
import com.github.cimela.e.restaurant.user.model.User;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, ObjectId> implements UserCustomRepository {

    @Override
    public void insert(User user) {
        this.mongoTemplate.insert(user);
    }

    @Override
    public void update(User model) {
        Query query = Query.query(Criteria.where(User.ATTR_USERNAME).is(model.getUsername()));
        Update update = new Update();
        update.set(User.ATTR_FIRST_NAME, model.getFirstName());
        update.set(User.ATTR_LAST_NAME, model.getFirstName());
        
        this.mongoTemplate.updateFirst(query , update, User.class);
    }
    
    @Override
    public void updateUserStatus(String username, Status status) {
        Query query = Query.query(Criteria.where(User.ATTR_USERNAME).is(username));
        Update update = new Update();
        update.set(User.ATTR_STATUS, status);
        
        this.mongoTemplate.updateFirst(query , update, User.class);
    }

}
