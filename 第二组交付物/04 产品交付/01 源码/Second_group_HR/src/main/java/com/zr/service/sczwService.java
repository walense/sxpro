package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class sczwService {

	public boolean scZwByUid(String[] array) {
		boolean flag = false;
		try {
			String idArgs = "(";
			
			for(int a = 0; a < array.length; a++) {
				if(a > 0) {
					idArgs += ","+array[a];
				}else {
					idArgs += array[a];
				}
			}
			idArgs += ")";
		//	System.out.print(idArgs);
			String sql = "delete from four where uid in "+idArgs;
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
