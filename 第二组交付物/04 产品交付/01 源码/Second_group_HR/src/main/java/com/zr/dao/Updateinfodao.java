package com.zr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zr.util.JDBCUtil;

public class Updateinfodao {
	public boolean updateinfo(String[] arrary,int id) throws Exception {
		boolean flag=false;
		Connection  con = com.zr.util.JDBCUtil.getConnection();
		String sql="UPDATE information_yuangong SET name = ? ,sex=?,shouji=?,youxiang=?,zhiwei=? ,xueli=?,shenfenzheng=?,bumen=?,lianxidizhi=?,jiandangriqi=?,chushengriqi=?,minzu=?,youzhengbianma=?,qq=?,zhengzhimianmao=?,dianhua=? WHERE id = ?";
		PreparedStatement  pst = con.prepareStatement(sql);
		for(int i=0;i<arrary.length;i++) {
			pst.setString(i+1, arrary[i]);
		}
		pst.setInt(arrary.length+1, id);
		int  rs = pst.executeUpdate();
		if(rs>=0) {
			flag=true;
		}
		System.out.println(flag);
		return flag;
		
	}

}
