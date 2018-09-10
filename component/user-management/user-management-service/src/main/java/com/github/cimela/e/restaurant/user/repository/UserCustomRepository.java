package com.github.cimela.e.restaurant.user.repository;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.model.Status;
import com.github.cimela.e.restaurant.base.repository.BaseCustomRepository;
import com.github.cimela.e.restaurant.user.model.User;

public interface UserCustomRepository extends BaseCustomRepository<User, ObjectId> {
    ObjectId insert(User user);
    long update(User model);
    long updateUserStatus(String username, Status status);
}
