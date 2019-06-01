package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zr.model.Login;
import com.zr.util.*;


public class Login_table {
	Login login_o = new Login();
	Connection conn;
	PreparedStatement ptmt;
	ResultSet rs;
	JDBCUtil jut =new JDBCUtil();
	public  Login query(Login login_i){
		try {
			conn = jut.getConnection();
			// 3.操作数据库，实现增删改查
			//sql
	        String sql = "select * from login where loginname = ? and password = ?";
	        //预编译
	        ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
	        //传参
	        ptmt.setString(1, login_i.getLoginname());
	        ptmt.setString(2, login_i.getPassword());
	        //执行
	        rs=ptmt.executeQuery();
	        while(rs.next())
	        {
	        	login_o.setLoginname(rs.getString("loginname"));
	        	login_o.setPassword(rs.getString("password"));
	        	login_o.setPower(rs.getInt("power"));
	        }
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {           		
        }
		return this.login_o;
	}

}
