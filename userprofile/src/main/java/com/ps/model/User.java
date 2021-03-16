package com.ps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User {
	
  
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="firstName",nullable = false)
	@NotBlank(message="first Name will not be null")
	private String firstName;
	
	@Column(name="lastName",nullable = false)
	@NotBlank(message="last Name will not be null")
	private String lastName;
	
	@Column(name="email",nullable = false,unique = true)
	@NotBlank(message="Email will not be null")
	private String email;
	
	
	@Column(name="date_of_birth",nullable = false)
	@NotNull(message="date  will not be null")
	@JsonFormat(pattern="yyyy-MM-dd")
    private String dob;
	
	@Column(name="Address",nullable = false)
	@NotEmpty(message="address number will not be null")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", address=" + address + "]";
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	
	
	
}

	