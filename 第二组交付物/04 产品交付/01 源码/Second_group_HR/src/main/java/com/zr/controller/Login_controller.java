package com.zr.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.*;
import com.zr.model.*;

public class Login_controller extends HttpServlet{
	Login login_o = new Login();
	Login_service login_s = new Login_service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		Login login_i=new Login();
		//将页面数据封装进model对象中
		login_i.setLoginname(req.getParameter("name"));
		login_i.setPassword(req.getParameter("password"));		
		//调用业务逻辑层
		login_o=login_s.query(login_i);
		if(login_o.getPassword()!=null) {
			//页面跳转
			resp.sendRedirect("main.jsp");
		}		
		else 
		{
			resp.setCharacterEncoding("utf8");
			PrintWriter   pw = resp.getWriter();
			pw.write("<script language='javascript'>alert('账号密码不对,请重新输入');</script>");
			resp.sendRedirect("login.jsp");
			pw.flush();
			pw.close();			
		}
	}

}
