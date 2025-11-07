package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL ="jdbc:mysql://localhost:3306/estatebasic" ; 
	static final String USER = "root" ; 
	static final String PASS="12345" ; 
	@Override
	public  List<BuildingEntity>  findAll(String name, Integer districtid){
		StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1=1 ") ;
		if(name!=null && !name.equals("")) {
			sql.append("and name LIKE '%"+name + "%' ") ; 
		}
		if(districtid!= null ) {
			sql.append("and districtid = '"+districtid+"' ") ; 
		}
		List<BuildingEntity> results = new ArrayList<>() ; 
		try(Connection conn = DriverManager.getConnection(DB_URL , USER , PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString()) ){ // vì là đối tượng nên cần tótring để chuyển đổi 
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity() ; 
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setNumberofbasement(rs.getInt("numberofbasement"));
				buildingEntity.setWard(rs.getString("ward"));
				results.add(buildingEntity) ; 
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return results ; 
	}

}
