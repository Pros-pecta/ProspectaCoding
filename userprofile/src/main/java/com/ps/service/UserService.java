package com.ps.service;

import java.util.List;

import com.ps.model.User;

public interface UserService {
	
	public Integer saveUser(User user);
	
	public List<User> getUsers();
	
	public User getByUserName(String name);
	
	public User getUser(Integer id);
	
	public void deleteUser(Integer id);
	
	public boolean  isUserExist(Integer id); 
	
	public Integer updateUser(User user);
	
	public User getUserByEmail(String email);

}
