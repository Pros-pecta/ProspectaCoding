package com.ps.service;

import java.util.List;

import com.ps.model.Address;

public interface AddressService {
	
	public List<Address> getAddreeses();
	
	public Integer saveAddress(Address address);
	
	public Integer updateAddress(Address address);
	
	public void deleteAddress(Integer id);
	
	public Address getAddress(Integer id);
	
	public boolean isAddressExist(Integer id);

}
