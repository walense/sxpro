package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.xgzwService;

public class xgzwController extends HttpServlet {
	xgzwService modifyAnnService = new xgzwService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setCharacterEncoding("utf8");
		String uname = req.getParameter("uname");
		String usname = req.getParameter("usname");
		String uid = req.getParameter("uid");
		//有个保存用户的服务
		boolean  flag = modifyAnnService.modifyAnnByAnnName(uname, usname, uid);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}

}
