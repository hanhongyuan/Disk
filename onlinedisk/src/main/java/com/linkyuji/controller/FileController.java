package com.linkyuji.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.linkyuji.pojo.Folder;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.FileService;

@Controller
@RequestMapping("/jsp/user")
public class FileController {
	@Resource(name = "fileServiceImpl")
	private FileService fileService;

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request, Model model) throws IllegalStateException, IOException {
		System.out.println("upload.do");
		List<MultipartFile> fileList = request.getFiles("upload");
		Iterator<MultipartFile> iterFile = fileList.iterator();
		while (iterFile.hasNext()) {
			MultipartFile file = iterFile.next();
			if (file != null) {
				String myFileName = file.getOriginalFilename();
				if (myFileName.trim() != "") {
					System.out.println(myFileName);
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
					String time = dateFormat.format(now);
					System.out.println(time);
					String fileName = time + "_" + file.getOriginalFilename();
					String path = "F:/disk/" + fileName;
					File localFile = new File(path);
					file.transferTo(localFile);

					String parent = request.getSession().getAttribute("parent").toString();
					com.linkyuji.pojo.File file2sql = new com.linkyuji.pojo.File();
					String userid = ((Users) request.getSession().getAttribute("user")).getUserid();
					file2sql.setFilename(myFileName);
					file2sql.setUrl(path);
					file2sql.setFolderid(parent);
					file2sql.setUserid(userid);
					fileService.upload(file2sql);
					List<com.linkyuji.pojo.File> filelist = fileService.loadFileByIdP(userid, parent + "");
					request.getSession().setAttribute("filelist", filelist);
				}
			}
		}
		return "redirect:/jsp/user/resource.jsp";
	}

	@RequestMapping(value = "/deletefile.do", method = RequestMethod.GET)
	public String deleteFolder(HttpServletRequest request, Model model) {
		System.out.println("deletefile.do");
		int id = Integer.parseInt(request.getParameter("fileid").toString());
		System.out.println("文件序号" + id);
		com.linkyuji.pojo.File filesql = fileService.getFileById(id);
		File f = new File(filesql.getUrl()); // 输入要删除的文件位置
		if (f.exists())
			f.delete();

		fileService.deleteFile(id);

		String parent = request.getSession().getAttribute("parent").toString();
		String userid = ((Users) request.getSession().getAttribute("user")).getUserid();

		List<com.linkyuji.pojo.File> filelist = fileService.loadFileByIdP(userid, parent + "");
		request.getSession().setAttribute("filelist", filelist);

		return "redirect:/jsp/user/resource.jsp";
	}

	@RequestMapping(value = "/download.do", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response,HttpServletRequest request, Model model)throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");  
        response.setContentType("multipart/form-data");  
        int id = Integer.parseInt(request.getParameter("fileid"));
        com.linkyuji.pojo.File sqlfile = fileService.getFileById(id);
       	String filename = new String(sqlfile.getFilename().getBytes(), "ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;fileName="+filename); 
        try {  
            File file=new File(sqlfile.getUrl());  
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
