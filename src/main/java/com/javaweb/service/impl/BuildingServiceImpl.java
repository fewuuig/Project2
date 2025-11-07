package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository ; 
	@Override
	public List<BuildingDTO> findAll(String name ,Integer districtid) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name ,districtid) ; 
		List<BuildingDTO> results = new ArrayList<>() ; 
		for(BuildingEntity build : buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO() ; 
			buildingDTO.setName(build.getName());
			buildingDTO.setNumberOfBasement(build.getNumberofbasement());
			buildingDTO.setAddress(build.getStreet()+" , "+build.getWard());
			results.add(buildingDTO) ; 
		}
		return results;
		
	}
}
