package com.tduy.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.tduy.repository.BuildingRepository;
import com.tduy.repository.entity.BuildingEntity;
import com.tduy.utils.ConnectionJDBC;
import com.tduy.utils.NumberUtil;
import com.tduy.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	public static void joinTable(Map<String, Object> params, List<String> code, StringBuilder sql) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if (code != null || code.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
			sql.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id");
		}
	}

	public static void queryNormal(Map<String, Object> params, StringBuilder where) {
		for (Map.Entry<String, Object> item : params.entrySet()) {
			if (!item.getKey().equals("staffId") && !item.getKey().equals("code") && !item.getKey().startsWith("area")
					&& !item.getKey().startsWith("rentPrice")) {
				String value = item.getValue().toString();
				if (StringUtil.checkString(value)) {
					if (NumberUtil.isNumber(value)) {
						where.append(" AND b." + item.getKey() + " = " + value);
					} else {
						where.append(" AND b." + item.getKey() + " LIKE '%" + value + "%' ");
					}
				}
			}
		}
	}

	public static void querySpecial(Map<String, Object> params, List<String> code, StringBuilder where) {
		String staffId = (String) params.get("staffId");
		if (StringUtil.checkString(staffId)) {
			where.append(" AND assignmentbuilding.staffid = " + staffId);
		}
		String rentPrice = (String) params.get("rentPrice");
		if (StringUtil.checkString(rentPrice)) {
			where.append(" AND building.rentprice >= " + rentPrice);
		}
		String rentAreaTo = (String) params.get("areaTo");
		String rentAreaFrom = (String) params.get("areaFrom");
		if (StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
			where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid");
			if (StringUtil.checkString(rentAreaFrom)) {
				where.append(" AND r.value >= " + rentAreaFrom);
			}
			if (StringUtil.checkString(rentAreaTo)) {
				where.append(" AND r.value <= " + rentAreaTo);
			}
			where.append(") ");

		}

		String rentPriceTo = (String) params.get("rentPriceTo");
		String rentPriceFrom = (String) params.get("rentPriceFrom");
		if (StringUtil.checkString(rentPriceFrom) || StringUtil.checkString(rentPriceTo)) {
			if (StringUtil.checkString(rentPriceFrom)) {
				where.append(" AND b.rentprice >= " + rentPriceFrom);
			}
			if (StringUtil.checkString(rentAreaTo)) {
				where.append(" AND b.rentprice <= " + rentPriceTo);
			}

		}
		if (code != null && code.size() != 0) {
			where.append(" AND (");
			String sql = code.stream().map(it -> "renttype.code LIKE '%" + it + "%'")
					.collect(Collectors.joining(" OR "));
			where.append(sql);
			where.append(") ");
		}
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> code) {
		StringBuilder sql = new StringBuilder(
				"SELECT b.id, b.name, b.street, b.ward, b.districtid, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber FROM building b ");
		joinTable(params, code, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		queryNormal(params, where);
		querySpecial(params, code, where);
		where.append("GROUP BY b.id");
		sql.append(where);
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		try (Connection conn = ConnectionJDBC.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("b.id"));
				building.setName(rs.getString("b.name"));
				building.setWard(rs.getString("b.ward"));
				building.setStreet(rs.getString("b.street"));
				building.setDistrictId(rs.getLong("b.districtid"));
				building.setFloorArea(rs.getLong("b.floorarea"));
				building.setRentPrice(rs.getLong("b.rentprice"));
				building.setManagerName(rs.getString("b.managername"));
				building.setManagerPhoneNumber(rs.getString("b.managerPhoneNumber"));
				result.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
