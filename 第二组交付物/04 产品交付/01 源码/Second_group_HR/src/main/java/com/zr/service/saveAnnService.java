package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class saveAnnService {

	public boolean saveAnnByAnnName(String annName, String annContext, String userName, String annTime){
		boolean  flag = false;
		try {
			String sql = "INSERT INTO ann (annName,annContext,announcer,annTime) VALUES (?,?,?,?)";
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1, annName);
			pst.setString(2, annContext);
			pst.setString(3, userName);
			pst.setString(4, annTime);
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
