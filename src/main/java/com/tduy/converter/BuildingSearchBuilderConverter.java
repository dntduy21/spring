package com.tduy.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tduy.builder.BuildingSearchBuilder;
import com.tduy.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
		BuildingSearchBuilder buildingSearch = new BuildingSearchBuilder.Builder()
				.setName(MapUtil.getObject(params, "name", String.class))
				.setStreet(MapUtil.getObject(params, "street", String.class))
				.setWard(MapUtil.getObject(params, "ward", String.class))
				.setDistrictid(MapUtil.getObject(params, "districtid", Integer.class))
				.setNumberofbasement(MapUtil.getObject(params, "numberofbasement", Integer.class))
				.setFloorarea(MapUtil.getObject(params, "floorarea", Integer.class))
				.setLevel(MapUtil.getObject(params, "level", String.class))
				.setRentpricefrom(MapUtil.getObject(params, "rentpricefrom", Integer.class))
				.setRentpriceto(MapUtil.getObject(params, "rentpriceto", Integer.class))
				.setRentareafrom(MapUtil.getObject(params, "rentareafrom", Integer.class))
				.setRentareato(MapUtil.getObject(params, "rentareato", Integer.class))
				.setBrokeragefee(MapUtil.getObject(params, "brokeragefee", Long.class))
				.setManagername(MapUtil.getObject(params, "managername", String.class))
				.setManagerphonenumber(MapUtil.getObject(params, "managerphonenumber", String.class))
				.setStaffid(MapUtil.getObject(params, "staffid", Long.class)).setTypeCode(typeCode).build();
		return buildingSearch;
	}
}
