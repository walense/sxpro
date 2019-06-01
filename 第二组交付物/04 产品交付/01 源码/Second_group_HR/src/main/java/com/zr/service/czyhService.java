package com.zr.service;

import java.util.List;

import com.zr.dao.czyhDao;
import com.zr.model.Yh;

import net.sf.json.JSONObject;

public class czyhService {

	public JSONObject getYh(int page, int rows, String uname, String lvl) {
		JSONObject  data = new JSONObject();
		czyhDao ga = new czyhDao();
		String sql1 = null;
		String sql2 = null;
		System.out.print(lvl);
		if(uname == null) {
			sql1 = "select count(*) from third_menu";
			sql2 = "select * from third_menu limit "+(page*rows-rows)+","+rows;
		}else if(uname != null && Integer.parseInt(lvl) == 0){
			sql1 = "select count(*) from third_menu where uname LIKE \'%"+uname+"%\'";
			sql2 = "select * from third_menu where uname LIKE \'%"+uname+"%\' limit "+(page*rows-rows)+","+rows;
		}else{
			sql1 = "select count(*) from third_menu where lvl=\'"+lvl+"\' AND uname LIKE \'%"+uname+"%\'";
			sql2 = "select * from third_menu where lvl=\'"+lvl+"\' AND uname LIKE \'%"+uname+"%\' limit "+(page*rows-rows)+","+rows;
		}
		data.put("total", ga.cxYhCount(sql1));
		List<Yh> anns = ga.cxYhs(sql2);
		data.put("rows", anns);
		return  data;
	}
}
