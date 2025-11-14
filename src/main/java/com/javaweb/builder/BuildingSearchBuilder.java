 package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name ; 
	private Long floorarea ; 
	private String ward ; 
	private String street ; 
	private String districtcode ; 
	private Integer numberofbasement ; 
	private List<String> typeCode = new ArrayList<>() ; 
	private String managername ; 
	private String managerphonenumber ; 
	private Long rentpricefrom ; 
	private Long rentpriceto ; 
	private Long rentareafrom ; 
	private Long rentareato ; 
	private Long staffid ; 
	
	
	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.floorarea = builder.floorarea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtcode = builder.districtcode;
		this.numberofbasement = builder.numberofbasement;
		this.typeCode = builder.typeCode;
		this.managername = builder.managername;
		this.managerphonenumber = builder.managerphonenumber;
		this.rentpricefrom = builder.rentpricefrom;
		this.rentpriceto = builder.rentpriceto;
		this.rentareafrom = builder.rentareafrom;
		this.rentareato = builder.rentareato;
		this.staffid = builder.staffid;
	}
	public String getName() {
		return name;
	}
	public Long getFloorarea() {
		return floorarea;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public String getDistrictcode() {
		return districtcode;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public List<String> getTypecode() {
		return typeCode;
	}
	public String getManagername() {
		return managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public Long getRentpricefrom() {
		return rentpricefrom;
	}
	public Long getRentpriceto() {
		return rentpriceto;
	}
	public Long getAreafrom() {
		return rentareafrom;
	}
	public Long getAreato() {
		return rentareato;
	}
	public Long getStaffid() {
		return staffid;
	}
	public static class Builder{
		private String name ; 
		private Long floorarea ; 
		private String ward ; 
		private String street ; 
		private String districtcode ; 
		private Integer numberofbasement ; 
		private List<String> typeCode = new ArrayList<>() ; 
		private String managername ; 
		private String managerphonenumber ; 
		private Long rentpricefrom ; 
		private Long rentpriceto ; 
		private Long rentareafrom ; 
		private Long rentareato ; 
		private Long staffid ;
		public Builder setName(String name) {
			this.name = name;
			return this ; 
		}
		public Builder setFloorarea(Long floorarea) {
			this.floorarea = floorarea;
			return this ; 
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this ; 
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this ; 
		}
		public Builder setDistrictcode(String districtcode) {
			this.districtcode = districtcode;
			return this ; 
		}
		public Builder setNumberofbasement(Integer numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this ; 
		}
		public Builder setTypecode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this ; 
		}
		public Builder setManagername(String managername) {
			this.managername = managername;
			return this ; 
		}
		public Builder setManagerphonenumber(String managerphonenumber) {
			this.managerphonenumber = managerphonenumber;
			return this ; 
		}
		public Builder setRentpricefrom(Long rentpricefrom) {
			this.rentpricefrom = rentpricefrom;
			return this ; 
		}
		public Builder setRentpriceto(Long rentpriceto) {
			this.rentpriceto = rentpriceto;
			return this ; 
		}
		public Builder setAreafrom(Long areafrom) {
			this.rentareafrom = areafrom;
			return this ; 
		}
		public Builder setAreato(Long areato) {
			this.rentareato = areato;
			return this ; 
		}
		public Builder setStaffid(Long staffid) {
			this.staffid = staffid;
			return this ; 
		} 
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this) ; 
		}
	}
	
}
