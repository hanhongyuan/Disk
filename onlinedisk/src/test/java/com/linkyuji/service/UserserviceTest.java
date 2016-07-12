package com.linkyuji.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linkyuji.IDao.UsersMapper;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserserviceTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource
	private UsersMapper userDao;
	
	@Resource
	private UserServiceImpl userD;
	
	@Test
	public void loadTest() {
		Users user1 = new Users();
		user1.setUserid("admin");
		user1.setUserpsw("admin");
		System.out.println("loadTest:"+userD.getLoginUser(user1));		
	}
	
	@Test
	public void registerTest(){
		System.out.println("registerTest:");
		Users user1 = new Users();
		user1.setUserid("admin");
		user1.setUserpsw("admin");
		
		System.out.println(userD.regiest(user1));
		Users user2 = new Users();
		user2.setUserid("user");
		user2.setUserpsw("admin");
		System.out.println(userD.regiest(user2));
		
		Users user3 = new Users();
		user3.setUserid("");
		user3.setUserpsw("");
		System.out.println(userD.regiest(user3));
		
		
	}
	

}
