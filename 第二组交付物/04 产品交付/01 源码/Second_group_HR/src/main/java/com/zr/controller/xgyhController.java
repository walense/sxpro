package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.xgyhService;

public class xgyhController extends HttpServlet {

	xgyhService xgyh = new xgyhService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setCharacterEncoding("utf8");
		String useridd = req.getParameter("useridd");
		String name = req.getParameter("name");
		String uname = req.getParameter("uname");
		String lvl = req.getParameter("lvl");
		//有个保存用户的服务
		boolean  flag = xgyh.xgyhByYhId(useridd, name, uname, lvl);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}
}
