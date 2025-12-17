package com.javaweb.repository.Entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	
	@Column(name="name")
	private String name ;
	
	@Column(name = "street")
	private String street ;
	
	@Column(name="ward")
	private String ward ;
	
//	@Column(name="districtid")  
//	private Integer districtid ; 
	
	@Column(name="rentprice")
	private Long rentprice ; 
	
	@Column(name = "managername")
	private String managername ; 
	
	@Column(name="managerphonenumber")
	private String  managerphonenumber ;

	@Column(name = "numberofbasement")
	private Long numberofbasement ; 
	
	@Column(name = "floorarea")
	private Long floorarea ; 
	
	@Column(name = "rentpricedescription")
	private String rentpricedescription  ; 
	
	@Column(name = "servicefee")
	private Long servicefee ; 

	@ManyToOne
	@JoinColumn(name="districtid" )
	private DistrictEntity district ; 
	
	@OneToMany(mappedBy = "building" , fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreas= new ArrayList<>() ; 
	
	
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public List<RentAreaEntity> getRentArea() {
		return rentAreas;
	}
	public void setRentArea(List<RentAreaEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
//	public Integer getDistrictid() {
//		return districtid;
//	}
//	public void setDistrictid(Integer districtid) {
//		this.districtid = districtid;
//	}
	public Long getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
		this.numberofbasement = numberofbasement;
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
	public String getRentpricedescription() {
		return rentpricedescription;
	}
	public void setRentpricedescription(String rentpricedescription) {
		this.rentpricedescription = rentpricedescription;
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
	public Long getServicefee() {
		return servicefee;
	}
	public void setServicefee(Long servicefee) {
		this.servicefee = servicefee;
	}

	
	
}
