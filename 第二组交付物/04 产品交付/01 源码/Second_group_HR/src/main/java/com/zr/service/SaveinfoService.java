package com.zr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.zr.util.JDBCUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.zr.model.Saveinfo;;

public class SaveinfoService {
		/**
		 * 保存员工信息
		 * @param array 
		 * @param uname  
		 * @return
		 */
		public static boolean Saveinfo(String[] array){
				boolean  flag = false;
				try {
					String sql = "INSERT INTO information_yuangong (name,sex,shouji,youxiang,zhiwei ,xueli,shenfenzheng,bumen,lianxidizhi,jiandangriqi,chushengriqi,minzu,youzhengbianma,qq,zhengzhimianmao,dianhua) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
					Connection  con = JDBCUtil.getConnection();
					PreparedStatement  pst = con.prepareStatement(sql);
					for(int k=1;k<array.length+1;k++) {
						pst.setString(k,array[k-1] );
					}
					int i = pst.executeUpdate();
					if(i>=0){
						flag = true;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return  flag;
			}
			
		

}
