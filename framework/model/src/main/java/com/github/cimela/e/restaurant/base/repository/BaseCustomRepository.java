package com.github.cimela.e.restaurant.base.repository;

import java.io.Serializable;

import com.github.cimela.e.restaurant.base.model.GenericModel;

public interface BaseCustomRepository<T extends GenericModel<ID>, ID extends Serializable> {

}
