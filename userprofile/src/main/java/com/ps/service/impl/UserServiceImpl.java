package com.ps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.model.User;
import com.ps.repo.UserRepository;
import com.ps.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public List<User> getUsers() {
		List<User> list=userRepo.findAll();
		return list;
	}

	@Override
	public Integer saveUser(User user) {
		return userRepo.save(user).getId();
	}

	
	@Override
	public User getByUserName(String name) {
		User user=userRepo.findByFirstName(name);
		return user;
	}

	@Override
	public User getUser(Integer id) {
		User user=null;
		Optional<User> opt=userRepo.findById(id);
		if(opt.isPresent()) {
			user=opt.get();
		}
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public boolean isUserExist(Integer id) {
		boolean status=userRepo.existsById(id);
		return status;
	}

	@Override
	public Integer updateUser(User user) {
		return userRepo.save(user).getId();
	}
	
	
	//checking email exist or not
	@Override
	public User getUserByEmail(String email) {
		User findByEmail = userRepo.findByEmail(email);
		return findByEmail;
	}

}
