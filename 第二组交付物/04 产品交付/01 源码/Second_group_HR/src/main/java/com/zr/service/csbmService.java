package com.zr.service;

import java.util.List;

import com.zr.dao.cxBmDao;
import com.zr.model.Bm;

import net.sf.json.JSONObject;

public class csbmService {

	public JSONObject getBm(int page, int rows, String uname) {
		JSONObject  data = new JSONObject();
		cxBmDao ga = new cxBmDao();
		String sql1 = null;
		String sql2 = null;
		if(uname == null) {
			sql1 = "select count(*) from three";
			sql2 = "select * from three limit "+(page*rows-rows)+","+rows;
		}else {
			sql1 = "select count(*) from three where uname LIKE \'%"+uname+"%\'";
			sql2 = "select * from three where uname LIKE \'%"+uname+"%\' limit "+(page*rows-rows)+","+rows;
		}
		data.put("total", ga.cxBmCount(sql1));
		List<Bm> anns = ga.cxBms(sql2);
		data.put("rows", anns);
		return  data;
	}
}
