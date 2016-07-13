package com.linkyuji.pojo;

public class File {
	private Integer idfile;

	private String filename;

	private String folderid;

	private String url;

	private String userid;

	public Integer getIdfile() {
		return idfile;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setIdfile(Integer idfile) {
		this.idfile = idfile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename == null ? null : filename.trim();
	}

	public String getFolderid() {
		return folderid;
	}

	public void setFolderid(String folderid) {
		this.folderid = folderid == null ? null : folderid.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
}