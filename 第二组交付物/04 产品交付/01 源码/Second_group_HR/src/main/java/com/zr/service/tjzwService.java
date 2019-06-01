package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class tjzwService {

	public boolean tjzwByZwName(String uname, String usname){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO four (uname,usname) VALUES (?,?)";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, usname);
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
