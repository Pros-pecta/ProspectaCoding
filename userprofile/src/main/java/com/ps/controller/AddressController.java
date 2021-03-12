package com.ps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.exception.UserNotFoundException;
import com.ps.model.Address;
import com.ps.service.AddressService;
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addrService;
	
	@GetMapping
	public ResponseEntity<?> getAddress(){
		ResponseEntity<?> resp=null;	
		try {
			List<Address> list = addrService.getAddreeses();
			if(list!=null) {
				resp=new ResponseEntity<List<Address>>(list,HttpStatus.OK);
			}
			else {
				resp=new ResponseEntity<String>("Unable to fetch data",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			throw new UserNotFoundException("Pleace contact with Amin and Try later");
		}
		return resp;
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> createAddress(@Valid @RequestBody Address address){
		ResponseEntity<?> resp=null;
		
		try {
			if(address!=null && !address.equals(null)) {
				Integer userId = addrService.saveAddress(address);
				resp=new ResponseEntity<String>("Address save with"+userId,HttpStatus.CREATED);
			}
			else {
				resp=new ResponseEntity<String>("Address not save try after sometiems",HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			throw new UserNotFoundException("Please check the request and payload and retry");
		}
		return resp;
	}
}
