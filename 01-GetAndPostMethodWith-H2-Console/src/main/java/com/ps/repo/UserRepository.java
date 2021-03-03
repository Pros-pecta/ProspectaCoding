package com.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ps.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByFirstName(String firstName);

}
