package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.model.User;
import com.zr.util.JDBCUtil;


public class User_table {
	User user = new User();
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	public User getUser() {
		return this.user=this.query();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public  User query(){
		String uname=user.getUser_name();
		String upassword=user.getUser_password();
		try {
			conn = JDBCUtil.getConnection();
			// 3.操作数据库，实现增删改查
			//sql
	        String sql = "select * from user where user_name = ? and user_password = ?";
	        //预编译
	        ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	        //传参
	        ptmt.setString(1, uname);
	        ptmt.setString(2, upassword);
	        //执行
	        rs=ptmt.executeQuery();
	        while(rs.next())
	        {
	        	user.setUser_name(rs.getString("user_name"));
	        	user.setUser_password(rs.getString("user_password"));
	        	//user.setUser_power(rs.getInt("power"));
	        }
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
            // 释放资源
			try {
				JDBCUtil.closeResource(conn, rs, ptmt);
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }			
        }
		return this.user;
	}

}
