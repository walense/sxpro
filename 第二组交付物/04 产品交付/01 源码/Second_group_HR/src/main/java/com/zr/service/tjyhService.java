package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class tjyhService {

	public boolean tjyhByYhName(String name, String uname, String pwd, String lvl, String date){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO third_menu (name,uname,pwd,lvl,date) VALUES (?,?,?,?,?)";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, uname);
			pst.setString(3, pwd);
			pst.setString(4, lvl);
			pst.setString(5, date);
			int i = pst.executeUpdate();
			if(i>=0){
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  flag;
	}
}
