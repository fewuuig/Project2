package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.annotations.Typology;
import org.springframework.stereotype.Service;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository ; 
	@Autowired
	private BuildingDTOConverter BuildingDTOConverter ; 
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter ; 
	public List<BuildingDTO> findAll(Map<String,Object> params , List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder= buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode) ; 
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder) ; 
		List<BuildingDTO> results = new ArrayList<>() ; 
		
		for(BuildingEntity build : buildingEntities) {
			results.add(BuildingDTOConverter.toBuildingDTO(build)) ; 
		}
		return results;
		
	}
}
