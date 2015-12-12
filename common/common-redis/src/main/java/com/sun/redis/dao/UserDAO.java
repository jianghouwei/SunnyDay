package com.sun.redis.dao;

import com.sun.redis.model.User;

public interface UserDAO {

	public void saveUser(final User user);

	public User getUser(final long id);
}
