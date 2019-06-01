package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class xgyhService {

	public boolean xgyhByYhId(String useridd, String name, String uname, String lvl){
		boolean  flag = false;
		try {
			String sql = "UPDATE third_menu SET name=\'"+name+"\',uname=\'"+uname+"\',lvl=\'"+lvl+"\' WHERE useridd="+useridd;
		//	System.out.print(sql);
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
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
