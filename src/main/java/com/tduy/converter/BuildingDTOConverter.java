package com.tduy.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tduy.model.BuildingDTO;
import com.tduy.repository.DistrictRepository;
import com.tduy.repository.RentAreaRepository;
import com.tduy.repository.entity.BuildingEntity;
import com.tduy.repository.entity.DistrictEntity;
import com.tduy.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private RentAreaRepository areaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setName(item.getName());
		DistrictEntity districtEntity = districtRepository.getNameById(item.getDistrictId());
		building.setAddress(item.getStreet() + "," + item.getWard() + "," + districtEntity.getName());
		List<RentAreaEntity> areaEntities = areaRepository.getValueBuildingById(item.getId());
		String resultAreas = areaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(resultAreas);
		return building;
	}
}
