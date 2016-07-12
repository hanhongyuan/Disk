package com.linkyuji.pojo;

import java.util.Date;

public class Bloginfo {
    private Integer idbloginfo;

    private String blogname;

    private Date createdate;

    private Date modifydate;

    private String userid;

    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private String blogrtf;

    public Integer getIdbloginfo() {
        return idbloginfo;
    }

    public void setIdbloginfo(Integer idbloginfo) {
        this.idbloginfo = idbloginfo;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname == null ? null : blogname.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }



    public String getBlogrtf() {
        return blogrtf;
    }

    public void setBlogrtf(String blogrtf) {
        this.blogrtf = blogrtf == null ? null : blogrtf.trim();
    }
}