package com.sun.memcached.dao;

import com.sun.memcached.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public User getById(String userId);

	public void updateUser(User user);

	public void deleteUser(String userId);

}
