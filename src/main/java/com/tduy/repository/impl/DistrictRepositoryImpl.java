package com.tduy.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tduy.repository.DistrictRepository;
import com.tduy.repository.entity.DistrictEntity;
import com.tduy.utils.ConnectionJDBC;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntity getNameById(Long id) {
		String sql = "SELECT d.name FROM district d WHERE d.id = " + id;
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection conn = ConnectionJDBC.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				districtEntity.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return districtEntity;
	}

}
