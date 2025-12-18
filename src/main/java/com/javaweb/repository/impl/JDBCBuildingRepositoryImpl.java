package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.utils.connectionJDBCUtil;
import com.javaweb.utils.numberUtil;

@Repository
public class JDBCBuildingRepositoryImpl implements BuildingRepository{
	
	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder ,StringBuilder sql) {
		// có 3 cái file nếu người dubngf yêu cầu từ client gửi vêf thì sẽ phải join bảng 
		// staffid , typeCode, rentArera 
		Long staffId= buildingSearchBuilder.getStaffid() ;  
		if(staffId != null) {
			sql.append(" JOIN assignmentbuilding  ON assignmentbuilding.buildingid = b.id ") ; 
		}
		List<String> typeCode = buildingSearchBuilder.getTypecode() ; 
		if(typeCode!= null && typeCode.size()!=0 ) {
			sql.append(" JOIN buildingrenttype ON buildingrenttype.buildingid = b.id ") ; 
			sql.append(" JOIN renttype ON renttype.id = buildingrenttype.renttypeid "); 
		}
		Long rentAreaTo = buildingSearchBuilder.getAreato() ; 
		Long rentAreaFrom = buildingSearchBuilder.getAreafrom() ; 
		if (rentAreaTo != null || rentAreaFrom != null) {
			sql.append(" JOIN rentarea ON rentarea.buildingid = b.id ") ; 
		}
	}
	public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where ) {
		// nhumgwx cái yêu cầu từ building thì thuộc dạng Normal 
//		for(Map.Entry<String,Object> param : params.entrySet()){
//			if(param.getKey()!=null && !param.getKey().equals("staffId") && !param.getKey().equals("typeCode")
//		       && !param.getKey().startsWith("rentArea") && !param.getKey().startsWith("rentPrice")){
//				String value = param.getValue().toString() ; 
//				if(stringUtil.checkString(value)) {
//					if(numberUtil.checkNumber(value)) { // kiem tra xem no la so hay chu , la so dubng dau = 
//						where.append(" AND b." + param.getKey() + " = "+value+" " ) ; 
//					}else { // neu la chu thu dung cai Like 
//						where.append(" AND b."+param.getKey() + " Like '%"+value+"%' ") ; 
//					}
//				}
//			}
//		}
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields() ; 
			for(Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName() ; 
				if(!fieldName.equals("staffid") && !fieldName.equals("typeCode")
					&& !fieldName.startsWith("rentarea") && !fieldName.startsWith("rentprice")) {
					Object value = item.get(buildingSearchBuilder) ; 
					if(value != null) {
						if(numberUtil.checkNumber(value.toString())) {
							where.append(" AND b."+fieldName +" = "+value) ; 
						}else {
							where.append(" AND b."+fieldName +" Like '%"+value+"%'") ; 
						}
					}
				} 
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder ,StringBuilder where) {
		// nnhuwngx yêu cẦU <= >= join thì dùng special 
		Long staffId = buildingSearchBuilder.getStaffid() ; 
		if(staffId != null) {
			where.append(" AND assignmentbuilding.staffid = "+staffId+" ") ; 
		}
		Long rentAreaTo = buildingSearchBuilder.getAreato() ; 
		Long rentAreaFrom = buildingSearchBuilder.getAreafrom() ; 
		if(rentAreaFrom != null){
			where.append(" AND rentarea.value >=" + rentAreaFrom ) ; 
		}
		if(rentAreaTo != null) {
			where.append(" AND rentarea.value <= "+rentAreaTo) ; 
		}
		Long rentPriceTo= buildingSearchBuilder.getRentpriceto();
		Long rentPriceFrom= buildingSearchBuilder.getRentpricefrom();
		if(rentPriceFrom != null) {
			where.append("AND b.rentprice >= " + rentPriceFrom) ; 
		}
		if(rentPriceTo != null) {
			where.append("AND b.rentprice <= "+rentPriceTo); 
		}
		List<String> typeCode = buildingSearchBuilder.getTypecode() ; 
		if(typeCode != null ) {
			where.append(" AND renttype.code IN('" + java.lang.String.join("','",typeCode) +"')") ; 
		}
	}
	@PersistenceContext
	private EntityManager entityManager ; 
	@Override
	public  List<BuildingEntity>  findAll(BuildingSearchBuilder buildingSearchBuilder){
		StringBuilder sql = new StringBuilder("SELECT b.id , b.name , servicefee ,b.numberofbasement ,b.rentpricedescription, b.districtid, b.ward , b.street , b.floorarea , b.rentprice"
				+ ",b.managername, b.managerphonenumber FROM building b ") ;
		StringBuilder where = new StringBuilder("WHERE 1=1") ; 
		joinTable(buildingSearchBuilder, sql);
		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);
		sql =sql.append(where).append(" GROUP BY b.id ; ") ; 
		
		Query query = entityManager.createNativeQuery(sql.toString() , BuildingEntity.class) ; 
		return query.getResultList() ; 
	}

}
