package com.zr.dao;

import com.mysql.jdbc.PacketTooBigException;
import com.zr.model.File;
import com.zr.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GetFileDao {
		
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public int getRows() {
		//查询出记录的数量
		int rows=0;
		try {
			Connection connection =JDBCUtil.getConnection();
			String sql="select count(*) AS fid from  filedownload";
			PreparedStatement  pst = connection.prepareStatement(sql);
			ResultSet  rs = pst.executeQuery();
			while(rs.next()) {
				rows=rs.getInt("fid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rows;		
	}
	public int getRows(String title) {
		//查询出相同的标题的数据条数
		int rows=0;
		try {
			Connection connection =JDBCUtil.getConnection();
			String sql="select count(1) AS fid from  filedownload where title=?";
			PreparedStatement  pst = connection.prepareStatement(sql);
			pst.setString(1, title);
			ResultSet  rs = pst.executeQuery();
			while(rs.next()) {
				rows=rs.getInt("fid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rows;		
	}
	public List<File> getFile( int page, int i) {
		
		//查询数据库中的数据
		List<File> files=new ArrayList<File>();
		try {
			Connection con =JDBCUtil.getConnection();
			String sql ="select * from  filedownload limit ?,?";
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1, (page-1)*i);
			preparedStatement.setInt(2, i);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				File file =new File();
				file.setTitle(rs.getString("title"));
				file.setCreation_time(format.format(rs.getTimestamp("Creation_time")));
				file.setDescribe(rs.getString("content"));
				file.setDownload(rs.getString("download"));
				file.setFounder(rs.getString("founder"));
				file.setOperation(rs.getString("operation"));
				file.setFid(rs.getInt("fid"));
				files.add(file);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return files;
		
	}
	public List<File> getFile1(String title,int i, int j) {
		
	List<File> files=new ArrayList<File>();
		try {
			Connection connection =JDBCUtil.getConnection();
			String sql="select * from  filedownload  where title=? limit ?,?";
			PreparedStatement  pst = connection.prepareStatement(sql);
			pst.setString(1, title);
			pst.setInt(2,(i-1)*j);
			pst.setInt(3, j);
			ResultSet  rs = pst.executeQuery();
			while(rs.next()) {
				File file =new File();
				file.setTitle(rs.getString("title"));
				file.setCreation_time(format.format(rs.getTimestamp("Creation_time")));
				file.setDescribe(rs.getString("content"));
				file.setDownload(rs.getString("download"));
				file.setFounder(rs.getString("founder"));
				file.setOperation(rs.getString("operation"));
				file.setFid(rs.getInt("fid"));
				files.add(file);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return files;		
	}
	public void getSC(int fid) {
		// TODO Auto-generated method stub
		
		try {
			Connection con =JDBCUtil.getConnection();
			String sql="DELETE FROM filedownload where fid=?";
			PreparedStatement  pst = con.prepareStatement(sql);			
			pst.setInt(1, fid);
			int rs =pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
