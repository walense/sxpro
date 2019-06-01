package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.FiledownloadService;

import net.sf.json.JSONObject;

public class FileScController extends HttpServlet{
	FiledownloadService fdls=new FiledownloadService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
			resp.setCharacterEncoding("utf8");
			JSONObject files = fdls.SCFile(Integer.parseInt(req.getParameter("fid")),Integer.parseInt(req.getParameter("page")),Integer.parseInt(req.getParameter("rows")));
			PrintWriter pw = resp.getWriter();
			pw.write(files.toString());
			pw.flush();
			pw.close();
		
	}
	
}
