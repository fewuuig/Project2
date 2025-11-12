package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
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
    
//    void valiDate(BuildingDTO buildingDTO){
//    	String obj = "";
//		if(buildingDTO == null || buildingDTO.getAddress()==null || buildingDTO.getStreet()==null) {
//    		throw new FieldRequiredException("NOT NULL AND EMPTY!") ; 
//    	}
//    }
    @PostMapping(value="/api/building/" )
    public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
    	System.out.print("ok");
    }
    @DeleteMapping(value="/api/building/{id}/{building}")
    	public void DeleteBuilding(@PathVariable Integer id  ,  
    			@PathVariable String building ) {
    		System.out.println("đã xóa sản phẩm có id : " +id+" "+ building+"Xong" );
    	}
}