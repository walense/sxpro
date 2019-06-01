package com.zr.service;

import java.util.List;

import com.zr.dao.Menu_tree_table;
import com.zr.model.Tree_menu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Show_Menu_Tree_Service {
	//jdbc实体对象
	Menu_tree_table tree   = new Menu_tree_table();
	//模型对象，用于存储一个具体的菜单节点
	Tree_menu tm = new Tree_menu();
	/**
	 * 获取组件所要求的json数据结构
	 * @return
	 */
	public JSONArray getTree_menus() {
		//System.out.println("servce_1已启动");
		//tree菜单的JSON数据是集合
		//JSONArray  tree_json = new JSONArray();
		//一，构建一级菜单
		//1，获取一级菜单数据库结果集
		List<Tree_menu> root_tree = tree.getRoot_Menu();
        //转换为json数组
		JSONArray  tree_json = JSONArray.fromObject(root_tree);
        //根据一级菜单循环加载对应的二级菜单数据
		//System.out.println(tree_json.size());
		for (int i = 0; i < tree_json.size(); i++) {
			JSONObject  children_json = tree_json.getJSONObject(i);
			if(children_json.getInt("children")!=0)
				children_json=this.getChildren(children_json);
  		}
		//System.out.println(tree_json.toString());
		return tree_json;
	}
	public JSONObject getChildren(JSONObject job)
	{	
		//System.out.println("servce_2已启动"+job.getInt("children"));
		if(job.getInt("children")!=0) {
			//System.out.println(job.getInt("children"));
			JSONArray j_t = new JSONArray();
			List<Tree_menu>  chd_l = tree.getChildren_Menu((int)job.getInt("children"));
			JSONArray  chd_a = JSONArray.fromObject(chd_l);
			/* 关联功能页的具体方式,menuPath代表页面的URL
			 * JSONObject attr = new JSONObject();
			 * attr.put("menupath", sm.getString("menuPath"));
			 * sm.put("attributes", attr);*/
			for (int i = 0; i < chd_a.size(); i++) {
				JSONObject  children_json = chd_a.getJSONObject(i);
				if(job.getInt("children")!=0)
					children_json=this.getChildren(children_json);
			}
			job.put("children", chd_a);
			return job;
		}else {
			return job;
		}
	}
}
