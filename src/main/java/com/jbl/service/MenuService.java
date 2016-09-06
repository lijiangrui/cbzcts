package com.jbl.service;

import java.util.List;

import com.jbl.pagemodel.Menu;

public interface MenuService{
	
	public List<Menu> getTreeNode(String id) throws Exception;
	
	public List<Menu> getAllTreeNode() throws Exception;
}
