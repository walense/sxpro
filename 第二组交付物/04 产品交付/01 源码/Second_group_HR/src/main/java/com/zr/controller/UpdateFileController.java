package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.File;
import com.zr.service.UpdateFileService;

public class UpdateFileController extends HttpServlet{
	UpdateFileService ufs=new UpdateFileService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title=req.getParameter("title");
		String describe=req.getParameter("describe");		
		HttpSession session = req.getSession(true);
		File file=(File) session.getAttribute("datas");
		//System.out.println(file.getFid());
		boolean flag=ufs.UpdateFile(title,describe,file.getFid());
		Boolean f =new Boolean(flag);
		PrintWriter pw=resp.getWriter();
		pw.write(f.toString());
		pw.flush();
		pw.close();
		//System.out.println(file.getFid());
	}

}
