package com.zr.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.zr.dao.GetAnnDao;
import com.zr.model.Announ;

import net.sf.json.JSONObject;

public class searchAnnService {

	
	public JSONObject getAnn(int page, int rows, String annName, String annContext) {
		JSONObject  data = new JSONObject();
		GetAnnDao ga = new GetAnnDao();
		String sql1 = null;
		String sql2 = null;
		//调数据库层上面的2个操作
		//1.信息的总数  51条数据  dao层   public  int  getXXXCount()
		//data.put("total", 51);
		//2.sql  limit a,b   select * from  user limit 0,10
		//  public List<XXX>  getXXXs(int  page,int rows)
		//a起始位置  b参数代表取多少条数据  
		//page=1 rows=10   ====> a=0  b=10
		//page=2 rows=10   ====> a=10 b=10
		//page=3 rows=10   ====> a=20 b=10
		//limit的b=rows   a=(page-1)*rows
		/*	List<Announ>  anns = new ArrayList<Announ>();
		anns.add(new Announ("1","a","b","c"));
		anns.add(new Announ("1","a","b","c"));
		anns.add(new Announ("1","a","b","c"));
		data.put("rows", anns);*/
		if(annName == null && annContext == null) {
			sql1 = "select count(*) from ann";
			sql2 = "select * from ann limit "+(page*rows-rows)+","+rows;
		}else {
			sql1 = "select count(*) from ann where annName LIKE \'%"+annName+"%\' AND annContext LIKE \'%"+annContext+"%\'";
			sql2 = "select * from ann where annName LIKE \'%"+annName+"%\' AND annContext LIKE \'%"+annContext+"%\'"+" ORDER BY annTime DESC limit "+(page*rows-rows)+","+rows;
		}
		data.put("total", ga.getAnnounceCount(sql1));
		List<Announ> anns = ga.getAnnouns(sql2);
		data.put("rows", anns);
		return  data;
	}
}
