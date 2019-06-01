package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zr.model.Submit;
import com.zr.service.SubmitService;

import jdk.management.resource.internal.TotalResourceContext;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class SubmitController extends HttpServlet {
	SubmitService  ss = new SubmitService();
	Submit sbm= new Submit();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		sbm.setName(req.getParameter("name"));
		sbm.setShenfenzheng(req.getParameter("sfz"));
		sbm.setZhiwei(req.getParameter("zhiwei")); 
		sbm.setSex(req.getParameter("sex")); 
		sbm.setShouji(req.getParameter("shouji")); 
		sbm.setBumen(req.getParameter("bumen")); 
		//System.out.println(sbm.getBumen());
		//有个查询员工信息的服务
		//System.out.println(req.getParameter("name"));
		JSONObject json=ss.condition(sbm);
		//有个删除员工信息的服务
		System.out.println(json.toString());
		    resp.setCharacterEncoding("utf-8");
			PrintWriter  wr =  resp.getWriter();
			wr.write(json.toString());
			wr.flush();
			wr.close();
	}

	private void testNull() {
		// TODO Auto-generated method stub
		
	}

}
