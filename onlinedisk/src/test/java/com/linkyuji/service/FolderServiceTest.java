package com.linkyuji.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linkyuji.IDao.FolderMapper;
import com.linkyuji.pojo.Folder;
import com.linkyuji.service.impl.FolderServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class FolderServiceTest {
	@Resource
	private FolderServiceImpl folderService;

	@Test
	public void addfolder(){
/*		Folder folder = new Folder();
		folder.setFoldername("asd");
		folder.setUserid("as");
		folder.setFolderparent(1);
		folderService.addFolder(folder);*/
	}
	@Test
	public void load(){
/*		String userid = "as";
		int p = 0;
		folderService.loadFolderByIdP(userid, p);*/
	}
	@Test
	public void find(){
/*		String userid = "as";
		int parent = 0;
		String foldername = "新建文件夹（1）";
		boolean a = folderService.checkFolder(foldername, userid, parent);
		System.out.println("是否可以创建"+a);*/
	}
}
