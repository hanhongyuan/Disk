package com.linkyuji.IDao;

import java.util.List;
import java.util.Map;

import com.linkyuji.pojo.Folder;

public interface FolderMapper {
	void addFolder(Folder folder);
	List<Folder> loadFolderByIdP(Map map);
	Folder findFolder(Map map);
	void deleteFolder(int folderid);
	Folder getFolderById(int id);

}