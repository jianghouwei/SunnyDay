package com.sun.memcached.service;

import com.sun.memcached.model.User;

public interface SpyTwoUserService {
	
	public void saveUser(User user);

	public User getById(String userId);

	public void updateUser(User user);

	public void deleteUser(String userId);
	
}
