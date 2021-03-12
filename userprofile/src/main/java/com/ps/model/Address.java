package com.ps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private addressType address;
	
	private enum addressType{
		BILLING,
		SHIPPING,
		HOMEADDRESS
	}
	
	public boolean isShipping() {
		if( getAddress() == addressType.SHIPPING) {
			return true;
		}
		return false;
	}
	
	
	@NotEmpty(message = "Address1 should not be null")
	@Size(min=2,message="Name should have atleast 2 characters")
	@Column(name="address_line1")
	private String addressLine1;
	
	
	@NotEmpty(message = "Address2 should not be null")
	@Size(min=7, message="Address should have atleast 2 characters")
	@Column(name="address_line2")
	private String addressLine2;
	
	
	@NotEmpty(message = "postalCode data should not be null")
	@NotBlank(message = "postalCode data should not be null")
	@Column(name="postal_code")
	private String postalCode;
	
	@NotNull(message = "phone data should not be null")
	@Column(name="phone_number")
	private Long phoneNumber;
	
	
	@NotEmpty(message = "country data should not be null")
	@Column(name="country")
	private String country;
	
	
	@NotEmpty(message = "city data should not be null")
	@Column(name="city")
	private String city;
	
	
	@NotEmpty(message = "state data should not be null")
	@Column(name="state")
	private String state;
	
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public addressType getAddress() {
		return address;
	}

	public void setAddress(addressType address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", country=" + country + ", city="
				+ city + ", state=" + state + "]";
	}
	
	
	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
