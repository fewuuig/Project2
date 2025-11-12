package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.rentAreaRepository;
import com.javaweb.repository.Entity.RentAreaEntity;
import com.javaweb.utils.connectionJDBCUtil;

@Repository
public class rentAreaRepositoryImpl implements rentAreaRepository{
	@Override
	public List<RentAreaEntity> findValueById(Integer id) {
		String sql = "SELECT r.value FROM rentarea r WHERE r.buildingid = "+id +" ";
		List<RentAreaEntity> results = new ArrayList<>() ; 
		try(Connection conn = connectionJDBCUtil.getConnecTion() ;
			Statement stmt = conn.createStatement() ;
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity() ; 
				rentAreaEntity.setValue(rs.getLong("r.value"));
				results.add(rentAreaEntity) ; 
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return  results ; 
	}
}
