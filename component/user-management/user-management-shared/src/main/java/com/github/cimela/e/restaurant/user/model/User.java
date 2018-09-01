package com.github.cimela.e.restaurant.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.github.cimela.e.restaurant.base.model.GenericModel;

@Document(collection = User.COLLECTION_NAME)
public class User extends GenericModel<ObjectId> {
    
    public static final String COLLECTION_NAME = "users";
    public static final String ATTR_USERNAME = "username";
    
    @Indexed(unique = true)
    private String username;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
