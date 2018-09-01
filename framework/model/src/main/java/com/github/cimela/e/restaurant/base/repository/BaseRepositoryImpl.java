package com.github.cimela.e.restaurant.base.repository;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cimela.e.restaurant.base.model.GenericModel;

public abstract class BaseRepositoryImpl<T extends GenericModel<ID>, ID extends Serializable> implements BaseCustomRepository<T, ID> {
    
    @Autowired
    protected MongoTemplate mongoTemplate;
}
