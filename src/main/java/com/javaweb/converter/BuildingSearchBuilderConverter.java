package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;
@Component
public class BuildingSearchBuilderConverter {
	public  BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params , List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder() 
				                                      .setName(MapUtil.getObject(params,"name", String.class))
				                                      .setFloorarea(MapUtil.getObject(params,"floorArea", Long.class))
				                                      .setWard(MapUtil.getObject(params, "ward", String.class))
				                                      .setStreet(MapUtil.getObject(params, "street", String.class))
				                                      .setDistrictcode(MapUtil.getObject(params,"districtId" , String.class))
				                                      .setNumberofbasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
				                                      .setTypecode(typeCode)
				                                      .setManagername(MapUtil.getObject(params,"managerName", String.class))
				                                      .setManagerphonenumber(MapUtil.getObject(params,"managerPhoneNumber", String.class))
				                                      .setRentpriceto(MapUtil.getObject(params, "rentPriceTo", Long.class))
				                                      .setRentpricefrom(MapUtil.getObject(params, "rentPriceFrom", Long.class))
				                                      .setAreafrom(MapUtil.getObject(params, "rentAreaFrom", Long.class))
				                                      .setAreato(MapUtil.getObject(params, "rentAreaTo", Long.class))
				                                      .setStaffid(MapUtil.getObject(params, "staffId",Long.class))
				                                      .build() ; 
		return buildingSearchBuilder ;  
	}
}
