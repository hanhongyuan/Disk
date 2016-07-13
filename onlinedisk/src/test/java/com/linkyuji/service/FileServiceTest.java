package com.linkyuji.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linkyuji.pojo.File;
import com.linkyuji.service.impl.FileServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class FileServiceTest {
	@Resource
	private FileServiceImpl fileService;
	
	@Test
	public void test1(){
		List<File> list = fileService.loadFileByIdP("as","0");

		
		
	}

}
