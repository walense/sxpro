package com.zr.model;

public class Submit {

	private int id;
	private String sex;
	private String menupath;
	private String xueli;
	private String zhiwei;
	private String name;
	private String lianxidizhi;
	private String jiandangriqi;
	private String bumen;
	private String xingbie;
	private String youxiang;
	private String shenfenzheng;
	private String shouji;
	private String suoshubumen;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getShouji() 
	{
		return shouji;
	}
	
	public void setShouji(String shouji) {
		// TODO Auto-generated method stub
		this.shouji = shouji;
	}	
	public String getYouxiang() {
		return youxiang;
	}
	
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	public String getZhiwei() {
		return zhiwei;
		
	}
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
		
	}
	public String getXueli() {
		return xueli;
		
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
		
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng=shenfenzheng;
	}
	public String getLxdz() {
		return lianxidizhi;
	}
	public void setLxdz(String lianxidizhi) {
		this.lianxidizhi=lianxidizhi;
	}
	public String getJdrq() {
		return jiandangriqi;
	}
	public void setJdrq(String jiandangriqi) {
		this.jiandangriqi=jiandangriqi;
	}
	public Submit(String zhiwei ,String lianxidizhi,String jiandangriqi, String name, String sex,String shouji,String shenfenzheng,String suoshubumen) {
		super();
		this.zhiwei = zhiwei;
		this.name = name ;
		this.sex = sex;
		this.shouji = shouji ;
		this.shenfenzheng =shenfenzheng ;
		this.suoshubumen = suoshubumen ;
		this.lianxidizhi=lianxidizhi;
		this.jiandangriqi=jiandangriqi;
	}
	public Submit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSuoshubumen() {
		// TODO Auto-generated method stub
		return suoshubumen;
	}
	public void setSuoshubumen(String string) {
		// TODO Auto-generated method stub
		this.suoshubumen=suoshubumen;
	}
	
}
