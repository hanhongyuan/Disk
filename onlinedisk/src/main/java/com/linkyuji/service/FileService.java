package com.linkyuji.service;

import java.util.List;

import com.linkyuji.pojo.File;

public interface FileService {
	public void upload(File file);
	public List<File> loadFileByIdP(String id,String parent);
	public void deleteFile(int id);
	public File getFileById(int id);
	public List<File> loadAllFile();

}
