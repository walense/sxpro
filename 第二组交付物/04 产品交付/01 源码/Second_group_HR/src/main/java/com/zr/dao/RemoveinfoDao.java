package com.zr.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class RemoveinfoDao {
	 public boolean removeinfo(int id) {
		 boolean flag=false;
		 try {
			Connection  con = JDBCUtil.getConnection();
			String sql="DELETE FROM information_yuangong WHERE id = ? ";
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			int  rs = pst.executeUpdate();
			if(rs>=0) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		 
	 }

}
