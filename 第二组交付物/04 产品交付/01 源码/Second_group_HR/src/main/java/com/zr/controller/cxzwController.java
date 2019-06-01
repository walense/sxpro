package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.cxzwService;
import com.zr.service.cxzwService;

import net.sf.json.JSONObject;

public class cxzwController extends HttpServlet {

	cxzwService ss = new cxzwService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//展现user的数据
			req.setCharacterEncoding("utf8");
			String uname = req.getParameter("uname");
			int page = Integer.parseInt(req.getParameter("page"));
			int rows = Integer.parseInt(req.getParameter("rows"));
		    JSONObject datas = ss.getZw(page,rows,uname);
		    resp.setCharacterEncoding("utf8");
		    PrintWriter  pw = resp.getWriter();
		    pw.write(datas.toString());
		    pw.flush();
		    pw.close();
	}
}
