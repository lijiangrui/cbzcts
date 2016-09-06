package com.jbl.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbl.model.Tuser;

public class TestUserService {
	@Test
	public void testUserService() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
		UserService uService = (UserService) ac.getBean("userService");
		Tuser u = new Tuser();
		u.setName("aaa");
		u.setPwd("123");
		u.setCreatetime(new Date());
		//uService.save(u);
	}
}
