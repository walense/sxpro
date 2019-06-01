package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zr.service.FiledownloadService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FiledownloadController extends HttpServlet {
	FiledownloadService fd = new FiledownloadService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=1;
		req.getSession().setAttribute("power", i);
		JSONObject files = fd.getFile(Integer.parseInt(req.getParameter("page")),
				Integer.parseInt(req.getParameter("rows")));
		resp.setCharacterEncoding("utf8");
		//System.out.println(files);
		// System.out.println(files.toString());
		PrintWriter pw = resp.getWriter();
		pw.write(files.toString());
		pw.flush();
		pw.close();
	}

}
