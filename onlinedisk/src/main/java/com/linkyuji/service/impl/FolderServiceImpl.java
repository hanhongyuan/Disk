package com.linkyuji.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkyuji.IDao.FolderMapper;
import com.linkyuji.pojo.Folder;
import com.linkyuji.service.FolderService;

@Service("folderServiceImpl")
public class FolderServiceImpl implements FolderService {
	@Autowired
	private FolderMapper folderDao;
	@Transactional
	public boolean addFolder(Folder folder) {
		// TODO Auto-generated method stub
		folderDao.addFolder(folder);
		return false;
	}

	public List<Folder> loadAllFolder() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public boolean deleteFolder(int folderid) {
		// TODO Auto-generated method stub
		
		folderDao.deleteFolder(folderid);
		return true;
	}
	
	@Transactional
	public List<Folder> loadFolderByIdP(String userid, int parent) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("folderparent", parent);
		List<Folder> list = folderDao.loadFolderByIdP(map);
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).getFoldername());
		return list;
	}
	@Transactional
	public boolean checkFolder(String foldername, String userid, int parent) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("foldername", foldername);
		map.put("userid", userid);
		map.put("parent", parent);
		
		Folder folderSql = folderDao.findFolder(map);
		if(folderSql != null)
			return false;
		else
		return true;
	}

	public Folder getFolderById(int id) {
		// TODO Auto-generated method stub
		
		return folderDao.getFolderById(id);
	}

}
