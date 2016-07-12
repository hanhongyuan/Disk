package com.linkyuji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkyuji.IDao.BloginfoMapper;
import com.linkyuji.pojo.Bloginfo;
import com.linkyuji.service.BlogService;

@Service("blogServiceImpl")
public class BlogServiceImpl implements BlogService{
	@Autowired
	private BloginfoMapper blogDao;
	
	
	@Transactional
	public boolean saveBlog(Bloginfo blog) {
		// TODO Auto-generated method stub
		blogDao.saveBlog(blog);
		return true;
	}

	@Transactional
	public List<Bloginfo> loadAllBlogByID(String userid) {
		return blogDao.loadAllBlogByID(userid);
	
	}
	@Transactional
	public boolean modifyBlog(Bloginfo blog) {
		System.out.println("blogServiceImpl----modifyBlog");
		blogDao.updateBlog(blog);
		return true;
	}

	public boolean deleteBlog(int blogid) {
		blogDao.deleteBlog(blogid);
		return true;
	}
	

}
