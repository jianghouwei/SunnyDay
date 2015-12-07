package com.sun.memcached.service.impl;

import net.spy.memcached.MemcachedClient;

import org.springframework.stereotype.Service;

import com.sun.memcached.model.User;
import com.sun.memcached.service.SpyTwoUserService;

@Service
public class SpyTwoUserServiceImpl implements SpyTwoUserService {

	
	private MemcachedClient twomcacheClient;

	public void saveUser(User user) {
		twomcacheClient.add(user.getUserId(), 3600, user);
	}

	public User getById(String userId) {
		return (User) twomcacheClient.get(userId);
	}

	public void updateUser(User user) {
		twomcacheClient.replace(user.getUserId(), 3600, user);
	}

	public void deleteUser(String userId) {
		twomcacheClient.delete(userId);
	}

	public MemcachedClient getTwomcacheClient() {
		return twomcacheClient;
	}

	public void setTwomcacheClient(MemcachedClient twomcacheClient) {
		this.twomcacheClient = twomcacheClient;
	}


}
