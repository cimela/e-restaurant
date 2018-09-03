package com.github.cimela.e.restaurant.user.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.cimela.e.restaurant.base.repository.BaseRepository;
import com.github.cimela.e.restaurant.user.model.User;

@Repository
public interface UserRepository extends BaseRepository<User, ObjectId>, UserCustomRepository {
    @Query(value="{'status':'ACTIVE'}")
    List<User> findAllUsers();
    
    @Query(value="{'username': ?0, 'status':'ACTIVE'}")
    User findByUsername(String username);
    
    @Query(value="{'username': ?0, 'password': ?0, 'status':'ACTIVE'}")
    User findByUsernameAndPassword(String username, String password);
}
