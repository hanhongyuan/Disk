package com.linkyuji.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkyuji.pojo.Bloginfo;
import com.linkyuji.pojo.Folder;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.BlogService;
import com.linkyuji.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private Model theModel;

	@Resource(name = "userServiceImpl")
	private UserService userService;
	@Resource(name = "blogServiceImpl")
	private BlogService blogService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Model getTheModel() {
		return theModel;
	}

	public void setTheModel(Model theModel) {
		this.theModel = theModel;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping(value = "/load.do", method = RequestMethod.POST)
	public String toIndex(HttpServletRequest request, Model model) {
		theModel = model;
		System.out.println("进入login.do方法");
		Users userLogin = new Users();
		userLogin.setUserid(request.getParameter("username"));
		userLogin.setUserpsw(request.getParameter("password"));
		System.out.println(userLogin.getUserid() + "    " + userLogin.getUserpsw());
		Users user = new Users();

		if (this.userService.getLoginUser(userLogin)) {
			user = this.userService.getUserById(userLogin.getUserid());
			System.out.println(user.getUserid() + "get user success");
			model.addAttribute("user", user);
			request.getSession().setAttribute("user", user);

		} else {

			model.addAttribute("user can not in use");
			System.out.println("can not get user");
		}
		if (user.getUsertype() == 1) {
			List<Users> list = userService.loadAllUsers();
			request.getSession().setAttribute("userlist", list);
			model.addAttribute("managerurl", "managermain.jsp");
			model.addAttribute("userlist", list);			
		}else{
			System.out.println("blog user:"+user.getUserid());			
		}

		return "redirect:/jsp/loadjump.jsp";
	}

	@RequestMapping(value = "/regiset.do", method = RequestMethod.POST)
	public String regiest(HttpServletRequest request, Model model) {

		System.out.println("/regiset.do");
		Users userRegist = new Users();
		userRegist.setUserid(request.getParameter("username"));
		userRegist.setUserpsw(request.getParameter("password"));
		if (this.userService.regiest(userRegist))
			System.out.println("注册成功");
		else
			System.out.println("注册失败");
		return "redirect:/login.jsp";
	}

	@ResponseBody
	@RequestMapping(value = "/couldregiset.do", method = RequestMethod.POST)
	public boolean assign(String userId, HttpServletResponse response) {
		System.out.println("userId:" + userId);
		Users a = userService.getUserById(userId);
		if (a != null)
			return false;
		return true;
	}

	@ResponseBody
	@RequestMapping(value = "/geturl.do", method = RequestMethod.POST)
	public String geturl(String theurl, HttpServletResponse response) {
		
		String url = theurl + ".jsp";
		System.out.println(url);
		theModel.addAttribute("managerurl", url);
		return url;
	}

	@ResponseBody
	@RequestMapping(value = "/trylogin.do", method = RequestMethod.POST)
	public boolean trylogin(String userId, String password, HttpServletResponse response) {
		System.out.println("userId:" + userId + "---------password:" + password);
		Users userLogin = new Users();
		userLogin.setUserid(userId);
		userLogin.setUserpsw(password);
		System.out.println(userLogin.getUserid() + "    " + userLogin.getUserpsw());
		Users user = new Users();

		if (this.userService.getLoginUser(userLogin)) {
			user = this.userService.getUserById(userLogin.getUserid());
			System.out.println(user.toString() + "get user success");
			return true;

		} else {

			System.out.println("can not get user");
			return false;
		}
	}

}
