package com.javaweb.model;

public class BuildingDTO {
	private String name ; 
	private Integer numberofbasement ; 
	private String address ;
//	private String ward ;
//	private String street ; // đây làp hần model trực tiêp[s vứt data ra view vì vậy nó phải đc xây dựng trên các field mà khách hanmgf yêu bcaauf 
	// địa chỉ thì nó là : ward + street ; 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberofbasement;
	}
	public void setNumberOfBasement(Integer numberHome) {
		this.numberofbasement = numberHome;
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
	
	
	
}
