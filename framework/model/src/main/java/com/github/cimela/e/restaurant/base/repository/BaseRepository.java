package com.github.cimela.e.restaurant.base.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.github.cimela.e.restaurant.base.model.GenericModel;

@NoRepositoryBean
public interface BaseRepository<T extends GenericModel<ID>, ID extends Serializable> extends CrudRepository<T, ID> {

}
