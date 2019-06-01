package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.Show_Menu_Tree_Service;

public class Tree_controller extends HttpServlet{
	Show_Menu_Tree_Service  tree = new Show_Menu_Tree_Service();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		//System.out.println("servlet启动");
		resp.setCharacterEncoding("utf8");
		PrintWriter   pw = resp.getWriter();
		pw.write(tree.getTree_menus().toString());
		pw.flush();
		pw.close();
	}
	
}
