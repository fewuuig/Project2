package com.javaweb.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connectionJDBCUtil {
	static final String DB_URL ="jdbc:mysql://localhost:3306/estatebasic" ; 
	static final String USER = "root" ; 
	static final String PASS="12345" ;
	public static  Connection getConnecTion() {
		Connection conn = null ; 
		try{
			conn = DriverManager.getConnection(DB_URL, USER , PASS) ;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conn; 
	}
}


