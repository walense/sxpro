package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Bm;
import com.zr.util.JDBCUtil;

public class cxBmDao {

	public int cxBmCount(String sql) {
		int Count = 0;
		try {
			
			ResultSet rs = null;
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				Count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Count;	
	}
	public List<Bm>  cxBms(String sql){
		List<Bm> anns = new ArrayList<Bm>();
		try {
			ResultSet rs = null;
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Bm announs = new Bm(rs.getInt("uid"), rs.getString("uname"),rs.getString("usname"));
				anns.add(announs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return anns;
	}
}
