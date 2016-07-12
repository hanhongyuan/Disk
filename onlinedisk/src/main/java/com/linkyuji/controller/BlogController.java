package com.linkyuji.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkyuji.pojo.Bloginfo;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.BlogService;

@Controller
@RequestMapping("/jsp/user/blog")
public class BlogController {
	@Resource(name = "blogServiceImpl")
	private BlogService blogService;

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@RequestMapping(value = "/loadblog.do", method = RequestMethod.GET)
	public String loadblog(HttpServletRequest request, Model model) {

		System.out.println("/loadblog.do");
		Users user = (Users) request.getSession().getAttribute("user");
		List<Bloginfo> bloglist = blogService.loadAllBlogByID(user.getUserid());
		request.getSession().setAttribute("bloglist", bloglist);
		return "redirect:/jsp/user/blog.jsp";
	}
	
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public String save(HttpServletRequest request, Model model) {

		System.out.println("/save.do");
		Bloginfo blog = new Bloginfo();
		blog.setBlogname(request.getParameter("name"));
		blog.setUserid(((Users)request.getSession().getAttribute("user")).getUserid());
		blog.setBlogrtf(request.getParameter("content"));
		
		System.out.println(blog.getBlogname()+"\n"+blog.getBlogrtf()+"\n"+blog.getUserid());
		
		if(this.blogService.saveBlog(blog)){
			System.out.println("成功");
			Users user =(Users) request.getSession().getAttribute("user");
			List<Bloginfo> bloglist = blogService.loadAllBlogByID(user.getUserid());
			request.getSession().setAttribute("bloglist", bloglist);
		}
		else
			System.out.println("失败");

		return "redirect:/jsp/user/blog.jsp";
	}
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {

		System.out.println("/update.do");
		Bloginfo blog = new Bloginfo();
		blog.setBlogname(request.getParameter("name"));
		blog.setUserid(((Users)request.getSession().getAttribute("user")).getUserid());
		blog.setBlogrtf(request.getParameter("content"));
		blog.setIdbloginfo(((Bloginfo)request.getSession().getAttribute("uodateblog")).getIdbloginfo());
		
		System.out.println(blog.getBlogname()+"\n"+blog.getBlogrtf()+"\n"+blog.getIdbloginfo());
		
		if(this.blogService.modifyBlog(blog)){
			System.out.println("成功");
			Users user =(Users) request.getSession().getAttribute("user");
			List<Bloginfo> bloglist = blogService.loadAllBlogByID(user.getUserid());
			request.getSession().setAttribute("bloglist", bloglist);
		}
		else
			System.out.println("失败");

		return "redirect:/jsp/user/blog.jsp";
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {

		System.out.println("/delete.do");
		List<Bloginfo> list = (List<Bloginfo>)request.getSession().getAttribute("bloglist");
	    
	     String temp = (String)request.getParameter("item");

	     Bloginfo blog = (Bloginfo)list.get(Integer.parseInt(temp));
		int blogid = blog.getIdbloginfo();
		System.out.println(blogid);
		if(this.blogService.deleteBlog(blogid)){
			System.out.println("成功");
			Users user =(Users) request.getSession().getAttribute("user");
			List<Bloginfo> bloglist = blogService.loadAllBlogByID(user.getUserid());
			request.getSession().setAttribute("bloglist", bloglist);
		}
		else
			System.out.println("失败");
		return "redirect:/jsp/user/blog.jsp";
	}
}
