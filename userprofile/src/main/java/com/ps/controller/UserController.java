package com.ps.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.exception.UserNotFoundException;
import com.ps.model.Address;
import com.ps.model.User;
import com.ps.service.AddressService;
import com.ps.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private AddressService addrService;

	@PostMapping /*(consumes = "application/json", produces = "application/json")*/
	public ResponseEntity<?> createUser(@Valid @RequestBody(required = true) User user) {
		
		LOGGER.info("Enter into the User Post method" + user);
		
		ResponseEntity<?> resp = null;
		User email = userService.getUserByEmail(user.getEmail());
		try {
				if (email == null) {
					Integer id = userService.saveUser(user);
					resp = new ResponseEntity<User>(user, HttpStatus.CREATED);
				}
				if (email != null) {
					resp = new ResponseEntity<String>("User already Exist", HttpStatus.BAD_REQUEST);
				}
		} catch (Exception e) {
			throw new UserNotFoundException("Please check the request and payload and retry");
		}
		return resp;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable(required = true) Integer id) {
		System.out.println();
		ResponseEntity<String> resp = null;

		try {
			User userId = userService.getUser(id);
			if (userId != null) {
				return new ResponseEntity<User>(userId, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Student exist with id:" + id, HttpStatus.OK);
			}

		} catch (Exception e) {
			throw new UserNotFoundException("please try after some time");
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

		ResponseEntity<String> resp = null;
		try {

			if (userService.isUserExist(id)) {
				userService.deleteUser(id);
				resp = new ResponseEntity<String>("Record Deleted" + id, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("Record not exist by this id::" + id, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			throw new UserNotFoundException("please try after sometime");
		}

		return resp;
	}

	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		ResponseEntity<String> resp = null;

		// find the user exist or not
		Integer userId = user.getId();

		try {

			if (userService.isUserExist(userId)) {
				userService.updateUser(user);
				resp = new ResponseEntity<String>("User Record Update" + userId, HttpStatus.OK);
			}

			else {
				resp = new ResponseEntity<String>("User not exist", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			throw new UserNotFoundException("Pleace contact with Amin and Try later");
		}

		return resp;

	}
	

	@GetMapping
	public ResponseEntity<?> getUsersAllData() {
		ResponseEntity<?> resp = null;

		try {
			List<User> list = userService.getUsers();
			if(list.size() > 0  ) {
				resp= new  ResponseEntity<List<User>>(list, HttpStatus.OK);
			}
			else {
			resp = new ResponseEntity<String>("Unable to fetch data",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		} catch (Exception e) {
			throw new UserNotFoundException("Pleace contact with Amin and Try later");
		}
		return resp;

	}
	
	
	
	
	
	//Address Data is started after this =======================================
	
	
	@GetMapping("/address")
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
	
	
	
	@PostMapping("/address")
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
