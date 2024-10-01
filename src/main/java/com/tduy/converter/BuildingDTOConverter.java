package com.tduy.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tduy.model.BuildingDTO;
import com.tduy.repository.entity.BuildingEntity;
import com.tduy.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setName(item.getName());
		building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrictEntity().getName());
		List<RentAreaEntity> areaEntities = item.getAreaEntities();
		String resultAreas = areaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(resultAreas);
		return building;
	}
}
