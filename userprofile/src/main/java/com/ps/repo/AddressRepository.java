package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
