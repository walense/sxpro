package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Zw;
import com.zr.util.JDBCUtil;

public class cxZwDao {

	public int cxZwCount(String sql) {
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
	public List<Zw>  cxZws(String sql){
		List<Zw> anns = new ArrayList<Zw>();
		try {
			ResultSet rs = null;
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Zw announs = new Zw(rs.getInt("uid"), rs.getString("uname"),rs.getString("usname"));
				anns.add(announs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return anns;
	}
}
