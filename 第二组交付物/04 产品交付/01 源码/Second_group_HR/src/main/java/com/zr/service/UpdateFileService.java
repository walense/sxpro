package com.zr.service;

import com.zr.dao.UpdateFileDao;

public class UpdateFileService {

	public boolean UpdateFile(String title, String describe, int fid) {
		// TODO Auto-generated method stub
		UpdateFileDao uf=new UpdateFileDao();
		boolean flag=uf.updatefile(title,describe,fid);
		
		return flag;
		
		
	}
	
}
