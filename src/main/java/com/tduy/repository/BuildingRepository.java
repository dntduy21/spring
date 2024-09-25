package com.tduy.repository;

import java.util.List;
import java.util.Map;

import com.tduy.builder.BuildingSearchBuilder;
import com.tduy.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
