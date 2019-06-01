package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zr.model.Announ;
import com.zr.util.JDBCUtil;

public class GetAnnDao {

	public int getAnnounceCount(String sql) {
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
	public List<Announ>  getAnnouns(String sql){
		List<Announ> anns = new ArrayList<Announ>();
		try {
			ResultSet rs = null;
			Connection  con = JDBCUtil.getConnection();
			PreparedStatement  pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Announ announs = new Announ(rs.getInt("aid"), rs.getString("annName"),rs.getString("annContext"),rs.getString("announcer"),rs.getString("annTime"));
				anns.add(announs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return anns;
	}
}
