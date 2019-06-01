package com.zr.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import com.zr.model.Saveinfo;
import com.zr.service.SaveinfoService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleType;
import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.txw2.TypedXmlWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SaveinfoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//String id = req.getParameter("id");
		String name = req.getParameter("name");
		String shenfenzheng = req.getParameter("sfz");
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
		String bumen = req.getParameter("bumen");
		String jiandangriqi= req.getParameter("jdrq");
		String array[]= {name,sex,shouji,youxiang,zhiwei ,xueli,shenfenzheng,bumen,lianxidizhi,jiandangriqi,chushengriqi,minzu,youzhengbianma,qq,zhengzhimianmao,dianhua,};
		boolean  flag = SaveinfoService.Saveinfo(array);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}

}
