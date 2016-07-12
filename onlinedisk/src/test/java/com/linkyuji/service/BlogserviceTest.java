package com.linkyuji.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linkyuji.IDao.BloginfoMapper;
import com.linkyuji.pojo.Bloginfo;
import com.linkyuji.service.impl.BlogServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class BlogserviceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Resource
	private BloginfoMapper blogDao;
	
	@Resource
	private BlogServiceImpl blogService;
	@Test
	public void test() {
		Bloginfo blog = new Bloginfo();
		blog.setIdbloginfo(2);
		blog.setBlogname("asdasd");
		blog.setBlogrtf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		blog.setUserid("linkyuji");
		blogService.modifyBlog(blog);
	}
	@Test
	public void getBlog(){
		List<Bloginfo> list= blogService.loadAllBlogByID("as");
		System.out.println(list.get(0).getBlogname());
	}

}
