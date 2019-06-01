package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.model.Submit;
import com.zr.service.UpdateinfoService;

public class UpdateinfoController extends HttpServlet {
	UpdateinfoService us =new UpdateinfoService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		HttpSession session = req.getSession(true);		
		Submit datas=new Submit();
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String shenfenzheng = req.getParameter("shenfenzheng");
		String zhiwei = req.getParameter("zhiwei");
		String sex = req.getParameter("sex");
		String xueli = req.getParameter("xueli");
		String youxiang = req.getParameter("youxiang");
		String shouji = req.getParameter("shouji");
		String dianhua = req.getParameter("dianhua");
		String zhengzhimianmao = req.getParameter("zzmm");
		String qq = req.getParameter("qqh");
		String lianxidizhi = req.getParameter("lxdz");
		String youzhengbianma = req.getParameter("yzbm");
		String chushengriqi = req.getParameter("csrq");
		String minzu = req.getParameter("minzu");
		String bumen = null;
		String jiandangriqi=null;
		String array[]= {name,sex,shouji,youxiang,zhiwei ,xueli,shenfenzheng,bumen,lianxidizhi,jiandangriqi,chushengriqi,minzu,youzhengbianma,qq,zhengzhimianmao,dianhua,};
		//req.getSession().setAttribute("datas", datas);
		
		try {
			flag=us.updateinfo(array,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean  f =  new Boolean(flag);
		PrintWriter pw =resp.getWriter();
		pw.write(f.toString());
		pw.flush();
		pw.close();
		
	}

}
