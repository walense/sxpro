package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zr.util.JDBCUtil;

public class SaveFileDao {
	public boolean SaveFile(String title, String describe) {
		Date date = new Date();
		Timestamp timeStamep = new Timestamp(date.getTime());
		boolean flag=false;
		String user="yx";
		try {
			Connection con =JDBCUtil.getConnection();
			String sql="INSERT INTO filedownload (title,Creation_time,Founder,operation,download,content) VALUES (?,?,?,?,?,?)";
			PreparedStatement  pst = con.prepareStatement(sql);
			pst.setString(1,title);
			pst.setTimestamp(2,timeStamep);
			pst.setString(3,user);
			pst.setString(4,user);
			pst.setString(5,user);
			pst.setString(6,describe);
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
