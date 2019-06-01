package com.zr.model;

public class Yh {

	private int useridd;
	private String name;
	private String uname;
	private String pwd;
	private String lvl;
	private String date;
	
	public int getUseridd() {
		return useridd;
	}
	public void setUseridd(int useridd) {
		this.useridd = useridd;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Yh(int useridd, String name, String uname, String pwd, String lvl, String date) {
		super();
		this.useridd = useridd;
		this.name = name;
		this.uname = uname;
		this.pwd = pwd;
		this.lvl = lvl;
		this.date = date;
	}
	
}
