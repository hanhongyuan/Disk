package com.linkyuji.pojo;

public class Folder {
    private Integer idfolder;

    private String userid;

    private String foldername;

    private Integer folderparent;

    public Integer getIdfolder() {
        return idfolder;
    }

    public void setIdfolder(Integer idfolder) {
        this.idfolder = idfolder;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername == null ? null : foldername.trim();
    }

    public Integer getFolderparent() {
        return folderparent;
    }

    public void setFolderparent(Integer folderparent) {
        this.folderparent = folderparent;
    }
}