package com.javaweb.repository.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	@Column(name="username")
	private String UserName ;
	
	@Column(name="password")
	private String password ;
	
	@Column(name="fullname")
	private String fullName ;
	
	@Column(name="status")
	private Integer status ;
	
	@Column(name = "email")
	private String email ;

	@OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
	private List<UserRoleEntity> users = new ArrayList<>() ;
	
	public List<UserRoleEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserRoleEntity> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
	
}
