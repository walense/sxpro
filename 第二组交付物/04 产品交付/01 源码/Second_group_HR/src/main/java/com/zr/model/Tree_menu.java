package com.zr.model;

public class Tree_menu {
	//一，原始tree节点属性
	//节点的 id，它对于加载远程数据很重要。
	int id;
	//要显示的节点文本。
	String text;
	//节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
	String state;
	//指示节点是否被选中。
	boolean chechked;
	//attributes：给一个节点添加的自定义属性。是JSON对象。本例中最重要是存储{"menupath":URL}JSON对象，URL为字符串
	String attributes;
	//children：定义了一些子节点的节点数组。是存内涵JSON对象的JSON数组。但是本例中用于存储子节点ID
	int children;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChechked() {
		return chechked;
	}
	public void setChechked(boolean chechked) {
		this.chechked = chechked;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	
}
