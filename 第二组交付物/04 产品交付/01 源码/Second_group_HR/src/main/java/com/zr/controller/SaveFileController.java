package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.FiledownloadService;

public class SaveFileController extends HttpServlet{
    FiledownloadService fds=new FiledownloadService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String describe=req.getParameter("describe");
		//System.out.println(describe);
		boolean flag=fds.SaveFile(title,describe);
		Boolean  f =  new Boolean(flag);
		PrintWriter pw = resp.getWriter();
		pw.write(f.toString());
		pw.flush();
		pw.close();
	}

}
