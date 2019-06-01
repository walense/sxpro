package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Yh;
import com.zr.util.JDBCUtil;

public class czyhDao {

	public int cxYhCount(String sql) {
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
	public List<Yh>  cxYhs(String sql){
		List<Yh> anns = new ArrayList<Yh>();
		try {
			ResultSet rs = null;
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Yh announs = new Yh(rs.getInt("useridd"), rs.getString("name"), rs.getString("uname"),rs.getString("pwd"),rs.getString("lvl"),rs.getString("date"));
				anns.add(announs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return anns;
	}
}
