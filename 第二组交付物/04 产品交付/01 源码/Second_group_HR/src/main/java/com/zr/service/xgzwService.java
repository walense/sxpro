package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class xgzwService {
	public boolean modifyAnnByAnnName(String uname, String usname, String uid){
		boolean  flag = false;
		try {
			String sql = "UPDATE four SET uname=\'"+uname+"\',usname=\'"+usname+"\' WHERE uid="+uid;
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
