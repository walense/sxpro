package com.zr.model;

public class File {

	private int fid;
	private String title;
	private String Creation_time;
	private String describe;
	private String Founder;
	private String operation;
	private String download;
	
	public File(int fid, String title, String creation_time, String describe, String founder, String operation,
			String download) {
		super();
		this.fid = fid;
		this.title = title;
		Creation_time = creation_time;
		this.describe = describe;
		Founder = founder;
		this.operation = operation;
		this.download = download;
	}
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreation_time() {
		return Creation_time;
	}
	public void setCreation_time(String creation_time) {
		Creation_time = creation_time;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getFounder() {
		return Founder;
	}
	public void setFounder(String founder) {
		Founder = founder;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	
}
