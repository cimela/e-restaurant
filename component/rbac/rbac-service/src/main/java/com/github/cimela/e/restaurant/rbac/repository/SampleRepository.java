package com.github.cimela.e.restaurant.rbac.repository;

import org.bson.types.ObjectId;

import com.github.cimela.e.restaurant.base.repository.BaseCustomRepository;
import com.github.cimela.e.restaurant.base.repository.BaseRepository;
import com.github.cimela.e.restaurant.rbac.model.Sample;

public interface SampleRepository extends BaseRepository<Sample, ObjectId>, BaseCustomRepository<Sample, ObjectId> {

}
