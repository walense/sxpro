package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class modifyAnnService {

	public boolean modifyAnnByAnnName(String annName, String annContext, String aid){
		boolean  flag = false;
		try {
			String sql = "UPDATE ann SET annName=\'"+annName+"\',annContext=\'"+annContext+"\' WHERE aid="+aid;
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
