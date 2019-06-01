package com.zr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.sczwService;

public class sczwController extends HttpServlet {

	sczwService das = new sczwService();
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
			resp.setCharacterEncoding("utf8");
			String[] array = req.getParameterValues("array[]");
			boolean flag = das.scZwByUid(array);
	}
}
