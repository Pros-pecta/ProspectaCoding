package com.ps.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.ps.model.User;
import com.ps.repo.UserRepository;
import com.ps.service.UserService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/*	@PostMapping
		public ResponseEntity<?> getUserInfo(@RequestBody(required = true) User user) {
			System.out.println(user);
			ResponseEntity<?> resp = null;
		      User userName = userService.getByUserName(user.getFirstName());
		      
		      if(StringUtils.hasText(user.getFirstName())) {
			if (userName==null) {
				Integer id=userService.SaveUser(user);
				resp=new ResponseEntity<String>("saved with id:"+id,HttpStatus.OK);
			}
			
			if(userName!=null) {
				throw new UserNotFoundException("User Already Exists" + user.getFirstName());
			}
		      }
		      else {
		    		throw new UserNotFoundException("Please check the request and payload and retry");
		      }
			return resp;
		}*/
	
	
	
	
	@PostMapping
	public ResponseEntity<?> getUserInfo(@RequestBody(required = true) User user) {
		System.out.println(user);
		ResponseEntity<?> resp = null;
	      
	try {
		if(user!=null && user.toString().isBlank()) {
			Integer id=userService.SaveUser(user);
			resp= new ResponseEntity<String>("saved with id:"+id,HttpStatus.OK);	
		}
	} catch (Exception e) {
	throw new UserNotFoundException("User Already save "+user.getFirstName());
	}
	return resp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable(required = true) Integer id) {
		System.out.println();
		ResponseEntity<String> resp = null;

		try {
			User  userId= userService.getOneUser(id);
			if (userId!=null) {
				return new ResponseEntity<User>(userId, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("No Student exist with id:"+id,HttpStatus.OK);
			}
			
		} catch (Exception e) {
			throw  new UserNotFoundException("please try after some time");	
		}
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		
		ResponseEntity<String> resp=null;
		try {
			
			if(userService.isUserExist(id)) {
				userService.deleteById(id);
				resp=new ResponseEntity<String>("Record Deleted"+id,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Record not exist by this id::"+id,HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			throw new UserNotFoundException("please try after sometime");
		}
		
		return resp;
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody User user){
		ResponseEntity<String> resp = null;
		
		//find the user exist or not 
		Integer userId=user.getId();
		
		try {
			
			if(userService.isUserExist(userId)) {
				userService.updateUser(user);
				resp=new ResponseEntity<String>("User Record Update"+userId,HttpStatus.OK);
			}
			
			else {
				resp=new ResponseEntity<String>("User not exist",HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			throw new UserNotFoundException("Pleace contact with Amin and Try later");
		}
		
		return resp;
		
	}
}
