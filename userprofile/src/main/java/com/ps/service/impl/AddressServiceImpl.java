package com.ps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.model.Address;
import com.ps.repo.AddressRepository;
import com.ps.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addrRepo;
	

	@Override
	public List<Address> getAddreeses() {
		List<Address> list=addrRepo.findAll();
		return list;
	}

	@Override
	public Integer saveAddress(Address address) {
	return addrRepo.save(address).getId();
	}

	@Override
	public Integer updateAddress(Address address) {
		return addrRepo.save(address).getId();
	}

	@Override
	public void deleteAddress(Integer id) {
		addrRepo.deleteById(id);
	}

	@Override
	public Address getAddress(Integer id) {
		Address address=null;
	Optional<Address> opt=addrRepo.findById(id);
	if(opt.isPresent()) {
		address = opt.get();
	}
		return address;
	}

	@Override
	public boolean isAddressExist(Integer id) {
		  boolean status = addrRepo.existsById(id);
		return status;
	}

}
