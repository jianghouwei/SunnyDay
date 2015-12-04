package com.sun.memcached.service.impl;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.springframework.stereotype.Service;

import com.sun.memcached.model.User;
import com.sun.memcached.service.XMemUserService;

@Service
public class XMemUserServiceImpl implements XMemUserService {

	private XMemcachedClient cacheClient;

	public void saveUser(User user) {
		try {
			cacheClient.add(user.getUserId(), 3600, user);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public User getById(String userId) {
		try {
			return cacheClient.get("userId");
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateUser(User user) {
		try {
			this.cacheClient.replace(user.getUserId(), 3600, user);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String userId) {
		try {
			this.cacheClient.delete(userId);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	public XMemcachedClient getCacheClient() {
		return cacheClient;
	}

	public void setCacheClient(XMemcachedClient cacheClient) {
		this.cacheClient = cacheClient;
	}

}
