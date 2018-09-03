package com.github.cimela.e.restaurant.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.github.cimela.e.restaurant.base.model.GenericModel;
import com.github.cimela.e.restaurant.base.model.Status;

@Document(collection = User.COLLECTION_NAME)
public class User extends GenericModel<ObjectId> {
    
    public static final String COLLECTION_NAME = "users";
    public static final String ATTR_USERNAME   = "username";
    public static final String ATTR_FIRST_NAME = "firstName";
    public static final String ATTR_LAST_NAME  = "lastName";
    public static final String ATTR_STATUS     = "status";
    
    @Indexed(unique = true)
    private String username;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    
    private String firstName;
    private String lastName;
    
    private Status status = Status.ACTIVE;
    
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
