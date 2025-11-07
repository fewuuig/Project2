package com.javaweb.model;


import java.util.ArrayList;
import java.util.List;

public class errolResponeDTO {
	private String errol ; 
	private List<String> details = new ArrayList<>() ;
	public String getErrol() {
		return errol;
	}
	public void setErrol(String errol) {
		this.errol = errol;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	} 
	
}
