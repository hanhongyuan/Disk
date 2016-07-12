package com.linkyuji.service;

import java.util.List;

import com.linkyuji.pojo.Bloginfo;

public interface BlogService {
	public boolean saveBlog(Bloginfo blog);
	public List<Bloginfo> loadAllBlogByID(String userid);
	public boolean modifyBlog(Bloginfo blog);
	public boolean deleteBlog(int blogid);
}
