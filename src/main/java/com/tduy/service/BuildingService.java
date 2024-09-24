package com.tduy.service;

import java.util.List;
import java.util.Map;

import com.tduy.model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(Map<String, Object> params, List<String> code);
}
