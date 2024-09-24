package com.tduy.repository;

import java.util.List;

import com.tduy.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> getValueBuildingById(Long id);
}
