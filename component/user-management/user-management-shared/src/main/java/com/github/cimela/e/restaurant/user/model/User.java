package com.github.cimela.e.restaurant.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

import com.github.cimela.e.restaurant.base.model.GenericModel;

public class User extends GenericModel<ObjectId> {
    @Indexed(unique=true)
    private String username;
    
    private String password;
}
