package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.RemoveService;

public class RemoveinfoController extends HttpServlet{
	RemoveService rs=new RemoveService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		boolean flag=rs.removeinfo(id);
		Boolean  f =  new Boolean(flag);
		PrintWriter pw =resp.getWriter();
		pw.write(f.toString());
		pw.flush();
		pw.close();
	}

}
