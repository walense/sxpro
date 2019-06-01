package com.zr.service;

import com.zr.dao.Updateinfodao;

public class UpdateinfoService {
	public boolean updateinfo(String[] arrary, int id) throws Exception {
		Updateinfodao updateinfodao=new Updateinfodao();		
		boolean flag=updateinfodao.updateinfo(arrary,id);		
		return flag;
		
	}

}
