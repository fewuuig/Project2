package com.javaweb.api;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.repository.Entity.BuildingEntity;
import com.javaweb.repository.Entity.DistrictEntity;
import com.javaweb.service.BuildingService;

@RestController

public class BuildingAPI {
	@Autowired
	private BuildingService buildingService ; 
    @GetMapping(value="/api/building/" )
    public List<BuildingDTO> getBuilding1(@RequestParam Map<String,Object> params ,  
    		                              @RequestParam(value="typeCode", required = false) List<String> typeCode) {
    	
    	List<BuildingDTO> result = buildingService.findAll( params , typeCode) ;
    	return result; 
    }
    
    @PersistenceContext 
    private EntityManager entityManager ; 
    @PostMapping(value="/api/building/")
    @Transactional
    public void creatBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
    	BuildingEntity buildingEntity = new BuildingEntity() ; 
    	buildingEntity.setName(buildingRequestDTO.getName());
    	buildingEntity.setWard(buildingRequestDTO.getWard());
    	buildingEntity.setStreet(buildingRequestDTO.getStreet());
    	DistrictEntity districtEntity = new DistrictEntity() ;
    	districtEntity.setId(buildingRequestDTO.getDistrictId());
    	buildingEntity.setDistrict(districtEntity);
    	entityManager.persist(buildingEntity);
    	System.out.println("ok");
    }
    @PutMapping(value="/api/building/")
    @Transactional
    public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
    	BuildingEntity buildingEntity = new BuildingEntity() ; 
    	buildingEntity.setId(1);
    	buildingEntity.setName(buildingRequestDTO.getName());
    	buildingEntity.setWard(buildingRequestDTO.getWard());
    	buildingEntity.setStreet(buildingRequestDTO.getStreet());
    	DistrictEntity districtEntity = new DistrictEntity() ;
    	districtEntity.setId(buildingRequestDTO.getDistrictId());
    	buildingEntity.setDistrict(districtEntity);
    	entityManager.merge(buildingEntity);
    	System.out.println("ok");
    }
    
//    void valiDate(BuildingDTO buildingDTO){
//    	String obj = "";
//		if(buildingDTO == null || buildingDTO.getAddress()==null || buildingDTO.getStreet()==null) {
//    		throw new FieldRequiredException("NOT NULL AND EMPTY!") ; 
//    	}
//    }
//    @PostMapping(value="/api/building/" )
//    public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//    	System.out.print("ok");
//    } 
    @DeleteMapping(value="/api/building/{id}")
    @Transactional
    public void DeleteBuilding(@PathVariable Integer[] id  ) {
    	for(int i=0 ; i< id.length ; i++) {
    		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id[i]) ; 
        	entityManager.remove(buildingEntity);
    	}
    	System.out.println("ok");
    }
}