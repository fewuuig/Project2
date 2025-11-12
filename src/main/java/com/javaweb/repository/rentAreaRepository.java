package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.Entity.RentAreaEntity;

public interface rentAreaRepository {
	List<RentAreaEntity> findValueById(Integer id) ; 
}
