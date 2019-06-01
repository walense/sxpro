package com.zr.service;

import java.util.ArrayList;
import java.util.List;

import com.zr.dao.GetFileDao;
import com.zr.dao.SaveFileDao;
import com.zr.model.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FiledownloadService {
	GetFileDao getFileDao =new GetFileDao();
	
	public JSONObject getFile(int page, int i) {
		int rows=getFileDao.getRows();
		JSONObject file=new JSONObject();
		//System.out.println(rows);
		file.put("total", rows);
		List<File> files=new ArrayList<File>();
		files=getFileDao.getFile(page,i);
		file.put("rows", files);
		return file;
		
	}
	public JSONObject SSFile(String title, int i, int j) {
		int rows=getFileDao.getRows(title);		
		JSONObject file=new JSONObject();
		file.put("total", rows);
		List<File> files = new ArrayList<File>();
		files=getFileDao.getFile1(title,i,j);
		file.put("rows", files);
		return file;
		
	}	
	public JSONObject SCFile(int fid,int i,int j) {
		getFileDao.getSC(fid);
		int rows=getFileDao.getRows();
		JSONObject file=new JSONObject();
		file.put("total", rows);
		List<File> files = new ArrayList<File>();
		files=getFileDao.getFile(i,j);
		file.put("rows", files);
		return file;
		
	}
	public boolean SaveFile(String title, String describe) {
		SaveFileDao saveFileDao = new SaveFileDao();
		boolean flag= saveFileDao.SaveFile(title,describe);
		return flag;
		
	}
	

}
