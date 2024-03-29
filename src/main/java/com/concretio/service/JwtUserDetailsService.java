package com.concretio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import com.concretio.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.concretio.dao.UserDao;

/*
 * Create by Akash Chaturvedi
 * Service class to JWT requests to access Dao and check for the details of the user.
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(User user) throws Exception {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}
}