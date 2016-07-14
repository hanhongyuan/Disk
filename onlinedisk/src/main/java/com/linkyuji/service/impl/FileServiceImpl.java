package com.linkyuji.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkyuji.IDao.FileMapper;
import com.linkyuji.pojo.File;
import com.linkyuji.service.FileService;

@Service("fileServiceImpl")
public class FileServiceImpl implements FileService {
	@Autowired
	private FileMapper fileDao;

	@Transactional
	public void upload(File file) {
		// TODO Auto-generated method stub
		fileDao.upload(file);
	}
	
	@Transactional
	public List<File> loadFileByIdP(String id, String parent) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("userid", id);
		map.put("folderparent", parent);
		List<File> list = fileDao.loadFileByIdP(map);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getFilename());
		return list;
	}
	@Transactional
	public void deleteFile(int id) {
		// TODO Auto-generated method stub
		fileDao.deleteFile(id);
	}

	public File getFileById(int id) {
		// TODO Auto-generated method stub
		return fileDao.getFileById(id);
	}

	public List<File> loadAllFile() {
		// TODO Auto-generated method stub
		return fileDao.loadAllFile();
	}

}
