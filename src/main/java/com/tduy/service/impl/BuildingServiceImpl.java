package com.tduy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tduy.converter.BuildingDTOConverter;
import com.tduy.model.BuildingDTO;
import com.tduy.repository.BuildingRepository;
import com.tduy.repository.DistrictRepository;
import com.tduy.repository.RentAreaRepository;
import com.tduy.repository.entity.BuildingEntity;
import com.tduy.repository.entity.DistrictEntity;
import com.tduy.repository.entity.RentAreaEntity;
import com.tduy.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingDTOConverter buildingDTOConverter;

	@Override
	public List<BuildingDTO> findAll(Map<String, Object> params, List<String> code) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, code);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
			result.add(building);
		}
		return result;
	}

}
