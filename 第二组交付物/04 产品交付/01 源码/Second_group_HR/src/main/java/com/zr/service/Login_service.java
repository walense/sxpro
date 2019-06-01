package com.zr.service;

import com.zr.dao.Login_table;
import com.zr.model.*;

public class Login_service {
	Login login_o =new Login();
	Login_table login_t= new Login_table();
	public Login query(Login login_i) 
	{		
		login_o=login_t.query(login_i);
		if(login_o==null)
		{
			System.out.println("无该用户");
			return login_o;
		}else{
			System.out.println("查询成功");
			return login_o;
		}
	}
}
