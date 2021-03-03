package com.ps.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.model.User;
import com.ps.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Integer SaveUser(User user) {
		return userRepo.save(user).getId();
	}

	
	@Override
	public User getByUserName(String name) {
		User user=userRepo.findByFirstName(name);
		return user;
	}

	@Override
	public User getOneUser(Integer id) {
		User user=null;
		Optional<User> opt=userRepo.findById(id);
		if(opt.isPresent()) {
			user=opt.get();
		}
		return user;
	}

	@Override
	public void deleteById(Integer id) {
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

}
