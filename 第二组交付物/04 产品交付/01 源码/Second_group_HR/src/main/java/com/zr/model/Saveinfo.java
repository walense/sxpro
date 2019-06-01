package com.zr.model;
public class Saveinfo {
	private int qqh;
	private String name;
	private String yzbm;
	private String csrq;
	private String minzu;
	private String dianhua;
	private String sex;
	private String zzmm;
	private String xueli;
	private String zhiwei;
	private String lxdz;
	private String jiandangriqi;
	private String bumen;
	private String youxiang;
	private String sfz;
	private String shouji;
	private Object jdrq;
	public int getQqh() {
		return qqh;
	}
	public Saveinfo(int qqh, String name, String yzbm, String csrq, String minzu, String dianhua, String sex,
			String zzmm, String xueli, String zhiwei, String lxdz, String jdrq, String bumen, String xingbie,
			String youxiang, String sfz, String shouji) {
		super();
		this.qqh = qqh;
		this.name = name;
		this.yzbm = yzbm;
		this.csrq = csrq;
		this.minzu = minzu;
		this.dianhua = dianhua;
		this.sex = sex;
		this.zzmm = zzmm;
		this.xueli = xueli;
		this.zhiwei = zhiwei;
		this.lxdz = lxdz;
		this.setJdrq(jdrq);
		this.bumen = bumen;
		this.youxiang = youxiang;
		this.sfz = sfz;
		this.shouji = shouji;
	}
	public void setQqh(int qqh) {
		this.qqh = qqh;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getZhiwei() {
		return zhiwei;
	}
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	public String getLxdz() {
		return lxdz;
	}
	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}
	public String getJiandangriqi() {
		return jiandangriqi;
	}
	public void setJiandangriqi(String jiandangriqi) {
		this.jiandangriqi = jiandangriqi;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getShouji() {
		return shouji;
	}
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public Object getJdrq() {
		return jdrq;
	}
	public void setJdrq(Object jdrq) {
		this.jdrq = jdrq;
	}
}
