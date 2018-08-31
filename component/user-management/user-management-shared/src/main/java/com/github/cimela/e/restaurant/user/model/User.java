package com.github.cimela.e.restaurant.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.github.cimela.e.restaurant.base.model.GenericModel;

public class User extends GenericModel<ObjectId> {
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
