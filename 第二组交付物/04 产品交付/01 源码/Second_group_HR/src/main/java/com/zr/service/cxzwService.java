package com.zr.service;

import java.util.List;

import com.zr.dao.cxZwDao;
import com.zr.model.Zw;

import net.sf.json.JSONObject;

public class cxzwService {

	public JSONObject getZw(int page, int rows, String uname) {
		JSONObject  data = new JSONObject();
		cxZwDao ga = new cxZwDao();
		String sql1 = null;
		String sql2 = null;
		if(uname == null) {
			sql1 = "select count(*) from four";
			sql2 = "select * from four limit "+(page*rows-rows)+","+rows;
		}else {
			sql1 = "select count(*) from four where uname LIKE \'%"+uname+"%\'";
			sql2 = "select * from four where uname LIKE \'%"+uname+"%\' limit "+(page*rows-rows)+","+rows;
		}
		data.put("total", ga.cxZwCount(sql1));
		List<Zw> anns = ga.cxZws(sql2);
		data.put("rows", anns);
		return  data;
	}
}
