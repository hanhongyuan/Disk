package com.linkyuji.IDao;

import java.util.List;
import java.util.Map;

import com.linkyuji.pojo.File;

public interface FileMapper {

	void upload(File file);

	List<File> loadFileByIdP(Map map);

	void deleteFile(int id);

	File getFileById(int id);

}