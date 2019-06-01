package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zr.util.JDBCUtil;

public class UpdateFileDao {

	public boolean updatefile(String title, String describe, int fid ) {
		boolean flag=false;
		try {
			Connection con =JDBCUtil.getConnection();
			String sql="UPDATE filedownload SET title =?,content=? WHERE fid = ?";
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1,title);
			pst.setString(2,describe);
			pst.setInt(3, fid);
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
