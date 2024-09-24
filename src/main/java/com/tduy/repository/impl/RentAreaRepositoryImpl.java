package com.tduy.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tduy.repository.RentAreaRepository;
import com.tduy.repository.entity.RentAreaEntity;
import com.tduy.utils.ConnectionJDBC;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {

	@Override
	public List<RentAreaEntity> getValueBuildingById(Long id) {
		String sql = "SELECT * FROM rentarea WHERE rentarea.buildingid = " + id;
		List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();
		try (Connection conn = ConnectionJDBC.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				RentAreaEntity areaEntity = new RentAreaEntity();
				areaEntity.setValue(rs.getString("value"));
				rentAreas.add(areaEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentAreas;
	}

}
