package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.utils.connectionJDBCUtil;
import com.javaweb.utils.numberUtil;
import com.javaweb.utils.stringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	public static void joinTable(Map<String,Object> params ,List<String> typeCode ,StringBuilder sql) {
		// có 3 cái file nếu người dubngf yêu cầu từ client gửi vêf thì sẽ phải join bảng 
		// staffid , typeCode, rentArera 
		String staffId= (String)params.get("staffId") ; 
		if(staffId != null) {
			sql.append(" JOIN assignmentbuilding  ON assignmentbuilding.buildingid = b.id ") ; 
		}
		if(typeCode!= null && typeCode.size()!=0 ) {
			sql.append(" JOIN buildingrenttype ON buildingrenttype.buildingid = b.id ") ; 
			sql.append(" JOIN renttype ON renttype.id = buildingrenttype.renttypeid "); 
		}
		String rentAreaTo = (String)params.get("rentAreaTo") ; 
		String rentAreaFrom = (String)params.get("rentAreaFrom"); 
		if (stringUtil.checkString(rentAreaTo) || stringUtil.checkString(rentAreaFrom) ) {
			sql.append(" JOIN rentarea ON rentarea.buildingid = b.id ") ; 
		}
	}
	public static void queryNormal(Map<String,Object> params , StringBuilder where ) {
		// nhumgwx cái yêu cầu từ building thì thuộc dạng Normal 
		for(Map.Entry<String,Object> param : params.entrySet()){
			if(param.getKey()!=null && !param.getKey().equals("staffId") && !param.getKey().equals("typeCode")
		       && !param.getKey().startsWith("rentArea") && !param.getKey().startsWith("rentPrice")){
				String value = param.getValue().toString() ; 
				if(stringUtil.checkString(value)) {
					if(numberUtil.checkNumber(value)) { // kiem tra xem no la so hay chu , la so dubng dau = 
						where.append(" AND b." + param.getKey() + " = "+value+" " ) ; 
					}else { // neu la chu thu dung cai Like 
						where.append(" AND b."+param.getKey() + " Like '%"+value+"%' ") ; 
					}
				}
			}
		}
	}
	public static void querySpecial(Map<String,Object> params , List<String> typeCode,StringBuilder where) {
		// nnhuwngx yêu cẦU <= >= join thì dùng special 
		String staffId = (String)params.get("staffId"); 
		if(stringUtil.checkString(staffId)) {
			where.append(" AND assignmentbuilding.staffid = "+staffId+" ") ; 
		}
		String rentAreaTo = (String)params.get("rentAreaTo") ; 
		String rentAreaFrom = (String)params.get("rentAreaFrom") ; 
		if(stringUtil.checkString(rentAreaFrom)){
			where.append(" AND rentarea.value >=" + rentAreaFrom ) ; 
		}
		if(stringUtil.checkString(rentAreaTo)) {
			where.append(" AND rentarea.value <= "+rentAreaTo) ; 
		}
		String rentPriceTo= (String)params.get("rentPriceTo") ; 
		String rentPriceFrom= (String)params.get("rentPriceFrom") ; 
		if(stringUtil.checkString(rentPriceFrom)) {
			where.append("AND b.rentprice >= " + rentPriceFrom) ; 
		}
		if(stringUtil.checkString(rentAreaTo)) {
			where.append("AND b.rentprice <= "+rentPriceTo); 
		}
		if(typeCode != null && typeCode.size()!= 0) {
			where.append(" AND renttype.code IN('" + java.lang.String.join("','",typeCode) +"')") ; 
		}
	}
	@Override
	public  List<BuildingEntity>  findAll(Map<String,Object> params , List<String> typeCode){
		StringBuilder sql = new StringBuilder("SELECT b.id , b.name , servicefee ,b.numberofbasement ,b.rentpricedescription, b.districtid, b.ward , b.street , b.floorarea , b.rentprice"
				+ ",b.managername, b.managerphonenumber FROM building b ") ;
		StringBuilder where = new StringBuilder("WHERE 1=1") ; 
		joinTable(params, typeCode, sql);
		queryNormal(params, where);
		querySpecial(params, typeCode, where);
		sql =sql.append(where).append(" GROUP BY b.id ; ") ; 
		List<BuildingEntity> results = new ArrayList<>() ; 
		try(Connection conn = connectionJDBCUtil.getConnecTion();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString()) ){ 
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity() ; 
				buildingEntity.setId(rs.getInt("b.id"));
				buildingEntity.setName(rs.getString("b.name"));
				buildingEntity.setStreet(rs.getString("b.street")) ;
				buildingEntity.setWard(rs.getString("b.ward"));
				buildingEntity.setDistrictid(rs.getInt("b.districtid"));
				buildingEntity.setNumberofbasement(rs.getLong("b.numberofbasement"));
				buildingEntity.setFloorarea(rs.getLong("b.floorarea"));
				buildingEntity.setRentprice(rs.getLong("b.rentprice"));
				buildingEntity.setRentpricedescription(rs.getString("b.rentpricedescription"));
				buildingEntity.setManagername(rs.getString("b.managername"));
				buildingEntity.setManagerphonenumber(rs.getString("b.managerphonenumber"));
				buildingEntity.setServicefee(rs.getLong("b.servicefee"));
				results.add(buildingEntity) ; 
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return results ; 
	}

}
