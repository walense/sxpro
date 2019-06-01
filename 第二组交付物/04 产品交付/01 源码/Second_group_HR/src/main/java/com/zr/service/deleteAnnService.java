package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.zr.util.JDBCUtil;

public class deleteAnnService {
	
	public boolean deleteAnnByAid(String[] array) {
		boolean flag = false;
		try {
			String idArgs = "(";
		//	String sql = "INSERT INTO ann (annName,annContext,announcer,annTime) VALUES (?,?,?,?)";
			
			for(int a = 0; a < array.length; a++) {
				if(a > 0) {
					idArgs += ","+array[a];
				}else {
					idArgs += array[a];
				}
			}
			idArgs += ")";
		//	System.out.print(idArgs);
			String sql = "delete from ann where aid in "+idArgs;
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
		
		
		return flag;
	}

}
