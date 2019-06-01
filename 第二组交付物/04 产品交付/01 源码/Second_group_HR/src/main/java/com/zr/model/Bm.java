package com.zr.model;

public class Bm {
	private int uid;
	private String uname;
	private String usname;
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public Bm(int uid, String uname, String usname) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.usname = usname;
	}

}
