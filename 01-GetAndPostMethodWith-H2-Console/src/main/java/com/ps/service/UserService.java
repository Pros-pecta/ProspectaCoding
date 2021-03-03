package com.ps.service;

import com.ps.model.User;

public interface UserService {
	
	public Integer SaveUser(User user);
	
	public User getByUserName(String name);
	
	public User getOneUser(Integer id);
	
	public void deleteById(Integer id);
	
	boolean  isUserExist(Integer id); 
	
	public Integer updateUser(User user);

}
