package com.ps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User_Table")
@Data
public class User {
	
  
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="firstName",unique = true)
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobileNumber")
	private String mobile;
	
	private boolean isLocker=false;
	
	


	

}
