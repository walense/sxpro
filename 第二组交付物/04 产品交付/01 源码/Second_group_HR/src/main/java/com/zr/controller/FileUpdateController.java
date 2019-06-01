package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.File;

public class FileUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		HttpSession session = req.getSession(true);
		Integer.parseInt(req.getParameter("page"));
			File datas=new File();
			datas.setDownload(req.getParameter("download"));
			datas.setFid(Integer.parseInt(req.getParameter("fid")));
			datas.setCreation_time(req.getParameter("creation_time"));
			datas.setDescribe(req.getParameter("describe"));
			datas.setFounder(req.getParameter("founder"));
			datas.setOperation(req.getParameter("operation"));
			datas.setTitle(req.getParameter("title"));
			req.getSession().setAttribute("datas", datas);
		
		//resp.sendRedirect(req.getContextPath() + "/wdgg.jsp");
		//req.getRequestDispatcher("wdgg.jsp").forward(req, resp);
	}

}
