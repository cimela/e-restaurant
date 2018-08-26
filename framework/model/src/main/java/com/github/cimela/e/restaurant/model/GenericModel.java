package com.github.cimela.e.restaurant.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class GenericModel<ID extends Serializable> {

    public static final String ATTR_ID          = "_id";
    public static final String ATTR_ID_VALUE    = "id";
    public static final String ATTR_CREATE_DATE = "createDate";
    public static final String ATTR_UPDATE_DATE = "updateDate";
    public static final String ATTR_CREATE_USER = "createUser";
    public static final String ATTR_UPDATE_USER = "updateUser";

    @Id
    private ID id;

    private Date createDate;
    private Date updateDate;

    private ID createUser;
    private ID updateUser;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ID getCreateUser() {
        return createUser;
    }

    public void setCreateUser(ID createUser) {
        this.createUser = createUser;
    }

    public ID getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(ID updateUser) {
        this.updateUser = updateUser;
    }

}
