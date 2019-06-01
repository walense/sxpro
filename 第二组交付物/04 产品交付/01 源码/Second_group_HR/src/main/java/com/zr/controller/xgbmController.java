package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.xgbmService;

public class xgbmController extends HttpServlet {
	xgbmService modifyAnnService = new xgbmService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setCharacterEncoding("utf8");
		
		String pwer = "0";
		HttpSession session = req.getSession();
		session.setAttribute("pwer", pwer);
		
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
