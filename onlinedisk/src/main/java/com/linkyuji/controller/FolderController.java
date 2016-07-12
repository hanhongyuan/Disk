package com.linkyuji.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkyuji.pojo.Folder;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.FolderService;
import com.linkyuji.service.UserService;

@Controller
@RequestMapping("/jsp/user")
public class FolderController {
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@Resource(name = "folderServiceImpl")
	private FolderService folderService;
	
	private int trytemp = 0;
	
	@RequestMapping(value = "/loadResource.do", method = RequestMethod.GET)
	public String loadResource(HttpServletRequest request, Model model){
		System.out.println("loadResource.do");
		int parent = Integer.parseInt(request.getParameter("parent").toString());
		Users user = (Users)request.getSession().getAttribute("user");
		List<Folder> folderlist = folderService.loadFolderByIdP(user.getUserid(), parent);
		request.getSession().setAttribute("parent", parent);
		request.getSession().setAttribute("folderlist", folderlist);
		return "redirect:/jsp/user/resource.jsp";
	}
	@RequestMapping(value = "/deleteFolder.do", method = RequestMethod.GET)
	public String deleteFolder(HttpServletRequest request, Model model){
		System.out.println("deleteFolder.do");
		int id = Integer.parseInt(request.getParameter("folderid").toString());
		System.out.println("ÎÄ¼þ¼ÐÐòºÅ"+id);
		folderService.deleteFolder(id);
		Users user = (Users)request.getSession().getAttribute("user");
		List<Folder> folderlist = folderService.loadFolderByIdP(user.getUserid(), 0);
		request.getSession().setAttribute("folderlist", folderlist);
		
		return "redirect:/jsp/user/resource.jsp";
	}
	
	@RequestMapping(value = "/addFolder.do", method = RequestMethod.POST)
	public String addFolder(HttpServletRequest request, Model model){
		System.out.println("addFolder.do");
		String name = (String)request.getParameter("thenewfolder");
		String userid = ((Users)request.getSession().getAttribute("user")).getUserid();
		
		int parent = Integer.parseInt(request.getSession().getAttribute("parent").toString());
		System.out.println(name+"  ~~~~~~~~" +userid);
		Folder folder = new Folder();
		folder.setFoldername(name);
		folder.setUserid(userid);
		folder.setFolderparent(parent);
		String tryname = name;
		if(trytemp!=0)
			tryname = name+"("+trytemp+")";
		if(folderService.checkFolder(tryname, userid, parent)){
			folder.setFoldername(tryname);
			folderService.addFolder(folder);
			trytemp=0;			
		}else{
			trytemp++;
			return this.addFolder(request,model);
		}
		
		
		List<Folder> folderlist = folderService.loadFolderByIdP(userid, parent);
		request.getSession().setAttribute("folderlist", folderlist);
		return "redirect:/jsp/user/resource.jsp";
	}

}
