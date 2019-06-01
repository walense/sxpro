package com.zr.service;

import com.zr.dao.RemoveinfoDao;

public class RemoveService {
	public boolean removeinfo(int id) {
		RemoveinfoDao rDao=new RemoveinfoDao();		
		boolean flag=rDao.removeinfo(id);
		return flag;
	}

}
