package com.github.cimela.e.restaurant.base.repository;

import java.io.Serializable;

import com.github.cimela.e.restaurant.base.model.GenericModel;

public abstract class BaseRepositoryImpl<T extends GenericModel<ID>, ID extends Serializable> implements BaseCustomRepository<T, ID> {

}
