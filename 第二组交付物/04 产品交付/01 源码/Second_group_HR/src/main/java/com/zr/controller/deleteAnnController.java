package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.deleteAnnService;

import net.sf.json.JSONObject;

public class deleteAnnController extends HttpServlet {
	deleteAnnService das = new deleteAnnService();
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
			boolean flag = das.deleteAnnByAid(array);
		/*	String annName = req.getParameter("annName");
			String annContext = req.getParameter("annContext");
			int page = Integer.parseInt(req.getParameter("page"));
			int rows = Integer.parseInt(req.getParameter("rows"));
		    JSONObject datas = ss.getAnn(page,rows,annName, annContext);
		    PrintWriter  pw = resp.getWriter();
		    pw.write(datas.toString());
		    pw.flush();
		    pw.close();
		*/
	}
}
