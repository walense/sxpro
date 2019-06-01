package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zr.util.*;
import com.zr.model.Tree_menu;

public class Menu_tree_table {
	List<Tree_menu> ltm= new ArrayList<Tree_menu>();
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	
	public void setRoot_Menu(int i)
	{
		this.query(i);
	}
	public List<Tree_menu> getRoot_Menu() {
		// TODO 自动生成的方法存根
		ltm.clear();
		this.setRoot_Menu(0);
		return this.ltm;
	}
	public void setChildren_Menu(int i)
	{
		this.query(i);
	}
	public List<Tree_menu> getChildren_Menu(int i) {
		// TODO 自动生成的方法存根
		ltm.clear();
		this.setChildren_Menu(i);
		return this.ltm;
	}
	public  List<Tree_menu> query(int i){	
		try {
			conn = JDBCUtil.getConnection();
			// 3.操作数据库，实现增删改查
			//sql
	        String sql = "select * from menu_tree where id = ?";
	        //预编译
	        ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	        //传参
	        ptmt.setInt(1, i);
	        //执行
	        rs=ptmt.executeQuery();
	        while(rs.next())
	        {
	        	Tree_menu mt = new Tree_menu();
	        	/*
	        	 * //一，原始tree节点属性
	        	 * 	//节点的 id，它对于加载远程数据很重要。
	        	 * int id;
	        	 * //要显示的节点文本。
	        	 * String text;
	        	 * //节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
	        	 * String state;
	        	 * //指示节点是否被选中。
	        	 * boolean chechked;
	        	 * //attributes：给一个节点添加的自定义属性。是JSON对象。本例中最重要是存储{"menupath":URL}JSON对象，URL为字符串
	        	 * String attributes;
	        	 * //children：定义了一些子节点的节点数组。是存内涵JSON对象的JSON数组。但是本例中用于存储子节点ID
	        	 * int children;*/
	        	mt.setId(rs.getInt("id"));
	        	mt.setText(rs.getString("text"));
	        	mt.setState(rs.getString("state"));
	        	mt.setChechked(rs.getBoolean("chechked"));
	        	mt.setAttributes(rs.getString("attributes"));
	        	if(rs.getString("children")==null) {
	        		//如果children节点为空，着不给与赋值
	        		mt.setChildren(rs.getInt(0));
	        	}else {
	        		mt.setChildren(rs.getInt("children"));
	        	}	        	
	        	ltm.add(mt);
	        }
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
            /*// 释放资源
			try {
				JDBC_walense.closeResource(conn, rs, ptmt);
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }*/	
			return this.ltm;
        }
		
	}
}
