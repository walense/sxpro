package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import com.zr.model.Submit;
import com.zr.util.JDBCUtil;

public class GetDataDao {
   public  int  getyuangonginfoCount(Submit data){
	   int rows = 0;
	   try {
		   List<Object> params = new ArrayList<Object>();
	   		StringBuffer sql = new StringBuffer("select * from information_yuangong  where 1 = 1 ");
	   		if (data.getBumen() != null && !"".equals(data.getBumen())) {
	   			sql.append("and bumen like ? ");
	   			params.add("%" + data.getBumen() + "%");
	   		}
	   		if (data.getShenfenzheng() != null && !"".equals(data.getShenfenzheng())) {
	   			sql.append("and shenfenzheng like ? ");
	   			params.add("%" + data.getShenfenzheng() + "%");
	   		}
	   		if (data.getZhiwei() != null && !"".equals(data.getZhiwei())) {
	   			sql.append("and zhiwei like ? ");
	   			params.add("%" + data.getZhiwei() + "%");
	   		}
	   		if (data.getSex() != null && !"".equals(data.getSex())) {
	   			sql.append("and sex like ? ");
	   			params.add("%" + data.getSex() + "%");
	   		}
	   		if (data.getShouji() != null && !"".equals(data.getShouji())) {
	   			sql.append("and shouji like ? ");
	   			params.add("%" + data.getShouji() + "%");
	   		}
	   		if (data.getName() != null && !"".equals(data.getName())) {
	   			sql.append("and name like ? ");
	   			params.add("%" + data.getName() + "%");
	   		}
	   		Connection  con = JDBCUtil.getConnection();
	   		PreparedStatement  pst = con.prepareStatement(sql.toString());  
	   		pst.setString(1, data.getBumen());
			pst.setString(2, data.getShenfenzheng());
			pst.setString(3, data.getZhiwei());
			pst.setString(4, data.getSex());
			pst.setString(5, data.getShouji());
			pst.setString(6, data.getName());
	   		ResultSet  rs = pst.executeQuery();
	   		if(rs.next())      
	   		{      
	   			//   rowCount=rs.getInt("record_");      
	   			rows = rs.getInt("id");  
	   		}
	   } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	   return rows;
	   
   }
 
   public List<Submit> getyuangonginfo(Submit data) {
	   
	   List<Submit>  yuangongif = new ArrayList<Submit>();
	   try {
		   		List<Object> params = new ArrayList<Object>();
		   		StringBuffer sql = new StringBuffer("select * from information_yuangong  where 1 = 1 ");
		   		if (data.getBumen() != null && !"".equals(data.getBumen())) {
		   			sql.append("and bumen like ? ");
		   			params.add("%" + data.getBumen() + "%");
		   		}
		   		if (data.getShenfenzheng() != null && !"".equals(data.getShenfenzheng())) {
		   			sql.append("and shenfenzheng like ? ");
		   			params.add("%" + data.getShenfenzheng() + "%");
		   		}
		   		if (data.getZhiwei() != null && !"".equals(data.getZhiwei())) {
		   			sql.append("and zhiwei like ? ");
		   			params.add("%" + data.getZhiwei() + "%");
		   		}
		   		if (data.getSex() != null && !"".equals(data.getSex())) {
		   			sql.append("and sex like ? ");
		   			params.add("%" + data.getSex() + "%");
		   		}
		   		if (data.getShouji() != null && !"".equals(data.getShouji())) {
		   			sql.append("and shouji like ? ");
		   			params.add("%" + data.getShouji() + "%");
		   		}
		   		if (data.getName() != null && !"".equals(data.getName())) {
		   			sql.append("and name like ? ");
		   			params.add("%" + data.getName() + "%");
		   		}
		   		Connection  con = JDBCUtil.getConnection();
		   		PreparedStatement  pst = con.prepareStatement(sql.toString());
		   		pst.setString(1, data.getBumen());
				pst.setString(2, data.getShenfenzheng());
				pst.setString(3, data.getZhiwei());
				pst.setString(4, data.getSex());
				pst.setString(5, data.getShouji());
				pst.setString(6, data.getName());
		   		ResultSet  rs = pst.executeQuery();
				System.out.println("jdkf");
				while (rs.next()) {
					Submit m = new Submit();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setSex(rs.getString("sex"));
					m.setShouji(rs.getString("shouji"));
					m.setYouxiang(rs.getString("youxiang"));
					m.setZhiwei(rs.getString("zhiwei"));
					m.setXueli(rs.getString("xueli"));
					m.setShenfenzheng(rs.getString("shenfenzheng"));
					m.setBumen(rs.getString("bumen"));
					m.setLxdz(rs.getString("lianxidizhi"));
					m.setJdrq(rs.getString("jiandangriqi"));
					System.out.println(m.getLxdz());
					yuangongif.add(m);
				}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return yuangongif;
   }
}