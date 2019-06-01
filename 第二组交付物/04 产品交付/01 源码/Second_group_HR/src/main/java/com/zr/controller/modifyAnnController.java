package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.modifyAnnService;

public class modifyAnnController extends HttpServlet {
	modifyAnnService modifyAnnService = new modifyAnnService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setCharacterEncoding("utf8");
		String annName = req.getParameter("annName");
		String annContext = req.getParameter("annContext");
		String aid = req.getParameter("aid");
		//有个保存用户的服务
		boolean  flag = modifyAnnService.modifyAnnByAnnName(annName, annContext, aid);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}

}
