package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.rentAreaRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.repository.Entity.DistrictEntity;
import com.javaweb.repository.Entity.RentAreaEntity;
@Component
public class BuildingDTOConverter {
	@Autowired
	private  DistrictRepository districtRepository ; 
	@Autowired
	private rentAreaRepository rentAreaRepository ; 
	@Autowired 
	private ModelMapper modelMapper ; 
	public  BuildingDTO toBuildingDTO(BuildingEntity build) {
		DistrictEntity districtEntity =districtRepository .findDistrict(build.getDistrictid()) ; 
		List<RentAreaEntity> rentAreaEntity = rentAreaRepository.findValueById(build.getId()) ; 
		BuildingDTO buildingDTO = modelMapper.map(build, BuildingDTO.class) ;  
		buildingDTO.setAddress(build.getStreet()+" , "+build.getWard() + ","+districtEntity.getName());
		String rentArea = rentAreaEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")) ;
		buildingDTO.setRentArea(rentArea);
		
//		buildingDTO.setManagerphonenumber(build.getManagerphonenumber());
//		buildingDTO.setFloorarea(build.getFloorarea());
//		buildingDTO.setRentprice(build.getRentprice());
//		buildingDTO.setName(build.getName());
//		buildingDTO.setNumberOfBasement(build.getNumberofbasement());
//		buildingDTO.setManagername(build.getManagername()) ; 
		return buildingDTO ; 
	}
}
