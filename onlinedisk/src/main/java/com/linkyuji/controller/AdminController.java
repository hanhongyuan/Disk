package com.linkyuji.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkyuji.pojo.Bloginfo;
import com.linkyuji.pojo.File;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.BlogService;
import com.linkyuji.service.FileService;
import com.linkyuji.service.UserService;

@Controller
@RequestMapping("/jsp/admin")
public class AdminController {
	@Resource(name = "userServiceImpl")
	private UserService userService;
	@Resource(name = "blogServiceImpl")
	private BlogService blogService;
	@Resource(name = "fileServiceImpl")
	private FileService fileService;

	@RequestMapping(value = "/loaduser.do", method = RequestMethod.GET)
	public String loaduser(HttpServletRequest request, Model model) {
		System.out.println("admin:     /loaduser.do");
		List<Users> list = userService.loadAllUsers();
		request.getSession().setAttribute("userlist", list);
		model.addAttribute("managerurl", "managermain.jsp");
		model.addAttribute("userlist", list);
		return "redirect:/jsp/admin/usermanager.jsp";
	}

	@RequestMapping(value = "/deleteuser.do", method = RequestMethod.GET)
	public String deleteuser(HttpServletRequest request, Model model) {
		System.out.println("admin:     /deleteuser.do");
		int id = Integer.parseInt(request.getParameter("iduser"));
		userService.deleteUserById(id);
		return loaduser( request, model);
	}
	
	@RequestMapping(value = "/modifyuser.do", method = RequestMethod.POST)
	public String modifyuser(HttpServletRequest request, Model model) {
		System.out.println("admin:     /modifyuser.do");
		String userid = request.getParameter("userid");
		String userpsw = request.getParameter("password");
		String username = request.getParameter("username");
		Users user  = new Users();
		user.setUserid(userid);
		user.setUsername(username);
		user.setUserpsw(userpsw);
		userService.modifyUser(user);
		return loaduser( request, model);
	}

	@RequestMapping(value = "/loadfile.do", method = RequestMethod.GET)
	public String loadfile(HttpServletRequest request, Model model) {
		System.out.println("admin:     /loadfile.do");
		List<File> list = fileService.loadAllFile();
		request.getSession().setAttribute("allfile", list);
		return "redirect:/jsp/admin/resource.jsp";
	}

	@RequestMapping(value = "/deletefile.do", method = RequestMethod.GET)
	public String deletefile(HttpServletRequest request, Model model) {

		System.out.println("admin:     /deletefile.do");
		int id = Integer.parseInt(request.getParameter("idfile").toString());
		System.out.println("文件序号" + id);
		com.linkyuji.pojo.File filesql = fileService.getFileById(id);
		java.io.File f = new java.io.File(filesql.getUrl()); // 输入要删除的文件位置
		if (f.exists())
			f.delete();
		fileService.deleteFile(id);
		return loadfile(request, model);
	}

	@RequestMapping(value = "/loadblog.do", method = RequestMethod.GET)
	public String loadblog(HttpServletRequest request, Model model) {
		System.out.println("admin:     /loadblog.do");
		List<Bloginfo> list = blogService.loadAllBlog();
		request.getSession().setAttribute("allblog", list);
		return "redirect:/jsp/admin/blog.jsp";
	}
	@RequestMapping(value = "/deleteblog.do", method = RequestMethod.GET)
	public String deleteblog(HttpServletRequest request, Model model) {

		System.out.println("admin:     /deleteblog.do");
		int id = Integer.parseInt(request.getParameter("idbloginfo").toString());

		blogService.deleteBlog(id);
		return loadblog(request,model);
	}
	
	@RequestMapping(value = "/downloadfile.do", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response,HttpServletRequest request, Model model)throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");  
        response.setContentType("multipart/form-data");  
        int id = Integer.parseInt(request.getParameter("idfile"));
        com.linkyuji.pojo.File sqlfile = fileService.getFileById(id);
       	String filename = new String(sqlfile.getFilename().getBytes(), "ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;fileName="+filename); 
        try {  
            java.io.File file=new java.io.File(sqlfile.getUrl());  
            System.out.println(file.getAbsolutePath());  
            InputStream inputStream=new FileInputStream(file);  
            OutputStream os=response.getOutputStream();  
            byte[] b=new byte[1024];  
            int length;  
            while((length=inputStream.read(b))>0){  
                os.write(b,0,length);  
            }  
            inputStream.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
	}
	
	
}
