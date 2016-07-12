package com.linkyuji.service;

import java.util.List;

import com.linkyuji.pojo.Folder;

public interface FolderService {
	public boolean addFolder(Folder folder);
	public List<Folder> loadAllFolder();
	public boolean deleteFolder(int folderid);
	public List<Folder> loadFolderByIdP(String userid,int parent);
	public boolean checkFolder(String foldername,String userid,int parent);
	

}
