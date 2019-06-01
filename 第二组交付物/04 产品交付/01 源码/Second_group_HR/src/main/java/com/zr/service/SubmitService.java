package com.zr.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.model.Submit;
import com.zr.util.JDBCUtil;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.zr.dao.*;

public class SubmitService {
	GetDataDao   gdao = new GetDataDao();
	public JSONObject condition(Submit sbm) {
		//System.out.println("2");
		JSONObject  flag = new JSONObject();
		List<Submit> falg_1=gdao.getyuangonginfo(sbm);
		//System.out.println("dao完成");
		JSONArray   flag_2=JSONArray.fromObject(falg_1);
		
		flag.put("tatol", gdao.getyuangonginfoCount(sbm));
		flag.put("rows",flag_2 );
		
		
		return  flag;
	}
	
	
}
