package com.sun.memcached.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.memcached.model.User;
import com.sun.memcached.service.SpyTwoUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext-*.xml"})
public class TestSpyTMemcached {

	@Autowired
	private SpyTwoUserService spyTwoUserService;
	
	
	@Test
	public void TestUsers() {

		System.out.println("hello....");

		User u = new User();
		u.setUserId("2");
		u.setUsername("钟俊");
		u.setPassword("testUser");

		spyTwoUserService.saveUser(u);

		User u1 = spyTwoUserService.getById("2");
		System.out.println(u1.getUsername());

		u.setUsername("LeLe");
		spyTwoUserService.updateUser(u);

		User u2 = spyTwoUserService.getById("2");
		System.out.println(u2.getUsername());

	}
	
}
