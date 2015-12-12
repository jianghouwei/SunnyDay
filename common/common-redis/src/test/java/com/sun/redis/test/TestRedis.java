package com.sun.redis.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.redis.dao.UserDAO;
import com.sun.redis.dao.impl.RedisClient;
import com.sun.redis.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class TestRedis extends AbstractJUnit4SpringContextTests {

	
	@Resource
    private RedisClient<String, String> redisClient;
     
     
    @Test 
    public void login(){
        redisClient.add("aaaa", "aaaa");
        System.out.println(redisClient.get("aaaa"));
    }
    
    @Resource
	private UserDAO userDAO;
	
	@Test
	public void add(){
		User user1 = new User();
        user1.setId(1);
        user1.setName("obama");
        userDAO.saveUser(user1);
        User user2 = userDAO.getUser(1);
        System.out.println(user2.getName());
	}
}
