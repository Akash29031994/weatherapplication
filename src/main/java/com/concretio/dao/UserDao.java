package com.concretio.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concretio.model.User;

/*
 * Create by Akash Chaturvedi   
 */

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}
