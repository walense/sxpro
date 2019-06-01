package com.zr.model;

public class Announ {

	private int aid;
	private String annName;
	private String annContext;
	private String announcer;
	private String annTime;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getannName() {
		return annName;
	}
	public void setannName(String annName) {
		this.annName = annName;
	}
	public String getannContext() {
		return annContext;
	}
	public void setannContext(String annContext) {
		this.annContext = annContext;
	}
	public String getannouncer() {
		return announcer;
	}
	public void setannouncer(String announcer) {
		this.announcer = announcer;
	}
	public String getannTime() {
		return annTime;
	}
	public void setannTime(String annTime) {
		this.annTime = annTime;
	}
	public Announ (int aid, String annName, String annContext, String announcer, String annTime) {
		super();
		this.aid = aid;
		this.annName = annName;
		this.annContext = annContext;
		this.announcer = announcer;
		this.annTime = annTime;
	}
}
