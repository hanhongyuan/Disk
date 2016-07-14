package com.linkyuji.IDao;

import java.util.List;

import com.linkyuji.pojo.Bloginfo;

public interface BloginfoMapper {
	void saveBlog(Bloginfo blog);
	List<Bloginfo> loadAllBlogByID(String userid);
	void updateBlog(Bloginfo blog);
	void deleteBlog(int blogid);
	List<Bloginfo> loadAllBlog();
	void deleteBlogByUserid(String userid);
}