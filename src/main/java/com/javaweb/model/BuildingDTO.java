package com.javaweb.model;

public class BuildingDTO {
	private String name ; 
	private Long numberofbasement ; 
	private String address ;
	private String managername ; 
	private String managerphonenumber ; 
	private Long floorarea ; 
	private Long rentprice ; 
	private Long servicefee ; 
	private String rentArea ; 
//	private String ward ;
//	private String street ; // đây làp hần model trực tiêp[s vứt data ra view vì vậy nó phải đc xây dựng trên các field mà khách hanmgf yêu bcaauf 
	// địa chỉ thì nó là : ward + street ; 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumberOfBasement() {
		return numberofbasement;
	}
	public void setNumberOfBasement(Long numberofbasement) {
		this.numberofbasement = numberofbasement ;  
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getWard() {
//		return ward;
//	}
//	public void setWard(String ward) {
//		this.ward = ward;
//	}
//	public String getStreet() {
//		return street;
//	}
//	public void setStreet(String street) {
//		this.street = street;
//	} 
	public Long getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Long floorarea) {
		this.floorarea = floorarea;
	}
	public Long getRentprice() {
		return rentprice;
	}
	public void setRentprice(Long rentprice) {
		this.rentprice = rentprice;
	}
	public Long getServicefee() {
		return servicefee;
	}
	public void setServicefee(Long servicefee) {
		this.servicefee = servicefee;
	}
	public String getRentArea() {
		return rentArea;
	}
	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}
	
	
	
	
	
}
