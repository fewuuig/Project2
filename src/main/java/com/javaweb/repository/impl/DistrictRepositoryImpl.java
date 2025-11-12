package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.Entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
	static final String DB_URL ="jdbc:mysql://localhost:3306/estatebasic" ; 
	static final String USER = "root" ; 
	static final String PASS="12345" ;
	@Override
	public DistrictEntity findDistrict(Integer id){
		DistrictEntity result = new DistrictEntity() ; 
		String sql = "SELECT d.name , d.code FROM district d ; " ; 
		try(Connection conn = DriverManager.getConnection(DB_URL ,USER,PASS );
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ) {
			while (rs.next()) {
				result.setName(rs.getString("d.name"));
				result.setCode(rs.getString("d.code"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result  ; 
	}
	
}
